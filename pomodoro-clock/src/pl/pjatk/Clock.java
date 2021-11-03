package pl.pjatk;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clock implements ActionListener {

    JFrame frame;
    JLabel breakLabel;
    JSpinner breakSpinner;
    JLabel sessionLabel;
    JSpinner sessionSpinner;
    JLabel mainLabel;
    JLabel timeLabel;
    JButton playButton;
    JButton pauseButton;
    JButton resetButton;

    int sessionMinutes = 25;
    int sessionSeconds = 0;
    int breakMinutes = 5;
    int breakSeconds = 0;
    String sessionSeconds_string = String.format("%02d", sessionSeconds);
    String sessionMinutes_string = String.format("%02d", sessionMinutes);
    String breakSeconds_string = String.format("%02d", breakSeconds);
    String breakMinutes_string = String.format("%02d", breakMinutes);

    boolean isSession = true;

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                if(isSession==true) {
                    mainLabel.setText("Session");
                    if(sessionSeconds==0){
                        sessionSeconds = 60;
                        sessionMinutes--;
                    }
                    sessionSeconds--;
                    sessionSeconds_string = String.format("%02d", sessionSeconds);
                    sessionMinutes_string = String.format("%02d", sessionMinutes);
                    timeLabel.setText(sessionMinutes_string+":"+sessionSeconds_string);
                    if(sessionMinutes==0 && sessionSeconds==0) {
                        isSession=false;
                        sessionMinutes = (int)sessionSpinner.getValue();
                    }
                } else {
                    mainLabel.setText("Break");
                    if(breakSeconds==0){
                        breakSeconds = 60;
                        breakMinutes--;
                    }
                    breakSeconds--;
                    breakSeconds_string = String.format("%02d", breakSeconds);
                    breakMinutes_string = String.format("%02d", breakMinutes);
                    timeLabel.setText(breakMinutes_string+":"+breakSeconds_string);
                    if(breakMinutes==0 && breakSeconds==0) {
                        isSession=true;
                        breakMinutes = (int)breakSpinner.getValue();
                    }
                }


        }
    });


    Clock() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Pomodoro Clock");
        frame.setSize(420,420);
        frame.setLayout(null);

        breakLabel = new JLabel("Break Length");
        breakLabel.setBounds(0,0,200,45);
        breakLabel.setFont(new Font("Roboto",Font.PLAIN,25));
        breakLabel.setHorizontalAlignment(JLabel.CENTER);

        breakSpinner = new JSpinner();
        breakSpinner.setBounds(67,45,50,25);
        breakSpinner.setValue(5);
        breakSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                breakMinutes = (int)breakSpinner.getValue();
                breakMinutes_string = String.format("%02d", breakMinutes);
            }
        });

        sessionLabel = new JLabel("Session Length");
        sessionLabel.setBounds(200,0,200,45);
        sessionLabel.setFont(new Font("Roboto",Font.PLAIN,25));
        sessionLabel.setHorizontalAlignment(JLabel.CENTER);

        sessionSpinner = new JSpinner();
        sessionSpinner.setBounds(267,45,50,25);
        sessionSpinner.setValue(25);
        sessionSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sessionMinutes = (int)sessionSpinner.getValue();
                sessionMinutes_string = String.format("%02d", sessionMinutes);
                timeLabel.setText(sessionMinutes_string+":"+sessionSeconds_string);
            }
        });


        mainLabel = new JLabel("Session");
        mainLabel.setBounds(0,100,420,50);
        mainLabel.setFont(new Font("Roboto",Font.PLAIN,25));
        mainLabel.setHorizontalAlignment(JLabel.CENTER);


        timeLabel = new JLabel();
        timeLabel.setBounds(0,150,420,50);
        timeLabel.setFont(new Font("Roboto",Font.PLAIN,25));
        timeLabel.setText(sessionMinutes_string+":"+sessionSeconds_string);
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setOpaque(true);


        playButton = new JButton("PLAY");
        playButton.setBounds(50,280,100,45);
        playButton.setFont(new Font("Roboto",Font.PLAIN,20));
        playButton.addActionListener(this);

        pauseButton = new JButton("PAUSE");
        pauseButton.setBounds(150,280,100,45);
        pauseButton.setFont(new Font("Roboto",Font.PLAIN,20));
        pauseButton.addActionListener(this);

        resetButton = new JButton("RESET");
        resetButton.setBounds(250,280,100,45);
        resetButton.setFont(new Font("Roboto",Font.PLAIN,20));
        resetButton.addActionListener(this);

        frame.add(breakLabel);
        frame.add(breakSpinner);
        frame.add(sessionLabel);
        frame.add(sessionSpinner);
        frame.add(mainLabel);
        frame.add(timeLabel);
        frame.add(playButton);
        frame.add(pauseButton);
        frame.add(resetButton);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==playButton) {
            timer.start();
        }

        if(e.getSource()==pauseButton) {
            timer.stop();
        }

        if(e.getSource()==resetButton) {
            timer.stop();
            isSession=true;
            sessionMinutes = (int)sessionSpinner.getValue();
            breakMinutes = (int)breakSpinner.getValue();
            sessionSeconds = 0;
            breakSeconds = 0;
            sessionSeconds_string = String.format("%02d", sessionSeconds);
            sessionMinutes_string = String.format("%02d", sessionMinutes);
            breakSeconds_string = String.format("%02d", breakSeconds);
            breakMinutes_string = String.format("%02d", breakMinutes);
            timeLabel.setText(sessionMinutes_string+":"+sessionSeconds_string);
        }
    }

}
