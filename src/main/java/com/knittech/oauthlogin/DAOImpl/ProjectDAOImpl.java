/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knittech.oauthlogin.DAOImpl;

import com.knittech.oauthlogin.DAO.ProjectDAO;
import com.knittech.oauthlogin.entity.Project;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sumit
 */
@Repository
public class ProjectDAOImpl implements ProjectDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session;

    @Override
    public List<Project> getAll() throws ClassNotFoundException, SQLException {
        List<Project> project;
        session = sessionFactory.openSession();
        project = session.getNamedQuery("Project.findAll").list();
        session.close();
        return project;
    }

    @Override
    public void insert(Project t) throws ClassNotFoundException, SQLException {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();
        session.close();
    }

    @Override
    public Project getById(int id) throws ClassNotFoundException, SQLException {
        Project project;
        session = sessionFactory.openSession();
        project = session.find(Project.class, id);
        session.close();
        return project;
    }

    @Override
    public void deleteById(int id) throws ClassNotFoundException, SQLException {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("DELETE Project WHERE id = :id").setParameter("id", id).executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Project t) throws ClassNotFoundException, SQLException {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(t);
        transaction.commit();
        session.close();
    }
}
