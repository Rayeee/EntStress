package com.babel.stress.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Rayee on 2017/11/23.
 */
@Controller
@RequestMapping("/webapi")
public class PingController {

    @ResponseBody
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public ResponseEntity<String> ping(){
        return ResponseEntity.ok("pong");
    }

}
