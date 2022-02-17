package Timer;

/* *********************************************************************
 * The MyTimer class provides various methods to create a GUI interface
 * for the GeoCountDownTimer class
 *
 * @author Hector Garcia
 * @version February 1, 2022
 *
 ********************************************************************* */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyTimerPanel extends JPanel {

    /** GeoCountDownTimer object  */
    private GeoCountDownTimer watch;

    /** Timer object */
    private Timer javaTimer;

    /** TimerListener object */
    private TimerListener timer;

    /** JFrame object  */
    private JFrame parentFrame = new JFrame();

    /** JButton objects  */
    private JButton startButton, stopButton, suspendButton, loadButton,
            saveButton, daysToGoButton, daysInFuture, incrementButton,
            decrementButton, resetButton;

    /** JTextField objects  */
    private JTextField yearsField, monthsField, daysField,
            addField, newField, continueField;

    /** JButton objects  */
    private JButton addButton, continueButton, newButton;

    /** JLabel object  */
    private JLabel lblTime;

    // Menu Items
    private JMenu fileMenu;
    private JMenuItem quitItem;
    private JMenuBar menus;

    /*********************************************************************
     * Main Method
     ******************************************************************** */
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

        // pack all the content in the GUI together
        gui.pack();

        // Opens in the center of the screen
        gui.setLocationRelativeTo(null);

        // add menu to the panel
        gui.setJMenuBar(panel.menus);

        // set the GUI to visible (starts as invisible)
        gui.setVisible(true);

        // We will not be able to resize the window
        gui.setResizable(false);
    }

    /** *******************************************************************
     * MyTimerPanel Constructor
     ******************************************************************** */
    public MyTimerPanel() {

        // new GeoCountDownTimer object which is initialized with the date 2/1/2022
        watch = new GeoCountDownTimer(2,1,2022 );

        // timer is a TimerListener object
        timer = new TimerListener();

        // javaTimer is a Timer object
        javaTimer = new Timer(100, timer);

        // The layout is 11 rows by 2 columns
        setLayout(new GridLayout(11, 2));

        // background is set to light gray, we may change it
        setBackground(Color.lightGray);

        // add label to the right of the monthsField text area
        add(new JLabel("Months:"));
        // new JTextField object; months text field is initialized to 10
        monthsField = new JTextField("10", 3);
        // add the monthsField to the panel
        add(monthsField);

        // add label to the right of the daysField text area
        add(new JLabel("Days:"));
        // new JTextField object; days text field is initialized to 10
        daysField = new JTextField("10", 3);
        // add the daysField to the panel
        add(daysField);

        // Add label to the right of yearsField text area
        add(new JLabel("Years:"));
        // new JTextField object; The years text field is initialized to 2022
        yearsField = new JTextField("2022", 3);
        // add the yearField to the panel
        add(yearsField);

        // new JButton object labeled stop
        stopButton = new JButton("Stop");
        // add the stopButton JButton to the panel
        add(stopButton);

        // new JButton object labeled start
        startButton = new JButton("Start");
        // add the starButton JButton to the panel
        add(startButton);

        // new JButton object labeled load
        loadButton = new JButton("Load");
        // add the loadButton JButton to the panel
        add(loadButton);

        // new JButton object labeled save
        saveButton = new JButton("Save");
        // add the saveButton JButton to the panel
        add(saveButton);

        // new JButton object labeled Days To Go
        daysToGoButton = new JButton("Days To Go");
        // add the daysToGo JButton to the panel
        add(daysToGoButton);

        // new JButton object labeled Days in Future
        daysInFuture = new JButton("Days in Future");
        // add the daysInFuture to the panel
        add(daysInFuture);

        // new JButton object labeled Add
        addButton = new JButton("Add");
        // add the addButton to the panel
        add(addButton);

        // new JTextField not labeled
        addField = new JTextField("", 3);
        // add the text field to the panel
        add(addField);

        // new JButton object labeled New
        newButton = new JButton("New");
        // add the newButton to the panel
        add(newButton);

        // new JTextField initialized with the date 1/1/2022
        newField = new JTextField("1/1/2022 ", 3);
        // add the text field to the panel
        add(newField);

        // new JButton object labeled Continue
        continueButton = new JButton("Continue");
        // add the continueButton to the panel
        add(continueButton);

        // new JButton object labeled Continue
        incrementButton = new JButton("Increment");
        // add the continueButton to the panel
        add(incrementButton);

        // new JButton object labeled Continue
        decrementButton = new JButton("Decrement");
        // add the continueButton to the panel
        add(decrementButton);

        // new JButton object labeled Continue
        resetButton = new JButton("Reset");
        // add the continueButton to the panel
        add(resetButton);

        // add date JLabel to the panel
        add(new JLabel(" " + "Date"));

        // new JLabel object name lblTime
        lblTime = new JLabel();
        // set the text of lblTime object to " " + the date given to watch
        lblTime.setText(" " + watch.toString());
        // add the JLabel to the panel
        add(lblTime);

        // set up the dropdown menu
        setupMenus();

        // ActionListener for the quitItem
        quitItem.addActionListener(new ButtonListener());

        // ActionListener for the stop button
        stopButton.addActionListener(new ButtonListener());

        // ActionListener for the start button
        startButton.addActionListener(new ButtonListener());

        // ActionListener for the load button
        loadButton.addActionListener(new ButtonListener());

        // ActionListener for the save button
        saveButton.addActionListener(new ButtonListener());

        // ActionListener for the daysToGo button
        daysToGoButton.addActionListener(new ButtonListener());

        // ActionListener for the daysInFuture button
        daysInFuture.addActionListener(new ButtonListener());

        // ActionListener for the add button
        addButton.addActionListener(new ButtonListener());

        // ActionListener for the new button
        newButton.addActionListener(new ButtonListener());

        // ActionListener for the continue button
        continueButton.addActionListener(new ButtonListener());

        // ActionListener for the increment button
        incrementButton.addActionListener(new ButtonListener());

        // ActionListener for the decrement button
        decrementButton.addActionListener(new ButtonListener());

        // ActionListener for the reset button
        resetButton.addActionListener(new ButtonListener());

    }

    /** *******************************************************************
     * Respond to menu selections and button clicks
     ******************************************************************** */
    private class ButtonListener implements ActionListener {

        /*
         * The actionPerformed method responds to the various clicks done to
         * gui.
         *
         * @param ActionEvent event
         * @return none
         */
        public void actionPerformed(ActionEvent event) {

            // if the quit selection is pressed from the menu, exit the program
            if (event.getSource() == quitItem) {
                // exit with a 1 status
                System.exit(1);
            }

            // if the stop button is selected, stop the timer
            if (event.getSource() == stopButton) {
                // stop the timer
                javaTimer.stop();
                // update the gui date
                update();
            }

            // if the start button is clicked start the timer
            if (event.getSource() == startButton) {
                // start the timer
                javaTimer.start();
                // update the gui date
                update();
            }

            // if the load button is clicked prompt user to enter txt file name
            if (event.getSource() == loadButton) {
                try {
                    String loadMe = JOptionPane.showInputDialog(null, "Enter the file name");
                    // update the current date to what is saved in the file
                    watch.load(loadMe);
                    // update the gui date
                    update();
                } catch (NullPointerException ne) {
                    JOptionPane.showMessageDialog(null, "Enter the file name");
                }
            }

            // if the save button is clicked prompt the user to enter txt file name
            if (event.getSource() == saveButton) {
                try {
                    String saveMe = JOptionPane.showInputDialog(null, "Enter the file name");
                    watch.save(saveMe);
                } catch (NullPointerException ne) {
                    JOptionPane.showMessageDialog(null, "Enter the file name");
                }
            }

            // if days to go button is clicked calculate days to go
            if (event.getSource() == daysToGoButton) {
                try {
                    int a = watch.daysToGo(monthsField.getText() + "/" +
                            daysField.getText() + "/" + yearsField.getText());
                    JOptionPane.showMessageDialog(daysToGoButton, a + " days to go!");
                } catch (NumberFormatException io) {
                    JOptionPane.showMessageDialog(null, "Enter an integer in all fields");
                }catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Error in field");
                }
            }

            // if days in future is clicked calculate days in future
            if (event.getSource() == daysInFuture) {
                try {
                    // save the string from the days test field to text
                    String text = daysField.getText();
                    // parse through the string for the integer
                    int a = Integer.parseInt(text);
                    // show the user what happened
                    JOptionPane.showMessageDialog(daysInFuture, "In " + a + " days the date will be " +
                            watch.daysInFuture(a));

                } catch (NumberFormatException io) {
                    JOptionPane.showMessageDialog(null, "Enter an integer in all fields");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Error in field");
                }
            }

            // if add button is clicked, add the value in text field to current date
            if (event.getSource() == addButton) {
                try {
                    // obtain the the integer in the add text field
                    int a = Integer.parseInt(addField.getText());
                    // increment the current date by 'a' amount of days
                    watch.inc(a);
                    // update the gui date
                    update();
                    // display to the user what happened
                    JOptionPane.showMessageDialog(addButton, "You added " + a + " days to the current date " +
                            "the updated date is " + watch);

                } catch (NumberFormatException io) {
                    JOptionPane.showMessageDialog(null, "Enter an integer in all fields");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Error in field");
                }
            }

            // if new button is clicked, set the current date to the date in the text field
            if (event.getSource() == newButton) {
                try {
                    // update the current date to that that is the new text field
                    watch = new GeoCountDownTimer(newField.getText());
                    // update the gui date
                    update();
                } catch (InputMismatchException im) {
                    JOptionPane.showMessageDialog(null, "The format is mm/dd/yyyy");
                    // reset the textfield for new to 1/1/2022
                    newField.setText("");
                }
                catch (ArrayIndexOutOfBoundsException ae) {
                    JOptionPane.showMessageDialog(null, "The format is mm/dd/yyyy");
                    // reset the textfield for new to 1/1/2022
                    newField.setText("");
                } catch (NoSuchElementException ne) {
                    JOptionPane.showMessageDialog(null, "The format is mm/dd/yyyy");
                    // reset the textfield for new to 1/1/2022
                    newField.setText("");
                } catch (IllegalArgumentException ie) {
                    JOptionPane.showMessageDialog(null, "The format is mm/dd/yyyy");
                    // reset the textfield for new to 1/1/2022
                    newField.setText("");
                }
            }

            // if the start button is clicked start the timer
            if (event.getSource() == continueButton) {
                // start the timer
                javaTimer.start();
                // update the gui date
                update();
            }

            // if increment button is clicked, increment the current date by 1
            if (event.getSource() == incrementButton) {
                // increment the current date by 1
                watch.inc();
                // update the gui date
                update();
            }

            // if decrement button is clicked, decrement the current date by 1
            if (event.getSource() == decrementButton) {
                // decrement the current date by 1
                watch.dec();
                // update the gui date
                update();
            }

            // if the reset button is clicked, reset back to how the program starts
            if (event.getSource() == resetButton) {
                // reset the text field for months
                monthsField.setText("10");

                // reset the text field for days
                daysField.setText("10");

                // reset the text field for years
                yearsField.setText("2022");

                // clear the add text field
                addField.setText("");

                // reset the textfield for new to 1/1/2022
                newField.setText("1/1/2022");

                // this constructor sets the date to 1/1/2022
                watch = new GeoCountDownTimer();

                // update the gui date
                update();
            }
        }
    }

    /** *******************************************************************
     * Respond to timer actions
     ******************************************************************** */
    private class TimerListener implements ActionListener {

        /*
         * The actionPerformed method responds timer listener
         *
         * @param ActionEvent e
         * @return none
         */
        public void actionPerformed(ActionEvent e) {
            try {
                // increment the current day by 1
                watch.inc();
                update();
            }
            catch (Exception exception) {
                // do nothing
            }
        }
    }

    /** *******************************************************************
     * The update() method updates the date on the gui
     *
     * @return none
     ******************************************************************** */
    private void update() {
        // update the date on the GUI
        lblTime.setText(" " + watch.toString());
    }

    /** *******************************************************************
     * The setupMenus method sets up the menus for the gui
     *
     * @return none
     ******************************************************************** */
    private void setupMenus() {
        // create menu components
        fileMenu = new JMenu("File");

        // new JMenuItem object
        quitItem = new JMenuItem("Quit");

        // display menu components
        fileMenu.add(quitItem);

        // new JMenuBar object
        menus = new JMenuBar();

        // add menus
        menus.add(fileMenu);
    }
}