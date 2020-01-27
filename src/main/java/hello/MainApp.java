package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@ImportResource("classpath:app-Config.xml")
public class MainApp {
	public static void main(String[] args)
	{
		SpringApplication.run(MainApp.class, args);
		//ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:spring-server.xml");

	}
}