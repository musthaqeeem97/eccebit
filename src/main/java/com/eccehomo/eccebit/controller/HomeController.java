package com.eccehomo.eccebit.controller;

import com.eccehomo.eccebit.dto.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @GetMapping("")
    public ResponseEntity<APIResponse> homeController(){


        APIResponse res=new APIResponse(
                "welcome to crypto treading platform working fine",
                true
        );
        return new ResponseEntity<APIResponse>(res, HttpStatus.ACCEPTED);
    }

}
