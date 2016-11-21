package com.sj.resources.user;

import com.sj.model.UserModel;
import com.sj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping(name = "/user",method = RequestMethod.GET)
    public ResponseEntity<?> findById(@RequestParam(value = "id") Long id) {
        UserModel userModel = userService.getUser(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        if(userModel != null) {
            return new ResponseEntity<>(userModel, httpHeaders, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(name = "/user",method = RequestMethod.POST)
    public ResponseEntity<?> createUserModelFromForm(
            @RequestParam("username") String username,@RequestParam("id") Long id ) {
        UserModel userModel = new UserModel(username);
        userModel.setId(id);
        userService.saveUser(userModel);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(username, httpHeaders, HttpStatus.CREATED);
    }
}
