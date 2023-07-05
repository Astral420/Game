package main;



import objects.Obj_Question;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {
    GamePanel gp;
    Font arial_40, arial_80B;
    BufferedImage questionimg;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String currentDialogue = "";
    public int commandNum = 0;
    int substate = 0;
    
    double playTime;
    DecimalFormat df = new DecimalFormat("#0.00");
    public Graphics2D g2;
    
    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
        Obj_Question question = new Obj_Question();
        questionimg = question.img;

    }
    
    public void showMessage(String text){
        message = text;
        messageOn = true;
    }
    
    public void draw (Graphics2D g2){
        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.white);
        if(gp.gameState == gp.playState){
            
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        g2.drawImage(questionimg,gp.TileSize/2, gp.TileSize/2,gp.TileSize,gp.TileSize, null);
        g2.drawString("x = "+ gp.player.hasQuestionCompleted,80, 70);

        playTime +=(double)1/60;
        g2.setFont(g2.getFont().deriveFont(24F));
        g2.drawString("Time: " + df.format(playTime),gp.TileSize*12,30);

        if(messageOn == true){
            g2.setFont(g2.getFont().deriveFont(24F));
            g2.drawString(message, gp.TileSize/2, gp.TileSize*11);

            messageCounter++;

            if(messageCounter > 300){
                messageCounter = 0;
                messageOn = false;
                }
            }
        
        }
        if (gp.gameState == gp.titleState){
            drawTitleScreen();
        }
        if(gp.gameState == gp.pauseState){
            drawPauseScreen();
        }
        if (gp.gameState == gp.optionState){
            drawOptionScreen();
            
        }if (gp.gameState == gp.questionState1){
            drawQuestionScreen1();
        }
        if (gp.gameState == gp.questionState2){
            drawQuestionScreen2();
        }
        if (gp.gameState == gp.questionState3){
            drawQuestionScreen3();
        }
        if (gp.gameState == gp.questionState4){
            drawQuestionScreen4();
        }
        if (gp.gameState == gp.questionState5){
            drawQuestionScreen5();
        }
        if (gp.gameState == gp.questionState6){
            drawQuestionScreen6();
        }
        if (gp.gameState == gp.questionState7){
            drawQuestionScreen7();
        }
        if (gp.gameState == gp.questionState8){
            drawQuestionScreen8();
        }
        if (gp.gameState == gp.questionState9){
            drawQuestionScreen9();
        }
        if (gp.gameState == gp.questionState10){
            drawQuestionScreen10();
        }
          
}

    public void drawOptionScreen() {
        g2.setColor(Color.white);
        int frameX = gp.TileSize*5;
        int frameY = gp.TileSize;
        int frameWidth = gp.TileSize*8;
        int frameHeight = gp.TileSize*10;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);
        switch (substate) {
            case 0: options_top(frameX, frameY); break;
            case 1:  options_control(frameX,frameY);break;
            case 2:  options_endGameConfirmation(frameX,frameY);break;
        }
        gp.movement.enterPressed = false;
    }

    public void options_endGameConfirmation(int frameX, int frameY) {
        int textX = frameX + gp.TileSize;
        int textY = frameY + gp.TileSize*3;


        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 35F));
        currentDialogue = "Quit and return \nto Main Menu?";
        for(String line: currentDialogue.split("\n")){
            g2.drawString(line,textX+20,textY+20);
            textY += 40;
        }

        String text = "Yes";
        textX = getXforCenteredText(text);
        textY += gp.TileSize*3;
        g2.drawString(text,textX,textY);
        if(commandNum == 0){
            g2.drawString(">", textX-25, textY);
            if(gp.movement.enterPressed == true){
                substate = 0;
                gp.currentMap = 0;
                gp.gameState = gp.titleState;
                gp.stopMusic();
            }
        }
        text = "No";
        textX = getXforCenteredText(text);
        textY += gp.TileSize;
        g2.drawString(text,textX,textY);
        if(commandNum == 1){
            g2.drawString(">", textX-25, textY);
            if(gp.movement.enterPressed == true){
                substate = 0;
                commandNum = 4;
            }
        }
    }

    public void options_top(int frameX, int frameY){
        int textX;
        int textY;


        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 50F));
        String txt = "Options";
        textX = getXforCenteredText(txt);
        textY = frameY + gp.TileSize+15;
        g2.drawString(txt, textX, textY);


        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 28F));
        textX = frameX + gp.TileSize;
        textY += gp.TileSize*2;
        g2.drawString("Music", textX, textY);
        if (commandNum == 0) {
            g2.drawString(">", textX-25, textY);
        }

        textY += gp.TileSize*1.3;
        g2.drawString("SFX", textX, textY);
        if (commandNum == 1) {
            g2.drawString(">", textX-25, textY);
            if (gp.movement.enterPressed == true) {
            }
        }

        textY += gp.TileSize*1.3;
        g2.drawString("Controls", textX, textY);
        if (commandNum == 2) {
            g2.drawString(">", textX-25, textY);
            if (gp.movement.enterPressed == true) {
                substate = 1;
                commandNum = 0;

            }
        }

        textY += gp.TileSize*1.3;
        g2.drawString("Quit", textX, textY);
        if (commandNum == 3) {
            g2.drawString(">", textX-25, textY);
            if (gp.movement.enterPressed == true) {
                substate = 2;
                commandNum = 0;
            }
        }

        textY += gp.TileSize*1.3;
        g2.drawString("Close", textX, textY);
        if (commandNum == 4) {
            g2.drawString(">", textX-25, textY);
            if (gp.movement.enterPressed == true) {
                gp.gameState = gp.playState;
                commandNum = 0;
            }
        }

        textX = frameX + (int)(gp.TileSize*4.5);
        textY = frameY + gp.TileSize*2 + 40;
        g2.setStroke(new BasicStroke(3));
        g2.drawRect(textX,textY,120,24);
        int volumeWidth = 24 * gp.music.volumeScale;
        g2.fillRect(textX, textY, volumeWidth, 24);

        textY += gp.TileSize+12;
        g2.drawRect(textX,textY,120,24);
        volumeWidth = 24 * gp.SFX.volumeScale;
        g2.fillRect(textX, textY, volumeWidth, 24);

        gp.config.saveConfig();
    }

    public void options_control(int frameX, int frameY){

        int textX;
        int textY;

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 28F));

        String text = "Controls";
        textX = getXforCenteredText(text);
        textY = frameY + gp.TileSize;
        g2.drawString(text,textX,textY);

        textX = frameX + gp.TileSize;
        textY += gp.TileSize;
        g2.drawString("Move", textX, textY+20); textY+=gp.TileSize;
        g2.drawString("Talk", textX, textY+60); textY+=gp.TileSize;
        g2.drawString("Pause", textX, textY+80); textY+=gp.TileSize;
        g2.drawString("Options", textX, textY+100); textY+=gp.TileSize;

        textX = frameX + gp.TileSize*6;
        textY = frameY + gp.TileSize*2;
        g2.drawString("WASD",textX,textY+20); textY += gp.TileSize;
        g2.drawString("Enter",textX,textY+60); textY += gp.TileSize;
        g2.drawString("P",textX,textY+80); textY += gp.TileSize;
        g2.drawString("ESC",textX,textY+100); textY += gp.TileSize;

        textX = frameX + gp.TileSize;
        textY = frameY + gp.TileSize*9;
        g2.drawString("Back",textX,textY+20);
        if(commandNum == 0){
            g2.drawString(">", textX-25,textY+20);
            if(gp.movement.enterPressed == true){
                substate = 0;
            }
        }
    }

    public void drawPauseScreen(){
        g2.setFont(g2.getFont().deriveFont(60F));
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;
        
        g2.drawString(text, x, y);
    }
