package com.ankit.pomodoro;

import com.ankit.pomodoro.View.GUI;
import com.ankit.pomodoro.controller.GUIController;
import com.ankit.pomodoro.model.Clock;

import javax.swing.*;

/**
 * Created by ankit07 on 6/11/16.
 */
public class Main {

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUIController guiController = new GUIController();
                 guiController.control();
            }
        });
    }
}
