/*
 * To change this license header, choose License Headers in Skills Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knittech.oauthlogin.DAOImpl;

import com.knittech.oauthlogin.DAO.SkillsDAO;
import com.knittech.oauthlogin.entity.Skills;
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
public class SkillsDAOImpl implements SkillsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session;

    @Override
    public List<Skills> getAll() throws ClassNotFoundException, SQLException {
        List<Skills> skills;
        session = sessionFactory.openSession();
        skills = session.getNamedQuery("Skills.findAll").list();
        session.close();
        return skills;
    }

    @Override
    public void insert(Skills t) throws ClassNotFoundException, SQLException {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();
        session.close();
    }

    @Override
    public Skills getById(int id) throws ClassNotFoundException, SQLException {
        Skills skills;
        session = sessionFactory.openSession();
        skills = session.find(Skills.class, id);
        session.close();
        return skills;
    }

    @Override
    public void deleteById(int id) throws ClassNotFoundException, SQLException {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("DELETE Skills WHERE id = :id").setParameter("id", id).executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Skills t) throws ClassNotFoundException, SQLException {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(t);
        transaction.commit();
        session.close();
    }
}
