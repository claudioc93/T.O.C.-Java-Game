/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public class KeyManager implements KeyListener{
    
    private boolean[] keys;// definiamo un array boolean perchè faremo corrispondere ad ogni tasto un numero ovvero una casella dell'array,
                           // se il tasto corrispondente a quel numero è premuto lo settiamo a true nel metodo pressed, o a false nel metodo released
    
    public boolean up, down, left, right,shift; //servono per settare i movimenti del pg;
    public boolean pressed, released;
    
    public KeyManager(){ //costruttore della classe
        keys = new boolean[256];
    }
    
    public void tick(){ //controllo lo "stato" dei tasti
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];       
        shift=keys[KeyEvent.VK_SHIFT];
       
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {
           
    }

    @Override
    public void keyPressed(KeyEvent e) { //questo metodo è usato quando il giocatore preme un tasto sulla tastira
        keys[e.getKeyCode()] = true; //e.getKeyCode ci ridà il codice del tasto premuto(metodo di KeyListener);
        pressed = true;
        //System.out.println("pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) { //opposto al metodo keyPressed, quando il giocatore rilascia un tasto questo metodo viene chiamato
       keys[e.getKeyCode()] = false;
    }
    
    public int keyP(){
        if(up||down||right||left)
            return 1;
        return 0;
    }
}

