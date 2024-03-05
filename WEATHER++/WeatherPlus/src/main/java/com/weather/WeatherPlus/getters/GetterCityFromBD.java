package com.weather.WeatherPlus.getters;

import com.weather.WeatherPlus.model.User;
import com.weather.WeatherPlus.model.UserRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class GetterCityFromBD {
    public String getCity(UserRepository userRepository, Long chatId) {
        log.info("Went into the method getCity");
        String city = "Novosibirsk";
        Optional<User> user = userRepository.findById(chatId);
        if(user.isPresent()) {
            User foundUser = user.get();
            city = foundUser.getCity();
        }
        log.info("getCity returned city - " + city);
        log.info("Exited the method getCity");
        return city;
    }
}
