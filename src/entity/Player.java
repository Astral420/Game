package entity;

import main.GamePanel;
import main.Movement;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    Movement move;
    public final int screenX,screenY;
    public int hasQuestionCompleted = 0;


    public Player(GamePanel gp, Movement move) {

        this.gp = gp;
        this.move = move;

        screenX = gp.screenWidth/2 - (gp.TileSize/2);
        screenY = gp.screenHeight/2 - (gp.TileSize/2);

        solidArea = new Rectangle(16,24,15,5);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultValues();
        getPlayerImage();


    }

    public void setDefaultValues() {
        worldX  = gp.TileSize * 8;
        worldY = gp.TileSize * 6;
        speed = 4;
        Direction = "down";
    }

    public void getPlayerImage() {

        try {
            
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void updateScreen(){
        if(move.upPressed == true || move.downPressed == true || move.leftPressed == true || move.rightPressed == true || move.sprint == true){
            if(move.upPressed == true){
                Direction = "up";
            }
            if (move.downPressed == true){
                Direction = "down";
            }
            if(move.leftPressed == true){
                Direction = "left";
            }
            if (move.rightPressed == true){
                Direction = "right";
            }


            collisionOn = false;
            gp.cChecker.checkTile(this);
            int objIndex = gp.cChecker.checkObj(this, true);
            pickupObj(objIndex);

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

    }
    public void pickupObj(int i){ // eto nagaano ng question
        if (i != 999){
            String objName = gp.obj[i].name;

            switch (objName){
                case "Question":
                    gp.playSFX(3);
                    hasQuestionCompleted++;
                    gp.obj[i] = null;
                    System.out.println("Correct Answers: " + hasQuestionCompleted);
                    break;

                case "Cave":
                    if (hasQuestionCompleted > 0){
                        gp.obj[i] = null;
                        hasQuestionCompleted--;
                    }
            }
        }
    }
    public void draw(Graphics2D g2){
        BufferedImage img = null;
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
        g2.drawImage(img, screenX, screenY, gp.TileSize, gp.TileSize, null);
    }
}
