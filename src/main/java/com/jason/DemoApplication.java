package com.jason;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt.getDayOfMonth());
		System.out.println(ldt.plusMonths(1));
		//		@Value("${my.name}")
//		public String myName;
//		System.out.println(myName);
//		System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//		String[] beanNames = ctx.getBeanDefinitionNames();
//		Arrays.sort(beanNames);
//		for (String beanName : beanNames) {
//			System.out.println(beanName);
//		}

	}
}
