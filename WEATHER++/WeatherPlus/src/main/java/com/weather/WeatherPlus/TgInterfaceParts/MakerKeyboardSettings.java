package com.weather.WeatherPlus.TgInterfaceParts;

import com.weather.WeatherPlus.language.Translator;
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
    private Translator translator;

    public MakerKeyboardSettings(Translator translator) {
        this.translator = translator;
    }

    @Override
    public ReplyKeyboardMarkup makeKeyboard() {
        log.info("Went into the method makeKeyboard in MakerKeyboardSettings");
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();

        row1.add(translator.translate("Change units"));
        row1.add(translator.translate("Change city"));
        row2.add(translator.translate("EN/RU"));
        row2.add(translator.translate("Back"));


        keyboardRows.add(row1);
        keyboardRows.add(row2);


        keyboardMarkup.setKeyboard(keyboardRows);
        log.info("keyboardMarkup.setKeyboard(keyboardRows)");
        log.info("Exited the method makerKeyboard in MakerKeyboardSettings");
        return keyboardMarkup;
    }
}
