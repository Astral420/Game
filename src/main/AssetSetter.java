package main;

import entity.NPC_Boss;
import objects.Obj_Obstacle;
import objects.Obj_Question;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    public void setObj(){
        int mapNum = 0;
        int i = 0;
        gp.obj[mapNum][0] = new Obj_Obstacle();
        gp.obj[mapNum][0].worldX = 38 * gp.TileSize;
        gp.obj[mapNum][0].worldY = 25 * gp.TileSize;
        i++;

        gp.obj[mapNum][1] = new Obj_Question();
        gp.obj[mapNum][1].worldX = 36 * gp.TileSize;
        gp.obj[mapNum][1].worldY = 23 * gp.TileSize;
        i++;

        gp.obj[mapNum][2] = new Obj_Obstacle();
        gp.obj[mapNum][2].worldX = 22 * gp.TileSize;
        gp.obj[mapNum][2].worldY = 30 * gp.TileSize;
        i++;

        gp.obj[mapNum][3] = new Obj_Question();
        gp.obj[mapNum][3].worldX = 23 * gp.TileSize;
        gp.obj[mapNum][3].worldY = 26 * gp.TileSize;
        i++;

        gp.obj[mapNum][4] = new Obj_Obstacle();
        gp.obj[mapNum][4].worldX = 35 * gp.TileSize;
        gp.obj[mapNum][4].worldY = 34 * gp.TileSize;
        i++;

        gp.obj[mapNum][5] = new Obj_Question();
        gp.obj[mapNum][5].worldX = 33 * gp.TileSize;
        gp.obj[mapNum][5].worldY = 35 * gp.TileSize;
        i++;

        gp.obj[mapNum][6] = new Obj_Obstacle();
        gp.obj[mapNum][6].worldX = 31 * gp.TileSize;
        gp.obj[mapNum][6].worldY = 40 * gp.TileSize;
        i++;

        gp.obj[mapNum][7] = new Obj_Question();
        gp.obj[mapNum][7].worldX = 35 * gp.TileSize;
        gp.obj[mapNum][7].worldY = 43 * gp.TileSize;
        i++;

        gp.obj[mapNum][8] = new Obj_Obstacle();
        gp.obj[mapNum][8].worldX = 18 * gp.TileSize;
        gp.obj[mapNum][8].worldY = 38 * gp.TileSize;
        i++;

        gp.obj[mapNum][9] = new Obj_Question();
        gp.obj[mapNum][9].worldX = 23 * gp.TileSize;
        gp.obj[mapNum][9].worldY = 40 * gp.TileSize;

        gp.obj[mapNum][10] = new Obj_Obstacle();
        gp.obj[mapNum][10].worldX = 12 * gp.TileSize;
        gp.obj[mapNum][10].worldY = 29 * gp.TileSize;
        i++;

        gp.obj[mapNum][11] = new Obj_Question();
        gp.obj[mapNum][11].worldX = 11 * gp.TileSize;
        gp.obj[mapNum][11].worldY = 32 * gp.TileSize;
        i++;

        gp.obj[mapNum][12] = new Obj_Obstacle();
        gp.obj[mapNum][12].worldX = 20 * gp.TileSize;
        gp.obj[mapNum][12].worldY = 17 * gp.TileSize;
        i++;

        gp.obj[mapNum][13] = new Obj_Question();
        gp.obj[mapNum][13].worldX = 17 * gp.TileSize;
        gp.obj[mapNum][13].worldY = 20 * gp.TileSize;
        i++;

        gp.obj[mapNum][14] = new Obj_Obstacle();
        gp.obj[mapNum][14].worldX = 32 * gp.TileSize;
        gp.obj[mapNum][14].worldY = 12 * gp.TileSize;
        i++;

        gp.obj[mapNum][15] = new Obj_Question();
        gp.obj[mapNum][15].worldX = 29 * gp.TileSize;
        gp.obj[mapNum][15].worldY = 15 * gp.TileSize;
        i++;

        gp.obj[mapNum][16] = new Obj_Obstacle();
        gp.obj[mapNum][16].worldX = 21 * gp.TileSize;
        gp.obj[mapNum][16].worldY = 7 * gp.TileSize;
        i++;

        gp.obj[mapNum][17] = new Obj_Question();
        gp.obj[mapNum][17].worldX = 25 * gp.TileSize;
        gp.obj[mapNum][17].worldY = 3 * gp.TileSize;
        i++;

        gp.obj[mapNum][18] = new Obj_Obstacle();
        gp.obj[mapNum][18].worldX = 8 * gp.TileSize;
        gp.obj[mapNum][18].worldY = 2 * gp.TileSize;
        i++;

        gp.obj[mapNum][19] = new Obj_Question();
        gp.obj[mapNum][19].worldX = 6 * gp.TileSize;
        gp.obj[mapNum][19].worldY = 4 * gp.TileSize;
        i++;
    }
    public void setNPC(){
        int mapNum = 0;
        int i = 0;

        gp.NPC[mapNum][0] = new NPC_Boss(gp);
        gp.NPC[mapNum][0].worldX = 41*gp.TileSize;
        gp.NPC[mapNum][0].worldY = 4*gp.TileSize;
        i++;
    }
}
