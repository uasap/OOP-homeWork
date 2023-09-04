
package geo_group;

import java.util.Comparator;

public class NodeComparatorByName<T> implements Comparator<Node<T> > {
    @Override
    public int compare(Node<T> o1, Node<T> o2) {
        return ((Person) o1.GetPerson1()).getFullName().compareTo(((Person)o2.GetPerson1()).getFullName());
    }
}
