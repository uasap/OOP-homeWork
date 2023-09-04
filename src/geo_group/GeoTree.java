package geo_group;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class GeoTree<T /*extends Animal*/ > implements  Serializable, Iterable<Node<T>>  {

    private ArrayList<Node<T>> tree = new ArrayList<Node<T>>();

    public ArrayList<Node<T>> getTree() {
        return tree;
    }

    /*
    public void addFamilyTree(T animal) {
        Node<T> node = new Node(node, null, node);
        if (!tree.contains(animal)) {
            tree.add (Node<T> node);
            if (animal.getMother() != null) {
                animal.getMother().addChild(animal);
            }
            if (animal.getFather() != null) {
                animal.getFather().addChild(animal);
            }
        }
    }
    */

    // связь родитель - ребенок
    public void appendPerentChild(T parent, T children) {
        tree.add(new Node<T>(parent, Relationship.parent, children));
        tree.add(new Node<T>(children, Relationship.children, parent));
    }

    // связь муж - жена
    public void appendVifeHusbent(T vife, T husbent) {
        tree.add(new Node<T>(vife, Relationship.vife, husbent));
        tree.add(new Node<T>(husbent, Relationship.husbent, vife));
    }

    public void saveObj(IO objIO,Serializable obj, String path) {
        objIO.save(path, obj);
    }

    @Override
    public String toString() {
        String res = "";  
        
        for(Node<T> node : tree){
             res+= node.toString();
             res+= "\n";
        }
        return res;
    }

    public void sortByName() {        
        tree.sort(new NodeComparatorByName<T>());
    }

    public void sortByAge() {
        tree.sort(new NodeComparatorByAge<T>());
    }

    @Override
    public Iterator<Node<T>> iterator() {
        return new NodeIterator<T>(tree);
    }  
    
    public T getByName(String humanName) {
        for (Node<T> nodeHuman : tree) {
            if (nodeHuman.getName().equalsIgnoreCase(humanName)) {
                return (T) nodeHuman.GetPerson1();
            }
        }
        return null;
    }

}