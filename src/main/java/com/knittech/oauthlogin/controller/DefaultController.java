package com.knittech.oauthlogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sumit
 */
@Controller
@RequestMapping(path = "/")
public class DefaultController {
    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}