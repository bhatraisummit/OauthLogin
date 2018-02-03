/*
 * To change this license header, choose License Headers in Task Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knittech.oauthlogin.DAOImpl;

import com.knittech.oauthlogin.DAO.TaskDAO;
import com.knittech.oauthlogin.entity.Task;
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
public class TaskDAOImpl implements TaskDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session;

    @Override
    public List<Task> getAll() throws ClassNotFoundException, SQLException {
        List<Task> task;
        session = sessionFactory.openSession();
        task = session.getNamedQuery("Task.findAll").list();
        session.close();
        return task;
    }

    @Override
    public void insert(Task t) throws ClassNotFoundException, SQLException {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();
        session.close();
    }

    @Override
    public Task getById(int id) throws ClassNotFoundException, SQLException {
        Task task;
        session = sessionFactory.openSession();
        task = session.find(Task.class, id);
        session.close();
        return task;
    }

    @Override
    public void deleteById(int id) throws ClassNotFoundException, SQLException {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("DELETE Task WHERE id = :id").setParameter("id", id).executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Task t) throws ClassNotFoundException, SQLException {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(t);
        transaction.commit();
        session.close();
    }
}
