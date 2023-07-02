package main;

import objects.Obj_Question;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObj(){
        gp.obj[0] = new Obj_Question();
        gp.obj[0].worldX = 1 * gp.TileSize;
        gp.obj[0].worldY = 2 * gp.TileSize;

        gp.obj[1] = new Obj_Question();
        gp.obj[1].worldX = 2 * gp.TileSize;
        gp.obj[1].worldY = 2 * gp.TileSize;
    }
}
