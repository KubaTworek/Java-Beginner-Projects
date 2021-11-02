package pl.pjatk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Converter implements ActionListener {

    JFrame frame;
    JLabel title;
    JLabel subtitle;
    JTextField binaryField;
    JTextField decimalField;
    JLabel binaryLabel;
    JLabel decimalLabel;
    JButton convertButton;

    Converter() {
        frame = new JFrame("Bin2Dec Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);

        title = new JLabel("Bin2Dec");
        title.setBounds(0,0,420,45);
        title.setFont(new Font("Roboto",Font.PLAIN,35));
        title.setHorizontalAlignment(JLabel.CENTER);

        subtitle = new JLabel("Binary to Decimal Converter");
        subtitle.setBounds(0,50,420,45);
        subtitle.setFont(new Font("Roboto",Font.PLAIN,25));
        subtitle.setHorizontalAlignment(JLabel.CENTER);

        binaryLabel = new JLabel("Binary:");
        binaryLabel.setBounds(30,130,150,45);
        binaryLabel.setFont(new Font("Roboto",Font.PLAIN,25));

        binaryField = new JTextField();
        binaryField.setBounds(120,140,200,30);
        binaryField.setFont(new Font("Roboto",Font.PLAIN,25));

        decimalLabel = new JLabel("Decimal:");
        decimalLabel.setBounds(30,170,150,45);
        decimalLabel.setFont(new Font("Roboto",Font.PLAIN,25));

        decimalField = new JTextField();
        decimalField.setBounds(140,180,180,30);
        decimalField.setFont(new Font("Roboto",Font.PLAIN,25));
        decimalField.setEnabled(false);

        convertButton = new JButton("Convert");
        convertButton.setBounds(135,280,150,45);
        convertButton.setFont(new Font("Roboto",Font.PLAIN,25));
        convertButton.addActionListener(this);

        frame.add(title);
        frame.add(subtitle);
        frame.add(binaryLabel);
        frame.add(binaryField);
        frame.add(decimalLabel);
        frame.add(decimalField);
        frame.add(convertButton);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==convertButton){
            try{
                String binary = binaryField.getText();
                int decimal = Integer.parseInt(binary,2);
                decimalField.setText(""+decimal);
            }
            catch (NumberFormatException a) {
                decimalField.setText("Niepoprawny format");
                decimalField.setFont(new Font("Roboto",Font.PLAIN,15));
            }

        }
    }
}
