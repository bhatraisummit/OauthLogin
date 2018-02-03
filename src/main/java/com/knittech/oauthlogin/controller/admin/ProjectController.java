/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knittech.oauthlogin.controller.admin;

import com.knittech.oauthlogin.DAO.ClientsDAO;
import com.knittech.oauthlogin.DAO.ProjectDAO;
import com.knittech.oauthlogin.DAO.StatusDAO;
import com.knittech.oauthlogin.entity.Clients;
import com.knittech.oauthlogin.entity.Project;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Sumit
 */
@Controller
@RequestMapping(path = "/admin/project")
public class ProjectController {

    @Autowired
    private ProjectDAO projectDAO;

    @Autowired
    private ClientsDAO clientsDAO;
    
    @Autowired
    private StatusDAO statusDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        try {
            model.addAttribute("clients", clientsDAO.getAll());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/admin/project/index";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public @ResponseBody
    List<Project> getByClientId(@PathVariable("id") int id) throws ClassNotFoundException, SQLException {
        if (id == 0) {
            return projectDAO.getAll();
        } else {
            Clients clients = clientsDAO.getByIdWithClients(id);
            return clients.getProjectList();
        }
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        try {
            model.addAttribute("clients", clientsDAO.getAll());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/admin/project/add";
    }
    
    @InitBinder
    public final void initBinder(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {
        try {
            projectDAO.deleteById(id);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/admin/project";
    }

    @RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") int id) {
        try {
            model.addAttribute("clients", clientsDAO.getAll());
            model.addAttribute("status", statusDAO.getAll());
            model.addAttribute("project", projectDAO.getById(id));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/admin/project/edit";
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String save(Project project) {
        try {
            if(project.getId()== null){
                projectDAO.insert(project);
            }else{
                projectDAO.update(project);
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error");
        }
        return "redirect:/admin/project";
    }
    
}
