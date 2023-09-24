/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author vaish
 */
public class VitalSignHistory {
    
    private ArrayList<VitalSigns> history; 

//arraylist is an object and like all objects we need to initialize using constructor - method with same name as class and is called 
    
    public VitalSignHistory(){
        
        this.history= new ArrayList<VitalSigns>();
         
    }

    public ArrayList<VitalSigns> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<VitalSigns> history) {
        this.history = history;
    }
    
    public VitalSigns addNewVitals(){
        
        VitalSigns newVitals= new VitalSigns();
        history.add(newVitals);
        return newVitals;
        
    }
    
    public void deleteVitals(VitalSigns vs){
        history.remove(vs);
        
    }
}
