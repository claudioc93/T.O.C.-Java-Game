/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toc;

import entity.Entity;
import tiles.Tile;
/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public class GameCamera {
	
	private Handler handler;
	private float xOffset, yOffset;
	
	public GameCamera(Handler handler, float xOffset, float yOffset){
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void checkBlankSpace(){ 		//verifica che non venga visualizzata la parte bianca della mappa 
		if(xOffset < 0){
			xOffset = 0;  //così facendo non vedrò mai ciò che è prima di zero
		}else if(xOffset > handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getGameWidth()){  
			xOffset = handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getGameWidth();
		}
		
		if(yOffset < 0){
			yOffset = 0;
		}else if(yOffset > handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getGameHeight()){
			yOffset = handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getGameHeight();
		}
	}
	
	public void centerOnEntity(Entity e){  //permette di tenere il focus sul personaggio (la camera segue il personaggio)
		xOffset = e.getX() - handler.getGameWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - handler.getGameHeight() / 2 + e.getHeight() / 2;
		checkBlankSpace();
	}
	
	public void move(float xAmt, float yAmt){ //indica quandto si deve spostare la camera rispetto alla posizione preceden
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}
