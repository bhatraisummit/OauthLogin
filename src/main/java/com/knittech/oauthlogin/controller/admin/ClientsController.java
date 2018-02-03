/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knittech.oauthlogin.controller.admin;

import com.knittech.oauthlogin.DAO.ClientsDAO;
import com.knittech.oauthlogin.entity.Clients;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Sumit
 */
@Controller
@RequestMapping(path = "/admin/clients")
public class ClientsController {
    
    @Autowired
    private ClientsDAO clientsDAO;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index (Model model){
        try {
            model.addAttribute("clients",clientsDAO.getAll());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/admin/clients/index";
    }
    
    @RequestMapping(path = "/add",method = RequestMethod.GET)
    public String add(){
        return "/admin/clients/add";
    }
    
    @RequestMapping(path = "/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id){
        try {
            clientsDAO.deleteById(id);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/admin/clients";
    }
    
    @RequestMapping(path = "/edit/{id}",method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") int id){
        try {
            model.addAttribute("clients", clientsDAO.getById(id));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/admin/clients/edit";
    }
    
    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String save(Clients clients){
        try {
           if(clients.getId() == null){
                clientsDAO.insert(clients);
           }else{
               clientsDAO.update(clients);
           }
        
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientsController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error");        }
        return "redirect:/admin/clients";
    }
}
