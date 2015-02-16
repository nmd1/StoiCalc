package ib_project2;

/**
 *
 * @author nemo
 * Chemical constants get put in here.
 * periodic table! and other pieces of information 
 */
public class Elements {
    public String name;
    public static String symbol;
    public static int atomicNumber;
    public static double atomicWeight;
    public static double density;
    
    public Elements(String named, String sy, int p, double gMol, double gL) {
        name = named;
        symbol = sy;
        atomicNumber = p;
        atomicWeight = gMol;
        density = gL;
        
    }
    
}
