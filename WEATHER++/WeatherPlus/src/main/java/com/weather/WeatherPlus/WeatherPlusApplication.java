package com.weather.WeatherPlus;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class WeatherPlusApplication {

	public static void main(String[] args) {
		log.info("Went into the method main");
		SpringApplication.run(WeatherPlusApplication.class, args);
		log.info("Exited the method main");
	}
}