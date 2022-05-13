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
public abstract class Animation {
    protected Handler handler;

    protected int atkCount, count,deathCount,index,speed,atkSpeed,deathSpeed;//contatori e velocità dei frames
    protected long lastTime,timer,timer2,timer3; //timer per la gestione del cambiamento da un frame a quello successivo

    protected BufferedImage[][] frames;
    protected BufferedImage[][] atkFrames;
    protected BufferedImage[] deathFrames;
 
    public Animation(Handler handler,int speed,int atkSpeed,int deathSpeed,BufferedImage[][] frames ,BufferedImage[][] atkFrames,BufferedImage[] deathFrames){
        this.speed=speed;
        this.atkSpeed=atkSpeed;
        this.deathSpeed=deathSpeed;
        this.handler=handler;
        this.frames=frames;
        this.atkFrames=atkFrames;
        this.deathFrames=deathFrames;
        atkCount=0;
        deathCount=0;
        count=0;
        index=0;
        timer=0;
        timer2=0;
        timer3=0;
        lastTime=System.currentTimeMillis(); 
    }
   
    public abstract void tick();
        
    public abstract void changeFrame();

    public abstract void changeAtkFrame();
    
    public abstract void changeDeathFrames();
    
    public abstract BufferedImage getCurrentFrame();
    
    public abstract BufferedImage getCurrentAtkFrame();
    
    public abstract BufferedImage getCurrentDeathFrame();
     
    public void setIndex(int index) {
        this.index = index;
    }
           
    public int getIndex() {
        return index;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
