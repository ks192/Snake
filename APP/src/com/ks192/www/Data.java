package com.ks192.www;

import javax.swing.*;
import java.net.URL;

public class Data {
    //头
    private URL headurl = Data.class.getResource("../statics/head.png");
    public ImageIcon head = new ImageIcon(headurl);
    //蛇头
    private URL upurl = Data.class.getResource("../statics/up.png");
    public ImageIcon up = new ImageIcon(upurl);
    private URL downurl = Data.class.getResource("../statics/down.png");
    public ImageIcon down = new ImageIcon(downurl);
    private URL lefturl = Data.class.getResource("../statics/left.png");
    public ImageIcon left = new ImageIcon(lefturl);
    private URL righturl = Data.class.getResource("../statics/right.png");
    public ImageIcon right = new ImageIcon(righturl);
    //蛇身
    private URL bodyurl = Data.class.getResource("../statics/body.png");
    public ImageIcon body = new ImageIcon(bodyurl);

    //食物
    private URL foodurl = Data.class.getResource("../statics/food.png");
    public ImageIcon food = new ImageIcon(foodurl);

}
