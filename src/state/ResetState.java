/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import audio.Bgm;
import entity.dynamicsEntity.Player;
import gfx.Assets;
import java.awt.Graphics;
import toc.Handler;
import ui.UIImageButton;
import ui.UIManager;

/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public class ResetState extends State {

      private UIManager uiManager;
    
   public ResetState( Handler handler){
       super(handler);
       uiManager = new UIManager(handler);
       handler.getMouseManager().setUIManager(uiManager);
       
        handler.getMouseManager().setUIManager(uiManager);
           //inserisco il tasto play e cosa accade se lo clicco
                                            
                                             uiManager.addObject(new UIImageButton(270, 404, 128,64, Assets.menu1[0],Assets.menu2[0], () -> {
                                               State.getState().setState(null);//devo aggiungere che se premo play devo prima di tutto resettare ogni cosa!
                                               handler.getMouseManager().setUIManager(null);
                                                handler.getGame().setSelectionState(handler);
                                                State.setState(handler.getGame().selectionState);
    }));
    
                                                    //exit
                                               uiManager.addObject(new UIImageButton(270, 404+64,128,64, Assets.menu1[2],Assets.menu2[2], () -> {
                                                 handler.getMouseManager().setUIManager(null);
                                                 State.setState(null);
                                                 System.exit(0);
    }));
                                             
                                             
   }
   
    @Override
    public void tick() {
           uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }
    

    
}
