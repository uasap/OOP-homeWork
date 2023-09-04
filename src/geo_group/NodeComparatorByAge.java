
package geo_group;

import java.util.Comparator;

public class NodeComparatorByAge<T> implements Comparator<Node<T>> {

    @Override
    public int compare(Node<T> o1, Node<T> o2) {
        return Integer.compare(((Person)o1.GetPerson1()).getAge(), ((Person)o2.GetPerson1()).getAge());
    }

    

}
