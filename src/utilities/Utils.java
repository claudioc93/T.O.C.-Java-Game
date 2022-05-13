/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Alessandra Donnini & Claudio Canulla
 */
public class Utils {

  public static String loadFileAsString(String path){
    StringBuilder builder = new StringBuilder();
      try{
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while((line =br.readLine())!= null)
          builder.append(line+"\n");
        br.close();
      }catch(IOException e){
        e.printStackTrace();
      }
    
    return builder.toString();
  }
    
  public static int parseInt(String number){//trasformo la stringa in un intero
    try{
      return Integer.parseInt(number);
    }catch(NumberFormatException e){
      e.printStackTrace();
      return 0;
    }
  }
}
