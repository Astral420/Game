package entity;

import main.GamePanel;

import java.awt.*;

public class NPC_6 extends Entity {
    public NPC_6(GamePanel gp) {
        super(gp);
        Direction = "down";
        speed = 1;
        solidArea = new Rectangle(0,0,48,48);
        getNPCImage();
        setDialogue();

    }
    public void getNPCImage() {



        up1 = setup("/player/up1");
        up2 = setup("/player/up2");
        down1 = setup("/player/down1");
        down2 = setup("/player/down2");
        left1 = setup("/player/left1");
        left2 = setup("/player/left2");
        right1 = setup("/player/right1");
        right2 = setup("/player/right2");
    }
    public void setDialogue(){

    }

    public void setAction(){

        actionLockCounter++;

        if (actionLockCounter == 100) {
            if (Direction == "down") {
                Direction = "left";
            }
        }
        if (actionLockCounter == 290) {
            if (Direction == "left") {
                Direction = "up";
            }
        }
        if (actionLockCounter == 385) {
            if (Direction == "up") {
                Direction = "right";
            }
        }
        if (actionLockCounter == 620) {
            if (Direction == "right") {
                Direction = "down";

            }
        }
        if (actionLockCounter == 710) {
            if (Direction == "down") {
                Direction = "left";

            }
        }
        if (actionLockCounter == 945) {
            if (Direction == "left") {
                Direction = "up";

            }actionLockCounter = 290;
        }

//            Random random = new Random();
//            int i = random.nextInt(100)+1;
//
//            if(i <= 25){
//                Direction = "up";
//            }
//            if(i >= 25 && i <= 50 ){
//                Direction = "down";
//            }
//            if(i >= 50 && i <= 75 ){
//                Direction = "left";
//            }
//            if(i >= 75 && i <= 100 ){
//                Direction = "right";
//            }



    }
    public void speak(){
        super.speak();

        speed = 0;
    }

}