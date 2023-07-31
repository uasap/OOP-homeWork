import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*Реализовать, с учетом ооп подхода, приложение.
Для проведения исследований с генеалогическим древом.
Идея: описать некоторое количество компонент, например:
модель человека и дерева
Под “проведением исследования” можно понимать например получение всех детей выбранного человека. */

public class Main {

    static Person irina ;
    static Person igor ;
    static Person vasya ;
    static Person masha ;
    static Person jane ;
    static Person ivan ;
    static Person Sasha ;
    static Person Sasha10;
    static Person Sasha11 ;
    static Person Sasha12 ;
    static Person Sasha3 ;

    public static void defConfif(GeoTree gt) {

         irina = new Person(  "Ирина",  1967, -1, Person.Gender.FEMALE);
         igor = new Person(   "Игорь",  1960, -1,Person.Gender.MALE);
         vasya = new Person(  "Вася",   1991, -1,Person.Gender.MALE);
         masha = new Person(  "Маша",   1989 , -1,Person.Gender.FEMALE);
         jane = new Person(   "Женя",   2013, -1,Person.Gender.MALE);
         ivan = new Person(   "Ваня",   2011, -1,Person.Gender.MALE);
         Sasha = new Person(  "Саша",   2010, -1,Person.Gender.MALE);
         Sasha10 = new Person("Коля",   2012, -1,Person.Gender.MALE);
         Sasha11 = new Person("Дима",   2015, -1,Person.Gender.MALE);
         Sasha12 = new Person("Андрей", 2016, -1,Person.Gender.MALE);
         Sasha3 = new Person( "Костя",  2020, -1,Person.Gender.MALE);
       
        gt.appendPerentChild(irina, vasya); // Ирина родитель Васи
        gt.appendPerentChild(irina, masha); // Ирина родитель Маши
        gt.appendPerentChild(vasya, jane); // Вася родитель Жени
        gt.appendPerentChild(vasya, ivan); // Вася родитель Ивана
        gt.appendVifeHusbent(irina, igor); // Ирина жена Игоря
        gt.appendPerentChild(igor, vasya); // Игорь родитель Васи
        gt.appendPerentChild(igor, masha); // Игорь родитель Маши
        gt.appendPerentChild(igor, Sasha); // Игорь родитель Саши
        gt.appendPerentChild(igor, Sasha10); // Игорь родитель Саши
        gt.appendPerentChild(igor, Sasha11); // Игорь родитель Саши
        gt.appendPerentChild(igor, Sasha3); // Игорь родитель Саши 

    }
    public static void main(String[] args) throws IOException, ClassNotFoundException{

        GeoTree gt = new GeoTree();
        defConfif(gt);       

         // Ищем детей Ирины
         System.out.println("Дети Ирины");
         System.out.println(new Research(gt).spend(irina, Relationship.parent));
         // Ищем детей Игоря
         System.out.println("Дети Игоря");
         System.out.println(new Research(gt).spend(igor, Relationship.parent));
 
         // Ищем мужа Ирины (Чья жена Ирина?)
         System.out.println("Муж Ирины");
         System.out.println(new Research(gt).spend(irina, Relationship.vife));
 
         // Ищем людей определенного возраста
         System.out.println(new Research(gt).searchAge());

         IO serialize = new IO();
        
        gt.saveObj(serialize,gt,"person.out");         
        GeoTree gtRestored = (GeoTree) serialize.load("person.out");        
        System.out.println("After Restored: " + "\n" + gtRestored + "\n");
        
        
    }
}
    
