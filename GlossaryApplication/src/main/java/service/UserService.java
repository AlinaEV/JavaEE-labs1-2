/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bl.Util;
import dao.UserDAO;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Алина
 */
public class UserService extends Util implements UserDAO{

    Connection connection = getConnection();
    
    @Override
    public void add(User user) {
        PreparedStatement preparedStatement = null;
        
        String sql = "INSERT INTO USER (LOGIN, EMAIL, PASSWORD) VALUES(?,?,?)";
        
        try{
            preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            
            preparedStatement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LanguageService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LanguageService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<User> getAll() throws SQLException{
        List<User> userList = new ArrayList<>();
        
        String sql = "SELECT ID, EMAIL, LOGIN, PASSWORD FROM USER";
        
        Statement statement = null;
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("ID"));
                user.setEmail(resultSet.getString("EMAIL"));
                user.setLogin(resultSet.getString("LOGIN"));
                user.setPassword(resultSet.getString("PASSWORD"));
                
                userList.add(user);
            }
        }catch(SQLException e){
            e.printStackTrace();
        } finally{
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return userList;
    }

    @Override
    public User getById(Integer id) throws SQLException{
        PreparedStatement preparedStatement = null;
        
        String sql = "SELECT ID, EMAIL, LOGIN, PASSWORD FROM USER WHERE ID=?";
        
        User user = new User();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            user.setId(resultSet.getInt("ID"));
            user.setEmail(resultSet.getString("EMAIL"));
            user.setLogin(resultSet.getString("LOGIN"));
            user.setPassword(resultSet.getString("PASSWORD"));
            
            preparedStatement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return user;
    }

    @Override
    public void update(User user) throws SQLException{
        PreparedStatement preparedStatement = null;
        
        String sql = "UPDATE USER SET EMAIL=?, LOGIN=?, PASSWORD=? WHERE ID=?";
        
        try{
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1,user.getEmail());
            preparedStatement.setString(2,user.getLogin());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setInt(4,user.getId());
            
            preparedStatement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void remove(User user) throws SQLException{
        PreparedStatement preparedStatement = null;
        
        String sql = "DELETE FROM USER WHERE ID=?";
       
        try{
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, user.getId());
         
            preparedStatement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }
    
}
