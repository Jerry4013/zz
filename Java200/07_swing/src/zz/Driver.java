package zz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Driver {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(400,300);
        frame.setLocation(400, 200);

        frame.setLayout(null);

        JMenu file = new JMenu("file");
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(file);
        frame.setJMenuBar(jMenuBar);

        JPanel jPanel = new JPanel();
        jPanel.setSize(100,100);
        jPanel.setBackground(Color.lightGray);
        jPanel.setLocation(200,10);
        frame.add(jPanel);

        JLabel label1 = new JLabel();
        label1.setText("myLabel");
        label1.setSize(100, 10);
        jPanel.add(label1);

        JLabel label = new JLabel();
        label.setText("Hello");
        label.setSize(100,40);
        label.setLocation(10, 10);
        frame.add(label);

        JButton button = new JButton();
        button.setText("Tap");
        button.setSize(100, 40);
        button.setLocation(10, 60);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("tapped");
            }
        });
//        button.addActionListener(e -> label.setText("tapped"));
        frame.add(button);

        JTextField textField = new JTextField();
        textField.setSize(100,40);
        textField.setLocation(10, 110);
        frame.add(textField);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
}
