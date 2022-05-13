/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dynamicsEntity;

import entity.Entity;
import gfx.Assets;
import gfx.animation.SkeletonAnimation;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import toc.Handler;

/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */

public class Skeleton extends Creatures {
  float dmax,dmin;
  private long timerRem; 

     
  public Skeleton (Handler handler, float x, float y) {
    super(handler, x, y,DEFAULT_CREATURE_WIDTH,DEFAULT_CREATURE_HEIGHT );
        
    bounds.x =43;
    bounds.y=60;
    bounds.width=16;
    bounds.height=32;
    dmax=250;
    dmin=50;
     
    anim= new SkeletonAnimation(handler,60,180,100,Assets.skeletonanimation,Assets.skeleton_animationAtk, Assets.skeleton_animationDeath);  
  }  
    
  @Override
  public void tick() {
    move();
    chasePlayer(dmax,dmin,anim);
     checkRemove();
  }

     
  @Override
  public void render(Graphics g) {
    if (dead ){
      anim.changeDeathFrames();
      g.drawImage(anim.getCurrentDeathFrame(),(int) (x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),2*width,2*height,null);
    } 
    else if(attacking){
      g.drawImage(anim.getCurrentAtkFrame(),(int) (x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),2*width,2*height,null);
    }
    else{
      g.drawImage(anim.getCurrentFrame(),(int) (x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),2*width,2*height,null);
      // Draw hitbox
     // g.setColor(Color.blue);
      //g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);               
    }
  }

  @Override
  public void die() {
    dead = true;     
    timerRem=System.nanoTime();
  }

  @Override
  public void Attacks() {
    
    if(!handler.getWorld().getEntityManager().getPlayer().dead){
    
      Rectangle  ar = new Rectangle ();   
      Rectangle cb = getCollisionBounds(0,0);
      int arSize = 26;
      ar.width = arSize;
      ar.height = arSize;   
      if (anim.getIndex() == 0){
        anim.changeAtkFrame();
        ar.x = cb.x + cb.width /2 - arSize /2 ;
        ar.y =   cb.y - arSize;
      }
      else if (anim.getIndex() == 1){   
        anim.changeAtkFrame();
        ar.x = cb.x - arSize ;
        ar.y =   cb.y + cb.height /2 - arSize/2;
      }
      else if (anim.getIndex() == 2){   
        anim.changeAtkFrame();
        ar.x = cb.x + cb.width /2 - arSize /2 ;
        ar.y =   cb.y + cb.height;
      }
      else if (anim.getIndex() == 3){   
        anim.changeAtkFrame();
        ar.x = cb.x + cb.width ;
        ar.y =   cb.y + cb.height /2 - arSize/2;
      }       
      for (Entity e: handler.getWorld().getEntityManager().getEntities()){
        if (!e.equals(handler.getWorld().getEntityManager().getPlayer()))
         continue;
             if (e.getCollisionBounds(0, 0).intersects (ar)&& timerAtk-lastAtk>500){
              lastAtk=System.currentTimeMillis();
              e.hurt(1);
               System.out.println(e.getHealth());
              }
         } 
    }
      timerAtk=System.currentTimeMillis();
  }
  @Override
      public void checkRemove(){
        if(dead && System.nanoTime()-timerRem >2000000000){
            handler.getWorld().enemyNumberDecraese();
            handler.getWorld().getEntityManager().removeEntity(this);  }
      }
}
