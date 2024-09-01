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
        List<String> user = Arrays.asList("coripedro3@gmail.com","pca1510@hotmail.com","pepe@gmail.com");

        logger.debug("/validateUser");
        logger.debug(request.toString());
        if(request.getEmail().equalsIgnoreCase("pepe@gmail.com")){

            response.setIsValidUser(true);
            response.setDisplayName("Pedro");
            response.setGivenName("pcoria");
            response.setSurname("Cori");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            response.setIsValidUser(false);
            responseError.setVersion("1.0.1");
            responseError.setStatus(409);
            responseError.setUserMessage("Contraseña o password invalida");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }



    }
}
