package com.ankit.pomodoro.model;

import com.sun.javafx.binding.StringFormatter;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by ankit07 on 6/18/16.
 */
public class Clock {
    final static int countDown = 1500000;

    long startTime;
    long endTime;

    public void start(){
        startTime = System.currentTimeMillis();
        endTime = startTime + countDown;
    }

    public boolean alarmOff(){
        if(System.currentTimeMillis() == endTime ){
            return true;
        }else {
            return false;
        }
    }

    public void restart() {
        startTime = System.currentTimeMillis();
        endTime = startTime + countDown;
    }

    public String getTime() {
        Long currentTime = System.currentTimeMillis();
        Long difference = currentTime - startTime;

        String min = Long.toString(difference /(1000*60));
        String sec = Long.toString( (difference/1000)>=60 ? (difference/1000)%60: (difference/1000));
        return (min.length()==1 ? "0"+min : min) + " : " + (sec.length() == 1 ? "0"+sec : (sec.equalsIgnoreCase("60")? "00":sec) );
    }
}
