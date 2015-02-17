package ib_project2;;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class GUI {
    public JFrame main, stoic;
    public JLabel debugLabel, debugLabel2,Answer;
    SpringLayout layout = new SpringLayout();
    Container pane = new Container(), sPane;
    TextField equationField,InputNumb,InputC;
    JComboBox chemicalDrop, chemicalDrop2;
    int xc, yc;
    boolean debug = true;
    
    public Label titleLabel = new Label();
    public Button[] buttons = new Button[100];
    
    public void GUI(){
        pane = new Container();
        main = new JFrame();
        newPanel(main);
        pane.setSize(main.getSize());//VERY IMPORTANT

        if(debug == true) main.addMouseListener(new PanelListener());
        
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
        
        //SOLVE MANY BUTTONS PROBLEM
        
        JButton conv = new JButton();
        conv.setText("stoic");
        Dimension a = new Dimension(100,40);
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
        
        
        
        if(debug)DebugSize(main);
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
        //setting up the window
        
        final JLabel stoicTitleScreen = new JLabel();
        stoicTitleScreen.setText("Stoichiometry");
        stoicTitleScreen.setSize(10,50);
        Font fs = new Font("Comic Sans", Font.PLAIN , 30);
        stoicTitleScreen.setFont(fs);
        
        final JLabel output = new JLabel();
        output.setText("Enter an equation");
        output.setSize(10,50);
        
        
        final JLabel Ihave = new JLabel();
        Ihave.setText("I have                                                 of");
        Ihave.setSize(10,10);
        
        final JLabel HowMuch = new JLabel();
        HowMuch.setText("How Much");
        HowMuch.setSize(10,10);
        
        final JLabel WillINeed = new JLabel();
        WillINeed.setText("Will I Have?");
        WillINeed.setSize(10,10);
        
        Answer = new JLabel();
        Answer.setText("");
        Answer.setSize(10,10);
        
        equationField = new TextField();
        equationField.setColumns(50);     
        
        InputNumb = new TextField();
        InputNumb.setColumns(5);
        
        InputC = new TextField();
        InputC.setColumns(3);
        InputC.setVisible(false);
        
        final JComboBox units = new JComboBox();
        units.addItem("moles");
        units.addItem("grams");
        units.addItem("liters");
        units.addItem("milliliters");
        units.addItem("atoms");
        units.addItem("molecules");
        units.setSelectedItem(null);
        
        chemicalDrop = new JComboBox();
        chemicalDrop.setMaximumRowCount(5);
        chemicalDrop.setPreferredSize(new Dimension(65,20));
        
        chemicalDrop2 = new JComboBox();
        chemicalDrop2.setMaximumRowCount(5);
        chemicalDrop2.setPreferredSize(new Dimension(65,20));
        
        final JComboBox form = new JComboBox();
        form.addItem("gas");
        form.addItem("liquid");
        form.addItem("solid");
        form.setSelectedItem(null);
        
        //(Left/right, up/down)
        Layout(equationField, 100, 170);
        Layout(InputNumb, 140, 50);
        Layout(chemicalDrop, 295, 50);
        Layout(chemicalDrop2, 155, 90);
        Layout(units, 200, 50);
        Layout(form, 375, 50);
        Layout(output, 100, 120);
        Layout(Ihave, 100, 53);
        Layout(HowMuch, 100, 93);
        Layout(WillINeed, 225, 93);
        Layout(Answer, 300, 93);
        Layout(stoicTitleScreen, 170, 7);
        Layout(InputC, 430, 50);
        
        equationField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                char z = e.getKeyChar();
                //System.out.print(z);
                boolean good = (z == '+') || (z == '-') || (z == '.') 
                        || (z >= 48 & z <= 57) || (z >= 65 & z <= 90) 
                        || (z >= 97 & z <= 122) || (z == 91) || (z == 93)
                        || (z == 60) || (z == 62) || (z == 32) || (z == 40)
                        || (z == 41);
                boolean badGood = (z == 81) || (z == 113) ||
                        (z == 74) || (z == 106);
                
                if(!good) e.consume(); //anything that's not in good gets consumed
                if(badGood) e.consume(); // these sepcific characters also get consumed
                //kinda redundent?
                
               // if(e.getKeyChar())
                    //43 (+) 45 (-) 46 (.)
                    //81, 113, 74, 106 bad numbers

            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //Here is where we parse the string.
                //its time to make an algorithm.
                //-MgCl --> Mg22+ + Cl-
                
                
                //output.setText(equation.getText());
                
                //SPLITTING ALGORTHYTHM!
                if(!equationField.getText().isEmpty()) {
                ArrayList<String> chemicals = Processing.CEPS(equationField.getText());
                
                
                chemicalDrop.removeAllItems();
                chemicalDrop2.removeAllItems();
                
                if(!chemicals.get(0).equals("ERRORS")) {//fix this exception problem
                    for(String a: chemicals) {
                        chemicalDrop.addItem(a);
                        chemicalDrop2.addItem(a);
                    }
                    chemicalDrop.removeItem("");
                    chemicalDrop2.removeItem("");
                }
                
                output.setText("");
                String outputText = Processing.CEDS(chemicals);
                if(outputText.equals("Ion number given without parent chemical")) {
                    chemicalDrop.removeAllItems();
                    chemicalDrop2.removeAllItems();
                }
                
                Font fs = new Font("Comic Sans", Font.PLAIN , 30);
                output.setFont(fs);
                output.setText(outputText);
                }
               
            }//end of key release  
        });
        InputNumb.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
               char z = ke.getKeyChar();
               //Burn?
               boolean burn = !Character.isDigit(z) && !(z == 8) 
                       && !(z == 46) && !(z < 32) && !(z == 127);//burn if its not a diget and its not a backspace
               if(burn) {
                   ke.consume();
               }
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                //doesn't work. fix.
                if(InputNumb.getText().toCharArray().length > 7) {
                    ke.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                double input = Double.parseDouble(InputNumb.getText());
                double ans = 0;
                if(units.getSelectedIndex() == 0) {
                    ans = Processing.molesToMoles(input, (String)chemicalDrop.getSelectedItem(), (String)chemicalDrop2.getSelectedItem()); 
                }
                if(units.getSelectedIndex() == 1) {
                    ans = Processing.gramsTograms(input, (String)chemicalDrop.getSelectedItem(), (String)chemicalDrop2.getSelectedItem()); 
                }
                if(units.getSelectedIndex() == 2) {
                    ans = Processing.litersToLiters(input, Double.parseDouble(InputC.getText()), Double.parseDouble(InputC.getText()));
                }
                if(units.getSelectedIndex() == 3) {
                    ans = Processing.litersToLiters((input / 1000), Double.parseDouble(InputC.getText()), Double.parseDouble(InputC.getText()));
                }
                if(units.getSelectedIndex() == 4) {
                    ans = Processing.atomsToMoles(input, (String)chemicalDrop.getSelectedItem());
                }
                Answer.setText(ans + "");
            }
        });
        InputC.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ge) {
               char z = ge.getKeyChar();
               //Burn?
               boolean burn = !Character.isDigit(z) && !(z == 8) 
                       && !(z == 46) && !(z < 32) && !(z == 127);//burn if its not a diget and its not a backspace
               if(burn) {
                   ge.consume();
               }
            }

            @Override
            public void keyPressed(KeyEvent e) {
               
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        form.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if Liquid is selected, show the Concentrations box
               if(form.getSelectedIndex() == 1) {
                   InputC.setVisible(true);
                   System.out.println("Hey!");
               } else {
                   InputC.setVisible(false);
               }
            }
        });
        stoic.add(equationField);
        stoic.add(InputNumb);
        stoic.add(chemicalDrop);
        stoic.add(chemicalDrop2);
        stoic.add(units);
        stoic.add(form);
        stoic.add(output);
        stoic.add(Ihave);
        stoic.add(HowMuch);
        stoic.add(WillINeed);
        stoic.add(Answer);
        stoic.add(stoicTitleScreen);
        stoic.add(InputC);
    }
    //==============================ACTION LISTENERS====================================//
    
    
    //===============================HELPER METHODS=====================================//
    

    private void newButton(Button b, String text, int x, int y) {
        b = new Button();
        b.setLabel(text);
        Layout(b, x, y);
        b.setVisible(true);
    }
    
    private void pack(JFrame J){
        //J.pack();
        //J.revalidate();
        main.setSize(565,402);
    }
    
    private void Layout(Component c, int x, int y) {
        layout.putConstraint(SpringLayout.WEST, c,x, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, c,y,SpringLayout.NORTH, pane);
    }
    
    private void newPanel(JFrame j) {
        j.setTitle("Main Menu");
        j.setSize(565,402);
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
                if(debug){
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
                    try{
                        d = j.getLocationOnScreen();
                    } catch (java.awt.IllegalComponentStateException er) {
                        System.out.println("ERROR: " + er.getMessage());
                        d = new Point(0,0);
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
            pack(main);
        
    }
}
