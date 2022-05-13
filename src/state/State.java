/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import java.awt.Graphics;
import toc.Handler;

/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public abstract class State { 
 
    private static State currentState = null;

   protected Handler handler;
    
    public State(Handler handler){
        this.handler = handler;
       
    }
    
    public static State getState() {
        return currentState;
   
    }
  
    
    public static void setState(State state) {
        State.currentState = state;
   
    } 
    
    public abstract void tick();    
    public abstract void render (Graphics g);
    
}
