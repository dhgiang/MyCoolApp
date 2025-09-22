package com.ducatech.springboot.demo.MyCoolApp.common;

import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements ICoach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // definite init method
//    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("In doMyStartupStuff(): " + getClass().getSimpleName());
    }

//    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("In doMyDestroyStuff(): " + getClass().getSimpleName());
    }


    @Override
    public String getDailyWorkout(){
        return "practice daily 000";
    }
}
