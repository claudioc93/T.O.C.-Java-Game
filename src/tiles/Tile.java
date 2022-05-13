/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author claud
 */

//come per le entità anche le piastrelle hanno bisogno di una classe genrica
public class Tile {
    
    
    public static Tile[] tiles = new Tile[256]; // questo array contiene tutte le nostre piastrelle
    
    public static Tile grassTile = new GrassTile(0);//associo il grassTile al id 0
    public static Tile Brick1Tile = new Brick1Tile(1);
    public static Tile Brick2Tile = new Brick2Tile(2);
    public static Tile DoorTile = new DoorTile(3);
    public static Tile ExitTile = new ExitTile(4);
    public static Tile GIsland1Tile = new GIsland1Tile(21);
    public static Tile GIsland2Tile = new GIsland2Tile(22);
    public static Tile GIslandDx1Tile = new GIslandDx1Tile(23);
    public static Tile GIslandDx2Tile = new GIslandDx2Tile(24);
    public static Tile GIslandSx1Tile = new GIslandSx1Tile(25);
    public static Tile GIslandSx2Tile = new GIslandSx2Tile(26);
    public static Tile Ground1Tile = new Ground1Tile(6);
    public static Tile Ground2Tile = new Ground2Tile(7);
    public static Tile Ground3Tile = new Ground3Tile(8);
    public static Tile Island1Tile = new  Island1Tile(27);
    public static Tile Island2Tile = new Island2Tile(28);
    public static Tile Island3Tile = new Island3Tile(29);
    public static Tile Island4Tile = new Island4Tile(30);
    public static Tile IslandCxTile = new IslandCxTile(31);
    public static Tile IslandDx1Tile = new IslandDx1Tile(32);
    public static Tile IslandDx2Tile = new IslandDx2Tile(33);
    public static Tile IslandSx1Tile = new IslandSx1Tile(34);
    public static Tile IslandSx2Tile = new IslandSx2Tile(35);
    public static Tile LavaTile = new LavaTile(9);
    public static Tile Magma1Tile = new Magma1Tile(14);
    public static Tile Magma2Tile = new Magma2Tile(15);
    public static Tile Magma3Tile = new Magma3Tile(16);
    public static Tile Magma4Tile = new Magma4Tile(17);
    public static Tile Rock1Tile = new Rock1Tile(10);
    public static Tile Rock2Tile = new Rock2Tile(11);
    public static Tile Rock3Tile = new Rock3Tile(12);
    public static Tile Rock4Tile = new Rock4Tile(13);
    public static Tile Street1Tile = new Street1Tile(18);
    public static Tile Street2Tile = new Street2Tile(19);
    public static Tile VulcanoTile = new VulcanoTile(20);
    public static Tile WaterTile = new WaterTile(5);
    
    
    //CLASSE
    public static final int TILE_WIDTH = 64;
    public static final int TILE_HEIGHT = 64;
    
    protected BufferedImage texture;
    protected final int id; // id di una piastrella ne determina e identifica il tipo per questo final
    
    
    public Tile(BufferedImage texture,int id){
        this.texture = texture;
        this.id = id;
        
        tiles[id] = this; 
    }
    
    public void tick(){  
    }
    
    public void render(Graphics g, int x, int y){//serve per disegnare a schermo la piastrella, necessita delle coordinate
        g.drawImage(texture, x, y, TILE_WIDTH,TILE_HEIGHT,null);
    }
    
    public boolean isSolid(){// devo sapere se una piastrella è calpestabile o meno,di base è calpestabile ovvero non è solida
        return false;
    }
    
    public boolean changeWorld(){
     return false;
 }
    public int getId() {
        return id;
    }
}
    