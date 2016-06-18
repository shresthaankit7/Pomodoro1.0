package com.ankit.pomodoro.controller;

import com.ankit.pomodoro.View.GUI;
import com.ankit.pomodoro.model.Clock;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by ankit07 on 6/18/16.
 */
public class Timer extends SwingWorker<String,Integer> {

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
                publish(clock.getTime());
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
    @Override
    protected void process(List<Integer> currentTimeList){
        Integer i = currentTimeList.size()-1;
        System.out.println("CURRENT TIME:::" + i);
        this.gui.getLabel().setText(i.toString());
    }

    public void restart() {
        this.clock.restart();
        System.out.println("RESTARTED****************************");
    }
}
