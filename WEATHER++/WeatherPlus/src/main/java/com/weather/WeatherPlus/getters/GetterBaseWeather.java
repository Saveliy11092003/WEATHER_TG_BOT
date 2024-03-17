package com.weather.WeatherPlus.getters;

import com.weather.WeatherPlus.model.UserRepository;
import com.weather.WeatherPlus.parsers.ParserBaseWeather;
import com.weather.WeatherPlus.units.StoreUnits;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class GetterBaseWeather {

    StoreUnits storeUnits;
    UserRepository userRepository;

    Long chatId;

    public GetterBaseWeather(StoreUnits storeUnits, UserRepository userRepository, Long chatId) {
        this.storeUnits = storeUnits;
        this.userRepository = userRepository;
        this.chatId = chatId;
    }

    public String getWeather(boolean isRus) throws IOException {
        log.info("Went into the method getWeather");
        ParserBaseWeather parser = new ParserBaseWeather();
        String message = parser.parse(storeUnits, userRepository, chatId, isRus);
        log.info("getWeather returned string - " + message);
        log.info("Exited the method getWeather");
        return message;
    }

}
