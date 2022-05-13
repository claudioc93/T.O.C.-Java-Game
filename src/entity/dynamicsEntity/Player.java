/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dynamicsEntity;

import entity.Entity;
import gfx.animation.Animation;
import tiles.Tile;
import toc.Handler;

/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public abstract class Player extends Entity {
    
    
    
    public static final float DEFAULT_SPEED= 1.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 50;
    public static final int DEFAULT_CREATURE_HEIGHT = 65;
  
   
    protected float speed; 
    protected float xMove, yMove;
    protected boolean dead=false;
    protected boolean change=false;
    protected boolean attacking=false;
    
    protected Animation anim;
    
    public Player(Handler handler, float x, float y,int width,int height) { // anche questa classe ha un costruttore per la posizione sulla mappa
        super(handler, x, y,width,height); // super ci permette di riferirci al costruttore di entity e ci fidà le variabili di posizione definite su entity
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }
    
    public void move(){ // metodo per il moviento di tutte le creature
      if(!checkEntityCollision(xMove,0f))
      moveX();
      if(!checkEntityCollision(0f,yMove))
      moveY();

    }
    
    public void moveX(){
        if(xMove > 0){//mi sposto a destra
            int tx = (int)(x+xMove + bounds.x + bounds.width)/Tile.TILE_WIDTH;
            if(!collisionWithTile(tx,(int)(y + bounds.y) / Tile.TILE_HEIGHT) && !collisionWithTile(tx,(int)(y+bounds.y +bounds.height)/Tile.TILE_HEIGHT)){
                x+=xMove;
            }else{
                x=tx *Tile.TILE_WIDTH - bounds.x -bounds.width -1 ;//il -1 mi serve altrimenti se ho una collisione a destra mi incasto anche verso l'alto o il basso
            }
        }else if(xMove<0){//mi sposto a sinistra     
            int tx = (int)(x+xMove + bounds.x)/Tile.TILE_WIDTH;
            if(!collisionWithTile(tx,(int)(y + bounds.y) / Tile.TILE_HEIGHT) &&
            !collisionWithTile(tx,(int)(y+bounds.y +bounds.height)/Tile.TILE_HEIGHT)){
                x+=xMove;
            }else{
                x=tx *Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x;
            }
        }
    }

    public void moveY(){
        if(yMove<0){//andiamo in alto
            int ty = (int) (y + yMove + bounds.y)/Tile.TILE_HEIGHT;
            if(!collisionWithTile((int)(x + bounds.x)/Tile.TILE_WIDTH, ty)&&
            !collisionWithTile((int)(x + bounds.x + bounds.width)/Tile.TILE_WIDTH, ty)    ){
                y+= yMove;
            }else{
                y= ty* Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y;
            }
        }else if (yMove>0){//andiamo in basso
            int ty = (int) (y + yMove + bounds.y+bounds.height)/Tile.TILE_HEIGHT;
            if(!collisionWithTile((int)(x + bounds.x)/Tile.TILE_WIDTH, ty)&&
                !collisionWithTile((int)(x + bounds.x + bounds.width)/Tile.TILE_WIDTH, ty)    ){
                    y+= yMove;
            }else{
                y= ty*Tile.TILE_HEIGHT - bounds.y - bounds.height -1;
            }
        }
    }
    
    public void stepOnADoor(){
        int dx = (int)(x+xMove + bounds.x + bounds.width)/Tile.TILE_WIDTH;
        int dy = (int) (y + yMove + bounds.y)/Tile.TILE_HEIGHT;
        if(checkDoorTile(dx,dy))
            change=true;
        else 
            change=false;
    }
    
    protected boolean collisionWithTile( int x, int y){
        return handler.getWorld().getTile(x, y).isSolid();
    }
    
   protected boolean checkDoorTile( int x, int y){
        return handler.getWorld().getTile(x, y).changeWorld();
    }
    
   
    protected  abstract void Attack();
   
   //GETTERS e SETTERS
   
    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public boolean getChange() {
        return change;
    }
    
    public void setChange(boolean x) {
         change=x;
    }
    
    public boolean getDeath(){
        return dead;
    }
}
    
