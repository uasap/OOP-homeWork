package geo_group;

import java.util.ArrayList;
import java.util.Scanner;

public class Research {
    ArrayList<String> result = new ArrayList<>();
    ArrayList<Node> tree;
    ArrayList<String> resultAge = new ArrayList<>();

    public Research(GeoTree geoTree) {
        tree = geoTree.getTree();
    }

    // метод поиска связи: родитель - ребенок, жена-муж
    public ArrayList<String> spend(Person inPerson, Relationship re) {
        for (Node t : tree) {
            Person curPers1 = t.GetPerson1();
            Person curPers2 = t.GetPerson2();
           
            String curName1 = curPers1.getFullName();
            String curName2 = curPers2.getFullName();

            String inName = inPerson.getFullName();

            Relationship curRelat = t.GetRelationship();
            
            if (curName1 == inName && curRelat == re) {
                result.add(curName2);
            }
        }
        return result;
    }

    // метод поиска по возрасту
    public ArrayList<String> searchAge() {
        System.out.print("Введите ограничение по возрасту: ");
        Scanner in = new Scanner(System.in);
        int age = in.nextInt();
        System.out.println("Люди, младше: " + age + ":");

        for (Node t : tree) {
            Person curPers = t.GetPerson1();
            int curAge =  curPers.getAge();
            String curName = curPers.getFullName();
            if (curAge <= age && !resultAge.contains(curName)) {
                resultAge.add(curName);
            }
        }
        return resultAge;
    }
}