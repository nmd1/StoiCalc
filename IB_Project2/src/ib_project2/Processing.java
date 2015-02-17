package ib_project2;

import java.util.ArrayList;

/**
 *
 * @author Nehemiah
 * 
 * Contains processes:
 * Stoic processing
 * Equilibrium  processing
 * String processing
 * 
 */
public class Processing {
    
    public static String atomicSearch(int i) {
        for(Elements e : Chemistry.elements) {
            if(e.atomicNumber == i) return e.name;
        }
        return "Number not found";
    }
    
    public static int symbolToAtomic(String Sy) {
        for(Elements e : Chemistry.elements) {
            if(e.symbol.equals(Sy)) return e.atomicNumber;
        }
        return 0;
    }
    
    public static String superScript(String str) {
        str = str.replaceAll("0", "⁰");
        str = str.replaceAll("1", "¹");
        str = str.replaceAll("2", "²");
        str = str.replaceAll("3", "³");
        str = str.replaceAll("4", "⁴");
        str = str.replaceAll("5", "⁵");
        str = str.replaceAll("6", "⁶");
        str = str.replaceAll("7", "⁷");
        str = str.replaceAll("8", "⁸");
        str = str.replaceAll("9", "⁹");
        str = str.replaceAll("\\+","⁺"); 
        str = str.replaceAll("-","⁻");  
        return str;
    }
    public static String subScript(String str) {
        str = str.replaceAll("0", "₀");
        str = str.replaceAll("1", "₁");
        str = str.replaceAll("2", "₂");
        str = str.replaceAll("3", "₃");
        str = str.replaceAll("4", "₄");
        str = str.replaceAll("5", "₅");
        str = str.replaceAll("6", "₆");
        str = str.replaceAll("7", "₇");
        str = str.replaceAll("8", "₈");
        str = str.replaceAll("9", "₉");
        return str;
    }
    public static String normalScript(String str) {
        str = str.replaceAll("₀","0");
        str = str.replaceAll("₁","1");
        str = str.replaceAll("₂","2");
        str = str.replaceAll("₃","3");
        str = str.replaceAll("₄","4");
        str = str.replaceAll("₅","5");
        str = str.replaceAll("₆","6");
        str = str.replaceAll("₇","7");
        str = str.replaceAll("₈","8");
        str = str.replaceAll("₉","9");
        str = str.replaceAll("⁰","0");
        str = str.replaceAll("¹","1");
        str = str.replaceAll("²","2");
        str = str.replaceAll("³","3");
        str = str.replaceAll("⁴","4");
        str = str.replaceAll("⁵","5");
        str = str.replaceAll("⁶","6");
        str = str.replaceAll("⁷","7");
        str = str.replaceAll("⁸","8");
        str = str.replaceAll("⁹","9");
        str = str.replaceAll("⁺","\\+"); 
        str = str.replaceAll("⁻","-");  
        return str;
    }
    public static char normalScript(char cha) {
        String temp = cha + "";
        String retu = normalScript(temp);
        char returned = retu.charAt(0);
        return returned;
    }
    public static int[][] elementLister(String substance) {
        int[][] apples;
        ArrayList<String> elementNumbs = new ArrayList<>();
        int count = 0;
        String builder = "";
        //symbolToAtomic(String Sy)
        for(char c : substance.toCharArray()) {
            if(Character.isUpperCase(c) && !builder.isEmpty()) {
                elementNumbs.add(builder);
                builder = "";
            }
            builder = builder + c;
            
        }
        elementNumbs.add(builder);
        
        apples = new int[elementNumbs.size()][2];
        
        for(String s: elementNumbs) {
            s = normalScript(s);
            String symbol = "";
            String number = "";
            for(char ca : s.toCharArray()) {
                if(Character.isLetter(ca)) {
                    symbol = symbol + ca;
                }
                if(Character.isDigit(ca)) {
                    number = number + ca;
                }
            }
            
            apples[count][0] = Processing.symbolToAtomic(symbol);
            if(number.isEmpty()) apples[count][1] = 1;
            else apples[count][1] = Integer.parseInt(number);
            count++;
        }
        
        return apples;
    }
    public static double molarMass(int[][] list) {
        double mass = 0;
        for(int binary[] : list) {
            double tempMass = 0;
            for(Elements e : Chemistry.elements) {
                if(e.atomicNumber == binary[0]) tempMass = e.atomicWeight;
            }
            mass = mass + (tempMass * binary[1]);
        }
        return mass;
    }
}
