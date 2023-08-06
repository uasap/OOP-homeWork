

package geo_group;

import java.util.ArrayList;
import java.util.Iterator;

public class NodeIterator implements Iterator<Node> {
    private int index;
    private ArrayList<Node> treeList;

    public NodeIterator(ArrayList<Node> treeList) {
        this.treeList = treeList;
    }

    @Override
    public boolean hasNext() {
        return treeList.size() > index;
    }

    @Override
    public Node next() {
        return treeList.get(index++);
    }
}

