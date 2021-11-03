package pl.pjatk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Converter implements ActionListener {


    JFrame frame;
    JLabel title;
    JLabel subtitle;
    JTextField inputField;
    JButton convertButton;
    JLabel totalCentsLabel;
    JLabel headers;
    JLabel quarters;
    JLabel dimes;
    JLabel nickels;
    JLabel pennies;

    boolean isConverted;

    Converter() {
        isConverted = false;

        frame = new JFrame("Converter App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 260);
        frame.setLayout(null);

        title = new JLabel("Converter App");
        title.setBounds(0, 0, 420, 45);
        title.setFont(new Font("Roboto", Font.PLAIN, 35));
        title.setHorizontalAlignment(JLabel.CENTER);

        subtitle = new JLabel("Enter the numbers of dollar");
        subtitle.setBounds(0, 50, 420, 45);
        subtitle.setFont(new Font("Roboto", Font.PLAIN, 25));
        subtitle.setHorizontalAlignment(JLabel.CENTER);

        inputField = new JTextField();
        inputField.setBounds(110, 100, 200, 30);
        inputField.setFont(new Font("Roboto", Font.PLAIN, 25));

        convertButton = new JButton("Convert");
        convertButton.setBounds(135, 140, 150, 45);
        convertButton.setFont(new Font("Roboto", Font.PLAIN, 25));
        convertButton.addActionListener(this);

        frame.add(title);
        frame.add(subtitle);
        frame.add(inputField);
        frame.add(convertButton);
        frame.setVisible(true);

        totalCentsLabel = new JLabel();
        headers = new JLabel();
        quarters = new JLabel();
        dimes = new JLabel();
        nickels = new JLabel();
        pennies = new JLabel();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        double cents;
        int quartesValue;
        int dimesValue;
        int nickelsValue;
        int penniesValue;

        if(e.getSource()==convertButton && isConverted==true) {

            cents = Double.parseDouble(inputField.getText()) * 100;
            quartesValue = (int) cents / 25;
            dimesValue = (int) ((cents - quartesValue * 25) / 10);
            nickelsValue = (int) ((cents - quartesValue * 25 - dimesValue * 10) / 5);
            penniesValue = (int) ((cents - quartesValue * 25 - dimesValue * 10 - nickelsValue * 5));

            totalCentsLabel.setText("Total cents: " + (int) cents);
            quarters.setText("Quarters (25 ¢)   " + quartesValue);
            dimes.setText("Dimes (10 ¢)  " + dimesValue);
            nickels.setText("Nickels (5 ¢)   " + nickelsValue);
            pennies.setText("Pennies (1 ¢)   " + penniesValue);
        }
        if(e.getSource()==convertButton && isConverted==false) {
            cents = Double.parseDouble(inputField.getText())*100;
            quartesValue = (int)cents/25;
            dimesValue = (int)((cents-quartesValue*25)/10);
            nickelsValue = (int)((cents-quartesValue*25-dimesValue*10)/5);
            penniesValue = (int)((cents-quartesValue*25-dimesValue*10-nickelsValue*5));

            frame.setSize(420, 520);
            totalCentsLabel.setBounds(0,240,420,45);
            totalCentsLabel.setFont(new Font("Roboto",Font.PLAIN,25));
            totalCentsLabel.setText("Total cents: "+ (int)cents);
            totalCentsLabel.setHorizontalAlignment(JLabel.CENTER);
            frame.add(totalCentsLabel);

            headers.setBounds(0,285,420,30);
            headers.setFont(new Font("Roboto",Font.PLAIN,15));
            headers.setText("Coins      Count");
            headers.setHorizontalAlignment(JLabel.CENTER);
            frame.add(headers);

            quarters.setBounds(0,315,420,30);
            quarters.setFont(new Font("Roboto",Font.PLAIN,15));
            quarters.setText("Quarters (25 ¢)   "+ quartesValue);
            quarters.setHorizontalAlignment(JLabel.CENTER);
            frame.add(quarters);

            dimes.setBounds(0,345,420,30);
            dimes.setFont(new Font("Roboto",Font.PLAIN,15));
            dimes.setText("Dimes (10 ¢)  "+ dimesValue);
            dimes.setHorizontalAlignment(JLabel.CENTER);
            frame.add(dimes);

            nickels.setBounds(0,375,420,30);
            nickels.setFont(new Font("Roboto",Font.PLAIN,15));
            nickels.setText("Nickels (5 ¢)   "+ nickelsValue);
            nickels.setHorizontalAlignment(JLabel.CENTER);
            frame.add(nickels);

            pennies.setBounds(0,405,420,30);
            pennies.setFont(new Font("Roboto",Font.PLAIN,15));
            pennies.setText("Pennies (1 ¢)   "+ penniesValue);
            pennies.setHorizontalAlignment(JLabel.CENTER);
            frame.add(pennies);

            isConverted = true;
        }
    }
}