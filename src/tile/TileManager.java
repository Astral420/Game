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
    public int mapTileNum[][][];
    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tiles[200];
        mapTileNum = new int[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/maps/main map txt file.txt",0);
        loadMap("/maps/map1.txt",1);
    }

    public void getTileImage() {

        setup(0, "tileset/001 (1)", false);
        setup(1, "tileset/003", false);
        setup(2, "tileset/004", false);
        setup(3, "tileset/005", false);
        setup(4, "tileset/006", false);
        setup(5, "tileset/007", false);
        setup(6, "tileset/008", false);
        setup(7, "tileset/00_tileset", false);
        setup(8, "tileset/016", true);
        setup(9, "tileset/017", false);
        setup(10, "tileset/018", false);
        setup(11, "tileset/019", false);
        setup(12, "tileset/01_tileset", false);
        setup(13, "tileset/020", false);
        setup(14, "tileset/021", false);
        setup(15, "tileset/022", false);
        setup(16, "tileset/023", false);
        setup(17, "tileset/024", false);
        setup(18, "tileset/025", false);
        setup(19, "tileset/026", false);
        setup(20, "tileset/027", false);
        setup(21, "tileset/028", false);
        setup(22, "tileset/029", false);
        setup(23, "tileset/02_tileset", false);
        setup(24, "tileset/030", false);
        setup(25, "tileset/031", false);
        setup(26, "tileset/032", false);
        setup(27, "tileset/033", false);
        setup(28, "tileset/03_tileset", false);
        setup(29, "tileset/04_tileset", false);
        setup(30, "tileset/05_tileset", false);
        setup(31, "tileset/06_tileset", false);
        setup(32, "tileset/07_tileset", false);
        setup(33, "tileset/08_tileset", false);
        setup(34, "tileset/09_tileset", false);
        setup(35, "tileset/100_tileset", false);
        setup(36, "tileset/101_tileset", false);
        setup(37, "tileset/102_tileset", false);
        setup(38, "tileset/103_tileset", false);
        setup(39, "tileset/10_tileset", false);
        setup(40, "tileset/11_tileset", false);
        setup(41, "tileset/12_tileset", false);
        setup(42, "tileset/13_tileset", false);
        setup(43, "tileset/14_tileset", false);
        setup(44, "tileset/15_tileset", false);
        setup(45, "tileset/16_tileset", false);
        setup(46, "tileset/17_tileset", false);
        setup(47, "tileset/18_tileset", false);
        setup(48, "tileset/19_tileset", false);
        setup(49, "tileset/20_tileset", false);
        setup(50, "tileset/21_tileset", false);
        setup(51, "tileset/22_tileset", false);
        setup(52, "tileset/23_tileset", false);
        setup(53, "tileset/24_tileset", false);
        setup(54, "tileset/25_tileset", false);
        setup(55, "tileset/26_tileset", false);
        setup(56, "tileset/27_tileset", false);
        setup(57, "tileset/28_tileset", false);
        setup(58, "tileset/29_tileset", false);
        setup(59, "tileset/30_tileset", false);
        setup(60, "tileset/31_tileset", false);
        setup(61, "tileset/32_tileset", false);
        setup(62, "tileset/33_tileset", false);
        setup(63, "tileset/34_tileset", false);
        setup(64, "tileset/35_tileset", false);
        setup(65, "tileset/36_tileset", false);
        setup(66, "tileset/37_tileset", false);
        setup(67, "tileset/38_tileset", false);
        setup(68, "tileset/39_tileset", false);
        setup(69, "tileset/40_tileset", false);
        setup(70, "tileset/41_tileset", false);
        setup(71, "tileset/42_tileset", false);
        setup(72, "tileset/43_tileset", false);
        setup(73, "tileset/44_tileset", false);
        setup(74, "tileset/45_tileset", false);
        setup(75, "tileset/46_tileset", false);
        setup(76, "tileset/47_tileset", false);
        setup(77, "tileset/48_tileset", false);
        setup(78, "tileset/49_tileset", false);
        setup(79, "tileset/50_tileset", false);
        setup(80, "tileset/51_tileset", false);
        setup(81, "tileset/52_tileset", false);
        setup(82, "tileset/53_tileset", false);
        setup(83, "tileset/54_tileset", false);
        setup(84, "tileset/55_tileset", false);
        setup(85, "tileset/56_tileset", false);
        setup(86, "tileset/57_tileset", false);
        setup(87, "tileset/58_tileset", false);
        setup(88, "tileset/59_tileset", false);
        setup(89, "tileset/60_tileset", false);
        setup(90, "tileset/61_tileset", false);
        setup(91, "tileset/62_tileset", false);
        setup(92, "tileset/63_tileset", false);
        setup(93, "tileset/64_tileset", false);
        setup(94, "tileset/65_tileset", false);
        setup(95, "tileset/66_tileset", false);
        setup(96, "tileset/67_tileset", false);
        setup(97, "tileset/68_tileset", false);
        setup(98, "tileset/69_tileset", false);
        setup(99, "tileset/70_tileset", false);
        setup(100, "tileset/71_tileset", false);
        setup(101, "tileset/72_tileset", false);
        setup(102, "tileset/73_tileset", false);
        setup(103, "tileset/74_tileset", false);
        setup(104, "tileset/75_tileset", false);
        setup(105, "tileset/76_tileset", false);
        setup(106, "tileset/77_tileset", false);
        setup(107, "tileset/78_tileset", false);
        setup(108, "tileset/79_tileset", false);
        setup(109, "tileset/80_tileset", false);
        setup(110, "tileset/81_tileset", false);
        setup(111, "tileset/82_tileset", false);
        setup(112, "tileset/83_tileset", false);
        setup(113, "tileset/84_tileset", false);
        setup(114, "tileset/85_tileset", false);
        setup(115, "tileset/86_tileset", false);
        setup(116, "tileset/87_tileset", false);
        setup(117, "tileset/88_tileset", false);
        setup(118, "tileset/89_tileset", false);
        setup(119, "tileset/90_tileset", false);
        setup(120, "tileset/91_tileset", false);
        setup(121, "tileset/92_tileset", false);
        setup(122, "tileset/93_tileset", false);
        setup(123, "tileset/94_tileset", false);
        setup(124, "tileset/95_tileset", false);
        setup(125, "tileset/96_tileset", false);
        setup(126, "tileset/97_tileset", false);
        setup(127, "tileset/98_tileset", false);
        setup(128, "tileset/99_tileset", false);
        setup(129, "tileset/bush1", false);
        setup(130, "tileset/bush2", false);
        setup(131, "tileset/bush3", false);
        setup(132, "tileset/bush4", false);
        setup(133, "tileset/roof1", false);
        setup(134, "tileset/roof2", false);
        setup(135, "tileset/roof5", false);
        setup(136, "tileset/roof6", false);
        setup(137, "tileset/side1", false);
        setup(138, "tileset/side2", false);
        setup(139, "tileset/side7", false);
        setup(140, "tileset/side8", false);



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
    public void loadMap(String filepath, int map){
        try {
            InputStream is = getClass().getResourceAsStream(filepath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();

                while (col < gp.maxWorldCol){
                    String numbers [] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[map][col][row] = num;
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
            int tileNum = mapTileNum[gp.currentMap][worldCol][worldRow];


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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
        
        
        
        
    
