/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import toc.Handler;

/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public abstract class Entity {
  
  public static final int DEFAULT_HEALTH =5;
  protected Handler handler;
  protected float x,y;
  protected int width,height;
  protected Rectangle bounds;
  protected int health;
      
  public Entity(Handler handler, float x,float y, int width, int height){
    this.handler= handler;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    bounds =new Rectangle(0,0,width,height);
    health = DEFAULT_HEALTH ; // inizializzo la vita a 5 poi ci saranno metodi per cambiarla
  }
    
  public abstract void die();
   
  public void hurt (int amt){
    if( health>0 ){
        health -= amt;
          if (health <=0)
                 die();
  }else{
    }
  }
  
  public float getX() {
    return x;
  }

  public void setX(float x) {
    this.x = x;
  }

  public float getY() {
    return y;
  }

  public void setY(float y) {
    this.y = y;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }
  
  public void setHeight(int height) {
    this.height = height;
  }
  
  public int getHealth() {
    return health;
  }
   

  public abstract void tick();
    
  public abstract void render(Graphics g);
    
  public Rectangle getCollisionBounds(float xOffset, float yOffset){
    return new Rectangle ((int) (x + bounds.x + xOffset), (int) (y+ bounds.y + yOffset),bounds.width,bounds.height);
  }
  
  public boolean checkEntityCollision( float xOffset, float yOffset){
    for ( Entity e : handler.getWorld().getEntityManager().getEntities()){
      if(e.equals(this))//non vogliamo che l'entità che chiama questo metodo testi la collisione con se stessa sarebbe sicuro positiva
        continue;
      if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset,yOffset)))
        return true; //c'è una collisione
      }
    return false;
  }
}
  
 