//    public void drawDialogueScreen(){
//        int x = gp.TileSize*2,
//         y = gp.TileSize/2,
//         width = gp.screenWidth - (gp.TileSize * 4),
//         height = gp.TileSize*4 ;
//        drawSubWindow(x,y,width,height);
//
//        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,28F));
//        x += gp.TileSize;
//        y += gp.TileSize;
//        for (String line : currentDialogue.split("\n")) {
//            g2.drawString(line, x, y);
//            y += 40;
//        }
//
//    }
    public void drawTitleScreen(){
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Question Game";
        int x = getXforCenteredText(text);
        int y = gp.TileSize*3;

        g2.setColor(Color.gray);
        g2.drawString(text,x+5,y+5);

        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        
        x = gp.screenWidth/2 - (gp.TileSize*3)/2;
        y += gp.TileSize;
        g2.drawImage(gp.player.down1, x, y, gp.TileSize*3, gp.TileSize*3, null);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "NEW GAME";
        x = getXforCenteredText(text);
        y += gp.TileSize*4;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "LEADERBOARDS";
        x = getXforCenteredText(text);
        y += gp.TileSize;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "QUIT";
        x = getXforCenteredText(text);
        y += gp.TileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
    }
    public void drawSubWindow(int x, int y, int width, int height){
        Color c = new Color(0,0,0,200);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width,height,35,35);

        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5,y+5,width-10,height-10,25,25);

    }
    
    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
    
    public void drawQuestionScreen1(){
        
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Level 1: ";
        int x = getXforCenteredText(text);
        int y = gp.TileSize*3;

        g2.setColor(Color.gray);
        g2.drawString(text,x+5,y+5);

        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        
        x = gp.screenWidth/2 - (gp.TileSize*3)/2;
        y += gp.TileSize;
        g2.drawImage(gp.player.down1, x, y, gp.TileSize*3, gp.TileSize*3, null);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "A. (PUT CORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize*4;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "B. (PUT INCORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "C. (PUT INCORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
    }
    
    public void drawQuestionScreen2(){
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Level 2: ";
        int x = getXforCenteredText(text);
        int y = gp.TileSize*3;

        g2.setColor(Color.gray);
        g2.drawString(text,x+5,y+5);

        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        
        x = gp.screenWidth/2 - (gp.TileSize*3)/2;
        y += gp.TileSize;
        g2.drawImage(gp.player.down1, x, y, gp.TileSize*3, gp.TileSize*3, null);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "A. (PUT INCORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize*4;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "B. (PUT CORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "C. (PUT INCORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
    }
    
    public void drawQuestionScreen3(){
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Level 3: ";
        int x = getXforCenteredText(text);
        int y = gp.TileSize*3;

        g2.setColor(Color.gray);
        g2.drawString(text,x+5,y+5);

        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        
        x = gp.screenWidth/2 - (gp.TileSize*3)/2;
        y += gp.TileSize;
        g2.drawImage(gp.player.down1, x, y, gp.TileSize*3, gp.TileSize*3, null);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "A. (PUT INCORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize*4;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "B. (PUT INCORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "C. (PUT CORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
    }
    
    public void drawQuestionScreen4(){
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Level 4: ";
        int x = getXforCenteredText(text);
        int y = gp.TileSize*3;

        g2.setColor(Color.gray);
        g2.drawString(text,x+5,y+5);

        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        
        x = gp.screenWidth/2 - (gp.TileSize*3)/2;
        y += gp.TileSize;
        g2.drawImage(gp.player.down1, x, y, gp.TileSize*3, gp.TileSize*3, null);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "A. (PUT INCORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize*4;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "B. (PUT INCORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "C. (PUT CORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
    }
    
    public void drawQuestionScreen5(){
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Level 5: ";
        int x = getXforCenteredText(text);
        int y = gp.TileSize*3;

        g2.setColor(Color.gray);
        g2.drawString(text,x+5,y+5);

        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        
        x = gp.screenWidth/2 - (gp.TileSize*3)/2;
        y += gp.TileSize;
        g2.drawImage(gp.player.down1, x, y, gp.TileSize*3, gp.TileSize*3, null);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "A. (PUT CORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize*4;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "B. (PUT INCORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "C. (PUT INCORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
    }
    
    public void drawQuestionScreen6(){
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Level 6: ";
        int x = getXforCenteredText(text);
        int y = gp.TileSize*3;

        g2.setColor(Color.gray);
        g2.drawString(text,x+5,y+5);

        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        
        x = gp.screenWidth/2 - (gp.TileSize*3)/2;
        y += gp.TileSize;
        g2.drawImage(gp.player.down1, x, y, gp.TileSize*3, gp.TileSize*3, null);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "A. (PUT INCORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize*4;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "B. (PUT CORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "C. (PUT INCORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
    }
    
    public void drawQuestionScreen7(){
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Level 7: ";
        int x = getXforCenteredText(text);
        int y = gp.TileSize*3;

        g2.setColor(Color.gray);
        g2.drawString(text,x+5,y+5);

        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        
        x = gp.screenWidth/2 - (gp.TileSize*3)/2;
        y += gp.TileSize;
        g2.drawImage(gp.player.down1, x, y, gp.TileSize*3, gp.TileSize*3, null);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "A. (PUT INCORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize*4;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "B. (PUT CORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "C. (PUT INCORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
    }
    
    public void drawQuestionScreen8(){
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Level 8: ";
        int x = getXforCenteredText(text);
        int y = gp.TileSize*3;

        g2.setColor(Color.gray);
        g2.drawString(text,x+5,y+5);

        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        
        x = gp.screenWidth/2 - (gp.TileSize*3)/2;
        y += gp.TileSize;
        g2.drawImage(gp.player.down1, x, y, gp.TileSize*3, gp.TileSize*3, null);

       g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "A. (PUT CORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize*4;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "B. (PUT INCORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "C. (PUT INCORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
    }
    
    public void drawQuestionScreen9(){
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Level 9: ";
        int x = getXforCenteredText(text);
        int y = gp.TileSize*3;

        g2.setColor(Color.gray);
        g2.drawString(text,x+5,y+5);

        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        
        x = gp.screenWidth/2 - (gp.TileSize*3)/2;
        y += gp.TileSize;
        g2.drawImage(gp.player.down1, x, y, gp.TileSize*3, gp.TileSize*3, null);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "A. (PUT INCORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize*4;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "B. (PUT INCORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "C. (PUT CORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
    }
    
    public void drawQuestionScreen10(){
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Level 10: ";
        int x = getXforCenteredText(text);
        int y = gp.TileSize*3;

        g2.setColor(Color.gray);
        g2.drawString(text,x+5,y+5);

        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        
        x = gp.screenWidth/2 - (gp.TileSize*3)/2;
        y += gp.TileSize;
        g2.drawImage(gp.player.down1, x, y, gp.TileSize*3, gp.TileSize*3, null);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "A. (PUT INCORRECT ANSWER";
        x = getXforCenteredText(text);
        y += gp.TileSize*4;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "B. (PUT CORRECT ANSWER))";
        x = getXforCenteredText(text);
        y += gp.TileSize;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,36F));
        text = "C. (PUT INCORRECT ANSWER)";
        x = getXforCenteredText(text);
        y += gp.TileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2){
            g2.drawString(">", x-gp.TileSize, y);
        }
        
    }
    
    
}