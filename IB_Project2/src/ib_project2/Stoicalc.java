package ib_project2;

import Stoic.Processing;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


/**
 * Main method for the program. Also handles the beautification of the GUI window.
 * @author nemo
 */
public class Stoicalc {
    static GUI gui = new GUI();
    //static Elements chemistry = new Elements();
    static Graphing graphing = new Graphing();
    static Processing processing = new Processing();
   
    static double versionNumber = 1.02;
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //and so, the STOIC CALC program begins.
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Stoicalc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Stoicalc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Stoicalc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Stoicalc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*DEBUG
        String test = "C8H10N4O2";
        
        int[][] tested = Processing.elementLister(test);
        
        for(int row[] : tested) {
            for(int c: row){
                System.out.print(c + "   ");
            }
            System.out.println();
        }
        
        System.out.println(Processing.molarMass(tested) + "g/mol");
        //DEBUG*/
        
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
