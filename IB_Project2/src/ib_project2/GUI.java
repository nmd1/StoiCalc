package ib_project2;

;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;



public class GUI {

    public JFrame main, stoic, info;
    public JLabel debugLabel, debugLabel2, Answer;
    SpringLayout layout = new SpringLayout();
    Container pane = new Container(), sPane, iPane;
    static TextField equationField, InputNumb;
    static JComboBox chemicalDrop, chemicalDrop2, units, units2;
    static JButton winBut = new JButton(), infoBut = new JButton();
    int xc, yc;
    boolean debug = true;

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

        titleLabel.setText("StoicCalc \n An exploration");
        Font f = new Font("Bookman Old Style", Font.PLAIN, 30);
        titleLabel.setFont(f);
        Layout(titleLabel, 88, 25);
        titleLabel.setVisible(true);

        //SOLVE MANY BUTTONS PROBLEM//SOLVED. Long ago too.
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

        //ADDING COMPONENTS
        main.add(titleLabel);
        main.add(conv);

        if (debug) {
            DebugSize(main);
        }
        //pack(main); //CHANGE IF COMPONENTS NOT SHOWING UP
        //main.revalidate();//CHANGE IF COMPONENTS NOT SHOWING UP

    }

    public void stoicWindow() {
        sPane = new Container();
        stoic = new JFrame();
        newPanel(stoic);
        stoic.setName("Stoiciometry");
        pane.setSize(main.getSize());//VERY IMPORTANT
        main.setVisible(false);
        stoic.setVisible(true);
        if (debug == true) stoic.addMouseListener(new PanelListener());

        //setting up the window

        final JLabel stoicTitleScreen = new JLabel();
        stoicTitleScreen.setText("Stoichiometry");
        stoicTitleScreen.setSize(10, 50);
        Font fs = new Font("Comic Sans", Font.PLAIN, 30);
        stoicTitleScreen.setFont(fs);

        final JLabel output = new JLabel();
        output.setText("     Enter an equation");
        output.setSize(10, 20);
        output.setFont(new Font("Comic Sans", Font.PLAIN, 30));
        
        final JLabel arrow = new JLabel();
        arrow.setText("→");
        arrow.setSize(10, 10);
        arrow.setFont(new Font("Comic Sans", Font.PLAIN, 50));

        Answer = new JLabel();
        Answer.setText("");
        Answer.setSize(10, 10);

        equationField = new TextField();
        equationField.setColumns(50);

        InputNumb = new TextField();
        InputNumb.setColumns(5);
       

        units = new JComboBox();
        units.addItem("moles");
        units.addItem("grams");//solid
        units.addItem("liters");//liquid or gas (or even solid, with density)
        units.addItem("milliliters");//liquid or gas again
        units.addItem("molecules");
        units.setSelectedItem(null);
        
        units2 = new JComboBox();
        units2.addItem("moles");
        units2.addItem("grams");//solid
        units2.addItem("liters");//liquid or gas (or even solid, with density)
        units2.addItem("milliliters");//liquid or gas again
        units2.addItem("molecules");
        units2.addItem("atoms");
        units2.addItem("gas...");
        units2.setSelectedItem(null);

        chemicalDrop = new JComboBox();
        chemicalDrop.setMaximumRowCount(5);
        chemicalDrop.setPreferredSize(new Dimension(65, 20));

        chemicalDrop2 = new JComboBox();
        chemicalDrop2.setMaximumRowCount(5);
        chemicalDrop2.setPreferredSize(new Dimension(65, 20));

        final JComboBox phase = new JComboBox();
        phase.addItem("gas");
        phase.addItem("liquid");
        phase.addItem("solid");
        phase.setSelectedItem(null);
        
        final JComboBox phase2 = new JComboBox();
        phase2.addItem("gas");
        phase2.addItem("liquid");
        phase2.addItem("solid");
        phase2.setSelectedItem(null);
        
        //Buttons
        winBut = new JButton();
        winBut.setText("P");
        Dimension a = new Dimension(75, 30);
        winBut.setPreferredSize(a);
        winBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PvtWindow();
            }
        });
        winBut.setVisible(false);
        infoBut = new JButton();
        infoBut.setText("P");
        infoBut.setPreferredSize(a);
        infoBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PvtWindow();
            }
        });
        infoBut.setVisible(false);
        
        JSeparator line = new JSeparator(SwingConstants.VERTICAL);
        line.setSize(60,60);
        
        
        //(Left/right, up/down)
        Layout(equationField, 100, 220);
        Layout(InputNumb, 70, 60);
        Layout(chemicalDrop, 70, 90);
        Layout(chemicalDrop2, 380, 60);
        Layout(units, 135, 60);
        Layout(units2, 300, 60);
        Layout(phase, 150, 90);
        Layout(phase2, 350, 85);
        Layout(output, 100, 170);
        Layout(arrow, 225, 85);
        Layout(Answer, 110, 250);
        Layout(stoicTitleScreen, 170, 7);
        Layout(winBut, 100, 130);
        Layout(infoBut, 340, 130);
        Layout(line, 200, 100);
        
        equationField.addKeyListener(new KeyListener() {
            final int widthLimit = 320;
            final int miniFont = 12;
            final int maxiFont = 30;
            
            @Override
            public void keyTyped(KeyEvent e) {
                char z = e.getKeyChar();
                //System.out.print(z);
                boolean good = (z == '+') || (z == '-') || (z == '.')
                        || (z >= 48 & z <= 57) || (z >= 65 & z <= 90)
                        || (z >= 97 & z <= 122) || (z == 91) || (z == 93)
                        || (z == 60) || (z == 62) || (z == 32) || (z == 40)
                        || (z == 41);
                boolean badGood = (z == 81) || (z == 113)
                        || (z == 74) || (z == 106);

                if (!good) {
                    e.consume(); //anything that's not in good gets consumed
                }
                if (badGood) {
                    e.consume(); // these sepcific characters also get consumed
                }                //kinda redundent?

               // if(e.getKeyChar())
                //43 (+) 45 (-) 46 (.)
                //81, 113, 74, 106 bad numbers
                if(equationField.getText().isEmpty()){
                    output.setText("");
                    output.setFont(new Font("Comic Sans", Font.PLAIN, 30));
                }
                //minimum font size, 12
                if(output.getFont().getSize() <= miniFont && (e.getKeyChar() != 8)) {
                        e.consume();
                }
                
 
            }

            @Override
            public void keyPressed(KeyEvent e) {
                    //limit of 320 (in length) and limit of size 30 font
                   if(output.getWidth() < widthLimit && output.getFont().getSize() < maxiFont) {
                       output.setFont(new Font("Comic Sans", Font.PLAIN, output.getFont().getSize() + 1));

               }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
                if (!equationField.getText().isEmpty()) {
                    ArrayList<String> chemicals = Processing.CEPS(equationField.getText());

                    chemicalDrop.removeAllItems();
                    chemicalDrop2.removeAllItems();

                    if (!chemicals.get(0).equals("ERRORS")) {//fix this exception problem
                        for (String a : chemicals) {
                            chemicalDrop.addItem(a);
                            chemicalDrop2.addItem(a);
                        }
                        chemicalDrop.removeItem("");
                        chemicalDrop2.removeItem("");
                    }

                    output.setText("");
                    String outputText = Processing.CEDS(chemicals);
                    if (outputText.equals("Ion number given without parent chemical")) {
                        chemicalDrop.removeAllItems();
                        chemicalDrop2.removeAllItems();
                    }
                    
                    //limit in length of 320 and minimum font size is 12
                    if(output.getWidth() > widthLimit && output.getFont().getSize() > miniFont) {
                        output.setFont(new Font("Comic Sans", Font.PLAIN, output.getFont().getSize() - 1));
                    }
                    
                    
                      
                    /*} else {
                        output.setFont(new Font("Comic Sans", Font.PLAIN, 20));  
                    }*/
                    
                    output.setText(outputText);  //Answer.setText(output.getWidth() + "");
                }
                //Here is where we parse the string.
                //its time to make an algorithm.
                //-MgCl --> Mg22+ + Cl-

                //output.setText(equation.getText());
                //SPLITTING ALGORTHYTHM!
                

            }//end of key release  
        });
        InputNumb.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                char z = ke.getKeyChar();
                //Burn?
                boolean burn = !Character.isDigit(z) && !(z == 8)
                        && !(z == 46) && !(z < 32)
                        && (6 < InputNumb.getText().length());//burn if its not a diget and its not a backspace and if there are more than 6 characters
                if (burn) {
                    System.out.println(z);
                    if (!(z == 127)) {
                        ke.consume();
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                //doesn't work. fix.
                if (InputNumb.getText().toCharArray().length > 7) {
                    ke.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                System.out.println(units);
                double ans = Processing.calculate();
                if (ans == -1) {
                    Answer.setText("Error");
                } else {
                    Answer.setText(ans + "");
                }
            }
        });
                /*
                char z = ge.getKeyChar();
                //Burn?
                boolean burn = !Character.isDigit(z) && !(z == 8)
                        && !(z == 46) && !(z < 32) && !(z == 127);//burn if its not a diget and its not a backspace
                if (burn) {
                    ge.consume();
                }
                        */
        phase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if Liquid is selected, show the Concentrations box
                if (phase.getSelectedIndex() == 0) { //GAS
                    InputNumb.setEnabled(false);
                    units.setEnabled(false);  
                    winBut.setVisible(true);
                    winBut.setText("PV=nRT");//or D instead of V
                } else if(phase.getSelectedIndex() == 1){ //LIQUID
                    InputNumb.setEnabled(true);
                    units.setEnabled(true);  
                    winBut.setVisible(true);
                    winBut.setText("[CONC]");
                } else if(phase.getSelectedIndex() == 2) { //SOLID
                    InputNumb.setEnabled(true);
                    units.setEnabled(true);  
                    winBut.setVisible(true);
                    winBut.setText("Density");
                }
            }
        });
        phase2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if Liquid is selected, show the Concentrations box
                if (phase2.getSelectedIndex() == 0) { //GAS
                    units2.setEnabled(true);  
                    infoBut.setVisible(true);
                    infoBut.setEnabled(true);
                    infoBut.setText("STP");
                } else if(phase2.getSelectedIndex() == 1){ //LIQUID
                    units2.setEnabled(true);  
                    infoBut.setVisible(true);
                    infoBut.setEnabled(true);
                    infoBut.setText("[CONC]");
                } else if(phase2.getSelectedIndex() == 2) { //SOLID
                    units2.setEnabled(true);  
                    infoBut.setVisible(true);
                    infoBut.setEnabled(true);
                    infoBut.setText("Density");
                }
            }
        });
        units.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (units.getSelectedIndex() == 0) { //moles
                    phase.setEnabled(false);
                    winBut.setVisible(false);
                } else if(units.getSelectedIndex() == 1){ //grams
                    phase.setEnabled(false);
                    winBut.setVisible(false);
                } else if(units.getSelectedIndex() == 2) { //liters
                    phase.setEnabled(true);
                } else if(units.getSelectedIndex() == 3) { //MLiters
                    phase.setEnabled(true);
                } else if(units.getSelectedIndex() == 4) { //Molecules
                    phase.setEnabled(false);
                    winBut.setVisible(false);
                }
            }
            
        });
        units2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (units2.getSelectedIndex() == 0) { //moles
                    phase2.setEnabled(false);
                    infoBut.setVisible(false);
                } else if(units2.getSelectedIndex() == 1){ //grams
                    phase2.setEnabled(false);
                    infoBut.setVisible(false);
                } else if(units2.getSelectedIndex() == 2) { //liters
                    phase2.setEnabled(true);
                } else if(units2.getSelectedIndex() == 3) { //MLiters
                    phase2.setEnabled(true);
                } else if(units2.getSelectedIndex() == 4) { //Molecules
                    phase2.setEnabled(false);
                    infoBut.setVisible(false);
                } else if(units2.getSelectedIndex() == 5) { //atoms
                    phase2.setEnabled(false);
                    infoBut.setVisible(false);
                } else if(units2.getSelectedIndex() == 6) { //gas
                    phase2.setEnabled(false);
                    phase2.setSelectedIndex(0);
                    infoBut.setVisible(true);
                    infoBut.setEnabled(true);
                    infoBut.setText("Select Type");
                }
                
            }
            
        });
        chemicalDrop.addActionListener(phase);
        

        //SmallWindow
        stoic.add(equationField);
        stoic.add(line);
        stoic.add(InputNumb);
        stoic.add(chemicalDrop);
        stoic.add(chemicalDrop2);
        stoic.add(units);
        stoic.add(units2);
        stoic.add(phase);
        stoic.add(phase2);
        stoic.add(output);
        stoic.add(arrow);
        stoic.add(Answer);
        stoic.add(stoicTitleScreen);
        stoic.add(winBut);
        stoic.add(infoBut);
        stoic.add(line);
    }

    public void PvtWindow() {
        iPane = new Container();
        info = new JFrame();
        newPanel(info);
        info.setName("Input Data");
        info.setSize(300,200);//VERY IMPORTANT
        main.setVisible(false);
        //stoic.setVisible(true);
        info.setVisible(true);
        info.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        info.setName("Congress");
        stoic.setEnabled(false);//important to make the window enabled after you're done.
        
        
        //setting up the window
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

    private void Layout(Component c, int x, int y) {
        layout.putConstraint(SpringLayout.WEST, c, x, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, c, y, SpringLayout.NORTH, pane);
    }

    private void newPanel(JFrame j) {
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

    private class PanelListener extends MouseAdapter { //mouse position

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
        main.add(debugLabel2);
        main.add(debugLabel);
        main.setSize(565, 402);//used to be main.Pack();

    }
}
