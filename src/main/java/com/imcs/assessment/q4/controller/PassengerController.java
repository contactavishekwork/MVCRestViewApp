/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imcs.assessment.q4.controller;

import com.imcs.assessment.q1.models.PassengerProfile;
import com.imcs.assessment.q3.rest.PassengerRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Avishek
 */
@RestController
@RequestMapping("/passengers")
public class PassengerController {
    
    @Autowired
    PassengerRestService passengerService;
    
    @RequestMapping(method=RequestMethod.GET, value="{/id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPassengerProfileById(@PathVariable("id")int profileId){
        PassengerProfile passenger = passengerService.getPassengerProfileById(profileId);
        
        if(passenger != null && passenger.getProfileId()!= 0)
            return new ResponseEntity<>(passenger, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public  @ResponseBody boolean addPassenger(@RequestBody PassengerProfile passenger){
        return passengerService.createPassengerProfile(passenger);
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public  @ResponseBody boolean updatePassenger(@RequestBody PassengerProfile passenger){
        return passengerService.updatePassengerProfileById(passenger);
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public  @ResponseBody boolean deletePassenger(@PathVariable("id")int profile_id){
        return passengerService.deletePassengerProfileById(profile_id);
    }
}
