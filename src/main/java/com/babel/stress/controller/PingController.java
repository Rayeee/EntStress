package com.babel.stress.controller;

import com.xiaoleilu.hutool.io.IoUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    @ResponseBody
    @RequestMapping(value = "/hook", method = RequestMethod.POST)
    public ResponseEntity<String> hook(HttpServletRequest request) throws IOException {
        String read = IoUtil.read(new BufferedReader(new InputStreamReader(request.getInputStream())));
        return ResponseEntity.ok(read);
    }

}
