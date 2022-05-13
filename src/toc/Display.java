/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toc;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public class Display {
    
    private JFrame frame;
    private Canvas canvas;  //un ogg canvas ci permette di disegnare ogni tipo di immagine
    
    private final String title;
    private int width_window; 
    private int height_window;
 
 //Constructor
    public Display(String title,int width,int height){
        this.title = title;
        this.width_window = width;
        this.height_window = height;
        createDisplay();  
    }

//Logic    
    private void createDisplay(){

        frame = new JFrame(title);
        frame.setSize(width_window,height_window);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width_window,height_window));
        canvas.setMaximumSize(new Dimension(width_window,height_window));
        canvas.setMinimumSize(new Dimension(width_window,height_window));
        canvas.setFocusable(false);//permette all'applicazione di ottenere il focus, se non inserito in alcuni computer non prende gli input(nel mio funziona anche senza)
        
        frame.add(canvas);
        frame.pack();  
    }
    
//Getters & Setters
   
    public Canvas getCanvas(){
        return canvas;
    }

    public JFrame getFrame(){ //permette di far vedere lo spostamento degli oggetti
         return frame;
    }
}
