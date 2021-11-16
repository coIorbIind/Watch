package model;

import frames.MyFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyTimer implements ActionListener {

    MyFrame frame;
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;
    String secondsStr = String.format("%02d", seconds);
    String minutesStr = String.format("%02d", minutes);
    String hoursStr = String.format("%02d", hours);
    Timer timer = new Timer(1000, this);

    public MyTimer(MyFrame frame){
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (elapsedTime > 0) {
            elapsedTime -= 1000;
            hours = (elapsedTime / 3600000);
            minutes = (elapsedTime / 60000) % 60;
            seconds = (elapsedTime / 1000) % 60;
            secondsStr = String.format("%02d", seconds);
            minutesStr = String.format("%02d", minutes);
            hoursStr = String.format("%02d", hours);
            frame.getLabel().setText(hoursStr + ":" + minutesStr + ":" + secondsStr);
        }
        else {
            timer.stop();
            started=false;
            frame.getStartButton().setText("Start");
            JOptionPane.showMessageDialog(null, "Your time has come", "DONE", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void start(){
        timer.start();
    }

    public void stop(){
        timer.stop();
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public String getSecondsStr() {
        return secondsStr;
    }

    public void setSecondsStr(String secondsStr) {
        this.secondsStr = secondsStr;
    }

    public String getMinutesStr() {
        return minutesStr;
    }

    public void setMinutesStr(String minutesStr) {
        this.minutesStr = minutesStr;
    }

    public String getHoursStr() {
        return hoursStr;
    }

    public void setHoursStr(String hoursStr) {
        this.hoursStr = hoursStr;
    }

    public void reset() {
        timer.stop();
        elapsedTime = 0;
        hours = 0;
        minutes = 0;
        seconds = 0;
        secondsStr = String.format("%02d", seconds);
        minutesStr = String.format("%02d", minutes);
        hoursStr = String.format("%02d", hours);
    }
}
