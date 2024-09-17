package com.login;

import com.login.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("/api")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/login")
    private ResponseEntity login(@RequestBody Request request){
        Response response = new Response();
        ResponseError responseError = new ResponseError();
        Random random = new Random();
        int promoCode= random.nextInt(1000) + 1;

        logger.debug("/login");
        if(!request.getEmail().equalsIgnoreCase("pepe@gmail.com")){
            responseError.setVersion("1.0.1");
            responseError.setStatus(409);
            responseError.setUserMessage("LoyaltyId ID '123' is not associated with 'pepe@gmail.com' email address.");

            return new ResponseEntity<>(responseError, HttpStatus.CONFLICT);
        }

        response.setPromoCode(""+promoCode);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping("/validateUser")
    private ResponseEntity validateUser(@RequestBody RequestValidateUser request){
        ResponseValidateUser response= new ResponseValidateUser();
        ResponseError responseError = new ResponseError();
        List<String> usersLs = Arrays.asList("vsantino","pepe","user1");
        String username= request.getEmail();
        String password =  request.getPassword();

        logger.debug("/validateUser");
        logger.debug(request.toString());
        if(usersLs.contains(username) && password.equals("1234")){

            response.setIsValidUser(true);
            response.setDisplayName("Pedro");
            response.setGivenName("pcoria");
            response.setSurname("Cori");
            response.setUserPrincipalName("pcori");
            response.setObjectId("12345");
            response.setRole("firmante");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            if(username.equals("vsantino")){
                response.setIsValidUser(false);
                responseError.setVersion("1.0.1");
                responseError.setStatus(409);
                responseError.setUserMessage("Contraseña o password invalida");
                responseError.setCount(2);
                responseError.setDetail("Usuario bloqueado");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);  // 2 intentos
            }else if(username.equals("pepe")) {
                response.setIsValidUser(false);
                return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED); // 1 intento
            }else{
                response.setIsValidUser(false);
                return new ResponseEntity<>(response, HttpStatus.PAYMENT_REQUIRED); // usuario bloqueado
            }



        }



    }
}
