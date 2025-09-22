package com.ducatech.springboot.demo.MyCoolApp.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements ICoach {

    public TennisCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swing the tennis racket 10x every day";
    }
}
