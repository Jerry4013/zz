package zz;

// *******************************************************************
// Swing12.java By: Aiman Hanna (C) 1993 - 2018
// This program introduces the Swing Text Areas.
// Notice carefully the behavior of the program when many lines are
// added to the text area. See Swing13.java for more information.
//
// Key Points:
// 1) Text Areas.
// *******************************************************************


import java.awt.event.*;
import java.awt.*;
import javax.swing.*;



class ExitListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        System.exit(0);
    }
}


// This class extends JFrame and also implements ActionListener
class JFrame7 extends JFrame implements ActionListener
{

    // Attributes
    public static final int WIDTH = 800;
    public static final int HIGHT = 600;

    public static final int ROWS = 1;
    public static final int COLUMNS = 3;


    private JPanel pan1;
    private JPanel pan2;
    private JPanel pan3;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel lab1;

    private JTextArea infoTA;


    // Default Constructor
    public JFrame7()
    {
        super();	// Calls the constructor of JFrame
        setSize(WIDTH, HIGHT);
        setTitle("Window Frame with Panels");


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sets the frame layout to a border layout

        setLayout(new BorderLayout());

        // Create one panel to place in the center part of the BorderLayout
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(ROWS, COLUMNS));

        // Now create add few (smaller) panels into that bigger one (centerPanel)
        pan1 = new JPanel();
        pan1.setBackground(Color.YELLOW);
        centerPanel.add(pan1);	// Add the entire panel to a larger panel (centerPanel)

        pan2 = new JPanel();
        pan2.setBackground(Color.RED);
        centerPanel.add(pan2);

        pan3 = new JPanel();
        pan3.setBackground(Color.GREEN);
        centerPanel.add(pan3);

        // Now add this bigger panel (with its three inside panels) into the
        // the center part of the layout
        add(centerPanel, BorderLayout.CENTER);


        // Create a button and add it to the south part of the layout
        button1 = new JButton("Click Here to Exit!");
        button1.addActionListener( new ExitListener());
        button1.setBackground(Color.PINK);

        add(button1, BorderLayout.SOUTH);


        // Now create the menu
        JMenu changeColorMenu = new JMenu("Change Colors");

        JMenuItem changeButtonColor = new JMenuItem("Change Exit Button Color");
        changeButtonColor.addActionListener(this);		// Calls the ActionListenerdefined by this class

        JMenuItem changeLeftColor = new JMenuItem("Change Left Side Color");
        changeLeftColor.addActionListener(this);


        JMenuItem changeCenterColor = new JMenuItem("Change Center Color");
        changeCenterColor.addActionListener(this);


        JMenuItem changeRightColor = new JMenuItem("Change Right Side Color");
        changeRightColor.addActionListener(this);

        JMenuItem restColors = new JMenuItem("Reset Colors to Default");
        restColors.addActionListener(this);


        // Now add these 5 menu items to the menu
        changeColorMenu.add(changeButtonColor);
        changeColorMenu.add(changeLeftColor);
        changeColorMenu.add(changeCenterColor);
        changeColorMenu.add(changeRightColor);
        changeColorMenu.add(restColors);


        // Finally, add the menu itself to a menu bar then add the menu bar to the frame
        JMenuBar bar1 = new JMenuBar();
        bar1.add(changeColorMenu);
        this.setJMenuBar(bar1);


        JMenu swapColorMenu = new JMenu("Swap Colors");
        changeColorMenu.add(swapColorMenu);

        JMenuItem swapLeftRightColor = new JMenuItem("Swap Left & Right Colors");
        swapLeftRightColor.addActionListener(this);

        JMenuItem swapLeftCenterColor = new JMenuItem("Swap Left & Center Colors");
        swapLeftCenterColor.addActionListener(this);

        JMenuItem swapRightCenterColor = new JMenuItem("Swap Right & Center Colors");
        swapRightCenterColor.addActionListener(this);


