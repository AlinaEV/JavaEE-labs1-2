/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Meaning;
import java.util.List;

/**
 *
 * @author Алина
 */
public interface MeaningDAO {
    //create
    void add(Meaning meaning);
    
    //read
    List<Meaning> getAll();
    
    Meaning getById(Integer id);
    
    //update
    void update(Meaning meaning);
    
    //delete
    void remove(Meaning meaning);
}
