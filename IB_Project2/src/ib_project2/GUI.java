package ib_project2;;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GUI {
    public JFrame main;
    public Label debugLabel;
    public Label debugLabel2;
    SpringLayout layout = new SpringLayout();
    Container pane = new Container();
    int xc, yc;
    boolean debug = true;
    
    public Label titleLabel = new Label();
    public Button[] buttons = new Button[100];
    
    public void GUI(){
        pane = new Container();
        main = new JFrame();
        newPanel(main);
        if(debug)DebugSize(main);
        
       
        
        
        
        if(debug == true) main.addMouseListener(new PanelListener());
        
        mainWindow();
    }
    //=====================================BODY==========================================//
    
    public void mainWindow() {
        titleLabel.setText("StoicCalc \n An exploration");
        Font f = new Font("Bookman Old Style", Font.PLAIN, 30);
        titleLabel.setFont(f);
        Layout(titleLabel, 88, 25);
        titleLabel.setVisible(true);
        
        //SOLVE MANY BUTTONS PROBLEM
        Button conv = new Button();
        conv = buttons[1];
        
        
        main.add(titleLabel);
        pack(main);
        main.revalidate();
        main.setVisible(true);
    }
    
    
    //===============================HELPER METHODS=====================================//
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
        j.setVisible(false);
        
        
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
        if(debug) {
            debugLabel = new Label();
            debugLabel2 = new Label();

            debugLabel.setText("asdf");
            debugLabel2.setText("asdf");
            
            pane.(25, 25);
            pane.add(debugLabel2);
            pane.add(debugLabel);
            
            
            //Layout(debugLabel2, 350, 335);
            Layout(debugLabel, 30, 335);       
               debugLabel2.setVisible(true);
            debugLabel.setVisible(true);
            
            
            
            pack(main);
            
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
        }
    }
}
