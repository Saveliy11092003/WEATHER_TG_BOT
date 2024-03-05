package com.weather.WeatherPlus.network;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Slf4j
public class HttpClient {
    public static String getUrlContent(String urlAddress) throws IOException {
        log.info("Went into the method getUrlContent");

        log.info("Created StringBuffer");
        StringBuffer content = new StringBuffer();
        log.info("Created URL");
        URL url = new URL(urlAddress);
        log.info("Created URLConnection");
        URLConnection urlConnection = url.openConnection();
        log.info("Created BufferedReader(new InputStreamReader((urlConnection.getInputStream())))");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((urlConnection.getInputStream())));
        String line;
        while((line = bufferedReader.readLine()) != null){
            content.append(line).append("\n");
        }
        log.info("All content received");
        bufferedReader.close();
        log.info("Closed bufferedReader");
        log.info("Exited the method getUrlContent");
        return content.toString();
    }
}
