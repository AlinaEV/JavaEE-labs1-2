/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bl.Util;
import dao.WordTextDAO;
import entity.Word_Text;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Алина
 */
public class WordTextService extends Util implements WordTextDAO{

    Connection connection = getConnection();
    
    @Override
    public void add(Word_Text wordText) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Word_Text> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Word_Text getByWordIdAndTextId(Integer wordId, Integer textId) throws SQLException{
        PreparedStatement preparedStatement = null;
        
        String sql = "SELECT WORD_ID, TEXT_ID FROM WORD_TEXT WHERE WORD_ID=? AND TEXT_ID=?";
        
        Word_Text wordText = new Word_Text();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, wordId);
             preparedStatement.setInt(1, textId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            wordText.setWord_id(resultSet.getInt("WORD_ID"));
            wordText.setText_id(resultSet.getInt("TEXT_ID"));
            
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
        return wordText;
    }

    @Override
    public void update(Word_Text wordText) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Word_Text wordText) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
