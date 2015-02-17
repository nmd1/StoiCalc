package ChemNode;

import java.util.Scanner;

/**
 *
 * @author nemo
 */
public class NodeProcessing {
    public static Substance lastSearch;
    public static int lastCount = -2;
    public static long lastSortTime = -1;
    
    public static Node insertAtEnd(Node p, Substance s) { //p represents the entire list
        Node newNode = new Node();
        //newPlanet = createNewPlanet();
        newNode.setChemical(s); //placed into node
        

        //if empty assign p to node else assign p at end of list
        if(p == null) {
            p = newNode;
            //the new node is passed into the first node
            //so the first node points to the new node
            
            /*how does the first statement lead to the second though....*/
        } else {
            Node q = p;
            //traversing (or advancing) the pointer
            while( q.getNext() != null) { //loop until the last node points to nothing
                q = q.getNext(); //advances a pointer
                
            }
            q.setNext(newNode);
        }
        return p;
    }
    
    public static Node insertAnywhere(Node p, Substance s, int after) {
        //0 is to be the first node,
        //1 is after the first node, etc.
        if(p == null) {
            return insertAtEnd(p,s);
        } else {
        Node newNode = new Node();
        Node q = new Node();
        
        newNode.setChemical(s);
        
        
        System.out.println("Insert This new Planet after which planet? (1 for first): ");
        
        q = p;
        
        if(after == 0){
            newNode.setNext(p);
            p = newNode;
            return p;
        }
        
        //test to see if it exists:
        boolean loop = true;
        Node j = p;
        while(loop) {
            if(j.getChemical().getIndex() == after) {
                loop = false;
            } else {
                if(j.getNext() == null){ 
                System.out.println("Error 404: Planet not found"); 
                return p;
                }
                j = j.getNext(); 
            }
        }
        
        if(!(q.getChemical().getIndex() == after)){ //if the first item does not equal the search
            
        //q = q.getNext();
            
        while( !(q.getNext().getChemical().getIndex() == after)) {
            q = q.getNext();
        }
        
            //if the next node is not earth   

        
        }
        //q ends up referencing earth.
        
        //now q equals the node whose planet name is the one we're looking for
        if(q.getNext().getChemical().getIndex() == after) {
            q = q.getNext();
            //if the next planet name equals the search name
            newNode.setNext(q.getNext());
            q.setNext(newNode);
            //node connection set up.
        } else {
            System.out.println("ERROR 404: Not Found");
            return p;
        }
    
        /*leave p where it is
        //create dummy q
        //advance q until we find what we looking for
        //if you hit null, print an error or not found
        //once q gets to the place where it needs to be, put new node there
        //make the new node point to the next thing
        //new node.setNext(q.getnext)
        //then move the list to point to new node
        q.setNext(newNode)*/
        return p;
        }
    }
    
    public static Node search(Node p, String name) {
        
        
        Node q = p;
        boolean loop = true;
        int counter = 0;
        while(loop) {
            counter++; //start off with 1
            if(q.getChemical().getSubstance().equalsIgnoreCase(name)) {
                lastSearch = q.getChemical();
                loop = false;
            } else {
                if(q.getNext() == null){ 
                lastSearch = null;//not found 
                return p;
                }
                q = q.getNext(); 
            }
        }
        return p;
    }
    
    public static Node count(Node p) {
        Node q = p;
        boolean loop = true;
        int counter = 0;
        
        if(q == null) {
            //There are no chemicals on this list
            lastCount = -1;
            return p;
        }
        while(loop) {
            counter++; //start off with 1
            if(q.getNext() == null) {
                lastCount = counter;
                loop = false;
            } else {
                q = q.getNext(); 
            }
        }
        return p;
    }
   
    
    public static Node sort(Node p) {
        //SEEING IF THE LIST IS EMPTY
        if(p == null) {
            //nothing to sort.
            return p;
        }
        long start = System.nanoTime();
        
        //SORT (insertion)
        Node head = p;
        if (head == null || head.next == null)
            return head;
 
        Node newHead = p;

        Node pointer = head.next;

        // loop through each element in the list
        while (pointer != null) { //second still normal
                // insert this element to the new list
            Node innerPointer = newHead;
            Node next = pointer.next;
            if (pointer.getChemical().getIndex() <= newHead.getChemical().getIndex()) {
                Node oldHead = newHead;
                newHead = pointer;
                newHead.next = oldHead;
            } else {
                while (innerPointer.next != null) { //in here
                    if (pointer.getChemical().getIndex() > innerPointer.getChemical().getIndex() && pointer.getChemical().getIndex()
                            <= innerPointer.next.getChemical().getIndex()) {
                        Node oldNext = innerPointer.next;
                        innerPointer.next = pointer;
                        pointer.next = oldNext.next; //pointer.next = oldNext;
                    } //within this loop

                    innerPointer = innerPointer.next;
                }

                if (innerPointer.next == null && pointer.getChemical().getIndex() > innerPointer.getChemical().getIndex()) {
                    innerPointer.next = pointer;
                    pointer.next = null;
                }
            }

            pointer = next;
        }
 
		
        //END SORT
        //this works lord knows how
        
        
        long end = System.nanoTime();
        
        lastSortTime = (end - start);
        
        return newHead;
    }
    
    
    public static Node delete(Node p, int index) {    
        System.out.println("Search for chem Location");
        int counter = 0;
            
            Node i = p;
            while(i.getNext() != null) {
                if(i.getChemical().getIndex() == index){
                    index = i.getChemical().getIndex();
                    //it exists!
                } else {
                    if(i.getNext() == null) {System.out.println("Delete Unsuccessful");return p;} //delete unsucessful;
                }
                i = i.getNext();
            }            
        
        //index = 1;//get rid of this for any of the above to be revelent
        //System.out.println(index);
        //node stuffs//
        counter = 1;
        if(index == 1) {
           p = p.getNext(); 
        } else {
            
            Node j = p, q = p;
            q = q.getNext(); //making it the leader
            counter++; //equals 2
            //loop until q finds the index
            while(counter != index) {
                q = q.getNext();
                j = j.getNext();
                counter++;
            }
            j.setNext(q.getNext());
        }
        // AS MR.BALCAR ABOUT THIS!!!!
        //advance p 
        //advance p again
        //loop {
        // advance p AND q
        //when p hits the thing you want, stap loop
        //}
        //q.setNext(p.getNext())
        return p;
    }
    
    public static void print(Node p){
        while(p != null) {
            System.out.println(p.getChemical().toString());
            p = p.getNext();
        }
    }
    
    
    public static void print(Node p, String s) {
        Node q = p;
        
        if(q == null) {
            System.out.print("[Null]" );
            return;
        }
        boolean flag = true;
        System.out.print(s + "-->");
        while(flag) {
            String tester = "";
            if(q.getChemical().isReact()) tester = "R";
            else tester = "P";
            
            System.out.print("["+ q.getChemical().getSubstance() + "|" + /*q.getChemical().getIndex()*/ tester + "]-->" );
                
            if(q.getNext() == null) {
                System.out.println("[Null]");
                break;
            }
            q = q.getNext();
        }
    }
}
