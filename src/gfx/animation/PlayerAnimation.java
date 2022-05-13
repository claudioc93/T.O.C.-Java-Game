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
public class PlayerAnimation extends Animation{

    public PlayerAnimation( Handler handler,int speed,int atkSpeed,int deathSpeed,BufferedImage[][] frames,BufferedImage[][] atkFrames, BufferedImage[] deathFrames){
        super(handler,speed,atkSpeed,deathSpeed,frames,atkFrames,deathFrames);
    }
   
    @Override
    public void tick(){
        
        timer += System.currentTimeMillis() - lastTime; //aggiorno timer movimento
         
        timer2+= System.currentTimeMillis() - lastTime; //aggiorno timer attacco
      
        timer3+= System.currentTimeMillis() - lastTime; //aggiorno timer morte
        
        lastTime = System.currentTimeMillis();    
    }

    @Override
    public void changeFrame(){
        tick();
        if(handler.getKeyManager().pressed){
            if(timer>speed){
                timer = 0; 
                count++;
            }
            if(count>8){
                count=0;
            }
        }else if(handler.getKeyManager().released){
            count=0;
            tick();
        }    
    }
    
    @Override
    public void changeAtkFrame() {
        tick();
        if(timer2>atkSpeed){
            timer2 =0; 
            atkCount++;
        }
        if(atkCount >=5 ){
            atkCount=5;
            if(!handler.getMouseManager().isLeftPressed())
                atkCount=0;
        }
        tick();
    }
 
    
    @Override
    public void changeDeathFrames() {
        tick();
        if(timer3>deathSpeed){
            timer3=0;
            deathCount++;
        }
        if(deathCount>=4)
            deathCount=5;
        tick();
    }
    
    @Override
    public BufferedImage getCurrentFrame(){
       
        if(handler.getKeyManager().up){
            index=0;
            return frames[0][count];
        }

        if(handler.getKeyManager().left){    
            index=1;
            return frames[1][count];  
        }
  
        if(handler.getKeyManager().down){
            index=2;
            return frames[2][count];
        }

        if(handler.getKeyManager().right){
            index=3;
            return frames[3][count];
        }

        return frames[index][0];
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
