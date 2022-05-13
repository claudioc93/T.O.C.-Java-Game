/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dynamicsEntity;

import audio.Sfx;
import entity.Entity;
import gfx.Assets;
import gfx.animation.PlayerAnimation;
import java.awt.Graphics;
import java.awt.Rectangle;
import toc.Handler;

/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public class Templar extends Player{
  
  private int  atk=0, count=0;
  private Rectangle a = new Rectangle();
  private Rectangle b = new Rectangle();

  //COSTRUTTORE
  public Templar(Handler handler,float x, float y) {   
    super(handler,x, y,DEFAULT_CREATURE_WIDTH,DEFAULT_CREATURE_HEIGHT );     
    bounds.x =43;
    bounds.y=55;
    bounds.width=22;
    bounds.height=42;
    health=25; 

    anim= new PlayerAnimation(handler,60,120,100,Assets.Templaranimation,Assets.Templar_animationAtk, Assets.Templar_animationDeath);
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
  //  stepSound();
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
    if (handler.getMouseManager().isLeftPressed()&& !dead){
      if (atk==0){
          Sfx.MELEATK.play();
          
          atk=1;
      }
      Rectangle ar = new Rectangle ();
      Rectangle cb = getCollisionBounds(0,0);
      int arSize = 20;
      ar.width = arSize;
      ar.height = arSize;   
      if (anim.getIndex() == 0){
        ar.x = cb.x + cb.width /2 - arSize /2 ;
        ar.y =   cb.y - arSize;
      }else if (anim.getIndex() == 1){
        ar.x = cb.x - arSize ;
        ar.y =   cb.y + cb.height /2 - arSize/2;
      }else if (anim.getIndex() == 2){       
        ar.x = cb.x + cb.width /2 - arSize /2 ;
        ar.y =   cb.y + cb.height;
      }else if (anim.getIndex() == 3){           
        ar.x = cb.x + cb.width ;
        ar.y =   cb.y + cb.height /2 - arSize/2;                    
      } else{ 
        return;
      }     
      for (Entity e: handler.getWorld().getEntityManager().getEntities()){
        if (e.equals(this))
          continue;
        if (e.getCollisionBounds(0, 0).intersects (ar)){
          count++;
          if(atk==count){
            e.hurt(5);
            System.out.println(e.getHealth());
          }
        }
      }
      a=ar;
    }
    if(!handler.getMouseManager().isLeftPressed())
      atk=count=0;  
  }

}
      
