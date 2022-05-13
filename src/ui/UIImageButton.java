/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public class UIImageButton extends  UIObject {
    private BufferedImage image;
    private BufferedImage image2;
    private ClickListener clicker;

//costruttore
   public UIImageButton(float x, float y, int width, int height, BufferedImage image,BufferedImage image2,ClickListener clicker) {
        super(x, y, width, height);
        this.image= image;
        this.image2=image2;
        this.clicker= clicker;
    }

   
//implemento i metodi astratti
    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        if(!hovering)
            g.drawImage(image,(int) x,(int) y, width,height,null);
        else
            g.drawImage(image2,(int) x,(int) y, width,height,null);
    }

    @Override
    public void onClick() {
        clicker.onClick();
        
    }
}
