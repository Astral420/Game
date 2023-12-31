package entity;

import main.GamePanel;
import main.Movement;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    Movement move;
    public final int screenX, screenY;
    public int hasQuestionCompleted = 0;


    public Player(GamePanel gp, Movement move) {
        super(gp);
        this.gp = gp;
        this.move = move;

        screenX = gp.screenWidth / 2 - (gp.TileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.TileSize / 2);

        solidArea = new Rectangle(6, 6, 36, 38);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultValues();
        getPlayerImage();


    }

    public void setDefaultValues() {
        worldX = gp.TileSize * 42;
        worldY = gp.TileSize * 4;
//        worldX = gp.TileSize * 32;
//        worldY = gp.TileSize * 33;
        speed = 4;
        Direction = "down";
    }

    public void getPlayerImage() {

        up1 = setup("/player/up1");
        up2 = setup("/player/up2");
        down1 = setup("/player/down1");
        down2 = setup("/player/down2");
        left1 = setup("/player/left1");
        left2 = setup("/player/left2");
        right1 = setup("/player/right1");
        right2 = setup("/player/right2");
    }








    public void updateScreen(){
        if(move.upPressed == true || move.downPressed == true || move.leftPressed == true || move.rightPressed == true ){
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
            
            int npcIndex = gp.cChecker.checkEntity(this, gp.NPC[gp.currentMap]);
            interactNPC(npcIndex);

            gp.eHandler.checkEvent();

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
            String objName = gp.obj[gp.currentMap][i].name;

            switch (objName){
                case "Question":
                    gp.playSFX(3);
                    hasQuestionCompleted++;
                    gp.obj[gp.currentMap][i] = null;
                    System.out.println("Correct Answers: " + hasQuestionCompleted);
                    gp.ui.showMessage("Congratulations! Please proceed to the next room.");
                    break;

//                case "Cave":
//                    if (hasQuestionCompleted > 0){
//                        gp.obj[i] = null;
//                        hasQuestionCompleted--;
//                    }
//                    else{
//                        gp.ui.showMessage("You need a key!");
//                    }
//                    break;
                case "Obstacle":
                    if (hasQuestionCompleted > 0){
                        gp.playSFX(2);
                        gp.obj[gp.currentMap][i] = null;
                        hasQuestionCompleted--;
                        gp.ui.showMessage("Obstacle Removed!");
                    }
                    else{
                        gp.ui.showMessage("You need a key!");
                    }
                    break;
                case "Final Boss":
                    gp.ui.gameFinished = true;
                    gp.stopMusic();;
                    gp.playSFX(3); //change to sfx game ending later
                    break;
            }
        }
    }
    
    public void interactNPC(int i){
    
        if (i != 999){
            if (gp.movement.enterPressed == true){

                    if(gp.NPC[i] == gp.NPC[0]){
                gp.gameState = gp.questionState1;
                    if(gp.ui.commandNum == 0){
                    move.QuesLimitDrop1++;
                    }
                }
                    if(gp.NPC[i] == gp.NPC[1]){
                gp.gameState = gp.questionState2;
                    if(gp.ui.commandNum == 1){
                    move.QuesLimitDrop2++;
                    }
                }
                    if(gp.NPC[i] == gp.NPC[2]){
                gp.gameState = gp.questionState3;
                    if(gp.ui.commandNum == 2){
                    move.QuesLimitDrop3++;
                    }
                }
                    if(gp.NPC[i] == gp.NPC[3]){
                gp.gameState = gp.questionState4;
                    if(gp.ui.commandNum == 2){
                    move.QuesLimitDrop4++;
                    }
                }
                    if(gp.NPC[i] == gp.NPC[4]){
                gp.gameState = gp.questionState5;
                    if(gp.ui.commandNum == 0){
                    move.QuesLimitDrop5++;
                    }
                }
                    if(gp.NPC[i] == gp.NPC[5]){
                gp.gameState = gp.questionState6;
                    if(gp.ui.commandNum == 1){
                    move.QuesLimitDrop6++;
                    }
                }
                    if(gp.NPC[i] == gp.NPC[6]){
                gp.gameState = gp.questionState7;
                    if(gp.ui.commandNum == 1){
                    move.QuesLimitDrop7++;
                    }
                }
                    if(gp.NPC[i] == gp.NPC[7]){
                gp.gameState = gp.questionState8;
                    if(gp.ui.commandNum == 0){
                    move.QuesLimitDrop8++;
                    }
                }
                    if(gp.NPC[i] == gp.NPC[8]){
                gp.gameState = gp.questionState9;
                    if(gp.ui.commandNum == 2){
                    move.QuesLimitDrop9++;
                    }
                }
                    if(gp.NPC[i] == gp.NPC[9]){
                gp.gameState = gp.questionState10;
                    if(gp.ui.commandNum == 1){
                    move.QuesLimitDrop10++;
                    }
                }
            }

        }
        gp.movement.enterPressed = false;

        
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
