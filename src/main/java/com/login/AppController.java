package com.login;

import com.login.entity.ResponseError;
import com.login.entity.ResponseValidateUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
