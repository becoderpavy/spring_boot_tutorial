package com.becoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.becoder.config.MyMessge;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		MyMessge msg = context.getBean(MyMessge.class);
		System.out.println(msg.getMessage());
	}

}
