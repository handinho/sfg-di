package com.springframework.sfgdi.config;

import com.springframework.sfgdi.services.ConstructorGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingServiceConfig {

    @Bean
    ConstructorGreetingService constructorGreetingService() {
        /**
         * the bean gets the name from the method name
         */
        return new ConstructorGreetingService();
    }

}
