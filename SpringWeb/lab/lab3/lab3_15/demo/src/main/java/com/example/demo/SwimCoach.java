package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach{
private FortuneService fortuneService;

    //@Autowired
    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
