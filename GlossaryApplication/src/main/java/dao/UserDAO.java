/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Алина
 */
public interface UserDAO {
    
    //create
    void add(User user);
    
    //read
    List<User> getAll() throws SQLException;
    
    User getById(Integer id) throws SQLException;
    
    //update
    void update(User user) throws SQLException;
    
    //delete
    void remove(User user) throws SQLException;
}
