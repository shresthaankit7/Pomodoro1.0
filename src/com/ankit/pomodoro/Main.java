package com.ankit.pomodoro;

import com.ankit.pomodoro.View.GUI;
import com.ankit.pomodoro.controller.GUIController;

import javax.swing.*;

/**
 * Created by ankit07 on 6/11/16.
 */
public class Main {

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI gui = new GUI();
                gui.setActionListener(new GUIController());
            }
        });
    }
}
