package dk.kea.junitdemodat22b.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Calculator {

    @Value("${spring.datasource.url}")
    String url;

    public String getUrl(){
        return url;
    }
    
    public int adder(int a, int b){

        //exception hvis negative tal
        if (a<0||b<0){
            throw new IllegalArgumentException("Negative numbers not allowed!");
        }
        int c = a + b;
        return c;
    }
}
