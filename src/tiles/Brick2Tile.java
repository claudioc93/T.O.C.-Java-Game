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
public class Brick2Tile extends Tile{
       public Brick2Tile(int id) {
        super(Assets.tileBrick2, id);
    }
    
    @Override
    public boolean isSolid(){// la roccia non è calpestabile quindi è solida, devo quindi fare l'ovveride del metodo isSolid della super classe
        return true;
    }
    
    
}
