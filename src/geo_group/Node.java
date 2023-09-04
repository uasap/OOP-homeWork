package geo_group;

import java.io.Serializable;

public class Node<T>  implements Serializable{

    private T p1;
    private T p2;
    private Relationship re;
    

    public Node(T parent, Relationship re, T children) {
        this.p1 = parent;
        this.re = re;
        this.p2 = children;
    }

    public T GetPerson1() {
        return p1;
    }

    public T GetPerson2() {
        return p2;
    }

    public Relationship GetRelationship() {
        return re;
    }

    @Override
    public String toString() {
        return String.format("<%s %s %s>", p1, re, p2);
    }

    public String getName() {
        return ((Person) p1).getFullName();
    }
    
}