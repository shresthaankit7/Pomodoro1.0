package com.ankit.pomodoro.controller;

import com.ankit.pomodoro.View.GUI;
import com.ankit.pomodoro.model.Clock;
import com.sun.applet2.preloader.CancelException;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/**
 * Created by ankit07 on 6/18/16.
 */
public class Timer extends SwingWorker<String,Void> {

    Clock clock;
    GUI gui;

    public Timer(GUI gui){
        this.gui = gui;
        this.clock = new Clock();
    }

    @Override
    protected String doInBackground() throws Exception {
        clock.start();
        while(!isCancelled()){
            if(clock.alarmOff()){
                break;
            }else{
                publish();
            }
        }
        return "ALARM OFF";
    }

    @Override
    protected void done(){
        try {
            System.out.println(get());

            gui.enablePlay();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch(CancellationException e){
            System.out.println("Cancelled");
        }

    }

    @Override
    protected void process(List<Void> v){
//        System.out.println("NOW::::" + this.clock.getTime());
        this.gui.getLabel().setText( this.clock.getTime());
    }

}
