package com.gecko.demo.resource;

import com.gecko.demo.api.HelloResource;
import org.springframework.stereotype.Component;

@Component
public class HelloResourceImpl implements HelloResource {

    @Override
    public String greet(String name){
        return "Hello " + name;
    }
}
