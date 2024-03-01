package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println("TennisCoach: inside default constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
//    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("TennisCoach: inside setFortuneService() method");
        this.fortuneService = fortuneService;
    }
    
}
