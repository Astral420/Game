package tile;

import main.GamePanel;
import main.UtilityTool;

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

        setup(0,"tile_mainmap/tile001", false);
        setup(1,"tile_mainmap/tile002", false);
        setup(2,"tile_mainmap/tile008", false);
        setup(3,"tile_mainmap/tile009", false);
        setup(4,"tile_mainmap/tile010", false);
        setup(5,"tile_mainmap/tile011", false);
        setup(6,"tile_mainmap/tile012", false);
        setup(7,"tile_mainmap/tile013", false);
        setup(8,"tile_mainmap/tile014", false);
        setup(9,"tile_mainmap/tile015", false);
        setup(10,"tile_mainmap/tile016", false);
        setup(11,"tile_mainmap/tile017", false);
        setup(12,"tile_mainmap/tile018", false);
        setup(13,"tile_mainmap/tile019", false);
        setup(14,"tile_mainmap/tile020", false);
        setup(15,"tile_mainmap/tile024", false);
        setup(16,"tile_mainmap/tile025", false);
        setup(17,"tile_mainmap/tile026", false);
        setup(18,"puno/puno1", true);
        setup(19,"puno/puno2", true);
        setup(20,"puno/puno3", true);
        setup(21,"puno/puno4", true);
        setup(22,"puno/puno5", true);
        setup(23,"puno/puno6", true);
        setup(24,"puno/puno7", true);
        setup(25,"puno/puno8", true);
        setup(26,"puno/puno9", true);
        setup(27,"puno/puno10", true);
        setup(28,"kweba_entry/kweba1", false);
        setup(29,"kweba_entry/kweba2", false);
        setup(30,"kweba_entry/kweba3", false);
        setup(31,"kweba_entry/kweba4", false);

    }

    public void setup(int index, String imagepath, boolean collision){
        UtilityTool UTool = new UtilityTool();
        try {
            tile[index] = new Tiles();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tile/" + imagepath +".png"));
            tile[index].image = UTool.scaledImage(tile[index].image,gp.TileSize, gp.TileSize);
            tile[index].collision = collision;
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
        
        
        
        
    
