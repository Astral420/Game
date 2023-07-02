package main;

import entity.Player;
import objects.SuperObj;
import tile.TileManager;


import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics2D;
public class GamePanel extends JPanel implements Runnable {

    public final int originalTileSize = 16;
    public final int scale = 3;
    public final int TileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = TileSize * maxScreenCol;
    public final int screenHeight = TileSize * maxScreenRow;

    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;

    int FPS = 60;

    TileManager TileM = new TileManager(this);
    Movement movement = new Movement(this);
    Sound SFX = new Sound();
    Sound music = new Sound();
    UI ui = new UI(this);
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this,movement);
    public SuperObj obj[] = new SuperObj[10];



    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(movement);
        this.setFocusable(true);
    }

    public void setupGame(){

        aSetter.setObj();
        playMusic(0);
    }

    public void GameStart(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void updateScreen() {

            player.updateScreen();
        }



    @Override
    public void run (){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        int timer = 0;
        int drawCount = 0;


        while (gameThread != null){

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1){
                updateScreen();
                repaint();
                delta --;
                drawCount ++;
            }
            if (timer >= 1000000000){
                System.out.println("FPS: " +drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        TileM.draw(g2);
        for (int i = 0; i < obj.length; i++){
            if (obj[i] != null){
                obj[i].draw(g2,this);
            }
        }
        player.draw(g2);
        ui.draw(g2);
        g2.dispose();

    }
    public void playMusic(int i){
        music.setFile(i);
        music.play();
        music.loop();
    }
    public void stopMusic(){
        music.stop();
    }
    public void playSFX(int i){
        SFX.setFile(i);
        SFX.play();
    }
}
