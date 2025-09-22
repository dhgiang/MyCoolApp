package com.ducatech.springboot.demo.MyCoolApp.config;

import com.ducatech.springboot.demo.MyCoolApp.common.ICoach;
import com.ducatech.springboot.demo.MyCoolApp.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public ICoach swimCoach() {
        return new SwimCoach();
    }
}
