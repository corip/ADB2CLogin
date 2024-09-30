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
        List<String> usersLs = Arrays.asList("vsantino","pepe","user1","ecordero","VSANTINO");
        String username= request.getUserCredentialId();
        String password =  request.getPassword();

        logger.debug("/validateUser");
        logger.debug(request.toString());
        if(usersLs.contains(username) && password.equals("1234")){

            response.setIsValidUser(true);
            response.setIsFirstLogin(false);
            response.setUserCredentialId(username);
            if(username.equals("ecordero")){
                response.setIsFirstLogin(true);
            }
            response.setJti("prueba-jti");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            if(username.equals("vsantino")){
                response.setIsValidUser(false);
                responseError.setVersion("1.0.0");
                responseError.setStatus(400);
                responseError.setUserMessage("status:error,type:has_two_attemps"); // 2 intentos
                responseError.setCount(2);



            }else if(username.equals("pepe")) {
                responseError.setVersion("1.0.0");
                responseError.setUserMessage("status:error,type:has_one_attemp");// 1 intento
                responseError.setStatus(401);
                response.setIsValidUser(false);

            }else{
                response.setIsValidUser(false);
                responseError.setVersion("1.0.0");
                responseError.setStatus(402);
                responseError.setUserMessage("status:error,type:user_blocked");// usuario bloqueado

            }

            return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);

        }



    }
}
