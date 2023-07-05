package main;

import entity.Entity;
import entity.Player;
import objects.SuperObj;
import tile.TileManager;


import javax.swing.JPanel;
import java.awt.*;

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
    Config config = new Config(this);
    public UI ui = new UI(this);
    Thread gameThread;
    
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this,movement);
    public SuperObj obj[][] = new SuperObj[maxMap][999];
    public Entity NPC [][]= new Entity[maxMap][100];

    public EventHandler eHandler = new EventHandler(this);

    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int titleState = 0;
    public final int optionState = 4;
    public final int questionState1 = 10;
    public final int questionState2 = 11;
    public final int questionState3 = 12;
    public final int questionState4 = 13;
    public final int questionState5 = 14;
    public final int questionState6 = 15;
    public final int questionState7 = 16;
    public final int questionState8 = 17;
    public final int questionState9 = 18;
    public final int questionState10 = 19;
    

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(movement);
        this.setFocusable(true);
    }

    public void setupGame(){
        aSetter.setObs();
        aSetter.setNPC();
        playMusic(0);
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
        if (movement.showDebugText == true){
            g2.setFont(new Font("Arial",Font.PLAIN,20));
            g2.setColor(Color.white);
            int x = 10;
            int y = 400;
            int lineHeight = 20;

            g2.drawString("World X: " + player.worldX,x,y); y += lineHeight;
            g2.drawString("World Y: " + player.worldY,x,y); y += lineHeight;
            g2.drawString("Col: " + (player.worldX + player.solidArea.x)/ TileSize,x,y); y += lineHeight;
            g2.drawString("Row: " + (player.worldY + player.solidArea.y)/TileSize,x,y); y += lineHeight;


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
