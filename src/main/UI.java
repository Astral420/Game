package main;



import objects.Obj_Question;

import javax.imageio.ImageIO;
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
    
    double playTime;
    DecimalFormat df = new DecimalFormat("#0.00");
    public Graphics2D g2;
    
    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);


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
        if (gp.gameState == gp.dialogueState){
            drawDialogueScreen();
        }
          
}
    public void drawPauseScreen(){
        g2.setFont(g2.getFont().deriveFont(60F));
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;
        
        g2.drawString(text, x, y);
    }
    public void drawDialogueScreen(){
        int x = gp.TileSize*2,
         y = gp.TileSize/2,
         width = gp.screenWidth - (gp.TileSize * 4),
         height = gp.TileSize*4 ;
        drawSubWindow(x,y,width,height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,28F));
        x += gp.TileSize;
        y += gp.TileSize;
        for (String line : currentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y += 40;
        }

    }
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
}