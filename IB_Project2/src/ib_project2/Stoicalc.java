package ib_project2;

import javax.swing.*;

public class Stoicalc {
    static GUI gui = new GUI();
    static Chemistry chemistry = new Chemistry();
    static Graphing graphing = new Graphing();
    static Processing processing = new Processing();
   
    public static void main(String[] args) {
        //and so, the STOIC CALC program begins.
        
        //Major Clusters:
        //GUI: handles all of the visual information and displaying things to the user:
        //String processing: process chemical equations 
        //Chem bank: contains data for chemical calculations.
        //Maths: handles the compelx calculations
        //Graphing: If there is time: graphs for chemical data.
        
        //This file? Handles opening and closing the program.
        //maybe saved data will be kept here? who knows.
        
        gui.GUI();
    }
}
