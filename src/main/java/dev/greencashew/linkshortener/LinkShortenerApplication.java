package dev.greencashew.linkshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;


@SpringBootApplication
public class LinkShortenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkShortenerApplication.class, args);
		System.out.println("Hello");
	}


}
