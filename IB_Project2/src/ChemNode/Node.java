package ChemNode;

/**
 * The Class that sets up the structures of the node in the equation linked list 
 * @author nemo
 */
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
