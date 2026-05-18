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
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective o = board.registerNewObjective("My server", "dummy");

        o.setDisplayName(ChatColor.BOLD + "My Server");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score score = o.getScore("Players: ");
        score.setScore(Bukkit.getOnlinePlayers().size());
        player.setScoreboard(board);
    }

    public void updateScoreBoard(){
        for(Player online : Bukkit.getOnlinePlayers()){
            Score score = online.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getScore("Players: ");
            score.setScore(Bukkit.getOnlinePlayers().size());
        }
    }
}
