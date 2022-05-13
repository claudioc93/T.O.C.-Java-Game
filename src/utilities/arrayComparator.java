/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import entity.Entity;
import java.util.Comparator;

/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public class arrayComparator implements Comparator<Entity>{
  
  @Override
  public int compare(Entity a, Entity b){    
    if(a.getY()+ a.getHeight() <b.getY()+ b.getHeight())
      return -1; // a deve essere rederrizzato prima di b
    else if(a.getY()+ a.getHeight() > b.getY()+ b.getHeight()) 
      return 1;
    return 0;
  }

}