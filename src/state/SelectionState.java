/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import audio.Bgm;
import gfx.Assets;
import java.awt.Graphics;
import toc.Handler;
import ui.ClickListener;
import ui.UIImageButton;
import ui.UIManager;



/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public class SelectionState extends State {
  
     private UIManager uiManager;
  
  public SelectionState(Handler handler) {
    super(handler);
    
    uiManager = new UIManager(handler);
    handler.getMouseManager().setUIManager(uiManager);
   
    
   
            
    //inserisco il tasto cavaliere 
   uiManager.addObject(new UIImageButton(100, 200, 128, 64, Assets.select2[0],Assets.select1[0], new ClickListener() {
        @Override
            public void onClick() {
                      handler.getMouseManager().setUIManager(null);
                      handler.getGame().setGameState(0);
                      State.setState(handler.getGame().gameState);
            Bgm.MENUMUSIC.stop();
        }
    }));
                                            
    //inserisco il tasto guerriera 
     uiManager.addObject(new UIImageButton(600, 200, 128,64, Assets.select2[1],Assets.select1[1], new ClickListener() {
        @Override
            public void onClick() {
                      handler.getMouseManager().setUIManager(null);
                      handler.getGame().setGameState(1);
                      State.setState(handler.getGame().gameState);
           Bgm.MENUMUSIC.stop();
        }
    }));
                                            
    //inserisco il tasto arcere 
  uiManager.addObject(new UIImageButton(100, 300, 128,64, Assets.select2[2],Assets.select1[2], new ClickListener() {
           @Override
           public void onClick() {
                      handler.getMouseManager().setUIManager(null);
                      handler.getGame().setGameState(2);
                      State.setState(handler.getGame().gameState);
           Bgm.MENUMUSIC.stop();
        }
    }));
      
    //inserisco il tasto arcera
  uiManager.addObject(new UIImageButton(600, 300, 128,64, Assets.select2[3],Assets.select1[3], new ClickListener() {
           @Override
           public void onClick() {
                      handler.getMouseManager().setUIManager(null);
                      handler.getGame().setGameState(3); 
                      State.setState(handler.getGame().gameState);
           Bgm.MENUMUSIC.stop();
        }
    }));
                                            
    //inserisco il tasto mago
      uiManager.addObject(new UIImageButton(100, 400, 128,64, Assets.select2[4],Assets.select1[4], new ClickListener() {
           @Override
           public void onClick() {
                      handler.getMouseManager().setUIManager(null);
                      handler.getGame().setGameState(4);
                      State.setState(handler.getGame().gameState);
           Bgm.MENUMUSIC.stop();
        }
    }));
                                            
    //inserisco il tasto strega
    uiManager.addObject(new UIImageButton(600, 400, 128,64, Assets.select2[5],Assets.select1[5], new ClickListener() {
           @Override
           public void onClick() {
                      handler.getMouseManager().setUIManager(null);
                      handler.getGame().setGameState(5);
                      State.setState(handler.getGame().gameState);
            Bgm.MENUMUSIC.stop();
        }
    }));                                        
                                            
  }
                        
    @Override
    public void tick() {
      uiManager.tick();
    }

    @Override
    public synchronized void render(Graphics g) {
        if(uiManager !=null)   
            uiManager.render(g);
            // g.fillRect(StateManager.handler.getMouseManager().getMouseX(), StateManager.handler.getMouseManager().getMouseY(), 8, 8);
       }
    }

    