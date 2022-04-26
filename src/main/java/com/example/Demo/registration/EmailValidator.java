package com.example.Demo.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;


@Service
@AllArgsConstructor
public class EmailValidator implements Predicate<String> {
    private EmailValidator emailValidator;
    @Override
    public boolean test(String s) {

        return true;
    }


}
