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
public class GrassTile  extends Tile {
       public GrassTile(int id) {
        super(Assets.tileGrass,id);//so già quale è la texture dell'erba e quindi gli passo direttamente quella dagli Assets
    }
}
