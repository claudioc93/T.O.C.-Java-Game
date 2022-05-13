/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.staticEntity;

import gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import toc.Handler;
/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public class Column2  extends StaticEntity {
     private static int objectWidth = 64;
    private static int objectHeight = 64;
    public Column2 (Handler handler, float x, float y) {
        super(handler, x, y, objectWidth, objectHeight);        
        bounds.x =24;
        bounds.y =25;
        bounds.width = 9;
        bounds.height = 15;
    }

    public void update() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.world3_Entities[0][4], (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), objectWidth, objectHeight, null);
        // Draw hitbox
       //g.setColor(Color.red);
       //g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
    }

    @Override
    public void tick() {
      
    }
    
      @Override
    public void die() {
     } 
    
}
