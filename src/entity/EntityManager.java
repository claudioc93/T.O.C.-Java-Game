/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.dynamicsEntity.Dragon;
import entity.dynamicsEntity.Pirate;
import entity.dynamicsEntity.Player;
import entity.dynamicsEntity.Skeleton;
import entity.staticEntity.Amphora1;
import entity.staticEntity.Amphora2;
import entity.staticEntity.Amphora3;
import entity.staticEntity.Barrels;
import entity.staticEntity.Bench1;
import entity.staticEntity.Bench2;
import entity.staticEntity.Boat1;
import entity.staticEntity.Boat2;
import entity.staticEntity.Bush;
import entity.staticEntity.Column1;
import entity.staticEntity.Column2;
import entity.staticEntity.Column3;
import entity.staticEntity.Crates1;
import entity.staticEntity.Crates2;
import entity.staticEntity.Fire;
import entity.staticEntity.Guillotine;
import entity.staticEntity.Handcuffs;
import entity.staticEntity.Haystack;
import entity.staticEntity.Oar1;
import entity.staticEntity.Oar2;
import entity.staticEntity.Oar3;
import entity.staticEntity.Statue1;
import entity.staticEntity.Statue2;
import entity.staticEntity.Statue3;
import entity.staticEntity.Statue4;
import entity.staticEntity.Stone;
import entity.staticEntity.Tend1;
import entity.staticEntity.Tend2;
import entity.staticEntity.Tomb1;
import entity.staticEntity.Tomb2;
import entity.staticEntity.Tomb3;
import entity.staticEntity.Trasure1;
import entity.staticEntity.Trasure2;
import entity.staticEntity.Trasure3;
import entity.staticEntity.Well;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import toc.Handler;
import static utilities.Utils.parseInt;
import utilities.arrayComparator;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public class EntityManager {
  
  private Handler handler;
  private Player player;
  private ArrayList<Entity> entities;//con un ArrayList possiamo aggiungere e rimuovere quante entità vogliamo,
                                     //non devo speificare la dimensione
                                     // per gestirlo devo usare i get e set
  
  public EntityManager(Handler handler,Player player){
    this.handler = handler;
    this.player= player;
    entities = new ArrayList<Entity>();
    addEntity(player);
  }
    
  public void tick(){  
    Collections.sort(entities, new arrayComparator()); 
    for(int i =0;i< entities.size();i++){
      Entity e = entities.get(i);
      e.tick();
    }
  }
    
  public void render(Graphics g){
    for(Entity e: entities)//creo un entità e dopo scorro tutta la lista
      e.render(g);
  }
    
  public void addEntity(Entity e){
    entities.add(e);
  }
  
 public void removeEntity(Entity e){
        entities.remove(e);
  }
 
  public void removeAllEntity(){
    entities.removeAll(entities);
    addEntity(player);
  }
    
  public void loadWorldEntities(String path){
    try {
      File file = new File(path);
      Scanner sc = new Scanner(file);
            
      while(sc.hasNextLine()){
        String line = sc.nextLine();
        String[] values = line.split("\\s+");         
                
        if(values.length == 3){
          int id = parseInt(values[0]);
          int spawnX = parseInt(values[1]);
          int spawnY = parseInt(values[2]);
                    
          switch(id){
          case 1:
            addEntity(new Bush(handler, spawnX, spawnY));
            break;
                        
          case 2:
            addEntity(new Barrels(handler, spawnX, spawnY));
            break;
                          
          case 3:
            addEntity(new Tend1(handler, spawnX, spawnY));
            break;
                             
          case 4:
            addEntity(new Tend2(handler, spawnX, spawnY));
            break;
                             
          case 5:
            addEntity(new Crates1(handler, spawnX, spawnY));
            break;
                             
          case 6:
            addEntity(new Crates2(handler, spawnX, spawnY));
            break;
                             
          case 7:
            addEntity(new Statue1(handler, spawnX, spawnY));
            break;
                             
          case 8:
            addEntity(new Statue2(handler, spawnX, spawnY));
            break;
                             
          case 9:
            addEntity(new Statue3(handler, spawnX, spawnY));
            break;
                             
          case 10:
            addEntity(new Statue4(handler, spawnX, spawnY));
            break;
                             
          case 11:
            addEntity(new Well(handler, spawnX, spawnY));
            break;
                             
          case 12:
            addEntity(new Haystack(handler, spawnX, spawnY));
            break;
                      
          case 13:
            addEntity(new Trasure1(handler, spawnX, spawnY));
            break;
                             
          case 14:
            addEntity(new Trasure2(handler, spawnX, spawnY));
            break;
                             
          case 15:
            addEntity(new Trasure3(handler, spawnX, spawnY));
            break;
                      
          case 16:
            addEntity(new Amphora1(handler, spawnX, spawnY));
            break;
                          
          case 18:
            addEntity(new Amphora2(handler, spawnX, spawnY));
            break;
                                                
          case 19: 
            addEntity(new Boat1(handler, spawnX, spawnY));
            break;
                             
          case 20: 
            addEntity(new Boat2(handler, spawnX, spawnY));
            break;
                             
          case 21:
            addEntity(new Amphora3(handler, spawnX, spawnY));
            break;
                        
          case 22:
            addEntity(new Oar1(handler, spawnX, spawnY));
            break;
                             
          case 23: 
            addEntity(new Oar2(handler, spawnX, spawnY));
            break;
                             
          case 24:
            addEntity(new Oar3(handler, spawnX, spawnY));
            break;
                          
          case 25:
            addEntity(new Tomb1(handler, spawnX, spawnY));
            break;
                             
          case 26: 
            addEntity(new Tomb2(handler, spawnX, spawnY));
            break;

          case 27: 
            addEntity(new Tomb3(handler, spawnX, spawnY));
            break;
                             
          case 28: 
            addEntity(new Column1(handler, spawnX, spawnY));
            break;

          case 29:
            addEntity(new Column2(handler, spawnX, spawnY));
            break;

          case 30:
            addEntity(new Column3(handler, spawnX, spawnY));
            break;

          case 31: 
            addEntity(new Guillotine(handler, spawnX, spawnY));
            break;

          case 32: 
            addEntity(new Bench1(handler, spawnX, spawnY));
            break;

          case 33: 
            addEntity(new Bench2(handler, spawnX, spawnY));
            break;

          case 34: 
            addEntity(new Handcuffs(handler, spawnX, spawnY));
            break;
                      
          case 35:
            addEntity(new Stone(handler, spawnX, spawnY));
            break;

          case 36:
            addEntity(new Fire(handler, spawnX, spawnY));
            break;
                    
          case 101:
            addEntity(new Pirate(handler,spawnX,spawnY));
            break;
                        
          case 102:
            addEntity(new Skeleton(handler,spawnX,spawnY));
            break;
                          
          case 103:
            addEntity(new Dragon(handler,spawnX,spawnY));
            break;
          
          }
        }
      }
    }catch (FileNotFoundException ex) {
            Logger.getLogger(EntityManager.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
       
  //GETTERS & SETTERS
  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public ArrayList<Entity> getEntities() {
    return entities;
  }

  public void setEntities(ArrayList<Entity> entities) {
    this.entities = entities;
  }
    
}

