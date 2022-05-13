
package toc;

import gfx.Assets;
import input.KeyManager;
import input.MouseManager;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import state.GameState;
import state.MenuState;
import state.ResetState;
import state.SelectionState;
import state.State;


/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public class Game implements Runnable{ //implementa Runnable perchè utilizzeremo un oggetto thread, che per essere eseguito ha bisogno dell'interfaccia Runnable 
    
    private boolean running = false;   //mi indica quando il gioco è in run 
    private Thread thread;

//States
    
    public State gameState;        //creo gli stati del gioco: Game, Menu, Selection (del personaggio)
    public State selectionState;
    public State menuState;
    public State resetState;

 

//Camera 

    private GameCamera gameCamera;  //rapprensenta la porzione di mappa visualizzata dall'utente 

//Handler

    private static Handler handler;  //rappresenta una oggetto/classe che permette di gestire  e scambiare le variabili  tra le classi  

//Input

    protected static KeyManager keyManager;                //oggetti che permettono la gestione dell'input 
    protected static MouseManager mouseManager;

//Display

    private Display display;        //dimensioni e titolo finestra di gioco 
    private int width,height;
    public String title;

//Immages

    private BufferStrategy bs;  //gli oggetti che ci permettono di rappresentare a schermo o nella finestra le immagini/disegni
    private Graphics g;

//Constructor

    public Game (String title,int width,int height){
        this.title=title;
        this.width=width;
        this.height=height;   
     
        
        keyManager= new KeyManager();
        mouseManager= new MouseManager();
    }

//Logic
        
    public synchronized void start(){            //metodo chiamato in toc. 
        if(running)                              //running all'inizio era settata a false    
             return;
        running = true;
        thread = new Thread(this);              //creo oggetto thread 
        thread.start();                         //(metodo proprio che manda in esecuzione il processo). 
                                                // Thread.start() chiama il metodo "game.run()" , perchè  game implementa runnable
    }                   
    
    public synchronized void run(){   //(gestione logica thread)

        init();

        int fps = 60;                           //frame per second --> frequenza di refresh del thread 
        double timePerTick = 100000000/ fps;   //tempo in nanosecondi  che può trascorrere al massimo tra gli aggiornamenti dei vari elementi del thread ovvero tra  una chiamata di tick() e render()
        double delta = 0;
        long now;                                  
        long lastTime = System.nanoTime();      //rapprenseta il tempo macchina attuale 
        long timer = 0;
        int ticks = 0; 

        while (running) {                       
            now = System.nanoTime();
            delta += (now - lastTime)/ timePerTick; // sto sommando a delta quanto tempo deve trascorrere tra un aggiornamento e l'altro, di base ci dice quando chiamare tick() e render()
            timer += now - lastTime; // tempo che intercorre da quando ho aggiornato now l'ultima volta
            lastTime =  System.nanoTime(); // aggiorno last time con il tempo attuale

            if(delta >=1){
                tick();                         //aggiorno tutte le variabili               
                render();                       //rappresento tutte le immagini , deve avvenire sempre dopo aver aggiornato le variabili con tick()
                ticks ++;      
                delta--;
            }

            if(timer >= 100000000){
              //  System.out.println("Ticks and Frames: " + ticks);
                ticks=0;
                timer=0;
            }

        }

        stop();
    }                 
                      
    public void init(){  //metodo che inizializza tutti gli oggetti di game (display, handler, gamecamera e gli stati)

        display = new Display(title,width,height);     //frame --> finestra, canvas --> tela
        display.getFrame().addKeyListener(keyManager); //permette di rilevare in quella finestra i comandi eseguiti da tastiera 
        display.getFrame().addMouseListener(mouseManager);  //permette di rilevare in quella finestra i comandi eseguiti da mouse
        display.getFrame().addMouseMotionListener(mouseManager); //rilevamento spostamento del del mouse 
        display.getCanvas().addMouseListener(mouseManager); //permette di rilevare in quella finestra i comandi eseguiti da mouse
        display.getCanvas().addMouseMotionListener(mouseManager); //rilevamento spostamento del del mouse

        handler = new Handler(this);
        
        gameCamera = new GameCamera(handler,0,0); //X=0,Y=0 posizione primo pixel 
        
        Assets.init();  //ci permette di caricare tutti gli asset 
        
       
        menuState = new MenuState(handler);
        State.setState(menuState); //il primo state a cui voglio far accedere è quello del menu 
        
 
    }

    

    private void tick(){
        if(State.getState()== gameState){
            keyManager.tick();
            State.getState().tick(); //devo aggiornare lo stato di gioco 
        }
    }         

    
    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//View

    public synchronized void render(){
        bs = display.getCanvas().getBufferStrategy();  //indica dove dovrò rappresentare le figure/disegni 
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);
        
        //Rappresento le immagini a schermo    
        if(State.getState() != null){
            if(State.getState()==menuState ||State.getState()==selectionState)
                  g.drawImage(Assets.menuBG, 0, 0,800,750, null);
            else if(State.getState()==resetState)
                g.drawImage(Assets.game_overBG, 0, 0,800,750, null);
           State.getState().render(g);
        }
        //End Drawing!
        bs.show();
        g.dispose(); 
    }


//Getters & Setters

    public KeyManager getKeyManager(){
        return keyManager;
    }
  
    public MouseManager getMouseManager(){
        return mouseManager;
    }
  
    public GameCamera getGameCamera(){
        return gameCamera;
    }
  
    public static  Handler getHandler(){
        return handler;
    }
   
    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getWidth(){
        return width;
    }
  
    public int getHeight(){
        return height;
    }
    
    public void setGameState(int id) {
        this.gameState = new GameState(handler,id);
    }

    public void setSelectionState(Handler handler) {
        this.selectionState = new SelectionState(handler);
    }
    
    public void setResetState() {
        this.resetState = new ResetState(handler);
    }
}