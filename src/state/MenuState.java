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
public class MenuState extends State {
    
     private UIManager uiManager;
                                    
    public MenuState(Handler handler) {
        super(handler);
        
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);
        
        Bgm.MENUMUSIC.loop();
        handler.getMouseManager().setUIManager(uiManager);
    
                                               //inserisco il tasto play e cosa accade se lo clicco
                                            
       uiManager.addObject(new UIImageButton(336, 311, 128,64, Assets.menu1[0],Assets.menu2[0], new ClickListener() {
                @Override
                public void onClick() {
                    handler.getMouseManager().setUIManager(null);
                    handler.getGame().setSelectionState(handler);
                    State.setState(handler.getGame().selectionState);
                    
                }
        }));
                                                    //exit
           uiManager.addObject(new UIImageButton(336, 311+64,128,64, Assets.menu1[2],Assets.menu2[2], new ClickListener() {
                @Override
                public void onClick() {
                    handler.getMouseManager().setUIManager(null);
                    State.setState(null);
                    System.exit(0);
                }
           }));
  }

    // IMPLEMENTO I METODI ASTRATTI
    @Override
    public synchronized void tick() {
      uiManager.tick();
    }

    @Override
    public synchronized void render(Graphics g) {
    if(uiManager !=null)      
          uiManager.render(g);
           //g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 8, 8);
       }
    
 }
              

