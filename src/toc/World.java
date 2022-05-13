
package toc;

import audio.Bgm;
import entity.EntityManager;
import entity.dynamicsEntity.Archer;
import entity.dynamicsEntity.ArcherW;
import entity.dynamicsEntity.Mage;
import entity.dynamicsEntity.Player;
import entity.dynamicsEntity.Templar;
import entity.dynamicsEntity.Witch;
import entity.dynamicsEntity.WorriorW;
import java.awt.Graphics;
import tiles.Tile;
import utilities.Utils;

/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public class World {
    
   private static int [] lvl=new int [3];
   private static int changeCount=0;
  
   
    private Handler handler;
    private int width, height; 

//Variabili prese da File
    private int spawnX, spawnY; //dove viene messo il personaggio
    private int [][]tiles;// è una matrice che contiene tutti gli id delle tiles
    private static Player pg;
    private int enemyNumber;
    
//Entity
    private EntityManager entityManager;

    
//Constructor
    public World(Handler handler , int id) {//carica il mondo da file e prende in ingresso il percorso per il file del pc
        this.handler =handler;
        switch (id){
            case 0:
               pg=new Templar(handler,0,0);
               break;
            case 1:
                pg=new WorriorW(handler,0,0);
                break;
            case 2:
                pg=new Archer(handler,0,0);
                break;
            case 3:
                pg=new ArcherW(handler,0,0);
                break;
            case 4:
                pg=new Mage(handler,0,0);
                break;
            case 5:
                 pg=new Witch(handler,0,0);
                break;       
        }
        entityManager = new EntityManager(handler,pg);
            
        loadWorld("worlds/matrici/mappa1.txt");
        //loadWorld("res/textures/worlds/mappa2.txt");
        //loadWorld("res/textures/worlds/mappa3.txt");
          
        entityManager = new EntityManager(handler,pg);
        entityManager.loadWorldEntities("worlds/matrici/world1_entities.txt");
        //entityManager.loadWorldEntities("res/textures/worlds/world2_entities.txt");
        //entityManager.loadWorldEntities("res/textures/worlds/world3_entities.txt");
       
         Bgm.VILLAGEMUSIC.loop();
    }

//Logic 

    public void tick(){
        entityManager.tick();
    }

    public Tile getTile(int x, int y){
        
        if(x<0 || y<0 || x>=width || y>=height)
           return Tile.grassTile;
        
        Tile t = Tile.tiles[tiles[x][y]];
        
        if(t==null)
           return Tile.WaterTile;
        
        return t;
    }

    public void loadWorld(String path){ // carica il mondo
        String file = Utils.loadFileAsString(path);
        String [] tokens = file.split("\\s+");//prendo il file .txt e prendo ogni numerino singolo del file e lo salvo in un array

        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);
        enemyNumber =Utils.parseInt(tokens[4]);
        
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
      
       
        tiles = new int [width][height];
        for( int y =0; y< height; y++){
           for ( int x =0; x< width; x++){
                 tiles[x][y]= Utils.parseInt(tokens[(x+y * width)+ 5]);//setto tutti gli indici di tiles nell'arrai perfarlo divido il file.txt in tokens e prendo solo i pezzetti
                                                                      //che mi servono escludendo i primi 5 che abbiamo inserito manualmente
           }
       }
    
    }
    
    public void enemyNumberDecraese(){
        System.out.print(enemyNumber);
        enemyNumber=enemyNumber-1;
    }
    
    public void changeWorld(boolean change){
        if(change && enemyNumber==0){
            Bgm.VILLAGEMUSIC.stop();
            Bgm.LAVAMUSIC.stop();
            Bgm.SEAMUSIC.stop();
            int i=getRandomNumberInRange(1,4);
            if(changeCount!=0){
                while(!testLvl(lvl,i)){
                    i=getRandomNumberInRange(1,4);
                }
            }
            lvl[changeCount]=i;
            changeCount ++;
            if (changeCount==4){
                loadWorld("worlds/matrici/mappa4.txt");
                entityManager.removeAllEntity();//prima di rimettere le entità devo cancellare tutte quelle presenti o si sovrappongono
                entityManager.loadWorldEntities("worlds/matrici/world4_entities.txt");
                entityManager.getPlayer().setChange(false);
            }

            else{
                switch(i){

                 /*   case 1:

                        loadWorld("res/textures/worlds/mappa0.txt");
                        entityManager.removeAllEntity();
                        entityManager.loadWorldEntities("res/textures/worlds/world0_entities.txt");
                        entityManager.getPlayer().setChange(false);

                        break;*/

                    case 2:
                              
                        loadWorld("worlds/matrici/mappa2.txt");
                        entityManager.removeAllEntity();
                        entityManager.loadWorldEntities("worlds/matrici/world2_entities.txt");
                        entityManager.getPlayer().setChange(false);
                        Bgm.SEAMUSIC.loop();
                        break;

                    case 3:

                        loadWorld("worlds/matrici/mappa3.txt");
                        entityManager.removeAllEntity();
                        entityManager.loadWorldEntities("worlds/matrici/world3_entities.txt");
                        entityManager.getPlayer().setChange(false);
                         Bgm.LAVAMUSIC.loop();
                        break;
                }
            }
        }
    }

    private static int getRandomNumberInRange(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

       
    private static boolean testLvl( int []x,int i){
        for(int j=0;j<x.length;j++){

            if(x[j]==i)
                return false;

        }
        return true;
    }
        
//View
    
    public void render (Graphics g){
        //dobbiamo fare in modo che il render avvenga solo per gli oggetti che entrino nella schermata
        //non per tutta la mappa altrimenti diventa inefficiente
        
        int xStart;//andrà a contenere la piastrella più lontana che il giocatore riesce a vedere alla sua sinistra
        xStart = (int)Math.max(0,handler.getGameCamera().getxOffset() /Tile.TILE_WIDTH);
        
        int xEnd;//andrà a contenere la piastrella più lonata che il giocatore riesce a veder alla sua destra
        xEnd =(int)Math.min(width, (handler.getGameCamera().getxOffset()+ handler.getGameWidth())/Tile.TILE_WIDTH +1);
        
        int yStart;//andrà a contenere la piastrella più lonata che il giocatore riesce a vedere in alto
        yStart = (int)Math.max(0,handler.getGameCamera().getyOffset() /Tile.TILE_HEIGHT);
       
        int yEnd;//andrà a contenere la piastrella più lonata che il giocatore riesce a vedere in basso
        yEnd=(int)Math.min(height, (handler.getGameCamera().getyOffset()+ handler.getGameHeight())/Tile.TILE_HEIGHT +1);
        
        for (int y=yStart; y<yEnd; y++){
            for(int x=xStart; x< xEnd; x++){
                getTile(x,y).render(g,(int)(x* Tile.TILE_WIDTH-handler.getGameCamera().getxOffset()),(int)(y* Tile.TILE_HEIGHT-handler.getGameCamera().getyOffset()));
            }
        }
        
       //Entities
     
        entityManager.render(g);
    }
     
//Getters & Setters
       
    public int getWidth() {
        return width;
    }

    
    public int getHeight() {
        return height;
    }


    public EntityManager getEntityManager() {
       return entityManager;
    }


    public int getSpawnX() {
        return spawnX;
    }

    public int getSpawnY() {
        return spawnY;
    }

    public static Player getPg() {
        return pg;
    }
 
}
     

