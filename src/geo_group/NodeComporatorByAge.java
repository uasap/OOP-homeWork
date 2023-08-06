
package geo_group;

import java.util.Comparator;

public class NodeComporatorByAge implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        return Integer.compare(o1.GetPerson1().getAge(), o2.GetPerson1().getAge());
    }

}
