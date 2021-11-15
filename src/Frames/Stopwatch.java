package Frames;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
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

    JFrame frame = new JFrame();
    JButton startButton = new JButton("Start");
    JButton resetButton = new JButton("Reset");
    JLabel label = new JLabel();
    JPanel panel = new JPanel();
    JTextField textField = new JTextField();
    JButton setButton = new JButton();
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;
    String secondsStr = String.format("%02d", seconds);
    String minutesStr = String.format("%02d", minutes);
    String hoursStr = String.format("%02d", hours);

    Timer timer = new Timer(1000, new ActionListener() {
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
                label.setText(hoursStr + ":" + minutesStr + ":" + secondsStr);
            }
            else {
                timer.stop();
                started=false;
                startButton.setText("Start");
                JOptionPane.showMessageDialog(null, "Your time has come", "DONE", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    });

    public Stopwatch(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        panel.setLayout(null);
//        frame.setResizable(false);

        label.setText(hoursStr + ":" + minutesStr + ":" + secondsStr);
        label.setSize(new Dimension(486, 200));
        label.setFont(new Font("MV Boli", Font.PLAIN, 35));
        label.setForeground(Color.CYAN);
        label.setBackground(Color.BLACK);
        label.setBorder(BorderFactory.createLineBorder(Color.CYAN, 3));
        label.setOpaque(true);
        label.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(0,200, 243, 170);
        startButton.setForeground(Color.BLUE);
        startButton.setFont(new Font("MV Boli", Font.BOLD, 25));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        resetButton.setBounds(243,200, 243, 170);
        resetButton.setForeground(Color.BLUE);
        resetButton.setFont(new Font("MV Boli", Font.BOLD, 25));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);


        textField.setBounds(10,10,300,75);
        textField.setFont(new Font("MV Boli", Font.BOLD, 25));
        textField.setText("hours:minutes:seconds");
        textField.setBackground(Color.WHITE);

        setButton.setForeground(Color.BLUE);
        setButton.setFont(new Font("MV Boli", Font.BOLD, 20));
        setButton.setText("Set Timer");
        setButton.setBounds(320,10, 150, 75);
        setButton.setFocusable(false);
        setButton.addActionListener(this);

        panel.add(setButton);
        panel.add(textField);
        panel.setBackground(Color.BLACK);
        panel.setBounds(0, 370, 486, 100);

        frame.add(panel);
        frame.add(label);
        frame.add(startButton);
        frame.add(resetButton);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==startButton){
            if (!started){
                if (elapsedTime != 0)
                {
                    start();
                    started=true;
                    startButton.setText("Stop");
                }
            }
            else{
                stop();
                started=false;
                startButton.setText("Start");
            }
        }
        if (e.getSource()==resetButton){
            started=false;
            startButton.setText("Start");
            reset();
        }

        if(e.getSource()==setButton){
            String[] text = textField.getText().split(":");
            int hoursInput;
            int minutesInput;
            int secondsInput;
            try{
                hoursInput = Integer.parseInt(text[0]);
                minutesInput = Integer.parseInt(text[1]);
                secondsInput = Integer.parseInt(text[2]);
                if (hoursInput >=0 && hoursInput < 24 && minutesInput >=0 && minutesInput < 60 && secondsInput >=0 && secondsInput < 60){
                    System.out.println("All Okay");
                    elapsedTime = hoursInput * 3600000 + minutesInput * 60000 + secondsInput * 1000;
                    hours = hoursInput;
                    minutes = minutesInput;
                    seconds = secondsInput;
                    secondsStr = String.format("%02d", seconds);
                    minutesStr = String.format("%02d", minutes);
                    hoursStr = String.format("%02d", hours);
                    label.setText(hoursStr + ":" + minutesStr + ":" + secondsStr);
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
        elapsedTime = 0;
        hours = 0;
        minutes = 0;
        seconds = 0;
        secondsStr = String.format("%02d", seconds);
        minutesStr = String.format("%02d", minutes);
        hoursStr = String.format("%02d", hours);
        label.setText(hoursStr + ":" + minutesStr + ":" + secondsStr);
    }
}