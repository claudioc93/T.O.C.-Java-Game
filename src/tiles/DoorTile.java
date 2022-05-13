/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;

import gfx.Assets;

/**
 *
 * @author claud
 */
public class DoorTile extends Tile{
       public DoorTile(int id) {
        super(Assets.tileDoor, id);
    }
    
       @Override
 public boolean changeWorld(){
     return true;
 }
    
}
