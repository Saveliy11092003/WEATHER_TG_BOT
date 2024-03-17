package com.weather.WeatherPlus.language;

public class TranslatorRu implements Translator{
    @Override
    public String translate(String str) {
        return switch (str) {
            case "Help" -> "Помощь";
            case "Weather" -> "Погода";
            case "Settings" -> "Настройки";
            case "Cloth recommendations" -> "Рекомендация погоды";

            case "Change units" -> "Изменить единицы измерения";
            case "Change city" -> "Изменить город";
            case "EN-RU" -> "Русский-Английский";
            case "Back" -> "Назад";

            case "Base weather" -> "Стандартная погода";
            case "Advanced weather" -> "Расширенная погода";

            default -> null;
        };


    }
}
