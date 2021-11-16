package controllers;

import frames.MyFrame;
import model.MyTimer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//public class myFrame extends JFrame implements ActionListener{
//
//    JMenuItem stopwatchItem;
//    JMenuItem timerItem;
//    JLabel label = new JLabel();
//    JPanel panel = new JPanel();
//    Border border = BorderFactory.createLineBorder(Color.CYAN, 3);
//
//    public myFrame(){
//
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setSize(420, 420);
//        this.setLayout(new BorderLayout());
//
//        panel.setBackground(Color.BLACK);
////        panel.setPreferredSize(new Dimension(50,50));
//
//        JMenuBar menuBar = new JMenuBar();
//        JMenu menu = new JMenu("Mode");
//
//        stopwatchItem = new JMenuItem("Stopwatch");
//        stopwatchItem.addActionListener(this);
//        timerItem = new JMenuItem("Timer");
//        timerItem.addActionListener(this);
//
//        menu.add(stopwatchItem);
//        menu.add(timerItem);
//
//        menuBar.add(menu);
//
//        this.add(panel);
//        this.setJMenuBar(menuBar);
//        this.setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource()==stopwatchItem){
//            label.setText("Stop");
//            label.setVerticalAlignment(JLabel.CENTER);
//            label.setHorizontalAlignment(JLabel.CENTER);
//            label.setPreferredSize(new Dimension(420, 40));
//            label.setBorder(border);
//            panel.add(label);
//            panel.revalidate();
//            panel.setBackground(Color.BLUE);
//            System.out.println("stop");
//        }
//        if(e.getSource()==timerItem){
//            label.setText("Timer");
//            label.setVerticalAlignment(JLabel.CENTER);
//            label.setHorizontalAlignment(JLabel.CENTER);
//            label.setPreferredSize(new Dimension(420, 40));
//            label.setBorder(border);
//            panel.add(label);
//            panel.revalidate();
//            panel.setBackground(Color.RED);
//            System.out.println("timer");
//        }
//    }
//}

//public class myFrame extends JFrame {
//
//}
public class Stopwatch implements ActionListener{
    MyFrame frame;
//    int elapsedTime = 0;
//    int seconds = 0;
//    int minutes = 0;
//    int hours = 0;
//    boolean started = false;
//    String secondsStr = String.format("%02d", seconds);
//    String minutesStr = String.format("%02d", minutes);
//    String hoursStr = String.format("%02d", hours);
    MyTimer timer;
//    Timer timer = new Timer(1000, new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if (elapsedTime > 0) {
//                elapsedTime -= 1000;
//                hours = (elapsedTime / 3600000);
//                minutes = (elapsedTime / 60000) % 60;
//                seconds = (elapsedTime / 1000) % 60;
//                secondsStr = String.format("%02d", seconds);
//                minutesStr = String.format("%02d", minutes);
//                hoursStr = String.format("%02d", hours);
//                frame.getLabel().setText(hoursStr + ":" + minutesStr + ":" + secondsStr);
//            }
//            else {
//                timer.stop();
//                started=false;
//                frame.getStartButton().setText("Start");
//                JOptionPane.showMessageDialog(null, "Your time has come", "DONE", JOptionPane.INFORMATION_MESSAGE);
//            }
//        }
//    });

    public Stopwatch(MyFrame frameValue, MyTimer timerValue){
        frame = frameValue;
        timer = timerValue;
        frame.getStartButton().addActionListener(this);
        frame.getResetButton().addActionListener(this);
        frame.getSetButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==frame.getStartButton()){
            if (!timer.isStarted()){
                if (timer.getElapsedTime() != 0)
                {
                    start();
                    timer.setStarted(true);
                    frame.getStartButton().setText("Stop");
                }
            }
            else{
                stop();
                timer.setStarted(false);
                frame.getStartButton().setText("Start");
            }
        }

        if (e.getSource()==frame.getResetButton()){
            timer.setStarted(false);
            frame.getSetButton().setText("Start");
            reset();
        }

        if(e.getSource()==frame.getSetButton()){
            String[] text = frame.getTextField().getText().split(":");
            int hoursInput;
            int minutesInput;
            int secondsInput;
            try{
                hoursInput = Integer.parseInt(text[0]);
                minutesInput = Integer.parseInt(text[1]);
                secondsInput = Integer.parseInt(text[2]);
                if (hoursInput >=0 && hoursInput < 24 && minutesInput >=0 && minutesInput < 60 && secondsInput >=0 && secondsInput < 60){
                    System.out.println("All Okay");
                    timer.setElapsedTime(hoursInput * 3600000 + minutesInput * 60000 + secondsInput * 1000);
                    timer.setHours(hoursInput);
                    timer.setMinutes(minutesInput);
                    timer.setSeconds(secondsInput);
                    timer.setSecondsStr(String.format("%02d", timer.getSeconds()));
                    timer.setMinutesStr(String.format("%02d", timer.getMinutes()));
                    timer.setHoursStr(String.format("%02d", timer.getHours()));
                    frame.getLabel().setText(timer.getHoursStr() + ":" + timer.getMinutesStr() + ":" + timer.getSecondsStr());
                }
                else{
                    throw new Exception();
                }
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Unacceptable time values", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    void start(){
        timer.start();
    }

    void stop(){
        timer.stop();
    }

    void reset(){
        timer.stop();
        timer.setElapsedTime(0);
        timer.setHours(0);
        timer.setMinutes(0);
        timer.setSeconds(0);
        timer.setSecondsStr(String.format("%02d", timer.getSeconds()));
        timer.setMinutesStr(String.format("%02d", timer.getMinutes()));
        timer.setHoursStr(String.format("%02d", timer.getHours()));
        frame.getLabel().setText(timer.getHoursStr() + ":" + timer.getMinutesStr() + ":" + timer.getSecondsStr());
    }
}