        // Add the above menu items to the swapColorMenu
        swapColorMenu.add(swapLeftRightColor);
        swapColorMenu.add(swapLeftCenterColor);
        swapColorMenu.add(swapRightCenterColor);



        // Create a text area of 5 rows and at least 30 visible characters
        // per line; this  text area will later be placed on the north
        // part of the layout
        infoTA = new JTextArea(5, 30);
        infoTA.setBackground(Color.WHITE);
        infoTA.setLineWrap(true);


        JPanel northPanel = new JPanel();
        button2 = new JButton("Check Number of Lines");
        button2.setBackground(Color.ORANGE);
        button2.addActionListener(this);

        button3 = new JButton("Clear Text Area");
        button3.setBackground(new Color(100, 120, 244));
        button3.addActionListener(this);

        JPanel labPanl = new JPanel();
        labPanl.setBackground(Color.GRAY);
        lab1 = new JLabel("");
        labPanl.add(lab1);

        northPanel.setLayout(new GridLayout(4, 1));

        northPanel.add(labPanl);
        northPanel.add(infoTA);
        northPanel.add(button2);
        northPanel.add(button3);

        add(northPanel, BorderLayout.NORTH);


    }



    // We need to define the actionPerformed method
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();

        if(s.equals("Change Exit Button Color"))
            if(button1.getBackground() == Color.PINK)
                button1.setBackground(Color.ORANGE);
            else if(button1.getBackground() == Color.ORANGE)
                button1.setBackground(Color.LIGHT_GRAY);
            else
                button1.setBackground(Color.PINK);


        if(s.equals("Change Left Side Color"))
            if(pan1.getBackground() == Color.YELLOW)
                pan1.setBackground(Color.BLACK);
            else if(pan1.getBackground() == Color.BLACK)
                pan1.setBackground(Color.CYAN);
            else
                pan1.setBackground(Color.YELLOW);

        if(s.equals("Change Center Color"))
            if(pan2.getBackground() == Color.RED)
                pan2.setBackground(Color.BLUE);
            else if(pan2.getBackground() == Color.BLUE)
                pan2.setBackground(Color.MAGENTA);
            else
                pan2.setBackground(Color.RED);

        if(s.equals("Change Right Side Color"))
            if(pan3.getBackground() == Color.GREEN)
                pan3.setBackground(Color.WHITE);
            else if(pan3.getBackground() == Color.WHITE)
                pan3.setBackground(Color.GRAY);
            else
                pan3.setBackground(Color.GREEN);

        if(s.equals("Reset Colors to Default"))
        {
            button1.setBackground(Color.PINK);
            pan1.setBackground(Color.YELLOW);
            pan2.setBackground(Color.RED);
            pan3.setBackground(Color.GREEN);
        }


        if(s.equals("Swap Left & Right Colors"))
        {
            Color cl = pan1.getBackground();
            pan1.setBackground(pan3.getBackground());
            pan3.setBackground(cl);
        }

        if(s.equals("Swap Left & Center Colors"))
        {
            Color cl = pan1.getBackground();
            pan1.setBackground(pan2.getBackground());
            pan2.setBackground(cl);
        }

        if(s.equals("Swap Right & Center Colors"))
        {
            Color cl = pan2.getBackground();
            pan2.setBackground(pan3.getBackground());
            pan3.setBackground(cl);
        }

        if (s.equals("Check Number of Lines"))
        {
            String t = "The Text Area Below has currently " + infoTA.getLineCount() + " Lines";
            lab1.setText(t);
        }

        if (s.equals("Clear Text Area"))
        {
            infoTA.setText(""); // Clear Text Area
            String t = "The Text Area Below has currently " + infoTA.getLineCount() + " Lines";
            lab1.setText(t);
        }

    }

}

public class Swing12
{

    public static void main(String[] args)
    {
        JFrame7 window1 = new JFrame7();

        window1.setVisible(true);
    }
}

/* The Output - You need to run the program to see its behavior

 */