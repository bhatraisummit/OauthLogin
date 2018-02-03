/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knittech.oauthlogin.controller.admin;

import com.knittech.oauthlogin.DAO.StatusDAO;
import com.knittech.oauthlogin.entity.Status;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Sumit
 */
@Controller
@RequestMapping(path = "/admin/status")
public class StatusController {
    
    @Autowired
    private StatusDAO statusDAO;
   
    @RequestMapping(method = RequestMethod.GET)
    public String index (Model model){
        List <Status> status = null;
        try {
            status = statusDAO.getAll();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        model.addAttribute("status", status);
        return "/admin/status/index";
    }
}
