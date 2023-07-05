package main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setResizable(false);
        window.setTitle("Question Adventure Game");

        GamePanel gamepanel = new GamePanel();
        window.add(gamepanel);
        gamepanel.config.loadConfig();
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamepanel.setupGame();
        gamepanel.GameStart();

    }

}
