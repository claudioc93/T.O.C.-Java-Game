/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dynamicsEntity;

import entity.Entity;
import gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import toc.Handler;

/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public class Arrow extends Creatures{
    
      
  
    int index;
    boolean remove=false;
    float xF,yF,xI,yI;
    private Rectangle a = new Rectangle();
    private long timer =System.nanoTime(); 
            
    public Arrow (Handler handler, float x, float y) {
        super(handler, x, y,DEFAULT_CREATURE_WIDTH,DEFAULT_CREATURE_HEIGHT );
        
        bounds.x =0;
        bounds.y=0;
        this.index=0;
        this.setSpeed(10);
    
    }         
    
    public void ArrowSet(int i){
                
       float pgX,pgY;
      
       pgX=handler.getWorld().getEntityManager().getPlayer().getX();
       pgY=handler.getWorld().getEntityManager().getPlayer().getY();
       this.x=pgX;
       this.y=pgY;
       this.xI=pgX;
       this.yI=pgY;
        this.setIndex(i);
        
       if(index==0){
            this.bounds.x =48;
            this.bounds.y =16;
            bounds.width=6;
            bounds.height=6;
            this.xF=this.xI;
            this.yF=this.yI - 250;
       }
                            
      if(index==1){
            this.x=x-16;
            this.bounds.x =40;
            this.bounds.y =64;
            bounds.width=6;
            bounds.height=6;
            this.xF=this.xI-250;
            this.yF=this.yI;
    
                     
      }
   if(index==2){
            this.y=y+16;
            this.bounds.x=48;
            this.bounds.y =80;
            bounds.width=6;
            bounds.height=6;
        this.xF=this.xI;
        this.yF=this.yI + 250;
   }
       
    if(index==3){
            this.x=x+16;
            this.bounds.x =60;
            this.bounds.y =64;
            bounds.width=6;
            bounds.height=6;
         this.xF=this.xI+250;
         this.yF=this.yI;
     
      
      }
      
    }
      
      public void arrowMove(){
       if (index==0){
            if (this.y>=yF && this.y <= yI){
                yMove=(-speed);
                xMove=0;
          }
            
       }
       
       if (index==1){
                if (this.x>=xF && this.x <= xI){
                     xMove=(-speed);
                     yMove=0;
          }
                
       }
            
       if (index==2){
             if (this.y<=yF && this.y >= yI){
                       yMove=speed;
                       xMove=0;
          }
             
       }
                 
        if (index==3){
             if (this.x<=xF && this.x >= xI){
                        xMove=speed;
                        yMove=0;
          }
            
       }
       
    }

    @Override
    public void tick() {
     move();
     arrowMove();
     die();
     Attacks();
     checkRemove();
    }   
    
    @Override
    public void render(Graphics g) {
   
        if (index==0 ){
                      g.drawImage(Assets.arrow[0],(int) (x-handler.getGameCamera().getxOffset()),(int)(y-32-handler.getGameCamera().getyOffset()),2*width,2*height,null);
         } 
        else if (index==1 ){
                     g.drawImage(Assets.arrow[1],(int) (x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),2*width,2*height,null);
         } 
        else if (index==2){
                     g.drawImage(Assets.arrow[2],(int) (x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),2*width,2*height,null);
         } 
         else if (index==3 ){
                     g.drawImage(Assets.arrow[3],(int) (x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),2*width,2*height,null);
         }
      
        //Draw hitbox
       /* g.setColor(Color.red);
         g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
        g.setColor(Color.blue);
        g.fillRect((int)(a.x-handler.getGameCamera().getxOffset()), (int)(a.y - handler.getGameCamera().getyOffset()), a.width, a.height);*/
       
        }
     
    @Override
    public void die() {
          if (index==0 && this.y<yF)
               handler.getWorld().getEntityManager().removeEntity(this);
         if (index==1 && this.x<xF )
               handler.getWorld().getEntityManager().removeEntity(this);
         if (index==2 && this.y>yF)
            handler.getWorld().getEntityManager().removeEntity(this);
         if (index==3 && this.x>xF)
               handler.getWorld().getEntityManager().removeEntity(this);
         if(remove)
             handler.getWorld().getEntityManager().removeEntity(this);
           
    }

        public void setIndex(int index) {
        this.index = index;
    }
        
        public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }
        

    @Override
    public void Attacks() {
      Rectangle ar = new Rectangle ();
      Rectangle cb = getCollisionBounds(0,0);
      int arSize = 8;
      ar.width = arSize;
      ar.height = arSize;   
   if (index == 0){
        ar.x = cb.x + cb.width - arSize ;
        ar.y =   cb.y-1-arSize ;
      }else if (index == 1){
        ar.x = cb.x -2- 2*arSize ;
        ar.y =   cb.y + cb.height /2 - arSize/2;
      }else if (index == 2){       
        ar.x = cb.x + cb.width /2 - arSize /2 ;
        ar.y =   cb.y+1 + arSize;
      }else if (index == 3){           
        ar.x = cb.x +2 +arSize;
        ar.y =   cb.y + cb.height /2 - arSize/2;                    
      } 
      a=ar;
        for (Entity e: handler.getWorld().getEntityManager().getEntities()){
                if (e.equals(this)||e.equals(handler.getWorld().getEntityManager().getPlayer()))
                    continue;
                if (e.getCollisionBounds(0, 0).intersects (ar)){  
                      e.hurt(2);
                      remove=true;
                     System.out.println(e.getHealth());
                     
                  }
               }
    }

    @Override
    public void checkRemove(){
        if(System.nanoTime()-timer >2000000000)
            remove=true;
    }
}
 
    

