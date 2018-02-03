/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knittech.oauthlogin.controller.admin;

import com.knittech.oauthlogin.DAO.ProjectDAO;
import com.knittech.oauthlogin.DAO.StatusDAO;
import com.knittech.oauthlogin.DAO.TaskDAO;
import com.knittech.oauthlogin.entity.Task;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Sumit
 */
@Controller
@RequestMapping(path = "/admin/task")
public class TaskController {
    
    @Autowired
    private TaskDAO taskDAO;
    
    @Autowired
    private ProjectDAO projectDAO;
    
    @Autowired
    private StatusDAO statusDAO;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index (Model model){
        try {
            model.addAttribute("task",taskDAO.getAll());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/admin/task/index";
    }
    
    @RequestMapping(path = "/add",method = RequestMethod.GET)
    public String add(Model model){
        try {
            model.addAttribute("project", projectDAO.getAll());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/admin/task/add";
    }
    
    @RequestMapping(path = "/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id){
        try {
            taskDAO.deleteById(id);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/admin/task";
    }
    
    @RequestMapping(path = "/edit/{id}",method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") int id){
        try {
            model.addAttribute("task", taskDAO.getById(id));
            model.addAttribute("project", projectDAO.getAll());
            model.addAttribute("status", statusDAO.getAll());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/admin/task/edit";
    }
    @InitBinder
    public final void initBinder(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String save(Task task){
            try {
                if(task.getId()==0){
                taskDAO.insert(task);
                }else{
                    taskDAO.update(task);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
            }
        return "redirect:/admin/task";
    }
}
