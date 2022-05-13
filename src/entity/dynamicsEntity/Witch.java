/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dynamicsEntity;

import audio.Sfx;
import gfx.Assets;
import gfx.animation.PlayerAnimation;
import java.awt.Graphics;
import java.awt.Rectangle;
import toc.Handler;

/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public class Witch extends Player{

   
 private Firebolt firebolt;
  private int  atk=0;

  //COSTRUTTORE
  public Witch(Handler handler,float x, float y) {   
    super(handler,x, y,DEFAULT_CREATURE_WIDTH,DEFAULT_CREATURE_HEIGHT );     
    bounds.x =43;
    bounds.y=55;
    bounds.width=22;
    bounds.height=42;
    health=3; 

    anim= new PlayerAnimation(handler,60,80,100,Assets.Witchanimation,Assets.Witch_animationAtk, Assets.Witch_animationDeath);
  }



  @Override //Templar non è più una classe astratta quindi devo implementare i metodi astratti della superclasse
  public void tick() { // nel metodo tiick aggiorniamo tutte le variabili per un oggetto quindi anche per il movimento del PG
        
  //Movement        
    getInput(); //metodo di player
    move();
    stepOnADoor();
    handler.getGameCamera().centerOnEntity(this);

  //Attack 
    Attack();

  //Sound
    //stepSound();
  }
    
    
  private void getInput(){ //questo metodo è responsabile di tutto quello che succede premendo un tasto
    xMove = 0; // possiamo usare queste variabili perchè le abbiamo definite protette in players
    yMove = 0;
        
    anim.changeFrame(); 
    anim.changeAtkFrame();
    
    if(!dead){
      if(!handler.getMouseManager().isLeftPressed()){
        if( !handler.getKeyManager().shift){     
          if(handler.getKeyManager().up)
            yMove = -speed; //pechè ci muoviamo in su ma l'asse y aumenta verso il basso   
          if(handler.getKeyManager().down)
            yMove = speed;
          if(handler.getKeyManager().left)
            xMove = -speed;
          if(handler.getKeyManager().right)
            xMove = speed;
        }else{
          if(handler.getKeyManager().up)
            yMove = -2*speed; //pechè ci muoviamo in su ma l'asse y aumenta verso il basso   
          if(handler.getKeyManager().down)
            yMove =2* speed;
          if(handler.getKeyManager().left)
            xMove = -2*speed;
          if(handler.getKeyManager().right)
            xMove = 2*speed;
        }
      }
    }
  }   
      
  @Override
  public  void render(Graphics g) {
    if(dead){
      anim.changeDeathFrames();
      g.drawImage(anim.getCurrentDeathFrame(),(int) (x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),2*width,2*height,null);
    }else if(atk==0){
      g.drawImage(anim.getCurrentFrame(),(int) (x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),2*width,2*height,null);//poicè drawImage vuole x e y  interi noi dobbiamo fare un casting ad intero      
    }else{
      g.drawImage(anim.getCurrentAtkFrame(),(int) (x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),2*width,2*height,null); 
      firebolt.render(g);
    }
  }
    
  //poichè drawImage vuole x e y  interi noi dobbiamo fare un casting ad intero
  
  /*g.setColor(Color.red);
    g.fillRect((int)(x+ bounds.x - handler.getGameCamera().getxOffset()),
              (int)(y+ bounds.y - handler.getGameCamera().getyOffset()), 
              bounds.width,bounds.height);
    g.setColor(Color.blue);
    g.fillRect((int)(a.x-handler.getGameCamera().getxOffset()), (int)(a.y - handler.getGameCamera().getyOffset()), a.width, a.height);
    g.fillRect((int)(b.x-handler.getGameCamera().getxOffset()), (int)(b.y - handler.getGameCamera().getyOffset()), b.width, b.height);
  
  }*/
 
  public Rectangle getBounds(){
    return this.bounds;
  }
    
  public float getX(){
    return this.x;
  }
     
  public float getY(){
     return this.y;
  }

@Override
  public void die(){       
    Sfx.LOSE.play();
    dead = true; 
  }

  protected void Attack() {
    if (handler.getMouseManager().isLeftPressed() && !dead){
            if (atk==0){
           firebolt=new Firebolt(this.handler,x,y-1);
           handler.getWorld().getEntityManager().addEntity(firebolt);
           Sfx.FIREBOLT.play();
            atk=1;
            }
           switch (anim.getIndex()) {
               case 0:
                   firebolt.FireboltSet(0);
  
                
                   break;
               case 1:
                 firebolt.FireboltSet(1);
          
                 
                   break;
               case 2:
                  firebolt.FireboltSet(2);
          
                 
                   break;
               case 3:
                  firebolt.FireboltSet(3);
               
 
                   break;
               default:
            
                   return;
           }
           
    
           } 
             if(!handler.getMouseManager().isLeftPressed()){
                    atk=0;
             
             }
  }
  
}