package com.bank.bookstore;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BookstoreApplication {


	public static void main(String[] args) {
		
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.scan("com.bank.bookstore");
//		context.refresh();
		SpringApplication.run(BookstoreApplication.class, args);
	}

}

