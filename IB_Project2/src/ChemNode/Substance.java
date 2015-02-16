package ChemNode;
//import ib_project2.Chemistry.*;
import ib_project2.*;

public class Substance {
    private String name;
    private String ion;
    private String coefficient;
    private String base;
    private boolean reactant; 
    private int index;
    private double molarMass;
    private int[][] elementList;//first number is row,which tells you how many 
                                //different elements are in the molecule, and
                                //second is column. there are only 2 columns, 
                                //first is atomic number, second is
                                //amount of that element that the molecule has
    
    public Substance() {
        //here is where molarMass and elementList is calculated.
    }
    
    public void setName(String s) {
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
    
    
    public String getName() {
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
        if(reactant) {
            type = "reactant";
        } else {
            type = "product";
        }
        for(int indexValue[]: elementList) {
            //looping through each row
            //basically index values
            for(int info: indexValue){
                String a = Chemistry.Hydrogen.name;
                
                //0-atomicNumber 1-number of that element in the substance
            }
        }
        
        return "Full Name: " + name
                +"\nIon: " + ion 
                +"\ncoefficient: " + coefficient 
                +"\nbase: " + base
                +"\nIt is a " + type
                +"\nIndex: " + index
                +"\n Molar Mass " + molarMass + "g/mol"
                +"\nit is made up of";
        
        
                
                
    }
    
    private String placed(int i) {
        switch(i){
            case 1:return "1st";
            case 2:return "2nd";
            case 3:return "3rd";
            default:return i+ "th";
        }
    }
    
    
}
