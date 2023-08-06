
package geo_group;

import java.util.Comparator;

public class NodeComparatorByName implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        return o1.GetPerson1().getFullName().compareTo(o2.GetPerson1().getFullName());
    }
}
