package pl.pjatk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Generator implements ActionListener {

    JFrame frame;
    JLabel title;
    JTextArea subtitle;
    JTextField minimumField;
    JTextField maximumField;
    JLabel minimumLabel;
    JLabel maximumLabel;
    JButton generateButton;
    JLabel scoreLabel;

    int max = 0,min = 0, random =0;

    Generator() {
        frame = new JFrame("Random Number Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);

        title = new JLabel("Random Number Generator");
        title.setBounds(0,0,420,45);
        title.setFont(new Font("Roboto",Font.PLAIN,25));
        title.setHorizontalAlignment(JLabel.CENTER);

        subtitle = new JTextArea();
        subtitle.setText("Set a range for minimum & maximun number value. \nThen click \"generate\" to receive a random number.");
        subtitle.setLineWrap(true);
        subtitle.setBounds(20,50,360,45);
        subtitle.setBackground(new Color(0xeeeeee));
        subtitle.setFont(new Font("Roboto",Font.PLAIN,15));


        minimumLabel = new JLabel("Minimum:");
        minimumLabel.setBounds(30,130,150,45);
        minimumLabel.setFont(new Font("Roboto",Font.PLAIN,25));


        minimumField = new JTextField();
        minimumField.setBounds(150,140,180,30);
        minimumField.setFont(new Font("Roboto",Font.PLAIN,25));

        maximumLabel = new JLabel("Maximum:");
        maximumLabel.setBounds(30,180,150,45);
        maximumLabel.setFont(new Font("Roboto",Font.PLAIN,25));

        maximumField = new JTextField();
        maximumField.setBounds(150,190,180,30);
        maximumField.setFont(new Font("Roboto",Font.PLAIN,25));

        generateButton = new JButton("Generator");
        generateButton.setBounds(135,250,150,45);
        generateButton.setFont(new Font("Roboto",Font.PLAIN,25));
        generateButton.addActionListener(this);

        scoreLabel = new JLabel();
        scoreLabel.setBounds(190,300,40,50);
        scoreLabel.setFont(new Font("Roboto",Font.PLAIN,25));


        frame.add(title);
        frame.add(subtitle);
        frame.add(minimumLabel);
        frame.add(minimumField);
        frame.add(maximumLabel);
        frame.add(maximumField);
        frame.add(generateButton);
        frame.add(scoreLabel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==generateButton){
            min = Integer.parseInt(minimumField.getText());
            max = Integer.parseInt(maximumField.getText());

            random = (int)(Math.random()*(max-min+1));
            random += min;

            scoreLabel.setText(random+"");
        }
    }
}