package ib_project2;

import ChemNode.Node;
import ChemNode.NodeProcessing;
import ChemNode.Substance;
import java.util.ArrayList;
import java.util.Arrays;

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
    static Node mainNode;
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
    public static int countAtoms(int[][] list) {
        int count = 0;
        for(int indexValue[]: list) {
            int molecules;
            //looping through each row
            //basically index values
            molecules = indexValue[1]; //number of substances
            count = count + molecules;
            
        }
        return count;
    }
    public static ArrayList<String> CEPS(String equationField) {
        //Chemical Equation Parsing System
        String reactProd[] = equationField.split("-->|<-->");
        String reactants = reactProd[0];
        
        String pString = reactants;
        if(reactProd.length > 1) {
            
            pString = pString + reactProd[1];
            //reactants + products
        }
        
        int productAfter = reactProd[0].split("\\s+\\+\\s+|\\s|\\s+\\+").length - 1;
        
        String veryTempList[] = pString.split("\\s+\\+\\s+|\\s|\\s+\\+");
        
        
        //do this next part twice 

        ArrayList<String> chemicals = new ArrayList<>(Arrays.asList(veryTempList));
        if(reactProd.length > 2) {
            chemicals.add(0, "ERROR");
            chemicals.add(1, "More than one Arrow");
            return chemicals;
        }
        
        
        chemicals.remove(" ");
        chemicals.remove("");
        chemicals.remove("\n");
        System.out.println(chemicals.toString());
        ArrayList<String> errors = new ArrayList<>();


        String chem = "";
        String ion = "";
        String bigNumb = "";
        int count = 0;
        Node equate = null;
        
        //=====================THE LOOP==========================
        for(String a : chemicals) {
            
            String error = "";
            //for each individual chemical in this equations
            //possible strings
            //Cu(H2O)2+
            //Na+
            //Na1+
            char tempList[] = a.toCharArray();
            //Start of complex algothem====================================START
            int n = 0;

            boolean plus = false, minus = false;
            for(int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == '+') {
                   n++;
                   plus = true;
                }
                if(a.charAt(i) == '-') {
                    n++;
                    minus = true;
                }
            }

            if(plus && minus) error = error + "Error: two types of ions\n";

            //boolean ionTrue = (n == 1);Not used

            int chemNumbL = 0;
            int chemNumbF = 0;

            if(n == 1) {
                //finds ion numbers

                for(int j = tempList.length - 1; j >= 0; j--){
                    //0-5 length: 6

                    if(Character.isLetter(tempList[j]) ) {
                        chemNumbL = j;
                        break;
                    } 
                    ion = ion + tempList[j];

                    //^to figure out if's a legit ion or 
                    //just 2+ 
                }
                //end of loop


            } else if (n > 1) {
                error = error + "More than one plus or minus\n";
            } else {
                ion = "";
                chemNumbL = tempList.length - 1;
            }



           ion = new StringBuilder(ion).reverse().toString();
           ion = Processing.superScript(ion);
           System.out.println("THIS IS 'ION'" + ion);

           //SuperScript Number
           for(int i = 0; i < tempList.length; i++) { 

                if(Character.isLetter(tempList[i])) {
                   chemNumbF = i;
                   break;
                }

                bigNumb = bigNumb + tempList[i];

                if(i == tempList.length - 1) {
                    chemNumbF = tempList.length;
                }
           }                    

            for(int i = chemNumbF; i < chemNumbL + 1; i++) {
                chem = chem + tempList[i];

            }
            System.out.println("THIS IS BEING SUBSCRIPTED:" + chem);  

            //ALL OF THIS IS TO PREVENT THE COEFFICENT FROM BEING SUB'ED
            //the first number in the chemical.
            String trueBig = "";
            if(!chem.isEmpty())
            if(Character.isDigit(chem.charAt(0))) {
                //get every number up until the first character.
                boolean iloop = true;
                int il = 0;
                while (iloop) {
                    if(Character.isAlphabetic(tempList[il])) {
                        iloop = false;
                        break;
                    } else {
                        trueBig = trueBig + tempList[il];
                    }
                    il++;
                    if(veryTempList.length >= il) break;
                }

                
            }
            //END OF ALL OF THIS
                chem = Processing.subScript(chem); 


            System.out.println("||||"+ chemicals.get(count) + ion +"||||");
            
            
            if(ion.equals(Processing.superScript(bigNumb))) chemicals.set(count, chem + ion);
            else  chemicals.set(count, bigNumb + chem + ion);
            //Na+ + Cl- -->

            System.out.println("Count:" + count);
            chemicals.remove(""); 
            chemicals.remove(" ");
            
            System.out.println("Chemicals:" + chemicals.toString());
            if(!error.equals("")) errors.add(error + "@" + chemicals.get(count));
            System.out.println("Ion: " + ion);
            System.out.println("BigNumber: " + bigNumb);
            System.out.println("Chem: " + chem);
            
            //Node stuff.
            Substance s;
            if(count > productAfter) {
                s = new Substance(chemicals.get(count), ion, bigNumb, chem, false, count);   
            } else { 
                s = new Substance(chemicals.get(count), ion, bigNumb, chem, true, count); 
            }
            equate = NodeProcessing.insertAtEnd(equate, s);
            NodeProcessing.print(equate, "Equation");
            mainNode = equate;
            
            //System.out.println(s.toString());
            count++;
            chem = "";
            ion = "";
            bigNumb = "";
            
            

        }//end of loop for this individual chemical
        System.out.println("\n==========END OF THE LINE==========");
        
        
        if(errors.isEmpty())return chemicals;
        else{ 
            errors.add(0, "ERRORS");
            return errors;
        }
    }
    public static String CEDS(ArrayList<String> chemicals) {
        
        //Chemical Equation Display System
        if(chemicals.get(0).equals("ERRORS")) return chemicals.toString();
        
        int chemcount = 0;
        for(String a : chemicals) {
            boolean Hgtest = false;
            for(char c : a.toCharArray()) {
                if(Character.isLetter(c)) Hgtest = true;
            }
            if(Hgtest == false){
                if(chemcount > 0) {
                    String apples = chemicals.get(chemcount - 1);
                    chemicals.set(chemcount - 1, apples + chemicals.get(chemcount));
                    chemicals.set(chemcount, "");
                } else {
                    return "Ion number given without parent chemical"; //2+, Na,...
                    /*chemicals.set(chemcount, "");
                    System.out.println(errors.toString());*/
                }
            }
            chemcount++;
        }


        
        int i = 0;


        chemicals.remove("");
        
        Node p = mainNode;
        String StringBuilder = "";
        boolean firstP = true; boolean first = true;

            Node q = p;
        
        if(q == null) {
            return "";
        }
        boolean flag = true;
        while(flag) {
            if(first) first = false;
            else if(q.getChemical().isReact() == false && firstP) {
                StringBuilder = StringBuilder + " → ";
                firstP = false;
            } else StringBuilder = StringBuilder + " + ";
            
            StringBuilder = StringBuilder + q.getChemical().getSubstance();
                
            if(q.getNext() == null) {
                break;
            }
            q = q.getNext();
        }
        /*
        }//later use ↔ for equlibrium
        if(Products.isEmpty()) {
            return Reactants;
        } else {
           return Reactants +" → "+ Products; 
        }*/
        return StringBuilder;
    }
    
    
    //CALCULATIONS
    public static double molesToMoles(double moles, String beg, String fin) {
        NodeProcessing.search(mainNode, beg);
        int a = Integer.parseInt(NodeProcessing.lastSearch.getCo());
        NodeProcessing.search(mainNode, fin);
        int b = Integer.parseInt(NodeProcessing.lastSearch.getCo());
        
        double c = (double)a / b;
        
        return moles * c;
    }
    public static double gramsToMoles(double grams, String sub) {
        NodeProcessing.search(mainNode, sub);
        Double a = NodeProcessing.lastSearch.getMolarMass();
        double answer = grams / a;
        return answer;
    }
    public static double molesToGrams(double moles, String sub) {
        NodeProcessing.search(mainNode, sub);
        Double a = NodeProcessing.lastSearch.getMolarMass();
        double answer = moles * a;
        return answer;
    }
    public static double gramsTograms(double grams, String beg, String fin) {
        double one = gramsToMoles(grams, beg);
        double two = molesToMoles(one, beg, fin);
        double three = molesToGrams(two, fin);

        return three;        
    }
    public static double moleculesToMoles(double molecules, String sub) {
        //fix
        NodeProcessing.search(mainNode, sub);
        int coef = Integer.parseInt(NodeProcessing.lastSearch.getCo());
        return molecules / Chemistry.avogadro; 
    }
    public static double molesToAtoms(double moles, String sub) {
        NodeProcessing.search(mainNode, sub);
        int[][] asdf = NodeProcessing.lastSearch.getElementList();
        double one = moles * Chemistry.avogadro * NodeProcessing.lastSearch.getAtoms();
        
        return one;
    }
    public static double litersToMoles(double liters, double molarity) {
        return liters * molarity;
    }
    public static double molesToLiters(double moles, double molarity) {
        return moles / molarity;
    }
    public static double litersToLiters(double liters, double molarity, double molarity2) {
        double one = litersToMoles(liters, molarity);
        double two = molesToLiters(one, molarity2);
        return two;
    }
}
