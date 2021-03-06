package Stoic;

import ib_project2.GUI;
import static ib_project2.GUI.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.*;


/**
 *
 * @author nemo
 */

public class StoicGUI {
    
public static Container sPane;   
public static JFrame stoic;
public static JLabel winLabel, Answer, infoLabel;
    public static void stoicWindow() {
        Stoic.StoicWindow.main(null);

        sPane = new Container();
        stoic = new JFrame();
        //GUI.newPanel(stoic);
        newPanel(stoic);
        stoic.setName("Stoiciometry");
        //GUI.pane.setSize(main.getSize());//VERY IMPORTANT
        pane.setSize(main.getSize());
        main.setVisible(false);
        stoic.setVisible(true);
        if (debug == true) stoic.addMouseListener(new GUI.PanelListener());

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
        
        winLabel = new JLabel("");
       // winLabel.setText("");
        winLabel.setSize(10, 10);
        
        infoLabel = new JLabel("");
        //infoLabel.setText("");
        infoLabel.setSize(10, 10);
        
        Answer = new JLabel();
        Answer.setText("");
        Answer.setSize(10, 10);
        Answer.setFont(new Font("Comic Sans", Font.PLAIN, 20));

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

        phase = new JComboBox();
        phase.addItem("gas");
        phase.addItem("liquid");
        phase.addItem("solid");
        phase.setSelectedItem(null);
        
        phase2 = new JComboBox();
        phase2.addItem("gas");
        phase2.addItem("liquid");
        phase2.addItem("solid");
        phase2.setSelectedItem(null);
        
        //Buttons
        JButton end = new JButton();
        end.setText("Main Menu");
        end.setPreferredSize(new Dimension (95, 50));
        end.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                main.setVisible(true);
                stoic.dispose();
            }
        });
        
        winBut = new JButton();
        winBut.setText("P");
        Dimension a = new Dimension(75, 30);
        winBut.setPreferredSize(a);
        winBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(chemicalDrop.getSelectedItem() != null) PvtWindow(true);
                else JOptionPane.showMessageDialog(stoic, "Select a chemical from the dropdown menu");
            }
        });
        winBut.setVisible(false);
        infoBut = new JButton();
        infoBut.setText("P");
        infoBut.setPreferredSize(a);
        infoBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(chemicalDrop2.getSelectedItem() != null) PvtWindow(false);
                else JOptionPane.showMessageDialog(stoic, "Select a chemical from the dropdown menu");
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
        Layout(Answer, 175, 250);
        Layout(stoicTitleScreen, 170, 7);
        Layout(winBut, 70, 130);
        Layout(infoBut, 300, 130);
        Layout(winLabel, 150, 140);
        Layout(infoLabel, 390, 140);
        Layout(end,220,300);
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
                } else {
                    chemicalDrop.removeAllItems();
                    chemicalDrop2.removeAllItems();
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
                    Answer.setText("Answer: " + ans + "");
                }
            }
        });
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
                    infoBut.setEnabled(false);
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
        chemicalDrop2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                double ans = Processing.calculate();
                if(ans < 0) {
                    Answer.setText("Error");
                } else {
                    Answer.setText("Answer: "+ ans + "");
                }  
            }
            
        });
        chemicalDrop.addActionListener(chemicalDrop2.getActionListeners()[0]);    
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
        stoic.add(winLabel);
        stoic.add(infoLabel);
        stoic.add(end);
        stoic.add(line);
    }

    public static void PvtWindow(boolean start) {
        String display = "";
        iPane = new Container();
        info = new JFrame();
        newPanel(info);
        info.setName("Input Data");
        info.setTitle("Input Data");
        info.setSize(300,300);
        main.setVisible(false);
        //stoic.setVisible(true);
        if (debug == true) info.addMouseListener(new GUI.PanelListener());
        info.setVisible(true);
        info.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        info.setName("Congress");
        stoic.setEnabled(false);//important to make the window enabled after you're done.
        
        
        JButton end = new JButton();
        end.setText("Done");
        Dimension a = new Dimension(65, 30);
        end.setPreferredSize(a);
        
        end.setVisible(true);
        final JTextField one = new JTextField();
        final JTextField two = new JTextField();
        final JTextField three = new JTextField();
        final JTextField four = new JTextField();
        one.setColumns(10);two.setColumns(10);
        three.setColumns(10);four.setColumns(10);
        final JLabel title = new JLabel("Null");
        title.setFont(new Font("Comic Sans", Font.BOLD, 15));
        JLabel first = new JLabel("Null");
        JLabel second = new JLabel("Null");
        JLabel third = new JLabel("Null");
        JLabel fourth = new JLabel("Null");
        
        final JCheckBox STP = new JCheckBox();
        STP.setVisible(false);
        
        final JRadioButton f = new JRadioButton("");f.setVisible(false);
        final JRadioButton s = new JRadioButton("");s.setVisible(false);
        final JRadioButton t = new JRadioButton("");t.setVisible(false);
        final JRadioButton r = new JRadioButton("");r.setVisible(false);
        ButtonGroup group = new ButtonGroup();
        group.add(f);
        group.add(s);
        group.add(t);
        group.add(r);
        two.setVisible(false);
        three.setVisible(false);
        four.setVisible(false);
        second.setVisible(false);
        third.setVisible(false);
        fourth.setVisible(false);
        one.setName(one.getText());
        two.setName(two.getText());
        three.setName(three.getText());
        four.setName(four.getText());
        final JComboBox press = new JComboBox();
        press.addItem("Kpa");
        press.addItem("torr");//solid
        press.addItem("Pa");//liquid or gas (or even solid, with density)
        press.addItem("Latm");//liquid or gas again
        press.addItem("bar");
        press.addItem("psi");
        press.setSelectedItem("Kpa");
        final JComboBox temp = new JComboBox();
        temp.addItem("K");
        temp.addItem("C");//solid
        temp.addItem("F");//liquid or gas (or even solid, with density)
        temp.setSelectedItem("K");
        final JComboBox vol = new JComboBox();
        vol.addItem("L");
        vol.addItem("mL");//solid
        vol.setSelectedItem("L");
        press.setVisible(false);
        temp.setVisible(false);
        vol.setVisible(false);
        
        
        one.addKeyListener(new KeyListener() {
            
            @Override
            public void keyTyped(KeyEvent ke) {
                char z = ke.getKeyChar();
                boolean burn = !Character.isDigit(z) && !(z == 8)
                    && !(z == 46) && !(z < 32) && !(z == 127);//burn if its not a diget and its not a backspace
                if(ke.getComponent().getName().contains(".") && z == 46)burn = true;
                if(burn) ke.consume();
            }
            @Override
            public void keyPressed(KeyEvent ke) {

            }
            @Override
            public void keyReleased(KeyEvent ke) {
            }
            
        });
        two.addKeyListener(one.getKeyListeners()[0]);
        three.addKeyListener(one.getKeyListeners()[0]);
        four.addKeyListener(one.getKeyListeners()[0]);
        /*
        DebugSize(info);
        Layout(debugLabel, 0, 110);
        Layout(debugLabel2, 0, 165);
        */
        int n = 35;
        Layout(end, 110, 200);
        Layout(one, 130, n);
        Layout(two, 130, n + 25);
        Layout(three, 130, n + 50);
        Layout(four, 130, n + 75);
        Layout(first, 10, n + 5);
        Layout(second, 10, n + 30);
        Layout(third, 10, n + 55);
        Layout(fourth, 10, n + 80);
        Layout(f, 10, n + 5);
        Layout(s, 10, n + 30);
        Layout(t, 10, n + 55);
        Layout(r, 10, n + 80);
        Layout(title, 60, 6);
        Layout(press, 220,35);
        Layout(temp, 220, 85);
        Layout(vol, 220, 60);
        Layout(STP, 120, 110);
        info.add(end);
        info.add(one);
        info.add(two);
        info.add(three);
        info.add(four);
        info.add(first);
        info.add(second);
        info.add(third);
        info.add(fourth);
        info.add(f);
        info.add(s);
        info.add(t);
        info.add(r);
        info.add(press);
        info.add(temp);
        info.add(title);
        info.add(vol);
        info.add(STP);
        
        String name = "";
        int indicator = 0;
        if(start) {
            name = winBut.getText();
            
            
            switch (name) {
                case "Density":
                    
                    title.setText("Set Density");
                    first.setText("Input Density in g/L");
                    indicator = 1;
                    Layout(title, 70, 6);
                    Layout(end, 70,70);
                    info.setSize(260,150);
                    break;
                case "[CONC]":
                    three.setEnabled(false);
                    four.setEnabled(false);
                    title.setText("Set Concentration");
                    first.setVisible(false);
                    f.setVisible(true);
                    t.setVisible(true);
                    f.setText("Concentration in M");
                    three.setVisible(true);
                    four.setVisible(true);
                    t.setText("% by mass");
                    fourth.setVisible(true);
                    fourth.setText("& density");
                    
                    Layout(f, 3, 33);
                    Layout(t, 40, 85);
                    Layout(fourth, 75, 115);
                    
                    f.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            if(f.isSelected()) {
                                three.setEnabled(false);
                                four.setEnabled(false);
                            one.setEnabled(true);
                            } else if(t.isSelected()) {
                                three.setEnabled(true);
                                four.setEnabled(true);
                                one.setEnabled(false);
                            } 
                        }

                    });
                    t.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            if(f.isSelected()) {
                                three.setEnabled(false);
                                four.setEnabled(false);
                            one.setEnabled(true);
                            } else if(t.isSelected()) {
                                three.setEnabled(true);
                                four.setEnabled(true);
                                one.setEnabled(false);
                            } 
                        }

                    });
                    
                    Layout(title, 45, 6);
                    Layout(end, 95, 150);
                    info.setSize(260,240);
                    indicator = 2;
                    break;
                case "PV=nRT":
                    two.setVisible(true);
                    three.setVisible(true);
                    second.setVisible(true);
                    third.setVisible(true);
                    STP.setVisible(true);
                    STP.setText("STP");
                    first.setText("Pressure");
                    second.setText("Volume");
                    third.setText("Temperature");
                    Layout(first, 70, 35);
                    Layout(second, 75, n + 30);
                    Layout(third, 60, n + 55);
                    Layout(title, 85, 6);
                    Layout(end, 110, 140);
                    
                    
                    STP.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(STP.isSelected()) {
                                one.setEnabled(false); 
                                two.setEnabled(true);
                                three.setEnabled(false);
                                
                                press.setEnabled(false);
                                temp.setEnabled(false);
                                vol.setEnabled(true);
                                
                            } else {
                                one.setEnabled(true); 
                                two.setEnabled(true);
                                three.setEnabled(true);
                                
                                press.setEnabled(true);
                                temp.setEnabled(true);
                                vol.setEnabled(true);
                            }
                        }
                    });
                    
                    title.setText("Gas Information");
                    temp.setVisible(true);
                    press.setVisible(true);
                    vol.setVisible(true);
                    
                    info.setSize(343,222);
                    
                    
                    indicator = 3;
                    break;
            }
            
            
        } else {
            name = infoBut.getText();
            
            switch (name) {
                case "Density":
                    title.setText("Set Density");
                    first.setText("Input Density in g/L");
                    Layout(title, 70, 6);
                    Layout(end, 70,70);
                    info.setSize(260,150);                 
                    indicator = 4;
                    break;
                case "[CONC]":
                    title.setText("Resulting Concentration");
                    first.setText("Concentration in M");
                    Layout(title, 30, 6);
                    Layout(end, 80, 60);
                    info.setSize(260,150);
                    indicator = 5;
                    break;
                case "Select Type":
                    first.setVisible(false);
                    two.setVisible(true);
                    three.setVisible(true);
                    f.setVisible(true);
                    s.setVisible(true);
                    t.setVisible(true);
                    r.setVisible(true);
                    title.setText("Select Desired Informaiton");
                    f.setText("Pressure");
                    s.setText("Volume");
                    t.setText("Temperature");
                    r.setText("Density (in g/L)");
                    press.setVisible(true);
                    vol.setVisible(true);
                    temp.setVisible(true);
                    
                    f.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            if(f.isSelected()) {
                                one.setEnabled(false);
                                two.setEnabled(true);
                                three.setEnabled(true);
                                
                                press.setEnabled(false);
                                vol.setEnabled(true);
                                temp.setEnabled(true);
                            } else if(s.isSelected()) {
                                one.setEnabled(true);
                                two.setEnabled(false);
                                three.setEnabled(true);
                                
                                press.setEnabled(true);
                                vol.setEnabled(false);
                                temp.setEnabled(true);
                            } else if(t.isSelected()) {
                                one.setEnabled(true);
                                two.setEnabled(true);
                                three.setEnabled(false);
                                        
                                press.setEnabled(true);
                                vol.setEnabled(true);
                                temp.setEnabled(false);
                            } else if(r.isSelected() ) {
                                one.setEnabled(true);
                                two.setEnabled(false);
                                three.setEnabled(true);
                                
                                press.setEnabled(true);
                                vol.setEnabled(false);
                                temp.setEnabled(true);
                            }
                        }

                    });
                    s.addActionListener(f.getActionListeners()[0]);
                    t.addActionListener(f.getActionListeners()[0]);
                    r.addActionListener(f.getActionListeners()[0]);
                    
                    Layout(title, 50, 6);
                    Layout(f, 60, 35);
                    Layout(s, 60, 60);
                    Layout(t, 40, 85);
                    Layout(r, 90, 115);
                    Layout(end, 110, 145);
                    info.setSize(315,220);
                    indicator = 6;
                    break;
                case "STP":
                    indicator = 7;
                    break;
            }
            
        }
        final int passthrough = indicator;
        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean go = true;
                
                stoic.setEnabled(true);
                try{
                    switch(passthrough) {
                        case 1:
                            winLabel.setText("Density:" + one.getText());
                            theNumber = Double.parseDouble(one.getText());
                            //The number is density
                            break;
                        case 2:
                            if(f.isSelected()){
                                winLabel.setText(one.getText() + "M");
                                theNumber = Double.parseDouble(one.getText());
                                //the number is Molarity
                            } else if(t.isSelected()){

                                double p = Double.parseDouble(three.getText());
                                double d = Double.parseDouble(four.getText());
                                double a = Processing.percentToConcentration(p, d, chemicalDrop.getSelectedItem().toString());
                                winLabel.setText(Math.round(a) + "M");
                                theNumber = a;
                                //the number is Molarity

                            }
                            break;
                        case 3:
                            if(!STP.isSelected()) {

                                double p2 = Double.parseDouble(one.getText());
                                double v2 = Double.parseDouble(two.getText());
                                if(vol.getSelectedIndex() == 1) v2 = v2 / 1000;
                                double t2 = Double.parseDouble(three.getText());
                                double a = Processing.PVnRT(p2, v2, 0, t2, press.getSelectedItem().toString(), temp.getSelectedItem().toString(), 'n');
                                Layout(winLabel, 150, 125);
                                winLabel.setText("<html>" +p2 +" "+ press.getSelectedItem().toString()
                                        + "<br>" + v2 +" "+ vol.getSelectedItem().toString() + "<br>"
                                        + t2 +" "+ temp.getSelectedItem().toString() + "</html>");
                                theNumber = a;
                                //the number is moles
                            } else {
                                double v2 = Double.parseDouble(two.getText());
                                winLabel.setText(v2 +" "+ vol.getSelectedItem().toString());
                                theNumber = v2 / 22.4;
                                //the number is moles
                                winLabel.setText("STP");
                            }
                            break;
                        case 4:
                            infoLabel.setText("at a Desnity of " + one.getText() + "g/L");
                            theNumber2 = Double.parseDouble(one.getText());
                            //The number is density
                            break;
                        case 5:
                            infoLabel.setText(one.getText() + "M");
                            theNumber2 = Double.parseDouble(one.getText());
                            //the number is Molarity
                            break;
                        case 6:
                            double p = 0;
                            double v = 0;
                            double te = 0;
                            if(f.isSelected()){
                                //pressure
                                v = Double.parseDouble(two.getText());
                                if(vol.getSelectedIndex() == 1) v = v / 1000;
                                te = Double.parseDouble(three.getText());
                                double ans = Processing.PVnRT(0, v, moles, te, "Kpa", temp.getSelectedItem().toString(), 'P');
                                theNumber2 = ans;//the number is pressure
                                infoLabel.setText("<html>Presure (in Kpa) at <br>" + v +" "+ vol.getSelectedItem().toString() + "<br>"
                                    + te +" "+ temp.getSelectedItem().toString() + "</html>");
                            } else if(s.isSelected()){
                                //Volume
                                p = Double.parseDouble(one.getText());
                                te = Double.parseDouble(three.getText());
                                double ans = Processing.PVnRT(p, 0, moles, te, press.getSelectedItem().toString(), temp.getSelectedItem().toString(), 'V');
                                theNumber2 = ans;//the number is volume
                                infoLabel.setText("<html>Volume (in L) at <br>" + p +" "+ press.getSelectedItem().toString() + "<br>"
                                    + te +" "+ temp.getSelectedItem().toString() + "</html>");
                            } else if(t.isSelected()) {
                                //temperature
                                p = Double.parseDouble(one.getText());
                                v = Double.parseDouble(two.getText());
                                if(vol.getSelectedIndex() == 1) v = v / 1000;
                                double ans = Processing.PVnRT(p, v, moles, 0, press.getSelectedItem().toString(), "K", 'T');
                                theNumber2 = ans;//the number is temperature
                                infoLabel.setText("<html>Temperature (in K) at <br>" + p +" "+ press.getSelectedItem().toString() + "<br>"
                                    + v+" "+ vol.getSelectedItem().toString() + "</html>");
                            } else if(r.isSelected()) {
                                //Density
                                p = Double.parseDouble(one.getText());
                                te = Double.parseDouble(three.getText());
                                double ans = Processing.DPmRT(0, p, chemicalDrop2.getSelectedItem().toString(), te, press.getSelectedItem().toString(),
                                        temp.getSelectedItem().toString(), 'D');
                                theNumber2 = ans;//The Number is density
                                infoLabel.setText("<html>Density at <br>" + p +" "+ press.getSelectedItem().toString() + "<br>"
                                    + te +" "+ temp.getSelectedItem().toString() + "</html>");

                            }

                            break;
                        case 7:
                            theNumber2 = Double.parseDouble(one.getText());
                            break;
                    }
                }catch(java.lang.NumberFormatException w) {
                    JOptionPane.showMessageDialog(info, "Fill in all info");
                    go = false;
                }
                System.out.println("The Number: " + theNumber);
                System.out.println("The Number2: " + theNumber2);
                if(go) info.dispose();
            }
        });
        //setting up the window
    }
}
