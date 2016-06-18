package com.ankit.pomodoro.controller;

import com.ankit.pomodoro.model.Clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ankit07 on 6/18/16.
 */
public class GUIController implements ActionListener {

    Timer timer = new Timer();

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand){
            case "play":
                System.out.println("PLAY");
                timer.execute();
                break;
            case "restart":
                System.out.println("RESTART");
                timer.cancel(true);
                break;
            default:
                System.out.println("ERROR");
        }
    }
}
