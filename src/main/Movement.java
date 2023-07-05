package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;


public class Movement implements KeyListener {
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
    boolean showDebugText;

    public Movement(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        if(gp.gameState == gp.titleState){
            titleState(code);
        }
        if(gp.gameState == gp.playState){
            playState(code);

        }
        
        else if (gp.gameState == gp.pauseState){
            pauseState(code);
        }else if (gp.gameState == gp.optionState) {
            optionState(code);
        }
        
        else if (gp.gameState == gp.questionState1){
            QuestionState1(code);
        }else if (gp.gameState == gp.questionState2){
            QuestionState2(code);
        }else if (gp.gameState == gp.questionState3){
            QuestionState3(code);
        }else if (gp.gameState == gp.questionState4){
            QuestionState4(code);
        }else if (gp.gameState == gp.questionState5){
            QuestionState5(code);
        }else if (gp.gameState == gp.questionState6){
            QuestionState6(code);
        }else if (gp.gameState == gp.questionState7){
            QuestionState7(code);
        }else if (gp.gameState == gp.questionState8){
            QuestionState8(code);
        }else if (gp.gameState == gp.questionState9){
            QuestionState9(code);
        }else if (gp.gameState == gp.questionState10){
            QuestionState10(code);
        }


    }
    public void titleState(int code){
        if (code == KeyEvent.VK_W) {
            gp.ui.commandNum--;
            if(gp.ui.commandNum < 0){
                gp.ui.commandNum = 2;
            }
        }
        if (code == KeyEvent.VK_S) {
            gp.ui.commandNum++;
            if(gp.ui.commandNum > 2){
                gp.ui.commandNum = 0;
            }
        }

        if(code == KeyEvent.VK_ENTER){

            if(gp.ui.commandNum == 0){
                gp.gameState = gp.playState;
//                    gp.playMusic(0);
            }
            if(gp.ui.commandNum == 1){
                //for leaderboards later
            }
            if(gp.ui.commandNum == 2){
                System.exit(0);
            }

        }
    }
    public void playState(int code){
        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }
        if(code == KeyEvent.VK_P){
            gp.gameState = gp.pauseState;
        }
        if(code == KeyEvent.VK_ENTER){
            enterPressed = true;
        }
        if(code == KeyEvent.VK_ESCAPE){
            gp.gameState = gp.optionState;
        }
        if (code == KeyEvent.VK_T){
            if (showDebugText == false){
                showDebugText = true;
            } else if (showDebugText == true) {
                showDebugText = false;
            }
        }
    }
    public void optionState(int code){
        if(code == KeyEvent.VK_ESCAPE){
            gp.gameState = gp.playState;
        }
        if(code == KeyEvent.VK_ENTER){
            if (gp.ui.commandNum == 1){

            }
            enterPressed = true;
        }
        int maxCommandNum = 0;
        switch (gp.ui.substate) {
            case 0: maxCommandNum = 4; break;
            case 2: maxCommandNum = 1; break;
        }
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            gp.ui.commandNum--;
            gp.playSFX(4);
            if (gp.ui.commandNum < 0) {
                gp.ui.commandNum = maxCommandNum;
            }
        }
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            gp.ui.commandNum++;
            gp.playSFX(4);
            if (gp.ui.commandNum > maxCommandNum) {
                gp.ui.commandNum = 0;
            }
        }

        if(code == KeyEvent.VK_A){
            if(gp.ui.substate == 0){
                if(gp.ui.commandNum == 0 && gp.music.volumeScale > 0){
                    gp.music.volumeScale--;
                    gp.music.checkVolume();
                    gp.playSFX(4);
                }
                if(gp.ui.commandNum == 1 && gp.SFX.volumeScale > 0){
                    gp.SFX.volumeScale--;
                    gp.playSFX(4);
                }
            }
        }
        if(code == KeyEvent.VK_D){
            if(gp.ui.substate == 0){
                if(gp.ui.commandNum == 0 && gp.music.volumeScale < 5){
                    gp.music.volumeScale++;
                    gp.music.checkVolume();
                    gp.playSFX(4);
                }
                if(gp.ui.commandNum == 1 && gp.SFX.volumeScale < 5){
                    gp.SFX.volumeScale++;
                    gp.playSFX(4);
                }
            }
        }
    }


    public void pauseState(int code){
        if(code == KeyEvent.VK_P){
            gp.gameState = gp.playState;

        }
    }
    
    
    public void QuestionState1(int code){
        if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                    if(gp.ui.commandNum < 0){
                        gp.ui.commandNum = 2;
                    }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                    if(gp.ui.commandNum > 2){
                        gp.ui.commandNum = 0;
                    }
            }
            
            if(code == KeyEvent.VK_ENTER){
            
                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.playState;
                    gp.aSetter.setObj1();
                }
                if(gp.ui.commandNum == 1){
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 2){
                    gp.gameState = gp.playState;
                }
                
            }
    }
    
    public void QuestionState2(int code){
        if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                    if(gp.ui.commandNum < 0){
                        gp.ui.commandNum = 2;
                    }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                    if(gp.ui.commandNum > 2){
                        gp.ui.commandNum = 0;
                    }
            }
            
            if(code == KeyEvent.VK_ENTER){
            
                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 1){
                    gp.gameState = gp.playState;
                    gp.aSetter.setObj2();
                }
                if(gp.ui.commandNum == 2){
                    gp.gameState = gp.playState;
                }
                
            }
    }
    
    public void QuestionState3(int code){
        if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                    if(gp.ui.commandNum < 0){
                        gp.ui.commandNum = 2;
                    }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                    if(gp.ui.commandNum > 2){
                        gp.ui.commandNum = 0;
                    }
            }
            
            if(code == KeyEvent.VK_ENTER){
            
                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 1){
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 2){
                    gp.gameState = gp.playState;
                    gp.aSetter.setObj3();
                }
                
            }
    }
    
    public void QuestionState4(int code){
        if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                    if(gp.ui.commandNum < 0){
                        gp.ui.commandNum = 2;
                    }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                    if(gp.ui.commandNum > 2){
                        gp.ui.commandNum = 0;
                    }
            }
            
            if(code == KeyEvent.VK_ENTER){
            
                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 1){
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 2){
                    gp.gameState = gp.playState;
                    gp.aSetter.setObj4();
                }
                
            }
    }
    
    public void QuestionState5(int code){
        if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                    if(gp.ui.commandNum < 0){
                        gp.ui.commandNum = 2;
                    }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                    if(gp.ui.commandNum > 2){
                        gp.ui.commandNum = 0;
                    }
            }
            
            if(code == KeyEvent.VK_ENTER){
            
                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.playState;
                    gp.aSetter.setObj5();
                }
                if(gp.ui.commandNum == 1){
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 2){
                    gp.gameState = gp.playState;
                }
                
            }
    }
    
    public void QuestionState6(int code){
        if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                    if(gp.ui.commandNum < 0){
                        gp.ui.commandNum = 2;
                    }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                    if(gp.ui.commandNum > 2){
                        gp.ui.commandNum = 0;
                    }
            }
            
            if(code == KeyEvent.VK_ENTER){
            
                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 1){
                    gp.gameState = gp.playState;
                    gp.aSetter.setObj6();
                }
                if(gp.ui.commandNum == 2){
                    gp.gameState = gp.playState;
                }
                
            }
    }
    
    public void QuestionState7(int code){
        if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                    if(gp.ui.commandNum < 0){
                        gp.ui.commandNum = 2;
                    }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                    if(gp.ui.commandNum > 2){
                        gp.ui.commandNum = 0;
                    }
            }
            
            if(code == KeyEvent.VK_ENTER){
            
                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 1){
                    gp.gameState = gp.playState;
                    gp.aSetter.setObj7();
                }
                if(gp.ui.commandNum == 2){
                    gp.gameState = gp.playState;
                }
                
            }
    }
    
    public void QuestionState8(int code){
        if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                    if(gp.ui.commandNum < 0){
                        gp.ui.commandNum = 2;
                    }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                    if(gp.ui.commandNum > 2){
                        gp.ui.commandNum = 0;
                    }
            }
            
            if(code == KeyEvent.VK_ENTER){
            
                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.playState;
                    gp.aSetter.setObj8();
                }
                if(gp.ui.commandNum == 1){
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 2){
                    gp.gameState = gp.playState;
                }
                
            }
    }
    
    public void QuestionState9(int code){
        if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                    if(gp.ui.commandNum < 0){
                        gp.ui.commandNum = 2;
                    }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                    if(gp.ui.commandNum > 2){
                        gp.ui.commandNum = 0;
                    }
            }
            
            if(code == KeyEvent.VK_ENTER){
            
                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 1){
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 2){
                    gp.gameState = gp.playState;
                    gp.aSetter.setObj9();
                }
                
            }
    }
    
    public void QuestionState10(int code){
        if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                    if(gp.ui.commandNum < 0){
                        gp.ui.commandNum = 2;
                    }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                    if(gp.ui.commandNum > 2){
                        gp.ui.commandNum = 0;
                    }
            }
            
            if(code == KeyEvent.VK_ENTER){
            
                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.playState;
                }
                if(gp.ui.commandNum == 1){
                    gp.gameState = gp.playState;
                    gp.aSetter.setObj10();
                }
                if(gp.ui.commandNum == 2){
                    gp.gameState = gp.playState;
                }
                
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }

    }
}
