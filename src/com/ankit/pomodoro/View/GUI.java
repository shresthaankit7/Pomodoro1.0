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
    JProgressBar progressBar = new JProgressBar();

    public GUI(){
        super("Pomodoro");
        setSize(200,150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel();
        JPanel progressBarPanel = new JPanel();

        buttonPanel.add(play);
        buttonPanel.add(restart);

        progressBarPanel.add(progressBar);

        add(buttonPanel, BorderLayout.NORTH);
        add(progressBarPanel,BorderLayout.SOUTH);
        setVisible(true);

    }

    public void setActionListener(GUIController listener) {
        play.addActionListener(listener);
        restart.addActionListener(listener);

        play.setActionCommand("play");
        restart.setActionCommand("restart");
    }
}
