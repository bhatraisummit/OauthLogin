/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knittech.oauthlogin.DAO;

import com.knittech.oauthlogin.entity.Clients;
import java.sql.SQLException;

/**
 *
 * @author Sumit
 */
public interface ClientsDAO extends GenericDAO<Clients>{
    public Clients getByIdWithClients(int id) throws ClassNotFoundException,SQLException;
}
