/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Алина
 */
public class Word_Text {
    private Integer id;
    private Integer word_id;
    private Integer text_id;
    
    public Word_Text(){
    
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWord_id() {
        return word_id;
    }

    public void setWord_id(Integer word_id) {
        this.word_id = word_id;
    }

    public Integer getText_id() {
        return text_id;
    }

    public void setText_id(Integer text_id) {
        this.text_id = text_id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.word_id);
        hash = 23 * hash + Objects.hashCode(this.text_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Word_Text other = (Word_Text) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.word_id, other.word_id)) {
            return false;
        }
        if (!Objects.equals(this.text_id, other.text_id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Word_Text{" + "id=" + id + ", word_id=" + word_id + ", text_id=" + text_id + '}';
    }
    
    
}
