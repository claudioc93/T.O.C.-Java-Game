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
public class Island4Tile extends Tile{
    public Island4Tile(int id) {
        super(Assets.tileIsland4, id);
    }
    
  
    
  @Override
    public boolean isSolid(){// la roccia non è calpestabile quindi è solida, devo quindi fare l'ovveride del metodo isSolid della super classe
        return true;
    }   
    
}
