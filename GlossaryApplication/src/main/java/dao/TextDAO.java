/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Text;
import java.util.List;

/**
 *
 * @author Алина
 */
public interface TextDAO {
    
    //create
    void add(Text text);
    
    //read
    List<Text> getAll();
    
    Text getById(Integer id);
    
    //update
    void update(Text text);
    
    //delete
    void remove(Text text);
}
