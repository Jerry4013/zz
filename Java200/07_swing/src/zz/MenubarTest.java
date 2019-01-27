package zz;

import javax.swing.*;

public class MenubarTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400,300);
        frame.setLocation(400, 200);


        JMenu file = new JMenu("file");

        JMenuItem blue = new JMenuItem("Blue");
        file.add(blue);

        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(file);
        frame.setJMenuBar(jMenuBar);
        frame.setVisible(true);
    }
}
