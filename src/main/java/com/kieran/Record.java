package com.kieran;

import java.io.Serializable;

/**
 * Created by kieran on 09/04/16.
 */
public class Record implements  Serializable{
    static final long serialVersionUID = 1L;
    private String nameAndAge;


    public Record() {
    }
        public String getNameAndAge() { return this.nameAndAge;}

        public void setNameAndAge(String nameAndAge) {this.nameAndAge = nameAndAge;}

    public Record(String nameAndAge){
        this.nameAndAge= nameAndAge;
    }
}
