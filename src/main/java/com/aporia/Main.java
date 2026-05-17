package com.aporia;

import java.util.Objects;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("MyPlugin has been enabled!");

        // "test"라는 이름의 명령어에 대해 MyCommand 클래스를 명령어 실행기로 처리
        Objects.requireNonNull(this.getCommand("test")).setExecutor(new MyCommand());
        // tihs.getCommand("test"): 현재 플러그인에서 "test"라는 이름을 가진 명령어를 가져옴
        // 이 명령어는 plugin.yml 파일에 정의된 명령어 중 하나여야 함
        // Objects.requireNonNull(): 해당하는 명령어를 찾을 수 있으면 해당 명령어 객체 반환, 존재하지 않으면 null 반환
        // setExecutor(): 명령어가 실행되었을 때 호출할 실행 처리기(executor) 설정 
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin Disabled!");
    }
}
