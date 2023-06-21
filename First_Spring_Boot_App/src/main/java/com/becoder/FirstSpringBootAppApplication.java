package com.becoder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstSpringBootAppApplication implements CommandLineRunner{

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(FirstSpringBootAppApplication.class, args);
		int i = run.getBeanDefinitionCount();
		System.out.println(i);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Command Line Runner Executed");
	}

}
