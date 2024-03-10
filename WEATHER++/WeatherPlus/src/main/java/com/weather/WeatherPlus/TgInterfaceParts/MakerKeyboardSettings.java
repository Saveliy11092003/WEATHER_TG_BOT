package com.weather.WeatherPlus.TgInterfaceParts;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

/*
*
*Class creates Settings Menu
*
 */


@Slf4j
public class MakerKeyboardSettings implements MakerKeyboard{
    @Override
    public ReplyKeyboardMarkup makeKeyboard() {
        log.info("Went into the method makeKeyboard in MakerKeyboardSettings");
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();

        row1.add("Change units");
        row1.add("Change city");
        row1.add("Back");

        keyboardRows.add(row1);


        keyboardMarkup.setKeyboard(keyboardRows);
        log.info("keyboardMarkup.setKeyboard(keyboardRows)");
        log.info("Exited the method makerKeyboard in MakerKeyboardSettings");
        return keyboardMarkup;
    }
}
