package main;

import entity.Entity;
import entity.NPC_Boss;
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
    public final int maxMap = 10;
    public int currentMap  = 0;

    int FPS = 60;

    TileManager TileM = new TileManager(this);
    public Movement movement = new Movement(this);
    Sound SFX = new Sound();
    public Sound music = new Sound();
    public UI ui = new UI(this);
    Thread gameThread;
    
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this,movement);
    public SuperObj obj[][] = new SuperObj[maxMap][100];
    public Entity NPC [] []= new Entity[maxMap][3];

    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int titleState = 0;
    public final int optionState = 4;


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(movement);
        this.setFocusable(true);
    }

    public void setupGame(){

        aSetter.setObj();
        aSetter.setNPC();
       // playMusic(0);
        gameState = titleState;
    }

    public void GameStart(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void updateScreen() {
        
            if(gameState == playState){
                player.updateScreen();
                
                for(int i = 0; i <NPC[1].length; i++){
                    if(NPC[currentMap][i] != null){
                        NPC[currentMap][i].update();
                    }
                }
            }
            if(gameState == pauseState){
                
            }

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

        if (gameState == titleState){
        ui.draw(g2);
        }else {
            TileM.draw(g2);
            for (int i = 0; i < obj[1].length; i++){
                if (obj[currentMap][i] != null){
                    obj[currentMap][i].draw(g2,this);
                }
            }

            for(int i = 0; i < NPC[1].length; i++){
                if (NPC[currentMap][i] !=null){
                    NPC[currentMap][i].draw(g2);
                }
            }
            player.draw(g2);
            ui.draw(g2);
        }

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
