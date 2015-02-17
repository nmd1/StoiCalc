package ChemNode;

public class Node {
    public Substance chem;
    public Node next; 
    
    public void setNext(Node n) {
        next = n;
    }
    public Node getNext() {
        return next;
    }
    
    public void setChemical(Substance s) {
        chem = s;
    }
    public Substance getChemical() {
        return chem;
    }
    
}
