package ib_project2;;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class GUI {
    public JFrame main, stoic;
    public JLabel debugLabel, debugLabel2;
    SpringLayout layout = new SpringLayout();
    Container pane = new Container(), sPane;
    TextField equation;
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
        
        
        final JLabel output = new JLabel();
        output.setText("This is what the JLabel looks like now: Empty");
        output.setSize(10,50);
        
        equation = new TextField();
        equation.setColumns(50);
     
        Layout(equation, 100, 150);
        Layout(output, 100, 100);
        equation.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                char z = e.getKeyChar();
                //System.out.print(z);
                boolean good = (z == '+') || (z == '-') || (z == '.') ||
                        (z >= 48 & z <= 57) || (z >= 65 & z <= 90) 
                        || (z >= 97 & z <= 122) || (z == 91) || (z == 93)
                        || (z == 60) || (z == 62);
                boolean badGood = (z == 81) || (z == 113) ||
                        (z == 74) || (z == 106);
                
                if(!good) e.consume();
                if(badGood) e.consume();
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
                
                //YOU ARE WORKING HERE+======================================================<<<<<<<<<<<<<<<
                //output.setText(equation.getText());
                String templist[] = equation.getText().split("-->|\\+|<-->|\\s+");
                ArrayList<String> chemicals = new ArrayList<>(Arrays.asList(templist));
                int clear = 0;
                /*for(String a : chemicals) {
                    if(a.equals("") || a.equals(" ")) {
                        chemicals.remove(clear);
                    }
                    clear++;
                }*/
                System.out.println(chemicals.toString());
                

                Stack dump = new Stack();
                
            }
        });
        stoic.add(equation);
        stoic.add(output);
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
                    Point d = j.getLocationOnScreen();

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
