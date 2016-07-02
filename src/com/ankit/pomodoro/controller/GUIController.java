package com.ankit.pomodoro.controller;

import com.ankit.pomodoro.View.GUI;
import com.ankit.pomodoro.model.Clock;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by ankit07 on 6/18/16.
 */
public class GUIController implements ActionListener {

    GUI gui;
    Timer timer;

    public GUIController(){
        gui = new GUI();
//        timer = new Timer(gui);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand){
            case "play":
//                System.out.println("PLAY");
                timer = new Timer(gui);
                timer.execute();
                gui.disablePlay();
                break;
            case "restart":
//                System.out.println("RESTART");
                    try{
                        timer.cancel(true);
                    }catch (Exception exception){
                        exception.printStackTrace();
                        break;
                    }
                    timer = new Timer(this.gui);
                    timer.execute();
                    gui.disablePlay();

                break;
            default:
                System.out.println("ERROR");
        }
    }

    public void control() {
        gui.setActionListener(this);
    }
}
