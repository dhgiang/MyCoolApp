package com.ducatech.springboot.demo.MyCoolApp.rest;

import com.ducatech.springboot.demo.MyCoolApp.common.ICoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private ICoach myCoach;
//    private ICoach anotherCoach;

    @Autowired
    public DemoController(@Qualifier("aquatic") ICoach theCoach) {
        System.out.println("In Constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
//        anotherCoach = theAnotherCoach;
    }

    private final String sql = """
            SELECT name, customer, lastname FROM customer WHERE lastname = 'Giang';
            """;

//    @GetMapping("/check")
//    public String check() {
//        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
//    }

//    @Autowired
//    public void setCoach(@Qualifier("tennisCoach") ICoach coach) {
//        myCoach = coach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
