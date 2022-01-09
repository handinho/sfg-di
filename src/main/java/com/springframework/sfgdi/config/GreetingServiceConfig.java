package com.springframework.sfgdi.config;

import com.springframework.sfgdi.services.ConstructorGreetingService;
import com.springframework.sfgdi.services.I18nEnglishGreetingService;
import com.springframework.sfgdi.services.I18nSpanishGreetingService;
import com.springframework.sfgdi.services.PrimaryGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService() {
        return new I18nSpanishGreetingService();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService() {
        return new I18nEnglishGreetingService();
    }

    @Bean
    ConstructorGreetingService constructorGreetingService() {
        /**
         * the bean gets the name from the method name
         */
        return new ConstructorGreetingService();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService () {
        return new PrimaryGreetingService();
    }

}