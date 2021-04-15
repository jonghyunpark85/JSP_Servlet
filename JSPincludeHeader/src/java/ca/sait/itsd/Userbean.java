/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

import java.io.Serializable;

/**
 *
 * @author Jonghyun Park
 */
public class Userbean implements Serializable{
    
    String username;
    
    public Userbean(){
        
    }
    
    public Userbean(String username) {
        this.username = username;
    }

    public String getUsername() {
        
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
}
