package ib_project2;;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GUI {
    public JFrame main;
    public Label debugLabel = new Label();
    public Label debugLabel2 = new Label();
    SpringLayout layout = new SpringLayout();
    Container pane = new Container();
    int xc, yc;
    boolean debug = true;
    
    public Label titleLabel = new Label();
    public Button[] buttons = new Button[100];
    
    public void GUI(){
        main = new JFrame();
        main.setTitle("Main Menu");
        newPanel(main);
        main.setSize(565,402);
        main.setVisible(true);
        main.setResizable(true);
        main.setLocation(458, 235);
        
        if(debug)DebugSize(main);
        
        debugLabel2.setVisible(true);
        debugLabel.setVisible(true);
        
        
        main.add(pane);
        pane.setLayout(layout);
        
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
    }
    
    
    //===============================HELPER METHODS=====================================//
    private void pack(JFrame J){
        J.pack();
        main.setSize(565,402);
    }
    
    private void Layout(Component c, int x, int y) {
        layout.putConstraint(SpringLayout.WEST, c,x, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, c,y,SpringLayout.NORTH, pane);
    }
    
    private void newPanel(JFrame j) {
        
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);
        j.setResizable(true);
        /*
        if(j.getTitle().equals("Main Menu")) {
            j.setVisible(true);
        } else {
            j.setVisible(false);
        }*/
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
            pane.add(debugLabel2);
            Layout(debugLabel2, 350, 335);
            pane.add(debugLabel);
            Layout(debugLabel, 30, 335);
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
