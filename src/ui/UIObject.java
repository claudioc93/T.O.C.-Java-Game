/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public abstract class UIObject {
    
  protected float x, y; //coordinate dell'oggetto nella finestra
  protected int width,height;//altezza e larghezza dell'oggetto
  protected Rectangle bounds;//bordo
  protected boolean hovering =false;//variabile che ci indica se il puntatore del mouse è sopra all'oggetto
    
  public UIObject(float x, float y, int width,int height){  //costruttore
    this.x=x;
    this.y= y;
    this.height=height;
    this.width=width;
    bounds= new Rectangle((int)x,(int) y, width,height); //rettangolo è un oggetto della libreria java.awt.Rectangle
  }
        
  //METODI
  public abstract void tick();
    
    public abstract void render(Graphics g);
            
    public abstract void onClick();
              
    public void onMouseMove(MouseEvent e){ // vedo se il mouse è sopra un bottone
      if(bounds.contains(e.getX(), e.getY()))
        hovering=true;
      else
        hovering=false;
    }
           
    public void onMouseRelease(MouseEvent e){ // vediamo se un bottone viene clickato
      if(hovering)
        onClick();
    }
    
    //GETTERS & SETTERS
    public float getX(){
      return x;
    }

    public void setX(float x){
      this.x = x;
    }

    public float getY(){
      return y;
    }

    public void setY(float y){
      this.y = y;
    }

    public int getWidth(){
      return width;
    }

    public void setWidth(int width){
      this.width = width;
    }

    public int getHeight(){
      return height;
    }

    public void setHeight(int height){
      this.height = height;
    }

    public void setHovering(boolean hovering){
      this.hovering = hovering;
    }
        
    public boolean getHovering(){
      return hovering;
    }
}