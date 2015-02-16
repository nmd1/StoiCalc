package ib_project2;

/**
 *
 * @author nemo
 */
public class Chemistry {
    //static:accessed via Chemistry.Hydrogen
    //nonstatic: accessed via Chemistry c = new Chemistry(); c.Hydrigen;
    //there's a SHITTON OF ELELEMNTS OHMYGOD
    public static Elements elements[] = {new Elements("Electron", "e", 0, 5.4857990946 * Math.pow(10, -4), -1),
        new Elements("Hydrogen", "H", 1, 1.0079, 0.09),
        new Elements("Helium", "He", 2, 4.0026, 0.18),//Noble gas
        
        
        
        new Elements("Lithium", "Li", 3, 6.941, 0.53),
        new Elements("Beryllium", "Be", 4, 9.0122, 1.85),
        new Elements("Boron", "B", 5, 10.811, 2.34),
        new Elements("Carbon", "C", 6, 12.0107, 2.26),
        new Elements("Nitrogen", "N", 7, 14.0067, 1.25),
        new Elements("Oxygen", "O", 8, 15.9994, 1.43),
        new Elements("Fluorine", "F", 9, 18.9984, 1.7),
        new Elements("Neon", "Ne", 10, 20.1797, 0.9),//NOBLE GAS
        
        
        
        new Elements("Sodium", "Na", 11, 22.9897, 0.97),
        new Elements("Magnesium", "Mg", 12, 24.305, 1.74),
        new Elements("Aluminum", "Al", 13, 26.9815, 2.7),
        new Elements("Silicon", "Si", 14, 28.0855, 2.33),
        new Elements("Phosphorus", "P", 15, 30.9738, 1.82),
        new Elements("Sulfur", "S", 16, 32.065, 2.07),
        new Elements("Chlorine", "Cl", 17, 35.453, 3.21),//heh.
        new Elements("Argon", "Ar", 18, 39.948, 1.78),//NOBLE GAS
        
        
        
        new Elements("Potassium", "K", 19, 39.0983, 0.86),
        new Elements("Calcium", "Ca", 20, 40.078, 1.55),
        
        new Elements("Scandium", "Sc", 21, 44.9559, 2.99),
        new Elements("Titanium", "Ti", 22, 47.867, 4.54),
        new Elements("Vanadium", "V", 23, 50.9415, 6.11),
        new Elements("Chromium", "Cr", 24, 51.9961, 7.19),
        new Elements("Manganese", "Mn", 25, 54.938, 7.43),
        new Elements("Iron", "Fe", 26, 55.845, 7.87),
        new Elements("Cobalt", "Co", 27, 58.9332, 8.9),
        new Elements("Nickel", "Ni", 28, 58.6934, 8.9),
        new Elements("Copper", "Cu", 29, 63.546, 8.96),
        new Elements("Zinc", "Zn", 30, 65.39, 7.13),
        
        new Elements("Gallium", "Ga", 31, 69.723, 5.91),
        new Elements("Germanium", "Ge", 32, 72.64, 5.32),
        new Elements("Arsenic", "As", 33, 74.9216, 5.72),
        new Elements("Selenium", "Se", 34, 78.96, 4.79),
        new Elements("Bromine", "Br", 35, 79.904, 3.12),
        new Elements("Krypton", "Kr", 36, 83.8, 3.75),//Noble gas
        
        
        
        new Elements("Rubidium", "Rb", 37, 85.4678, 1.63),
        new Elements("Strontium", "Sr", 38, 87.62, 2.54),
        new Elements("Yttrium", "Y", 39, 88.9059, 4.47),
        new Elements("Zirconium", "Zr", 40, 91.224, 6.51),
        
        new Elements("Niobium", "Nb",41, 92.9064, 8.57),
        new Elements("Molybdenum", "Mo", 42, 95.94, 10.22),
        new Elements("Technetium", "Tc", 43, 98, 11.5),
        new Elements("Ruthenium", "Ru", 44, 101.07, 12.37),
        new Elements("Rhodium", "Rh", 45, 102.9055, 12.41),
        new Elements("Palladium", "Pd", 46, 106.42, 12.02),
        new Elements("Silver", "Ag", 47, 107.8682, 10.5),
        new Elements("Cadmium", "Cd", 48, 112.411, 8.65),
        new Elements("Indium", "In", 49, 114.818, 7.31),
        new Elements("Tin", "Sn", 50, 118.71, 7.31),
        
        new Elements("Antimony", "Sb", 51, 121.76, 6.68),
        new Elements("Tellurium", "Te", 52, 127.6, 6.24),
        new Elements("Iodine", "I", 53, 126.9045, 4.93),
        new Elements("Xenon", "Xe", 54, 131.293, 5.9),//noble gas
        
        
        
        new Elements("Cesium", "Cs", 55, 132.9055, 1.87),
        new Elements("Barium", "Ba", 56, 137.327, 3.59),
        new Elements("Lanthanum", "La", 57, 138.9055, 6.15),
        new Elements("Cerium", "Ce", 58, 140.116, 6.77),
        new Elements("Praseodymium", "Pr", 59, 140.9077, 6.77),
        new Elements("Neodymium", "Nd", 60, 144.24, 7.01),
        
        new Elements("Promethium", "Pm", 61, 145, 7.3),
        new Elements("Samarium", "Sm", 62, 150.36, 7.52),
        new Elements("Europium", "Eu", 63, 151.964, 5.24),
        new Elements("Gadolinium", "Gd", 64, 157.25, 7.9),
        new Elements("Terbium", "Tb", 65, 158.9253, 8.23),
        new Elements("Dysprosium", "Dy", 66, 162.5, 8.55),
        new Elements("Holmium", "Ho", 67, 164.9303, 8.8),
        new Elements("Erbium", "Er", 68, 167.259, 9.07),
        new Elements("Thulium", "Tm", 69, 168.9342, 9.32),
        new Elements("Ytterbium", "Yb", 70, 173.04, 6.9),
        
        new Elements("Lutetium", "Lu", 71, 174.967, 9.84),
        new Elements("Hafnium", "Hf", 72, 178.49, 13.31),
        new Elements("Tantalum", "Ta", 73, 180.9479, 16.65),
        new Elements("Tungsten", "W", 74, 183.84, 19.35),
        new Elements("Rhenium", "Re", 75, 186.207, 21.04),
        new Elements("Osmium", "Os", 76, 190.23, 22.6),
        new Elements("Iridium", "Ir", 77, 192.217, 22.4),
        new Elements("Platinum", "Pt", 78, 195.078, 21.45),
        new Elements("Gold", "Au", 79, 196.9665, 19.32),
        new Elements("Mercury", "Hg", 80, 200.59, 13.55),
        
        new Elements("Thallium", "Tl", 81, 204.3833, 11.85),
        new Elements("Lead", "Pb", 82, 207.2, 11.35),
        new Elements("Bismuth", "Bi", 83, 208.9804, 9.75),
        new Elements("Polonium", "Po", 84, 209, 9.3),
        new Elements("Astatine", "At", 85, 210, -1),
        new Elements("Radon", "Rn", 86, 222, 9.73),//Noble Gas
        
        
        
        new Elements("Francium", "Fr", 87, 223, -1),
        new Elements("Radium", "Ra", 88, 226, 5.5),
        new Elements("Actinium", "Ac", 89, 227, 10.07),
        new Elements("Thorium", "Th", 90, 232.0381, 11.72),
        
        new Elements("Protactinium", "Pa", 91, 231.0359, 15.4),
        new Elements("Uranium", "U", 92, 238.0289, 18.95),
        new Elements("Neptunium", "Np", 93, 237, 20.2),//no longer natural
        new Elements("Plutonium", "Pu", 94, 244, 19.84),
        new Elements("Americium", "Am", 95, 243, 13.67),
        new Elements("Curium", "Cm", 96, 247, 13.5),
        new Elements("Berkelium", "Bk", 97, 247, 14.78),
        new Elements("Californium", "Cf", 98, 251, 15.1),
        new Elements("Einsteinium", "Es", 99, 252, -1),
        new Elements("Fermium", "Fm", 100, 257, -1),
        
        //Above information obtained from
        //http://www.science.co.il/PTelements.asp
        
        //below information obtained from
        //http://en.wikipedia.org/wiki/List_of_elements
        
        new Elements("Mendelevium", "Md", 101, 258, 123.45),
        new Elements("Nobelium", "No", 102, 259, 123.45),
        new Elements("Lawrencium", "Lr", 103, 266, 123.45),
        new Elements("Rutherfordium", "Rf", 104, 267, 23.2),
        new Elements("Dubnium", "Db", 105, 268, 29.3),
        new Elements("Seaborgium", "Sg", 106, 269, 35.0),
        new Elements("Bohrium", "Bh", 107, 270, 37.1),
        new Elements("Hassium", "Hs", 108, 269, 40.7),
        new Elements("Meitnerium", "Mt", 109, 278, 37.4),
        new Elements("Darmstadtium", "Ds", 110, 281, 34.8),
        
        new Elements("Roentgenium", "Rg", 111, 281, 28.7),
        new Elements("Copernicium", "Cn", 112, 285, 123.7),
        new Elements("Ununtrium", "Uut", 113, 286, 16),//placename
        new Elements("Flerovium", "Fl", 114, 289, 14),
        new Elements("Ununpentium", "Uup", 115, 289, 13.5),//placename
        new Elements("Livermorium", "Lv", 116, 293, 12.9),
        new Elements("Ununseptium", "Uus", 117, 294, 7.2),//placename
        new Elements("Ununoctium", "Uuo", 118, 294, 5.0)//noble gas(noble solid?)  
    
    };
    //size 118
    //length 119
}
    

