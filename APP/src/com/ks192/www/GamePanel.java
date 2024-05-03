package com.ks192.www;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener , ActionListener {
    private int length;
    private final int[] snakeX = new int[40];
    private final int[] snakeY = new int[40];
    private String ori;
    private boolean isStart, isFail = false;
    private int foodX;
    private int foodY;
    private final Random random = new Random();
    private int score;


    public GamePanel() {
        init();
        this.setFocusable(true);
        this.addKeyListener(this);
        Timer timer = new Timer(100, this::actionPerformed);
        timer.start();
    }

    private void init() {
        length = 3;
        snakeX[0] = 100;snakeY[0] = 125;
        snakeX[1] = 75;snakeY[1] = 125;
        snakeX[2] = 50;snakeY[2] = 125;
        foodX = 25 + 25 * random.nextInt(34);
        foodY = 100 + 25 * random.nextInt(26);
        ori = "r";
        score = 0;
        isStart = false;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//清屏
        this.setBackground(Color.WHITE);
        Data data = new Data();
        data.head.paintIcon(this, g, 25, 0);
        g.fillRect(25, 100, 850, 650);

        data.food.paintIcon(this, g, foodX, foodY);

        //绘制贪吃蛇的头
        switch (ori) {
            case "u":data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case "d":data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case "l":data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case "r": data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
        }
        //绘制贪吃蛇身体
        for (int i = 1; i < length; i++) {
            data.body.paintIcon(this, g, snakeX[i], snakeY[i]);
        }
        //绘制分数面板
        g.setColor(Color.BLACK);
        g.setFont(new Font("楷体",Font.CENTER_BASELINE,20));
        g.drawString("得分："+score,750,95);
        g.drawString("分数："+score*10,660,95);
        //判断是否开始
        if (!isStart) {
            g.setColor(Color.white);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("疯狂贪吃蛇，点击空格开始！", 260, 380);
        }

        if (isFail) {
            g.setColor(Color.red);
            g.setFont(new Font("楷体", Font.BOLD, 40));
            g.drawString("游戏失败，点击空格重新开始", 260, 380);

        }



    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:ori = "u";
                break;
            case KeyEvent.VK_DOWN:ori = "d";
                break;
            case KeyEvent.VK_LEFT: ori = "l";
                break;
            case KeyEvent.VK_RIGHT: ori = "r";
                break;
            case KeyEvent.VK_SPACE:
                if (isFail) {
                    isFail = false;
                    init();
                } else {
                    isStart = !isStart;
                }
                repaint();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isStart  && !isFail) {
            if (snakeX[0] == foodX && snakeY[0] == foodY) {
                length++;
                score++;
                foodX = 25 + 25 * random.nextInt(34);
                foodY = 100 + 25 * random.nextInt(26);
            }
            //身体移动
            for (int i = length - 1; i > 0; i--) {
                snakeX[i] = snakeX[i - 1];
                snakeY[i] = snakeY[i - 1];
            }

            switch (ori) {
                case "u": snakeY[0] = snakeY[0] - 25;if (snakeY[0] < 100) { snakeY[0] = 725; }
                    break;
                case "d":snakeY[0] = snakeY[0] + 25;if (snakeY[0] > 725) {snakeY[0] = 100;}
                    break;
                case "l": snakeX[0] = snakeX[0] - 25;if (snakeX[0] < 25) {snakeX[0] = 850;}
                    break;
                case "r": snakeX[0] = snakeX[0] + 25;if (snakeX[0] > 850) { snakeX[0] = 25;}
                    break;
            }

            for (int i = 1; i < length; i++) {
                if (snakeX[i] == snakeX[0] && snakeY[i] == snakeY[0]) {
                    isFail = true;
                }
                repaint();
            }
        }
    }
}