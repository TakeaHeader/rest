package com.rest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@MapperScan(basePackages = "com.rest.mapper")
public class RestApplication {

    private static String [] Sargs ;

    private static ConfigurableApplicationContext configurableApplicationContext;

    public static void main(String[] args) {
        RestApplication.Sargs = args;
        RestApplication.configurableApplicationContext = SpringApplication.run(RestApplication.class, args);
    }


    public static void restart(){
        RestApplication.configurableApplicationContext.close();
        RestApplication.configurableApplicationContext = SpringApplication.run(RestApplication.class, Sargs);
    }




}
