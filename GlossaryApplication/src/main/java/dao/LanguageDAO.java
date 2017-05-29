/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Language;
import java.util.List;

/**
 *
 * @author Алина
 */
public interface LanguageDAO {
    
    //create
    void add(Language language);
    
    //read
    List<Language> getAll();
    
    Language getById(Integer id);
    
    //update
    void update(Language language);
    
    //delete
    void remove(Language language);
}
