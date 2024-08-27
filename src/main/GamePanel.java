package main;

import entity.Player;
import entity.Screen;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //Screen Settings
    final static int ORIGINAL_TITLE_SIZE = 16;
    final static int SCALE = 3;
    final static int MAX_SCREEN_COL = 16;
    final static int MAX_SCREEN_ROW = 12;

    //FPS
    final static int FPS = 60;

    Screen screen = new Screen(ORIGINAL_TITLE_SIZE, SCALE, MAX_SCREEN_COL, MAX_SCREEN_ROW);
    TileManager tileManager = new TileManager(this, screen);
    KeyHundler keyHundler = new KeyHundler();
    Thread gameThread;
    Player player = new Player(this, keyHundler, screen);

    public GamePanel() {

        this.setPreferredSize(new Dimension(screen.getScreenWidth(), screen.getScreenHeight()));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHundler);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = (double) 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                //1 UPDATE: atualiza a informação da posição do perssonagem
                update();
                //2 DRAW: desenha na tela informação atualizada
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileManager.draw(g2, screen);
        player.draw(g2, screen);

        g2.dispose();
    }
}
