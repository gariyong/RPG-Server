package com.aporia;

import java.util.Objects;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.event.*;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.entity.Player;

// Listener: 특정 이벤트를 정의했을 때, 플레이어의 행동을 감지
public class Main extends JavaPlugin implements Listener{
    @Override
    public void onEnable() {
        getLogger().info("MyPlugin has been enabled!");

        // "test"라는 이름의 명령어에 대해 MyCommand 클래스를 명령어 실행기로 처리
        Objects.requireNonNull(this.getCommand("test")).setExecutor(new MyCommand());
        
        // tihs.getCommand("test"): 현재 플러그인에서 "test"라는 이름을 가진 명령어를 가져옴
        // 이 명령어는 plugin.yml 파일에 정의된 명령어 중 하나여야 함
        // Objects.requireNonNull(): 해당하는 명령어를 찾을 수 있으면 해당 명령어 객체 반환, 존재하지 않으면 null 반환
        // setExecutor(): 명령어가 실행되었을 때 호출할 실행 처리기(executor) 설정
        Objects.requireNonNull(this.getCommand("인벤토리")).setExecutor(new MyCommand());
        
        // bukkit 플러그인에서 이벤트 리스너를 등록하기 위해서 사용하는 메서드
        // 플러그인 시스템에 현재 클래스(this)가 이벤트를 처리하도록 알려줌
        // getServer() >> 서버 인스턴스를 가져옴, getPluginManager() >> 플러그인과 관련된 작업을 관리하는 객체 반환
        // registerEvents() >> 이벤트 리스너를 등록하는 리스너, 두개의 인자값을 받음
        // 첫번째 인자: 이벤트를 처리하는 클래스의 인스턴스, 두번째 인자: 플러그인의 메인 클래스 인스턴스
        getServer().getPluginManager().registerEvents(this, this); 
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin Disabled!");
    }

    @EventHandler // PlayerJointEvent 발생 시 실행
    public void onPlayerJoinBoard(PlayerJoinEvent e){
        createScoreBoard(e.getPlayer());
        updateScoreBoard();
    }

    @EventHandler
    public void onPlayerQuitBoard(PlayerQuitEvent e){
        updateScoreBoard();
    }

    @SuppressWarnings("deprecation")
    public void createScoreBoard(Player player){
        ScoreboardManager manager = Bukkit.getScoreboardManager();      // 서버에서 점수판 관리자를 가져옴
        Scoreboard board = manager.getNewScoreboard();                  // 새로운 빈 점수판 객체 생성
        Objective o = board.registerNewObjective("My server", "dummy"); // 잉름과 dummy(수동 업데이트) 유형의 오브젝트 생성

        o.setDisplayName(ChatColor.BOLD + "My Server");                 // 점수판의 제목을 설정, 굵은 글씨로 표시
        o.setDisplaySlot(DisplaySlot.SIDEBAR);                          // 점수판을 화면의 사이드바에 표시하도록 설정함
        Score score = o.getScore("Players: ");                          // Players라는 텍스트로 점수를 추가함
        score.setScore(Bukkit.getOnlinePlayers().size());               // 현재 온라인 플레이어 수를 점수로 설정함
        player.setScoreboard(board);                                    // 생성된 점수판을 플레이어에게 적용
    }

    public void updateScoreBoard(){
        // 현재 서버에 접속중인 모든 플레이어의 목록을 가져옴
        for(Player online : Bukkit.getOnlinePlayers()){
            // 플레이어의 현재 점수판에서 사이드바에 표시된 오브젝트에서 "Players: "라는 이름의 점수를 가져옴
            Score score = online.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getScore("Players: ");
            score.setScore(Bukkit.getOnlinePlayers().size());
        }
    }
}
