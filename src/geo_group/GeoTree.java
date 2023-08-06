package geo_group;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class GeoTree implements  Serializable, Iterable<Node>  {

    private ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getTree() {
        return tree;
    }

    // связь родитель - ребенок
    public void appendPerentChild(Person parent, Person children) {
        tree.add(new Node(parent, Relationship.parent, children));
        tree.add(new Node(children, Relationship.children, parent));
    }

    // связь муж - жена
    public void appendVifeHusbent(Person vife, Person husbent) {
        tree.add(new Node(vife, Relationship.vife, husbent));
        tree.add(new Node(husbent, Relationship.husbent, vife));
    }

    public void saveObj(IO objIO,Serializable obj, String path) {
        objIO.save(path, obj);
    }

    @Override
    public String toString() {
        String res = "";  
        
        for(Node node : tree){
             res+= node.toString();
             res+= "\n";
        }
        return res;
    }

    public void sortByName() {
        tree.sort(new NodeComparatorByName());
    }

    public void sortByAge() {
        tree.sort(new NodeComporatorByAge());
    }

    @Override
    public Iterator<Node> iterator() {
        return new NodeIterator(tree);
    }    

}