/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toc;

import input.KeyManager;
import input.MouseManager;

/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public class Handler { //gestisce e passa tutte le variabili per facilitare la gestione delle collisioni
    
    private Game game;

    private World world;
    
//Constructor

    public Handler (Game game){
        this.game=game;


    }

//Getters & Setters

    public Game getGame() {
        return game;
    }

    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }
    
    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }
    
    public void setWorld(World world){
        this.world=world;
    }
    public World getWorld() {
        return world;
    }

    public int getGameWidth(){
        return game.getWidth();             
    }
    
    public int getGameHeight(){
        return game.getHeight();             
    }
     
    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }
     
      
}

