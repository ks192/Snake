package com.ks192.www;

import javax.swing.*;
import java.awt.*;

public class Application {
    public static void main(String[] args) {
        new GameStart();
    }
}
class GameStart extends JFrame{
    public GameStart()  {
        this.setBounds(580 ,120,900,800);
        this.add(new GamePanel());

        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
}
