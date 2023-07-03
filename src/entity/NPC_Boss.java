package entity;

import main.GamePanel;

import java.awt.*;

import java.util.Random;

public class NPC_Boss extends Entity {
    public NPC_Boss(GamePanel gp) {
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
        dialogue[0] = "Hello, Tite";
        dialogue[1] = "Mukha kang burat";
        dialogue[2] = "What is the derivative dx/dy 430. Please \nanswer it manually. Alt Tabbing will \npunish you";


    }
    
    public void setAction(){
        
        actionLockCounter++;
        
        if(actionLockCounter == 120){
            
            Random random = new Random();
            int i = random.nextInt(100)+1;

            if(i <= 25 ){
                Direction = "up";
            }
            if(i >= 25 && i <= 50 ){
                Direction = "down";
            }
            if(i >= 50 && i <= 75 ){
                Direction = "left";
            }
            if(i >= 75 && i <= 100 ){
                Direction = "right";
            }
            actionLockCounter = 0;
        }
        
    }
    public void speak(){
    super.speak();
    }

}

