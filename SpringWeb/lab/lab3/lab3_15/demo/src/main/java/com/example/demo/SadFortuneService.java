package com.example.demo;

//@Component
public class SadFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Today is unlucky";
    }
}
