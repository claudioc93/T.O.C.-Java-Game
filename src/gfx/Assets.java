/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfx;

import java.awt.image.BufferedImage;
/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public class Assets {   //carica tutte le immagini e i video
    
    private static final int widthMenuButton=192, heigthMenuButton=64;   //dimesione bottoni del menu
    private static final int widthTile =32, heightTile = 32;
    private static final int widthDinamicEntity =128, heigthDinamicEntity =128;  //dimensioni sheet
    private static final int widthStaticEntity = 128, heightStaticEntity=128;    
    
    public static BufferedImage tileGrass,tileBrick1,tileBrick2,tileDoor,tileGround1,tileGround2,tileGround3,tileWater,tileRock1,tileRock2,tileRock3,tileRock4
                                ,tileIslandSx1,tileIsland1,tileIslandDx1,tileIsland2,tileIslandDx2,tileIsland3,tileIslandSx2,tileIsland4,tileIslandCx
                                ,tileGIslandSx1,tileGIsland1,tileGIslandDx1,tileGIsland2,tileGlslandDx2,tileGIslandSx2
                                ,tileExit,tileMagma1,tileMagma2,tileMagma3,tileMagma4,tileLava,TileVulcano,tileStreet1,tileStreet2;
    
    public static BufferedImage [][] Templaranimation = new BufferedImage[4][9]; 
    public static BufferedImage [][] Templar_animationAtk=  new BufferedImage[4][6];
    public static BufferedImage [] Templar_animationDeath=new BufferedImage[6];

    public static BufferedImage [][] WarriorWomananimation = new BufferedImage[4][9]; 
    public static BufferedImage [][] WarriorWoman_animationAtk=  new BufferedImage[4][6];
    public static BufferedImage [] WarriorWoman_animationDeath=new BufferedImage[6];

    public static BufferedImage [][] Mageanimation = new BufferedImage[4][9]; 
    public static BufferedImage [][] Mage_animationAtk=  new BufferedImage[4][6];
    public static BufferedImage [] Mage_animationDeath=new BufferedImage[6];

    public static BufferedImage [][] Witchanimation = new BufferedImage[4][9]; 
    public static BufferedImage [][] Witch_animationAtk=  new BufferedImage[4][6];
    public static BufferedImage [] Witch_animationDeath=new BufferedImage[6];

    public static BufferedImage [][] Archeranimation = new BufferedImage[4][9]; 
    public static BufferedImage [][] Archer_animationAtk=  new BufferedImage[4][6];
    public static BufferedImage [] Archer_animationDeath=new BufferedImage[6];

    public static BufferedImage [][] ArcherWomananimation = new BufferedImage[4][9]; 
    public static BufferedImage [][] ArcherWoman_animationAtk=  new BufferedImage[4][6];
    public static BufferedImage [] ArcherWoman_animationDeath=new BufferedImage[6];

    public static BufferedImage [][] pirateanimation= new BufferedImage[4][9];
    public static BufferedImage [][] pirate_animationAtk=  new BufferedImage[4][6];
    public static BufferedImage [] pirate_animationDeath=new BufferedImage[6];
    
    public static BufferedImage [][] dragonanimation= new BufferedImage[4][9];
    public static BufferedImage [][] dragon_animationAtk=  new BufferedImage[4][6];
    public static BufferedImage [] dragon_animationDeath=new BufferedImage[6];
    
    public static BufferedImage [][] skeletonanimation= new BufferedImage[4][9];
    public static BufferedImage [][] skeleton_animationAtk=  new BufferedImage[4][6];
    public static BufferedImage [] skeleton_animationDeath=new BufferedImage[6];
    
    public static BufferedImage [] arrow = new BufferedImage[4];
    public static BufferedImage [] firebolt = new BufferedImage[4];
    
    public static BufferedImage [] menu1;
    public static BufferedImage [] menu2;
    public static BufferedImage menuBG;  //menu backgournd
    public static BufferedImage [] select1;
    public static BufferedImage [] select2;   
    public static BufferedImage game_overBG;
    
    public static BufferedImage [][] world1_Entities;
    public static BufferedImage [][] world2_Entities;
    public static BufferedImage [][] world3_Entities;    
    
    protected static  SpriteSheet sheetWitch;
    protected static  SpriteSheet sheetWitchAtk;
    protected static  SpriteSheet sheetWitchDeath;
            
    protected static SpriteSheet sheetMage;
    protected static SpriteSheet sheetMageAtk;
    protected static SpriteSheet sheetMageDeath;
        
    protected static  SpriteSheet sheetWarriorWoman;
    protected static  SpriteSheet sheetWarriorWomanAtk;
    protected static  SpriteSheet sheetWarriorWomanDeath; 
    
    protected static SpriteSheet sheetTemplar;
    protected static SpriteSheet sheetTemplarAtk;
    protected static SpriteSheet sheetTemplarDeath;

    protected static  SpriteSheet sheetArcherWoman;
    protected static  SpriteSheet sheetArcherWomanAtk;
    protected static  SpriteSheet sheetArcherWomanDeath;
        
    protected static  SpriteSheet sheetArcher;
    protected static  SpriteSheet sheetArcherAtk;
    protected static  SpriteSheet sheetArcherDeath;
     
    protected static  SpriteSheet sheetPirate;
    protected static  SpriteSheet sheetPirateAtk;
    protected static  SpriteSheet sheetPirateDeath;
    
    protected static  SpriteSheet sheetDragon;
    protected static  SpriteSheet sheetDragonAtk;
    protected static  SpriteSheet sheetDragonDeath;
         
    protected static  SpriteSheet sheetSkeleton;
    protected static  SpriteSheet sheetSkeletonAtk;
    protected static  SpriteSheet sheetSkeletonDeath;

    //protected static  SpriteSheet sheetGuardian;
    // protected static SpriteSheet sheetPrincess;
     
    protected static  SpriteSheet sheetArrow;
    protected static SpriteSheet sheetFirebolt;
    
    protected static SpriteSheet sheet_menu1;
    protected static SpriteSheet sheet_menu2;
    protected static SpriteSheet sheet_menuBG;
    protected static SpriteSheet sheet_selectMenu1;
    protected static SpriteSheet sheet_selectMenu2;
    protected static SpriteSheet sheet_game_overBG;
    
    protected static SpriteSheet sheet_tiles;
    protected static SpriteSheet sheet_tiles1;   
     
    protected static SpriteSheet sheet_staticEntityW1;
    protected static SpriteSheet sheet_staticEntityW2;
    protected static SpriteSheet sheet_staticEntityW3;
     
    public static void init (){ //prende l'immagine dalle risorse 
        
        // carico le immagini pg
        sheetWitch = new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/PG/strega/stregaMov.png"));
        sheetWitchAtk = new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/PG/strega/stregaAtk.png"));
        sheetWitchDeath= new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/PG/strega/stregaDeath.png"));
         
        //sheetPrincess = new SpriteSheet (ImageLoader.loadImage("/textures/characters/principessa/principessaMov.png"));
      
        sheetMage = new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/PG/mago/magoMov.png"));
        sheetMageAtk = new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/PG/mago/magoAtk.png"));
        sheetMageDeath= new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/PG/mago/magoDeath.png"));
         
        sheetWarriorWoman= new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/PG/guerriera/guerrieraMov.png"));
        sheetWarriorWomanAtk = new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/PG/guerriera/guerrieraAtk.png"));
        sheetWarriorWomanDeath= new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/PG/guerriera/guerrieraDeath.png"));
         
        sheetTemplar= new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/PG/templare/templareMov.png"));
        sheetTemplarAtk = new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/PG/templare/templareAtk.png"));
        sheetTemplarDeath= new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/PG/templare/templareDeath.png"));
         
        sheetArcherWoman = new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/PG/arcera/arceraMov.png"));
        sheetArcherWomanAtk = new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/PG/arcera/arceraAtk.png"));
        sheetArcherWomanDeath= new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/PG/arcera/arceraDeath.png"));
        
        sheetArcher = new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/PG/arcere/arcereMov.png"));
        sheetArcherAtk = new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/PG/arcere/arcereAtk.png"));
        sheetArcherDeath = new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/PG/arcere/arcereDeath.png"));
        
        sheetPirate = new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/ENEMY/pirata/pirataMov.png"));
        sheetPirateAtk = new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/ENEMY/pirata/pirataAtk.png"));
        sheetPirateDeath = new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/ENEMY/pirata/pirataDeath.png"));
        
        sheetDragon = new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/ENEMY/rettile/dragonMov.png"));
        sheetDragonAtk = new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/ENEMY/rettile/dragonAtk.png"));
        sheetDragonDeath = new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/ENEMY/rettile/dragonDeath.png"));
        
        sheetSkeleton = new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/ENEMY/scheletro/scheletroMov.png"));
        sheetSkeletonAtk = new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/ENEMY/scheletro/scheletroAtk.png"));
        sheetSkeletonDeath = new SpriteSheet (ImageLoader.loadImage("/textures/entity/characters/ENEMY/scheletro/scheletroDeath.png"));
        
        //sheetGuardian = new SpriteSheet (ImageLoader.loadImage("/textures/characters/guardiano/guardianoMov.png"));
        sheetArrow = new SpriteSheet (ImageLoader.loadImage("/textures/entity/arrow.png"));
        sheetFirebolt = new SpriteSheet(ImageLoader.loadImage("/textures/entity/firebolt.png"));
        
        // carico le immagini menu
        sheet_menu1 = new SpriteSheet (ImageLoader.loadImage("/textures/menu/menu1.png"));
        sheet_menu2 = new SpriteSheet (ImageLoader.loadImage("/textures/menu/menu2.png"));
        sheet_menuBG = new SpriteSheet (ImageLoader.loadImage("/textures/menu/backgroundMainMenu.jpg"));
        sheet_selectMenu1 = new SpriteSheet (ImageLoader.loadImage("/textures/menu/menuSelect1.png"));
        sheet_selectMenu2 = new SpriteSheet (ImageLoader.loadImage("/textures/menu/menuSelect2.png"));
        sheet_game_overBG = new SpriteSheet (ImageLoader.loadImage("/textures/menu/game_over.png"));
        
        sheet_tiles = new SpriteSheet( ImageLoader.loadImage("/textures/tiles/tileset.jpg"));
        sheet_tiles1 = new SpriteSheet( ImageLoader.loadImage("/textures/tiles/tileset1.png"));
           
        //carico le entità statiche
        sheet_staticEntityW1 = new SpriteSheet (ImageLoader.loadImage("/textures/entity/staticEntity/staticEntities_World0.png"));
        sheet_staticEntityW2 = new SpriteSheet (ImageLoader.loadImage("/textures/entity/staticEntity/staticEntities_World2.png"));
        sheet_staticEntityW3 = new SpriteSheet (ImageLoader.loadImage("/textures/entity/staticEntity/staticEntities_World3.png"));
      
        DinamicEntityLoad();
        menuLoad();
        tilesLoad();
        entityLoad();
        ammoLoad();
    }
 
    public static void DinamicEntityLoad(){
        
        characterLoad(sheetPirate ,sheetPirateAtk, sheetPirateDeath, pirateanimation, pirate_animationAtk, pirate_animationDeath );
        characterLoad(sheetDragon,sheetDragonAtk, sheetDragonDeath, dragonanimation, dragon_animationAtk, dragon_animationDeath );
        characterLoad(sheetSkeleton,sheetSkeletonAtk, sheetSkeletonDeath, skeletonanimation, skeleton_animationAtk, skeleton_animationDeath );

        characterLoad(sheetTemplar ,sheetTemplarAtk, sheetTemplarDeath, Templaranimation, Templar_animationAtk, Templar_animationDeath );
        characterLoad(sheetWarriorWoman, sheetWarriorWomanAtk,sheetWarriorWomanDeath, WarriorWomananimation, WarriorWoman_animationAtk, WarriorWoman_animationDeath );
        characterLoad(sheetArcher,sheetArcherAtk,sheetArcherDeath, Archeranimation, Archer_animationAtk, Archer_animationDeath );

        characterLoad(sheetArcherWoman,sheetArcherWomanAtk, sheetArcherWomanDeath, ArcherWomananimation, ArcherWoman_animationAtk, ArcherWoman_animationDeath );
        characterLoad(sheetMage,sheetMageAtk ,sheetMageDeath, Mageanimation, Mage_animationAtk, Mage_animationDeath );
        characterLoad(sheetWitch,sheetWitchAtk,sheetWitchDeath,Witchanimation, Witch_animationAtk, Witch_animationDeath );
    }
     
    public static void menuLoad(){

        menuBG=sheet_menuBG.crop(0,0, 1280, 720); 
        game_overBG =sheet_game_overBG.crop(0,0, 1280, 720);
        
        //carico le immagini del menu iniziale
        menu1= new BufferedImage[3];
        menu2= new BufferedImage[3];
        
        for(int i=0;i<menu1.length;i++){    //taglio lo sheet del menu in più immagini e assegno ad oguna una posizione nel buffer
            menu1[i]=sheet_menu1.crop(0,heigthMenuButton*i,widthMenuButton,heigthMenuButton);  
            menu2[i]=sheet_menu2.crop(0,heigthMenuButton*i,widthMenuButton,heigthMenuButton);
        }               
         
        //carico le immagini del menu di selezione          
        select1= new BufferedImage[6];
        select2= new BufferedImage[6];
        
        for(int i=0;i<select1.length;i++){
            select1[i]=sheet_selectMenu1.crop(0,heigthMenuButton*i,widthMenuButton,heigthMenuButton);
            select2[i]=sheet_selectMenu2.crop(0,heigthMenuButton*i,widthMenuButton,heigthMenuButton);
        }        
    }
     
    public static void tilesLoad(){
        
        tileGrass =sheet_tiles.crop(widthTile*2,heightTile,widthTile,heightTile);   
        tileBrick1=sheet_tiles.crop(widthTile*3,0,widthTile,heightTile);
        tileBrick2=sheet_tiles.crop(widthTile*5,heightTile,widthTile,heightTile);
        tileDoor=sheet_tiles.crop(widthTile*7,0,widthTile,heightTile);
        tileGround1=sheet_tiles.crop(widthTile*12,heightTile,widthTile,heightTile);
        tileGround2=sheet_tiles.crop(widthTile*13,heightTile,widthTile,heightTile);
        tileGround3=sheet_tiles.crop(widthTile*14,heightTile,widthTile,heightTile);
        tileWater=sheet_tiles1.crop(0,heightTile*2,widthTile,heightTile);
        tileRock1=sheet_tiles1.crop(0,0,widthTile,heightTile);
        tileRock2=sheet_tiles1.crop(0,heightTile,widthTile,heightTile);
        tileRock3=sheet_tiles1.crop(widthTile*10,0,widthTile,heightTile);
        tileRock4=sheet_tiles1.crop(widthTile*11,0,widthTile,heightTile);
        tileIslandSx1=sheet_tiles1.crop(widthTile,0,widthTile,heightTile);
        tileIsland1=sheet_tiles1.crop(widthTile*2,0,widthTile,heightTile);
        tileIslandDx1=sheet_tiles1.crop(widthTile*3,0,widthTile,heightTile);
        tileIsland2=sheet_tiles1.crop(widthTile*3,heightTile,widthTile,heightTile);
        tileIslandDx2=sheet_tiles1.crop(widthTile*3,heightTile*2,widthTile,heightTile);
        tileIsland3=sheet_tiles1.crop(widthTile*2,heightTile*2,widthTile,heightTile);
        tileIslandSx2=sheet_tiles1.crop(widthTile,heightTile*2,widthTile,heightTile);
        tileIsland4=sheet_tiles1.crop(widthTile,heightTile,widthTile,heightTile);
        tileIslandCx=sheet_tiles1.crop(widthTile*2,heightTile,widthTile,heightTile);
        tileGIslandSx1=sheet_tiles.crop(widthTile*8,0,widthTile,heightTile);
        tileGIsland1=sheet_tiles.crop(widthTile*9,0,widthTile,heightTile);
        tileGIslandDx1=sheet_tiles.crop(widthTile*11,0,widthTile,heightTile);
        tileGIsland2=sheet_tiles.crop(widthTile*9,heightTile,widthTile,heightTile);
        tileGlslandDx2=sheet_tiles.crop(widthTile*11,heightTile,widthTile,heightTile);
        tileGIslandSx2=sheet_tiles.crop(widthTile*8,heightTile,widthTile,heightTile);
        tileExit=sheet_tiles.crop(widthTile*6,0,widthTile,heightTile);
        tileMagma1=sheet_tiles.crop(0,0,widthTile,heightTile);
        tileMagma2=sheet_tiles.crop(widthTile,0,widthTile,heightTile);
        tileMagma3=sheet_tiles.crop(widthTile*2,0,widthTile,heightTile);
        tileMagma4=sheet_tiles.crop(0,heightTile,widthTile,heightTile);
        tileLava=sheet_tiles1.crop(widthTile*7,heightTile,widthTile,heightTile);
        TileVulcano=sheet_tiles.crop(widthTile,heightTile,widthTile,heightTile);
        tileStreet1=sheet_tiles.crop(widthTile*13,0,widthTile,heightTile);
        tileStreet2=sheet_tiles.crop(widthTile*14,0,widthTile,heightTile);
    }
      
    public static void entityLoad (){
       
        world1_Entities = new BufferedImage[2][6];
        world2_Entities = new BufferedImage[2][6];
        world3_Entities = new BufferedImage[2][6];
        for(int i=0;i<6;i++){
            for(int j=0;j<2;j++){
                world1_Entities[j][i]= sheet_staticEntityW1.crop(widthStaticEntity*i,widthStaticEntity*j ,widthStaticEntity, heightStaticEntity);
                world2_Entities[j][i]= sheet_staticEntityW2.crop(widthStaticEntity*i,widthStaticEntity*j ,widthStaticEntity, heightStaticEntity);
                world3_Entities[j][i]= sheet_staticEntityW3.crop(widthStaticEntity*i,widthStaticEntity*j ,widthStaticEntity, heightStaticEntity);
            }
        }
    }
       
    public static void characterLoad (SpriteSheet mov,SpriteSheet atk,SpriteSheet death, BufferedImage [][] movImg, BufferedImage [][] atkImg, BufferedImage [] deathImg){
         
        for(int i=0 ; i<movImg.length;i++){
            for(int j=0; j<movImg[i].length; j++){
                movImg[i][j]= mov.crop( widthDinamicEntity*j, heigthDinamicEntity*i, widthDinamicEntity, heigthDinamicEntity);                
            }
        }
        
        for(int i=0 ; i<atkImg.length;i++){
            for(int j=0; j<atkImg[i].length; j++){
                atkImg [i][j]=atk.crop( widthDinamicEntity*j, heigthDinamicEntity*i, widthDinamicEntity, heigthDinamicEntity);
            }
        }       
        
        for(int i=0;i<  deathImg.length; i++)
              deathImg [i]=death.crop ( widthDinamicEntity*i, 0, widthDinamicEntity, heigthDinamicEntity);    
    }
    
     public static void ammoLoad (){
         for(int i=0; i<4; i++){
             arrow[i]=sheetArrow.crop(widthDinamicEntity*i, 0, widthDinamicEntity, heigthDinamicEntity);
             firebolt[i]=sheetFirebolt.crop(widthDinamicEntity*i, 0, widthDinamicEntity, heigthDinamicEntity);
         }
     }
}