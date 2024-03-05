package com.weather.WeatherPlus.Command;

import com.weather.WeatherPlus.model.User;
import com.weather.WeatherPlus.model.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.objects.Message;

@Slf4j
public class RegisterUser {
    public void registerUser(Message msg, UserRepository userRepository) {
        log.info("Went into the method registerUser");
        if(userRepository.findById(msg.getChatId()).isEmpty()) {
            var chatId = msg.getChatId();
            var chat = msg.getChat();

            User user = new User();
            user.setChatId(chatId);
            user.setUserName(chat.getUserName());

            userRepository.save(user);

            log.info("Saved user in BD, ChatId - " + chatId  + ", UserName - " + chat.getUserName());
        }
        log.info("Exited the method registerUser");
    }
}
