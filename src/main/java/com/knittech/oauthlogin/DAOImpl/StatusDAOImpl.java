/*
 * To change this license header, choose License Headers in Status Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knittech.oauthlogin.DAOImpl;

import com.knittech.oauthlogin.DAO.StatusDAO;
import com.knittech.oauthlogin.entity.Status;
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
public class StatusDAOImpl implements StatusDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session;

    @Override
    public List<Status> getAll() throws ClassNotFoundException, SQLException {
        List<Status> status;
        session = sessionFactory.openSession();
        status = session.getNamedQuery("Status.findAll").list();
        session.close();
        return status;
    }

    @Override
    public Status getById(int id) throws ClassNotFoundException, SQLException {
        Status status;
        session = sessionFactory.openSession();
        status = session.find(Status.class, id);
        session.close();
        return status;
    }

    @Override
    public void insert(Status t) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(int id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Status t) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
