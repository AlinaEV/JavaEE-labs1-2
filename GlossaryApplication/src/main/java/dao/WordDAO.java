/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Word;
import java.util.List;

/**
 *
 * @author Алина
 */
public interface WordDAO {
    
    //create
    void add(Word word);
    
    //read
    List<Word> getAll();
    
    Word getById(Word word);
    
    //update
    void update(Word word);
    
    //delete
    void remove(Word word);
}
