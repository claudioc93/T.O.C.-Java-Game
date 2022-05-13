/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import entity.dynamicsEntity.Player;
import java.awt.Graphics;
import toc.Handler;
import toc.World;

/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public class GameState extends State {  

  protected static World world;
  protected int id;
  private Player pg;
  
  public GameState(Handler handler,int id) {
    super(handler);
    world=new World(handler,id);
    handler.setWorld(world);
     pg=world.getPg();
  }
    
  @Override
  public void tick() {
  
    world.tick(); //permette di scandire i tempi di aggiornamento del game state
    world.changeWorld(world.getEntityManager().getPlayer().getChange());
    checkLose();
  }  
    
  @Override
  public void render(Graphics g) { 
    //aggiorna rispetto ai tick l'immagine del mondo quando sono in game state
    world.render(g);
          
  }
  
      private void checkLose(){
        if (State.getState()==this && pg.getHealth()<=0){
            handler.getGame().setResetState();
            State.setState(handler.getGame().resetState);
        }
    }
      
  public int getId() {
    return id;
    
  }
   
}
