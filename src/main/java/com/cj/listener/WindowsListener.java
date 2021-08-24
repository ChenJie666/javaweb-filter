package com.cj.listener;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author CJ
 * @date 2021/7/14 11:44
 */
public class WindowsListener {
    public static void main(String[] args) {
        Frame frame = new Frame("窗口测试");
        Panel panel = new Panel(null);
        frame.setLayout(null);

        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(0,0,255));

        panel.setBounds(60,60,300,300);
        panel.setBackground(new Color(0,255,0));

        frame.add(panel);
        frame.setVisible(true);

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("打开");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("关闭ing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("关闭ed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("窗口激活");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("窗口未激活");
            }
        });
    }
}
