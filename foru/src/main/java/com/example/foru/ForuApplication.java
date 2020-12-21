package com.example.foru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.example.foru.repository")
@EnableTransactionManagement
@EntityScan(basePackages="com.example.foru.entities")
public class ForuApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForuApplication.class, args);
	}

}
