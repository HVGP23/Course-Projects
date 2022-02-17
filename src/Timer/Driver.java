package Timer;

import javax.swing.*;
import java.awt.*;

public class Driver {

    public static void main(String arg[]){

        // create a new JFrame labeled GEO Count Down Timer
        JFrame gui = new JFrame("GEO Count Down Timer");

        // close the window when pressing the x in the GUI
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create three MyTimerPanels
        MyTimerPanel panel  = new MyTimerPanel();
        MyTimerPanel panel2 = new MyTimerPanel();
        MyTimerPanel panel3 = new MyTimerPanel();

        // 1 row and 3 column grid layout
        gui.getContentPane().setLayout(new GridLayout(1, 3));

        // add the first panel to the first column
        gui.getContentPane().add(panel);

        // add the second panel to the second column
        gui.getContentPane().add(panel2);

        // add the third panel to the third column
        gui.getContentPane().add(panel3);

        // Set GUI to the size 600 x 800 pxl
        gui.setSize(600,800);

        // set the GUI menus
        // gui.setJMenuBar(menus);

        // pack all the content in the GUI together
        gui.pack();

        // Opens in the center of the screen
        gui.setLocationRelativeTo(null);

        // set the GUI to visible (starts as invisible)
        gui.setVisible(true);

        // We will not be able to resize the window
        gui.setResizable(false);
    }
}
