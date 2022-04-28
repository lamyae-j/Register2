package com.example.Demo.registration;

import com.example.Demo.appuser.AppUser;
import com.example.Demo.appuser.AppUserRole;
import com.example.Demo.appuser.AppUserService;

import com.example.Demo.registration.token.ConfirmationToken;
import com.example.Demo.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService
{
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    private final ConfirmationTokenService confirmationTokenService;



   public String register(RegistrationRequest request) {
       boolean isValidEmail = emailValidator.test(request.getEmail());

       if(!isValidEmail){
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


    @Transactional
    public String confirmToken(String token) {

        ConfirmationToken confirmationToken = (ConfirmationToken) confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(
                confirmationToken.getAppUser().getEmail());
        return "confirmed";
    }
}
