package ib_project2;

/*IMPORTANT GUI NOTE
//Instead, have the user input a secified chemical amount and such
//and then read out the resulting amounts of all the species on the right side
//then have a dropdown menu so that the user can decide what unit she wants the
//results to be in
//2g water ---> 5mols co2
--------------> 8 mols c3h4
--------------> .3 mols V 
etc.
*/
import Stoic.Processing;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Handles all basic Graphic user interface code
 * @author nemo
 */
public class GUI {

    public static JFrame main, stoic, info;
    public JLabel debugLabel, debugLabel2;
    static SpringLayout layout = new SpringLayout();
    public static Container pane = new Container(), iPane;
    public static TextField equationField, InputNumb, InputC;
    public static JComboBox chemicalDrop, chemicalDrop2, units, units2, phase, phase2;
    public static JButton winBut = new JButton(), infoBut = new JButton();
    static int xc, yc;
    public static double theNumber, moles, theNumber2;
    public static boolean debug = false;

    public Label titleLabel = new Label();
    public Button[] buttons = new Button[100];

    public void GUI() {
        pane = new Container();
        main = new JFrame();
        newPanel(main);
        pane.setSize(main.getSize());//VERY IMPORTANT

        if (debug == true) {
            main.addMouseListener(new PanelListener());
        }
        
        mainWindow();
        main.setVisible(true);
    }
    //=====================================BODY==========================================//

    public void mainWindow() {

        titleLabel.setText("StoicCalc: \n an exploration");
        Font f = new Font("Bookman Old Style", Font.PLAIN, 30);
        titleLabel.setFont(f);
        Layout(titleLabel, 88, 25);
        titleLabel.setVisible(true);

        
        JButton conv = new JButton();
        conv.setText("stoic");
        Dimension a = new Dimension(100, 40);
        conv.setPreferredSize(a);
        Layout(conv, 100, 150);
        conv.setVisible(true);
        conv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stoicWindow();
            }
        });
        
        JButton exit = new JButton();
        exit.setText("Exit");
        exit.setPreferredSize(a);
        Layout(exit, 300, 150);
        exit.setVisible(true);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //ADDING COMPONENTS
        main.add(titleLabel);
        main.add(conv);
        main.add(exit);
        if (debug) {
            DebugSize(main);
        }
        //pack(main); //CHANGE IF COMPONENTS NOT SHOWING UP
        //main.revalidate();//CHANGE IF COMPONENTS NOT SHOWING UP

    }
    
    public void stoicWindow() {
        Stoic.StoicGUI.stoicWindow();
    }
    //==============================ACTION LISTENERS====================================//

    //KEEP CODE? MAYBE???????? 
    public class AL extends Frame implements WindowListener, ActionListener {

        TextField text = new TextField(20);
        Button b;
        private int numClicks = 0;

        public AL(String title) {

            super(title);
            setLayout(new FlowLayout());
            addWindowListener(this);
            b = new Button("Click me");
            add(b);
            add(text);
            b.addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
            numClicks++;
            text.setText("Button Clicked " + numClicks + " times");
        }

        public void windowClosing(WindowEvent e) {
            dispose();
            System.exit(0);
        }

        public void windowOpened(WindowEvent e) {
        }

        public void windowActivated(WindowEvent e) {
        }

        public void windowIconified(WindowEvent e) {
        }

        public void windowDeiconified(WindowEvent e) {
        }

        public void windowDeactivated(WindowEvent e) {
        }

        public void windowClosed(WindowEvent e) {
        }

    }
    //END OF KEEP CODE MAYBE???????

    //===============================HELPER METHODS=====================================//
    private void newButton(Button b, String text, int x, int y) {
        b = new Button();
        b.setLabel(text);
        Layout(b, x, y);
        b.setVisible(true);
    }

    private void pack(JFrame J) {
        //J.pack();
        //J.revalidate();
       
    }

    public static void Layout(Component c, int x, int y) {
        layout.putConstraint(SpringLayout.WEST, c, x, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, c, y, SpringLayout.NORTH, pane);
    }

    public static void newPanel(JFrame j) {
        j.setTitle("Main Menu");
        j.setSize(565, 402);
        j.setResizable(true);
        j.setLocation(458, 235);
        j.add(pane);

        j.setLayout(layout);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);

    }

    //=================================DEBUG METHODS====================================//

    public static class PanelListener extends MouseAdapter { //mouse position

        @Override
        public void mousePressed(MouseEvent e) {
            if (debug) {
                xc = e.getX();
                yc = e.getY();
                System.out.println("(" + (xc - 8) + ", " + (yc - 30) + ")");
            }
        }
    }

    public void DebugSize(final JFrame j) {

        debugLabel = new JLabel();
        debugLabel2 = new JLabel();

        debugLabel.setText("asdf");
        debugLabel2.setText("asdf");

            //pane.(25, 25);
        Layout(debugLabel2, 350, 335);
        Layout(debugLabel, 30, 335);
        debugLabel2.setVisible(true);
        debugLabel.setVisible(true);

            //If you add components to the frame after it is visible then
        //you need to revalidate() the JPanel that you add the components to. 
        j.addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(ComponentEvent e) {
                //System.out.println(j.getSize());
                Dimension d = j.getSize();

                debugLabel.setText(d.toString());
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                Point d = null;
                try {
                    d = j.getLocationOnScreen();
                } catch (java.awt.IllegalComponentStateException er) {
                    System.out.println("ERROR: " + er.getMessage());
                    d = new Point(0, 0);
                }

                debugLabel2.setText(d.toString());
            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });

        Layout(debugLabel, 30, 335);
        j.add(debugLabel2);
        j.add(debugLabel);
        //main.setSize(565, 402);//used to be main.Pack();

    }
}
