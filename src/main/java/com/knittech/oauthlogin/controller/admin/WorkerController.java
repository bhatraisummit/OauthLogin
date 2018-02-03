/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knittech.oauthlogin.controller.admin;

import com.knittech.oauthlogin.DAO.SkillsDAO;
import com.knittech.oauthlogin.DAO.WorkerDAO;
import com.knittech.oauthlogin.entity.Worker;
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
@RequestMapping(path = "/admin/worker")
public class WorkerController {
    
    @Autowired
    private WorkerDAO workerDAO;
    
    @Autowired
    private SkillsDAO skillsDAO;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index (Model model){
        try {
            model.addAttribute("worker",workerDAO.getAll());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/admin/worker/index";
    }
    
    @RequestMapping(path = "/add",method = RequestMethod.GET)
    public String add(Model model){
        try {
            model.addAttribute("skills",skillsDAO.getAll());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/admin/worker/add";
    }
    
    @RequestMapping(path = "/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id){
        try {
            workerDAO.deleteById(id);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/admin/worker";
    }
    
    @RequestMapping(path = "/edit/{id}",method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") int id){
        try {
            model.addAttribute("worker", workerDAO.getById(id));
            model.addAttribute("skills",skillsDAO.getAll());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/admin/worker/edit";
    }
    
    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String save(Worker worker){
        try {
           if(worker.getId() == null){
                workerDAO.insert(worker);
           }else{
               workerDAO.update(worker);
           }
        
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error");        }
        return "redirect:/admin/worker";
    }
}
