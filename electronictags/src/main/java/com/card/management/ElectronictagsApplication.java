package com.card.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ElectronictagsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectronictagsApplication.class, args);
	}

}
