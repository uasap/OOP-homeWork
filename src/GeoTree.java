import java.io.Serializable;
import java.util.ArrayList;

public class GeoTree implements  Serializable{

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
}