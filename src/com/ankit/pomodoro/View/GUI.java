package com.ankit.pomodoro.View;

import com.ankit.pomodoro.controller.GUIController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ankit07 on 6/18/16.
 */
public class GUI extends JFrame {
    JButton play = new JButton("PLAY");
    JButton restart = new JButton("RESTART");
    JLabel counter = new JLabel("COUNTER");

    public GUI(){
        super("Pomodoro");
        setSize(200,150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel();
        JPanel indicator = new JPanel();

        buttonPanel.add(play);
        buttonPanel.add(restart);

        counter.setOpaque(true);
        counter.setBackground(Color.GRAY);
        counter.setForeground(Color.WHITE);

        indicator.add(counter);

        add(buttonPanel, BorderLayout.NORTH);
        add(indicator,BorderLayout.SOUTH);
        setVisible(true);

    }

    public void setActionListener(GUIController listener) {
        play.addActionListener(listener);
        restart.addActionListener(listener);

        play.setActionCommand("play");
        restart.setActionCommand("restart");
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
}
