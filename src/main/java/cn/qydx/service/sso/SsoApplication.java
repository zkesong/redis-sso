package cn.qydx.service.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SsoApplication {
	
	public static void main(String[] args){
		SpringApplication.run(SsoApplication.class, args);
		System.out.println("SprintBoot Application Started!");
	}

}
