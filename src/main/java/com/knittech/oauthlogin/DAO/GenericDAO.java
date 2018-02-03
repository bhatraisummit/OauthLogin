/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knittech.oauthlogin.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Sumit
 * @param <T>
 */
public interface GenericDAO<T> {
    List<T> getAll() throws ClassNotFoundException,SQLException;
    void insert(T t) throws ClassNotFoundException,SQLException;
    T getById(int id) throws ClassNotFoundException,SQLException;
    void deleteById(int id) throws ClassNotFoundException,SQLException;
    void update(T t) throws ClassNotFoundException,SQLException;
}
