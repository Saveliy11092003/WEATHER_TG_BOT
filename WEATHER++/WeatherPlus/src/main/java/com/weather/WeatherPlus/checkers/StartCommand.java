package com.weather.WeatherPlus.checkers;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StartCommand {
    public String getStartCommandReceive(String firstName) {
        log.info("Went into the method getStartCommandReceive");
        log.info("return String - " + "Hi, " + firstName + ",  nice to meet you!");
        log.info("Exited the method getStartCommandReceive");
        return "Hi, " + firstName + ",  nice to meet you!";
    }
}
