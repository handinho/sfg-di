package com.springframework.sfgdi.services;

public class ConstructorGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello world! - Constructor";
    }
}
