package com.latewind.bootstart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan("com.latewind.bootstart.info.dao")
@EnableWebMvc
@EnableCaching
@ServletComponentScan
@EnableScheduling
public class BootstartApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootstartApplication.class, args);
	}

}
