package ib_project2;

/**
 *
 * @author nemo
 */
public class Chemistry {
    public static Elements elements[] = {new Elements("Null", "Null", 0, 0, 0.0),
        new Elements("Hydrogen", "H", 1, 1.0079, 0.09),
        new Elements("Helium", "He", 2, 4.0026, 0.18),
        new Elements("Lithium", "Li", 3, 6.941, 0.53),
        
        new Elements("Helium", "He", 4, 9.0122, 0.18),
        new Elements("Helium", "He", 5, 10.811, 0.18),
        new Elements("Helium", "He", 6, 12.0107, 0.18),
        new Elements("Helium", "He", 7, 14.0067, 0.18),
        new Elements("Helium", "He", 8, 15.9994, 0.18),
        new Elements("Helium", "He", 9, 18.9984, 0.18),
        new Elements("Helium", "He", 10, 20.1797, 0.18),
        new Elements("Hydrogen", "H", 11, 1.0079, 0.09),
        new Elements("Helium", "He", 12, 4.0026, 0.18),
        new Elements("Helium", "He", 13, 4.0026, 0.18),
        new Elements("Helium", "He", 14, 4.0026, 0.18),
        new Elements("Helium", "He", 15, 4.0026, 0.18),
        new Elements("Helium", "He", 16, 4.0026, 0.18),
        new Elements("Helium", "He", 17, 4.0026, 0.18),
        new Elements("Helium", "He", 18, 4.0026, 0.18),
        new Elements("Helium", "He", 19, 4.0026, 0.18),
        new Elements("Helium", "He", 20, 4.0026, 0.18),
        new Elements("Hydrogen", "H", 21, 1.0079, 0.09),
        new Elements("Helium", "He", 22, 4.0026, 0.18),
        new Elements("Helium", "He", 23, 4.0026, 0.18),
        new Elements("Helium", "He", 24, 4.0026, 0.18),
        new Elements("Helium", "He", 25, 4.0026, 0.18),
        new Elements("Helium", "He", 26, 4.0026, 0.18),
        new Elements("Helium", "He", 27, 4.0026, 0.18),
        new Elements("Helium", "He", 28, 4.0026, 0.18),
        new Elements("Helium", "He", 29, 4.0026, 0.18),
        new Elements("Helium", "He", 30, 4.0026, 0.18),
        new Elements("Hydrogen", "H", 31, 1.0079, 0.09),
        new Elements("Helium", "He", 32, 4.0026, 0.18),
        new Elements("Helium", "He", 33, 4.0026, 0.18),
        new Elements("Helium", "He", 34, 4.0026, 0.18),
        new Elements("Helium", "He", 35, 4.0026, 0.18),
        new Elements("Helium", "He", 36, 4.0026, 0.18),
        new Elements("Helium", "He", 37, 4.0026, 0.18),
        new Elements("Helium", "He", 38, 4.0026, 0.18),
        new Elements("Helium", "He", 39, 4.0026, 0.18),
        new Elements("Helium", "He", 40, 4.0026, 0.18),
        new Elements("Hydrogen", "H",41, 1.0079, 0.09),
        new Elements("Helium", "He", 42, 4.0026, 0.18),
        new Elements("Helium", "He", 43, 4.0026, 0.18),
        new Elements("Helium", "He", 44, 4.0026, 0.18),
        new Elements("Helium", "He", 45, 4.0026, 0.18),
        new Elements("Helium", "He", 46, 4.0026, 0.18),
        new Elements("Helium", "He", 47, 4.0026, 0.18),
        new Elements("Helium", "He", 48, 4.0026, 0.18),
        new Elements("Helium", "He", 49, 4.0026, 0.18),
        new Elements("Helium", "He", 50, 4.0026, 0.18),
        new Elements("Hydrogen", "H", 51, 1.0079, 0.09),
        new Elements("Helium", "He", 52, 4.0026, 0.18),
        new Elements("Helium", "He", 53, 4.0026, 0.18),
        new Elements("Helium", "He", 54, 4.0026, 0.18),
        new Elements("Helium", "He", 55, 4.0026, 0.18),
        new Elements("Helium", "He", 56, 4.0026, 0.18),
        new Elements("Helium", "He", 57, 4.0026, 0.18),
        new Elements("Helium", "He", 58, 4.0026, 0.18),
        new Elements("Helium", "He", 59, 4.0026, 0.18),
        new Elements("Helium", "He", 60, 4.0026, 0.18),
        new Elements("Hydrogen", "H", 61, 1.0079, 0.09),
        new Elements("Helium", "He", 62, 4.0026, 0.18),
        new Elements("Helium", "He", 63, 4.0026, 0.18),
        new Elements("Helium", "He", 64, 4.0026, 0.18),
        new Elements("Helium", "He", 65, 4.0026, 0.18),
        new Elements("Helium", "He", 66, 4.0026, 0.18),
        new Elements("Helium", "He", 67, 4.0026, 0.18),
        new Elements("Helium", "He", 68, 4.0026, 0.18),
        new Elements("Helium", "He", 69, 4.0026, 0.18),
        new Elements("Helium", "He", 70, 4.0026, 0.18),
        new Elements("Hydrogen", "H", 71, 1.0079, 0.09),
        new Elements("Helium", "He", 72, 4.0026, 0.18),
        new Elements("Helium", "He", 73, 4.0026, 0.18),
        new Elements("Helium", "He", 74, 4.0026, 0.18),
        new Elements("Helium", "He", 75, 4.0026, 0.18),
        new Elements("Helium", "He", 76, 4.0026, 0.18),
        new Elements("Helium", "He", 77, 4.0026, 0.18),
        new Elements("Helium", "He", 78, 4.0026, 0.18),
        new Elements("Helium", "He", 79, 4.0026, 0.18),
        new Elements("Helium", "He", 80, 4.0026, 0.18),
        new Elements("Hydrogen", "H", 81, 1.0079, 0.09),
        new Elements("Helium", "He", 82, 4.0026, 0.18),
        new Elements("Helium", "He", 83, 4.0026, 0.18),
        new Elements("Helium", "He", 84, 4.0026, 0.18),
        new Elements("Helium", "He", 85, 4.0026, 0.18),
        new Elements("Helium", "He", 86, 4.0026, 0.18),
        new Elements("Helium", "He", 87, 4.0026, 0.18),
        new Elements("Helium", "He", 88, 4.0026, 0.18),
        new Elements("Helium", "He", 89, 4.0026, 0.18),
        new Elements("Helium", "He", 90, 4.0026, 0.18),
        new Elements("Hydrogen", "H", 91, 1.0079, 0.09),
        new Elements("Helium", "He", 92, 4.0026, 0.18),
        new Elements("Helium", "He", 93, 4.0026, 0.18),
        new Elements("Helium", "He", 94, 4.0026, 0.18),
        new Elements("Helium", "He", 95, 4.0026, 0.18),
        new Elements("Helium", "He", 96, 4.0026, 0.18),
        new Elements("Helium", "He", 97, 4.0026, 0.18),
        new Elements("Helium", "He", 98, 4.0026, 0.18),
        new Elements("Helium", "He", 99, 4.0026, 0.18),
        new Elements("Helium", "He", 100, 4.0026, 0.18),
        
    
    
    
    };
    }
    //static:accessed via Chemistry.Hydrogen
    //nonstatic: accessed via Chemistry c = new Chemistry(); c.Hydrigen;
    //there's a SHITTON OF ELELEMNTS OHMYGOD
    public static void elementCreation() {
        
    } 


}
