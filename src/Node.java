import java.io.Serializable;

public class Node  implements Serializable{

    private Person p1;
    private Person p2;
    private Relationship re;
    

    public Node(Person p1, Relationship re, Person p2) {
        this.p1 = p1;
        this.re = re;
        this.p2 = p2;
    }

    public Person GetPerson1() {
        return p1;
    }

    public Person GetPerson2() {
        return p2;
    }

    public Relationship GetRelationship() {
        return re;
    }


    @Override
    public String toString() {
        return String.format("<%s %s %s>", p1, re, p2);
    }
    
}