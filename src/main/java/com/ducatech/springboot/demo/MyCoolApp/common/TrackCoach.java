package com.ducatech.springboot.demo.MyCoolApp.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//@Primary
@Lazy
@Component
public class TrackCoach implements ICoach {

    public TrackCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run hard 5K";
    }
}
