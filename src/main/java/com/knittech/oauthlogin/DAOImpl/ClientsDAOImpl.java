/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knittech.oauthlogin.DAOImpl;

import com.knittech.oauthlogin.DAO.ClientsDAO;
import com.knittech.oauthlogin.entity.Clients;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Hibernate;
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
public class ClientsDAOImpl implements ClientsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session;

    @Override
    public List<Clients> getAll() throws ClassNotFoundException, SQLException {
        List<Clients> clients;
        session = sessionFactory.openSession();
        clients = session.getNamedQuery("Clients.findAll").list();
        session.close();
        return clients;
    }

    @Override
    public void insert(Clients t) throws ClassNotFoundException, SQLException {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();
        session.close();
    }

    @Override
    public Clients getById(int id) throws ClassNotFoundException, SQLException {
        Clients clients;
        session = sessionFactory.openSession();
        clients = session.find(Clients.class, id);
        session.close();
        return clients;
    }
    
    @Override
    public Clients getByIdWithClients(int id) throws ClassNotFoundException,SQLException{
        session = sessionFactory.openSession();
        Clients clients = session.find(Clients.class, id);
        Hibernate.initialize(clients.getProjectList());
        session.close();
        return clients;
    }

    @Override
    public void deleteById(int id) throws ClassNotFoundException, SQLException {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("DELETE Clients WHERE id = :id").setParameter("id", id).executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Clients t) throws ClassNotFoundException, SQLException {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(t);
        transaction.commit();
        session.close();
    }

}
