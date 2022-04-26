package com.example.Demo.registration;

import com.example.Demo.appuser.AppUser;
import com.example.Demo.appuser.AppUserRole;
import com.example.Demo.appuser.AppUserService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService
{
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

   public String register(RegistrationRequest request) {
       boolean isValidEmail = emailValidator.test(request.getEmail());
       if(isValidEmail){
           throw new IllegalStateException("email not valid");
       }
       String s = appUserService.signUpUser(
               new AppUser(
                   request.getFirstName(),
                   request.getLastName(),
                   request.getEmail(),
                   request.getPassword(),
                   AppUserRole.USER)
       );
       return s;
   }
}
