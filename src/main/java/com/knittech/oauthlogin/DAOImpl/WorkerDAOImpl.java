/*
 * To change this license header, choose License Headers in Worker Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knittech.oauthlogin.DAOImpl;

import com.knittech.oauthlogin.DAO.WorkerDAO;
import com.knittech.oauthlogin.entity.Worker;
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
public class WorkerDAOImpl implements WorkerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session;

    @Override
    public List<Worker> getAll() throws ClassNotFoundException, SQLException {
        List<Worker> worker;
        session = sessionFactory.openSession();
        worker = session.getNamedQuery("Worker.findAll").list();
        session.close();
        return worker;
    }

    @Override
    public void insert(Worker t) throws ClassNotFoundException, SQLException {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();
        session.close();
    }

    @Override
    public Worker getById(int id) throws ClassNotFoundException, SQLException {
        Worker worker;
        session = sessionFactory.openSession();
        worker = session.find(Worker.class, id);
        session.close();
        return worker;
    }

    @Override
    public void deleteById(int id) throws ClassNotFoundException, SQLException {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("DELETE Worker WHERE id = :id").setParameter("id", id).executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Worker t) throws ClassNotFoundException, SQLException {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(t);
        transaction.commit();
        session.close();
    }
}
