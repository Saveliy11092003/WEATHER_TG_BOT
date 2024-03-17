package com.weather.WeatherPlus.language;

public class TranslatorRu implements Translator{
    @Override
    public String translate(String str) {
        return switch (str) {
            case "Help" -> "Помощь";
            case "Weather" -> "Погода";
            case "Settings" -> "Настройки";
            case "Cloth recommendations" -> "Рекомендация одежды";

            case "Change units" -> "Изменить единицы измерения";
            case "Change city" -> "Изменить город";
            case "RU EN" -> "Русский Английский";
            case "Back" -> "Назад";
            case "Sorry, command was not recognized" -> "Извините, команда не распознана";
            case "You enter:" -> "Вы ввели:";
            case "Enter the city: " -> "Введите город: ";
            case  "You pressed mmHG" -> "Вы ввели mmHG";
            case "You pressed hpa" -> "Вы ввели hpa";
            case "You pressed m/s" -> "Вы ввели m/s";
            case "You pressed km/h" -> "Вы ввели km/h";
            case  "You pressed K" -> "Вы ввели K";
            case "You pressed C" -> "Вы ввели C";


            case "Language is English" -> "Английский язык";
            case "Language is Russian" -> "Русский язык";
            case "Base weather" -> "Стандартная погода";
            case "Advanced weather" -> "Расширенная погода";

            case "The sun is scorching outside, so you should stay at home if possible." +
                    "\n\nIf you need to go outside, you should give preference to light clothing made from natural materials. " +
                    "A headdress is a must!" -> "На улице палящее солнце, так что по возможности лучше оставаться дома.\n\n" +
                    "Если вам необходимо выйти на улицу, следует отдать предпочтение легкой одежде из натуральных материалов" +
                    "Головной убор обязателен!";

            case "It's also raining outside. You need to take an umbrella or a thin raincoat with you." ->
                    "На улице также дождь. Нужно взять с собой зонтик или тонкий плащ";


            case "It’s warm outside, so you should wear comfortable clothes made from light natural materials. " +
                    "Don't forget to apply sunscreen and wear a hat!" -> "На улице тепло, поэтому следует надеть удобную одежду из легких натуральных материалов " +
                    "Не забудьте нанести солнцезащитный крем и надеть головной убор!";


            case "It's cool outside, " +
                    "so you should dress warmly: a sweater, jeans and light trousers. " +
                    "I recommend taking a warm jacket with you if there is a strong wind!" ->
                "На улице прохладно" + " поэтому одевайтесь тепло: свитер, джинсы и легкие брюки. " +
                        "Рекомендую взять с собой теплую куртку, если сильный ветер!";

            case "It's also raining outside, " +
                    "so it is worth taking an umbrella and wearing waterproof shoes." ->
                    "На улице тоже дождь " +
                        "поэтому стоит взять зонтик и надеть непромокаемую обувь";

            case "To go outside today, you should wear a warm jacket, " +
                    "and don’t forget about a hat, scarf and gloves!" ->
                "Чтобы выйти сегодня на улицу, тебе следует надеть теплую куртку " +
                        "и не забудь про шапку, шарф и перчатки";

            case "ing outside now, so you need to take an umbrella with you and wear warmer shoes. " ->
                    "на улице, поэтому нужно взять с собой зонтик и надеть обувь потеплее.";

            case "It's snow" -> "Cнег ";
            case "It's rain" -> "Дождь ";

            case "snow" -> "снег";
            case "rain" -> "дождь";

            case "It's getting cold outside, " +
                    "so you should put on a warmer jacket or coat, take out a hat and gloves." ->
                "На улице становится холодно, " +
                        "поэтому вам следует надеть куртку или пальто потеплее, достать шапку и перчатки";

            case "ing now, so remember that in such conditions it is important " +
                    "to ensure that your clothes are not only warm, but also protected from moisture and wind!" ->
                    "на улице, так что помните, что в таких условиях это важно. " +
                    "Чтобы ваша одежда была не только теплой, но и защищенной от влаги и ветра!";


            case "It feels cold outside, so you need to dress warmly! " +
                "Today you should wear a sweater and warm pants, and a down jacket on top." ->
                    "На улице холодно, поэтому нужно одеться потеплее! " +
                            "Сегодня вам следует надеть свитер и теплые штаны, а сверху пуховик.";

            case "It's also snowing outside, " +
                    "so you need to wear a scarf and gloves to protect yourself." ->
                    "На улице тоже снег. " +
                            "Поэтому вам нужно носить шарф и перчатки, чтобы защитить себя.";

            case "The temperature is quite low now, so you need to wear a warm insulated coat, " +
                    "warm trousers and shoes. It is important not to forget about gloves, a scarf and a hat!" ->
                "Температура сейчас довольно низкая, поэтому нужно надеть теплое утепленное пальто, " +
                        "тёплые брюки и обувь. Важно не забыть про перчатки, шарф и шапку!";


            case "It's also snowing, " +
                    "so it's important to wear a waterproof jacket and insulated shoes!" ->
                    "А еще снег идет " +
                        "поэтому важно носить водонепроницаемую куртку и утепленную обувь!";

            case "Temperatures outside are very low at the moment, " +
                    "so you should exercise caution and stay home if possible! " +
                    "If you still need to go outside, then you should wear thermal underwear, woolen socks, " +
                    "a hat, gloves, warm pants and a down jacket." ->
                    "Температура на улице сейчас очень низкая," +
                            "поэтому вам следует соблюдать осторожность и по возможности оставаться дома! " +
                            "Если вам все-таки нужно выйти на улицу, то следует надеть термобелье, шерстяные носки, шапка, перчатки, теплые штаны и пуховик";


            case "This bot is designed to provide weather conditions in your city." +
                    "\nYou can use one of the following commands by typing it or using the main menu:" +
                    "\n\nType /start to see the welcome message" +
                    "\n\nType /weather_base to get basic information about the current weather in your city" +
                    "\n\nType /weather_advanced to get more detailed information about the current weather in your city" +
                    "\n\nType /recommendation_of_clothes to see clothing recommendations depending on the weather in your city at the moment" +
                    "\n\nType /change_utils to change the units of temperature, pressure and wind speed" +
                    "\n\nType /help to see this message again" ->
                    "Этот бот предназначен для предоставления информации о погодных условиях в вашем городе." +
                            "\nВы можете использовать одну из следующих команд, набрав ее или воспользовавшись главным меню:" +
                            "\n\nВведите /start, чтобы увидеть приветственное сообщение." +
                            "\n\nВведите /weather_base, чтобы получить основную информацию о текущей погоде в вашем городе." +
                            "\n\nВведите /weather_advanced, чтобы получить более подробную информацию о текущей погоде в вашем городе." +
                            "\n\nВведите /recommendation_of_clothes, чтобы просмотреть рекомендации по одежде в зависимости от погоды в вашем городе в данный момент." +
                            "\n\nВведите /change_utils, чтобы изменить единицы измерения температуры, давления и скорости ветра." +
                            "\n\nВведите /help, чтобы снова увидеть это сообщение.";

            default -> null;
        };


    }
}
