package com.ankit.pomodoro.controller;

import com.ankit.pomodoro.model.Clock;

import javax.swing.*;
import java.util.concurrent.ExecutionException;

/**
 * Created by ankit07 on 6/18/16.
 */
public class Timer extends SwingWorker<String,Void> {

    Clock clock = new Clock();

    @Override
    protected String doInBackground() throws Exception {
        clock.start();
        while(!isCancelled()){
            if(clock.alarmOff()){
                break;
            }else{
                System.out.println("RUNNING");
            }
        }
        return "ALARM OFF";
    }
    
    @Override
    protected void done(){
        try {
            System.out.println(get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public void restart() {
        this.clock.restart();
        System.out.println("RESTARTED****************************");
    }
}
