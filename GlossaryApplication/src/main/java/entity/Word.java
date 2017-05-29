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
public class Word {
    private Integer id;
    private String name;
    private Integer num_meanings;
    private String transcript;
    private Integer lang_id;
    
    public Word() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum_meanings() {
        return num_meanings;
    }

    public void setNum_meanings(Integer num_meanings) {
        this.num_meanings = num_meanings;
    }

    public String getTranscript() {
        return transcript;
    }

    public void setTranscript(String transcript) {
        this.transcript = transcript;
    }

    public Integer getLang_id() {
        return lang_id;
    }

    public void setLang_id(Integer lang_id) {
        this.lang_id = lang_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.num_meanings);
        hash = 23 * hash + Objects.hashCode(this.transcript);
        hash = 23 * hash + Objects.hashCode(this.lang_id);
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
        final Word other = (Word) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.transcript, other.transcript)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.num_meanings, other.num_meanings)) {
            return false;
        }
        if (!Objects.equals(this.lang_id, other.lang_id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Word{" + "id=" + id + ", name=" + name + ", num_meanings=" + num_meanings + ", transcript=" + transcript + ", lang_id=" + lang_id + '}';
    }
    
    
}
