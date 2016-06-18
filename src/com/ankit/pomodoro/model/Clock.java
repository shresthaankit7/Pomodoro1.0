package com.ankit.pomodoro.model;

/**
 * Created by ankit07 on 6/18/16.
 */
public class Clock {
//    final static int countDown = 1500000;

    final static int countDown = 15000;

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

    public Integer getTime() {
        return (int)(System.currentTimeMillis()-startTime);
    }
}
