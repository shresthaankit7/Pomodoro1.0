package com.ankit.pomodoro.View;

import com.ankit.pomodoro.controller.GUIController;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.io.InputStream;

/**
 * Created by ankit07 on 6/18/16.
 */
public class GUI extends JFrame {
    JButton play = new JButton();
    JButton restart = new JButton();

    JButton stop = new JButton();

    JLabel counter = new JLabel("00:00");

    public GUI(){
        super("Pomodoro");

        setSize(300,150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel buttonPanel = new JPanel();
        JPanel indicator = new JPanel();

        buttonPanel.add(play);
        buttonPanel.add(restart);
        buttonPanel.add(stop);

        setIcons(play,"play.png");
        setIcons(restart,"restart.png");
        setIcons(stop,"stop.png");

        counter.setOpaque(true);
        counter.setBackground(Color.GRAY);
        counter.setForeground(Color.WHITE);

        indicator.add(counter);

        add(buttonPanel, BorderLayout.NORTH);
        add(indicator,BorderLayout.CENTER);
        setVisible(true);

    }

    private void setIcons(JButton button,String fileName) {
        try{
            InputStream stream = this.getClass().getClassLoader().getResourceAsStream(fileName);
            button.setIcon(new ImageIcon(ImageIO.read(stream)));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setActionListener(GUIController listener) {
        play.addActionListener(listener);
        restart.addActionListener(listener);
        stop.addActionListener(listener);

        play.setActionCommand("play");
        restart.setActionCommand("restart");
        stop.setActionCommand("stop");
    }


    public JButton getPlay() {
        return play;
    }

    public JButton getRestart(){ return restart; }

    public JLabel getLabel() {
        return counter;
    }

    public void disablePlay() {
        play.setEnabled(false);
    }

    public void enablePlay(){
        play.setEnabled(true);
    }

    public void clearCounter() {
        getLabel().setText("00:00");
    }
}
