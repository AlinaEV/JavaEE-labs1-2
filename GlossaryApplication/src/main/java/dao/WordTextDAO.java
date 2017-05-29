/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Word_Text;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Алина
 */
public interface WordTextDAO {
    //create
    void add(Word_Text wordText);
    
    //read
    List<Word_Text> getAll();
    
    Word_Text getByWordIdAndTextId(Integer wordId, Integer textId) throws SQLException;
    
    //update
    void update(Word_Text wordText);
    
    //delete
    void remove(Word_Text wordText);
}
