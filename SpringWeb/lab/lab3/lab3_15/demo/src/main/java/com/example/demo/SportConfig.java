package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("./")
public class SportConfig {
@Bean
    public Coach swimCoach(){
    SwimCoach mySwimCoach=new SwimCoach(sadFortuneService());
    return mySwimCoach;
}

@Bean
    public FortuneService sadFortuneService(){
    return new SadFortuneService();
}
}
