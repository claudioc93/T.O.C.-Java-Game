/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import toc.Handler;
/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public class UIManager {
  
  private Handler handler;
  private ArrayList<UIObject> objects=null;//ci permette di immaggazzinare oggetti di vario tipo non solo bottoni
    
  //COSTRUTTORE
  public UIManager(Handler handler){
    this.handler= handler;
    this.objects= new ArrayList<>();
  }
    
  //METODI
  public void tick(){
    for(UIObject o: objects)
      o.tick();
  }

  public  void  render(Graphics g){
for(UIObject o: objects)
    o.render(g);
          //g.fillRect(o.bounds.x, o.bounds.y,o.bounds.width , o.bounds.height);
     
  }
    
  public void onMouseMove(MouseEvent e){
    for(UIObject o: objects){
      o.onMouseMove(e);
    }
  }
    
  public void onMouseRelease(MouseEvent e){
    for(UIObject o: objects)
      o.onMouseRelease(e);
  }
    
  public void addObject(UIObject o){
    objects.add(o);
  }
    
  public void removeObject(UIObject o){
    objects.remove(o);
  }
  
  
  
  //getters & setters
  public Handler getHandler() {
    return handler;
  }

  public void setHandler(Handler handler) {
    this.handler = handler;
  }

  public ArrayList<UIObject> getObjects() {
    return objects;
  }

  public void setObjects(ArrayList<UIObject> objects) {
    this.objects = objects;
  }
}

