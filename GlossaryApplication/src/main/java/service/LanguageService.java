/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bl.Util;
import dao.LanguageDAO;
import entity.Language;
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
public class LanguageService extends Util implements LanguageDAO{

    Connection connection = getConnection();
    
    @Override
    public void add(Language language) {
        PreparedStatement preparedStatement = null;
        
        String sql = "INSERT INTO LANGUAGE ( NAME) VALUES(?)";
        
        try{
            preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setInt(1, language.getId());
            preparedStatement.setString(1, language.getName());
            
            preparedStatement.executeUpdate();
        } catch(SQLException e){
            throw new IllegalArgumentException(e);
            //e.printStackTrace();
        } finally{
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    //throw new IllegalArgumentException(ex);
                    Logger.getLogger(LanguageService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    //throw new IllegalArgumentException(ex);
                    Logger.getLogger(LanguageService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<Language> getAll(){
        
        List<Language> languageList = new ArrayList<Language>();
        
        try {
            String sql = "SELECT ID, NAME FROM LANGUAGE";
            
            Statement statement = null;
            
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Language language = new Language();
                language.setId(resultSet.getInt("id"));
                language.setName(resultSet.getString("name"));

                languageList.add(language);
            }
        
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
            
            
        } catch (SQLException ex) {
            //Logger.getLogger(LanguageService.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalArgumentException(ex);
        }
        return languageList;
    }

    @Override
    public Language getById(Integer id){
        PreparedStatement preparedStatement = null;
        
        String sql = "SELECT ID, NAME FROM LANGUAGE WHERE ID=?";
        
        Language language = new Language();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
            language.setId(resultSet.getInt("ID"));
            language.setName(resultSet.getString("NAME"));
            
            }
        } catch(SQLException e){
            throw new IllegalArgumentException(e);
            //e.printStackTrace();
        } finally{
             try {
                if(preparedStatement != null){

                        preparedStatement.close();

                }
                if(connection != null){
                        connection.close();
                }
            } catch (SQLException ex) {
                    //throw new IllegalArgumentException(ex);
                    Logger.getLogger(LanguageService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return language;
    }

    @Override
    public void update(Language language){
        PreparedStatement preparedStatement = null;
        
        String sql = "UPDATE LANGUAGE SET NAME=? WHERE ID=?";
        
        try{
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1,language.getName());
            preparedStatement.setInt(2,language.getId());
            
            preparedStatement.executeUpdate();
        } catch(SQLException e){
            throw new IllegalArgumentException(e);
            //e.printStackTrace();
        } finally{
            try {
                if(preparedStatement != null){
                        preparedStatement.close();
                }
                if(connection != null){
                        connection.close();
                }
            } catch (SQLException ex) {
                    throw new IllegalArgumentException(ex);
                    //Logger.getLogger(LanguageService.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }

    @Override
    public void remove(Language language){
        PreparedStatement preparedStatement = null;
        
        String sql = "DELETE FROM LANGUAGE WHERE ID=?";
       
        try{
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, language.getId());
         
            preparedStatement.executeUpdate();
        } catch(SQLException e){
            throw new IllegalArgumentException(e);
            //e.printStackTrace();
        } finally{
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    //throw new IllegalArgumentException(ex);
                    Logger.getLogger(LanguageService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    //throw new IllegalArgumentException(ex);
                    Logger.getLogger(LanguageService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
