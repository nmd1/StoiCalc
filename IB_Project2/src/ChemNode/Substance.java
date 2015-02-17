package ChemNode;
//import ib_project2.Chemistry.*;
import ib_project2.*;
import java.util.ArrayList;

public class Substance {
    //for example, 3C6H12O6+
    private String name;
    private String ion;
    private String coefficient;
    private String base;
    private boolean reactant; 
    private int index;
    private final double molarMass;
    private final int[][] elementList;//first number is row,which tells you how many 
                                //different elements are in the molecule, and
                                //second is column. there are only 2 columns, 
                                //first is atomic number, second is
                                //amount of that element that the molecule has
    
    public Substance(String sub, String ion2, String co, String based, boolean reac, int i) {
        name = sub;
        ion = ion2;
        if(co.isEmpty()) coefficient = "1";
        else coefficient = co;
        base = based;
        reactant = reac;
        index = i;
        elementList = Processing.elementLister(base);
        molarMass = Processing.molarMass(elementList);
        //here is where molarMass and elementList is calculated.
    }
    
    public void setSubstance(String s) {
        name = s;
    }
    
    public void setIon(String i) {
        ion = i;
    }
    
    public void setCo(String c) {
        coefficient = c;
    }
    
    public void setBase(String b) {
        base = b;
    }
    public void setReact(boolean r) {
        reactant = r;
        //if true, then the substance is a reactant
        //if false, thne the substance is a product
    }
    public void setIndex(int i){
        index = i;
    }
    
    
    public String getSubstance() {
        return name;
    }
    
    public String getIon() {
        return ion;
    }
    
    public String getCo() {
        return coefficient;
    }
    
    public String getBase() {
        return base;
    }
    public boolean isReact() {
        return reactant;
        //if true, then the substance is a reactant
        //if false, thne the substance is a product
    }
    public int getIndex(){
        return index;
    }
    public double getMolarMass(){
        return molarMass;
    }
    public int[][] getElementList() {
        return elementList;
    }
    
    
    @Override
    public String toString() {
        String type = "";
        String builder = "This substance contains ";
        if(reactant) {
            type = "reactant";
        } else {
            type = "product";
        }
        for(int indexValue[]: elementList) {
            int count = 0;
            String elementName;
            int molecules;
            //looping through each row
            //basically index values
            elementName = Processing.atomicSearch(indexValue[0]);
            molecules = indexValue[1];
            builder = builder + molecules + " " + elementName + " molecules \n";
            
        }
        
        return "Full Name: " + name
                +"\nIon: " + ion 
                +"\ncoefficient: " + coefficient 
                +"\nbase: " + base
                +"\nIt is a " + type
                +"\nIndex: " + index
                +"\n Molar Mass " + molarMass + "g/mol"
                +"\n" + builder;
        
                
    }
    
    

    
    
}
