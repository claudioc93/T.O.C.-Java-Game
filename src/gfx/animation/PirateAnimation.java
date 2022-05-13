/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfx.animation;

import java.awt.image.BufferedImage;
import toc.Handler;

/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public class PirateAnimation extends Animation {
    
    public PirateAnimation(Handler handler, int speed, int atkSpeed, int deathSpeed, BufferedImage[][] frames, BufferedImage[][] atkFrames, BufferedImage[] deathFrames) {
        super(handler, speed, atkSpeed, deathSpeed, frames, atkFrames, deathFrames); 
    }

    @Override
    public void changeAtkFrame() {
        tick();
        if(timer2>atkSpeed){
            timer2 =0; 
            atkCount++;
        }
        if(atkCount>5){
            atkCount=0;
        }
    }

    @Override
    public void tick() {
        timer += System.currentTimeMillis() - lastTime;
         
        timer2+= System.currentTimeMillis() - lastTime;
      
        timer3+= System.currentTimeMillis() - lastTime;
        
        lastTime = System.currentTimeMillis();  
    }

    @Override
    public void changeFrame() {
        tick();
        
        if(timer>speed){
            timer =0; 
            count++;
        }
        if(count>7){
            count=0;
        }
    }

    @Override
    public void changeDeathFrames() {
        tick();
        if(timer3>deathSpeed ){
            timer3=0;
            deathCount++;
        }
        if(deathCount>=4)
            deathCount=5;
        tick();
    }
    
    
    

    @Override
    public BufferedImage getCurrentFrame() {
        return frames[index][count];   
    }

    @Override
    public BufferedImage getCurrentAtkFrame() {
       return atkFrames[index][atkCount];
    }

    @Override
     public BufferedImage getCurrentDeathFrame() {
        return deathFrames[deathCount];
    }
}

