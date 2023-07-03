package entity;
import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Entity {
    GamePanel gp;
    public int worldX, worldY;


    public int speed;

    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;

    public String Direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;

    public boolean collisionOn= false;
    
    public int actionLockCounter = 0;
    String dialogue [] = new String[50];
    int dialogueIndex = 0;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }
    
    public void setAction(){}
    public void speak(){
        if (dialogue[dialogueIndex] == null){
            dialogueIndex = 0;

        }
        gp.ui.currentDialogue = dialogue[dialogueIndex];
        dialogueIndex++;

        switch (gp.player.Direction){
            case "up":
                Direction = "down";
                break;
            case "down":
                Direction = "up";
                break;

            case "left":
                Direction = "right";
                break;

            case "right":
                Direction = "left";
                break;
        }
    }
    
    public void update(){
    
        setAction();
        
        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObj(this, false);
        gp.cChecker.checkPlayer(this);
        
        if(collisionOn == false){

                switch(Direction){
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;


                }

            }

            spriteCounter++;
            if (spriteCounter> 12){
                if (spriteNum == 1){
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        
    }
    
    public void draw(Graphics2D g2){
        BufferedImage img = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + gp.TileSize> gp.player.worldX - gp.player.screenX &&
                worldX - gp.TileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.TileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.TileSize < gp.player.worldY + gp.player.screenY){
            switch (Direction){
                case "up":
                    if(spriteNum == 1) {
                        img = up1;
                    }
                    if(spriteNum == 2){
                        img = up2;
                    }
                    break;
                case "down":
                    if(spriteNum == 1) {
                        img = down1;
                    }
                    if(spriteNum == 2){
                        img = down2;
                    }
                    break;
                case "left":
                    if(spriteNum == 1) {
                        img = left1;
                    }
                    if(spriteNum == 2){
                        img = left2;
                    }
                    break;
                case "right":
                    if(spriteNum == 1) {
                        img = right1;
                    }
                    if(spriteNum == 2){
                        img = right2;
                    }
                    break;
            }
            g2.drawImage(img,screenX,screenY,gp.TileSize,gp.TileSize,null);
        }


    }
    public BufferedImage setup(String imgPath) {
        UtilityTool UTool = new UtilityTool();
        BufferedImage img = null;

        try {
            img = ImageIO.read(getClass().getResourceAsStream( imgPath + ".png"));
            img = UTool.scaledImage(img, gp.TileSize, gp.TileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
}
