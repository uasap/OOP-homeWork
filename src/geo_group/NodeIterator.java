

package geo_group;

import java.util.ArrayList;
import java.util.Iterator;

public class NodeIterator<T> implements Iterator<Node<T>> {
    private int index;
    private ArrayList<Node<T>> treeList;

    public NodeIterator(ArrayList<Node<T>> tree) {
        this.treeList = tree;
    }

    @Override
    public boolean hasNext() {
        return treeList.size() > index;
    }

    @Override
    public Node<T> next() {
        return treeList.get(index++);
    }
}

