package com.chainsys.mavenlessons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JacksonException;
/**
 * @author thai3141
 * @Date 16-06-2022
 */
@SpringBootApplication
public class App {

	public static void main(String[] args) throws JacksonException {
		SpringApplication.run(App.class, args);
	}
}