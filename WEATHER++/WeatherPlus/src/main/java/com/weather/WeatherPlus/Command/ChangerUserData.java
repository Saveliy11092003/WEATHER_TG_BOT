package com.weather.WeatherPlus.Command;

import com.weather.WeatherPlus.model.User;
import com.weather.WeatherPlus.model.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.objects.Chat;

@Slf4j
public class ChangerUserData {
    public void changeUserData(Long chatId, Chat chat, String city, UserRepository userRepository){
        log.info("Went into the method changeUserData");
        User user = new User();
        user.setChatId(chatId);
        user.setUserName(chat.getUserName());
        user.setCity(city);
        log.info("Changed city of user " + chatId);
        userRepository.save(user);
        log.info("Saved changes for user " + chatId );
        log.info("Exited the method changeUserData");
    }
}
