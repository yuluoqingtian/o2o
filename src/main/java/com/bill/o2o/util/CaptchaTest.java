package com.bill.o2o.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;


public class CaptchaTest {
    public static void fun1() throws FileNotFoundException, IOException {
        BufferedImage bi = new BufferedImage(70, 35, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) bi.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 70, 35);
        g.setColor(Color.RED);
        g.drawString("Hello", 2, 35 - 2);
        ImageIO.write(bi, "JPEG", new FileOutputStream("D:/captcha/xxx.jpg"));
    }

    public static void fun2() throws FileNotFoundException, IOException {
        CaptchaUtil vc = new CaptchaUtil();
        BufferedImage bi = vc.getImage();
        CaptchaUtil.output(bi, new FileOutputStream("D:/captcha/xxx.jpg"));
        System.out.println(vc.getText());

    }

    public static void main(String[] args) throws FileNotFoundException ,IOException {
        fun2();

    }
}
