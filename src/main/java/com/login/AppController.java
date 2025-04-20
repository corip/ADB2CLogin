package com.login;

import com.login.entity.Request;
import com.login.entity.Response;
import com.login.entity.ResponseError;
import com.login.entity.ResponseValidateUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/")
public class AppController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @GetMapping
    public ResponseEntity consulta(){
        ResponseValidateUser response= new ResponseValidateUser();
        logger.debug("consulta");
        response.setIsValidUser(true);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("login")
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
}