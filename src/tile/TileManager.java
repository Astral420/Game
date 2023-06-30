package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {


    GamePanel gp;
    public Tiles[] tile;
    public int mapTileNum[] [];
    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tiles[70];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap();
    }

    public void getTileImage() {
        try {
            tile[0] = new Tiles();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tile/tile_mainmap/tile001.png"));

            tile[1] = new Tiles();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tile/tile_mainmap/tile002.png"));

            tile[2] = new Tiles();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tile/tile_mainmap/tile008.png"));

            tile[3] = new Tiles();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tile/tile_mainmap/tile009.png"));

            tile[4] = new Tiles();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tile/tile_mainmap/tile010.png"));

            tile[5] = new Tiles();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tile/tile_mainmap/tile011.png"));

            tile[6] = new Tiles();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tile/tile_mainmap/tile012.png"));

            tile[7] = new Tiles();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tile/tile_mainmap/tile013.png"));

            tile[8] = new Tiles();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tile/tile_mainmap/tile014.png"));

            tile[9] = new Tiles();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tile/tile_mainmap/tile015.png"));

            tile[10] = new Tiles();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tile/tile_mainmap/tile016.png"));

            tile[11] = new Tiles();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tile/tile_mainmap/tile017.png"));

            tile[12] = new Tiles();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tile/tile_mainmap/tile018.png"));

            tile[13] = new Tiles();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tile/tile_mainmap/tile019.png"));

            tile[14] = new Tiles();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tile/tile_mainmap/tile020.png"));

            tile[15] = new Tiles();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tile/tile_mainmap/tile024.png"));

            tile[16] = new Tiles();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tile/tile_mainmap/tile025.png"));

            tile[17] = new Tiles();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tile/tile_mainmap/tile026.png"));

            tile[18] = new Tiles();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tile/puno/puno1.png"));
            tile[18].collision = true;

            tile[19] = new Tiles();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tile/puno/puno2.png"));

            tile[20] = new Tiles();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tile/puno/puno3.png"));

            tile[21] = new Tiles();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tile/puno/puno4.png"));

            tile[22] = new Tiles();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tile/puno/puno5.png"));

            tile[23] = new Tiles();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tile/puno/puno6.png"));
            tile[23].collision = true;

            tile[24] = new Tiles();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/tile/puno/puno7.png"));

            tile[25] = new Tiles();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/tile/puno/puno8.png"));

            tile[26] = new Tiles();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/tile/puno/puno9.png"));

            tile[27] = new Tiles();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/tile/puno/puno10.png"));

            tile[28] = new Tiles();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/tile/kweba_entry/kweba1.png"));

            tile[29] = new Tiles();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/tile/kweba_entry/kweba2.png"));

            tile[30] = new Tiles();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/tile/kweba_entry/kweba3.png"));

            tile[31] = new Tiles();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/tile/kweba_entry/kweba4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadMap(){
        try {
            InputStream is = getClass().getResourceAsStream("/maps/map1.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();

                while (col < gp.maxWorldCol){
                    String numbers [] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;

                }
                if (col == gp.maxWorldCol){
                    col = 0;
                    row++;

                }
            }
            br.close();
        }catch (Exception e){

        }
    }


    public void draw(Graphics2D g2){
        int worldCol = 0;
        int worldRow = 0;


        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){
            int tileNum = mapTileNum[worldCol][worldRow];


            int worldX = worldCol * gp.TileSize;
            int worldY = worldRow * gp.TileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (worldX + gp.TileSize> gp.player.worldX - gp.player.screenX &&
                worldX - gp.TileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.TileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.TileSize < gp.player.worldY + gp.player.screenY){
             g2.drawImage(tile[tileNum].image,screenX,screenY,gp.TileSize,gp.TileSize,null);
            }

            worldCol++;

            if (worldCol == gp.maxWorldCol){
                worldCol = 0;

                worldRow++;

            }

        }
    }

}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
        
        
        
        
    
