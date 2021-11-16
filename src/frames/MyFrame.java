package frames;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private JButton startButton = new JButton("Start");
    private JButton resetButton = new JButton("Reset");
    private JLabel label = new JLabel();
    private JPanel panel = new JPanel();
    private JTextField textField = new JTextField();
    private JButton setButton = new JButton();

    public JButton getResetButton() {
        return resetButton;
    }

    public void setResetButton(JButton resetButton) {
        this.resetButton = resetButton;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public JButton getSetButton() {
        return setButton;
    }

    public void setSetButton(JButton setButton) {
        this.setButton = setButton;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }
    public MyFrame(int hours, int minutes, int seconds) {
        String secondsStr = String.format("%02d", seconds);
        String minutesStr = String.format("%02d", minutes);
        String hoursStr = String.format("%02d", hours);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);
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

        startButton.setBounds(0, 200, 243, 170);
        startButton.setForeground(Color.BLUE);
        startButton.setFont(new Font("MV Boli", Font.BOLD, 25));
        startButton.setFocusable(false);


        resetButton.setBounds(243, 200, 243, 170);
        resetButton.setForeground(Color.BLUE);
        resetButton.setFont(new Font("MV Boli", Font.BOLD, 25));
        resetButton.setFocusable(false);



        textField.setBounds(10, 10, 300, 75);
        textField.setFont(new Font("MV Boli", Font.BOLD, 25));
        textField.setText("hours:minutes:seconds");
        textField.setBackground(Color.WHITE);

        setButton.setForeground(Color.BLUE);
        setButton.setFont(new Font("MV Boli", Font.BOLD, 20));
        setButton.setText("Set Timer");
        setButton.setBounds(320, 10, 150, 75);
        setButton.setFocusable(false);
//        frame.getStartButton().addActionListener(this);

        panel.add(setButton);
        panel.add(textField);
        panel.setBackground(Color.BLACK);
        panel.setBounds(0, 370, 486, 100);

        this.add(panel);
        this.add(label);
        this.add(startButton);
        this.add(resetButton);
        this.setVisible(true);
    }
}
