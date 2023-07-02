package main;



import objects.Obj_Question;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
    GamePanel gp;
    Font arial;
    BufferedImage questionimg;
    public UI(GamePanel gp) {
        this.gp = gp;
        arial = new Font("Arial", Font.PLAIN, 40);
        Obj_Question question = new Obj_Question();
        questionimg = question.img;

    }
    public void draw (Graphics2D g2){
        g2.setFont(arial);
        g2.setColor(Color.white);
        g2.drawImage(questionimg,gp.TileSize/2, gp.TileSize/2,gp.TileSize,gp.TileSize, null);
        g2.drawString("x = "+ gp.player.hasQuestionCompleted,80, 70);



    }
}
