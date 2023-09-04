
package geo_group;

import java.io.IOException;

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
    static Person Kolya;
    static Person andrey ;
    static Person Dima ;
    static Person Anton ;

    public static void defConfig(GeoTree<Person> gt) {

         irina = new Person(  "Ирина",  1967, -1, Person.Gender.FEMALE);
         igor = new Person(   "Игорь",  1960, -1,Person.Gender.MALE);
         vasya = new Person(  "Вася",   1991, -1,Person.Gender.MALE);
         masha = new Person(  "Маша",   1989 , -1,Person.Gender.FEMALE);
         jane = new Person(   "Женя",   2013, -1,Person.Gender.MALE);
         ivan = new Person(   "Ваня",   2011, -1,Person.Gender.MALE);
         Sasha = new Person(  "Саша",   2010, -1,Person.Gender.MALE);
         Kolya = new Person("Коля",   2012, -1,Person.Gender.MALE);
         andrey = new Person("Андрей",   2015, -1,Person.Gender.MALE);
         Dima = new Person("Дима", 2016, -1,Person.Gender.MALE);
         Anton = new Person( "Антон",  2020, -1,Person.Gender.MALE);
       
        gt.appendPerentChild(irina, vasya); // Ирина родитель Васи
        gt.appendPerentChild(irina, masha); // Ирина родитель Маши
        gt.appendPerentChild(vasya, jane); // Вася родитель Жени
        gt.appendPerentChild(vasya, ivan); // Вася родитель Ивана
        gt.appendVifeHusbent(irina, igor); // Ирина жена Игоря
        gt.appendPerentChild(igor, vasya); // Игорь родитель Васи
        gt.appendPerentChild(igor, masha); // Игорь родитель Маши
        gt.appendPerentChild(igor, Sasha); // Игорь родитель Саши
        gt.appendPerentChild(igor, Kolya); // Игорь родитель Коли
        gt.appendPerentChild(igor, andrey); // Игорь родитель андрея
        gt.appendPerentChild(igor, Anton); // Игорь родитель Антона 

    }
    public static void main(String[] args) throws IOException, ClassNotFoundException{

        boolean USE_MVP = true;

        IO serialize = new IO();  
           
        if(!USE_MVP){
           GeoTree<Person> gt = new GeoTree<Person>();
           defConfig(gt);              

           // Ищем детей Ирины
           System.out.println("Дети Ирины");
           System.out.println(new Research<Person>(gt).spend(irina, Relationship.parent));
           // Ищем детей Игоря
           System.out.println("Дети Игоря");
           System.out.println(new Research<Person>(gt).spend(igor, Relationship.parent));
 
           // Ищем мужа Ирины (Чья жена Ирина?)
           System.out.println("Муж Ирины");
           System.out.println(new Research<Person>(gt).spend(irina, Relationship.vife));
 
           // Ищем людей определенного возраста
           System.out.println(new Research<Person>(gt).searchAge());       

           gt.sortByName();
           gt.sortByAge();
        
           gt.saveObj(serialize,gt,"person.out");         
           GeoTree<Person> gtRestored = (GeoTree<Person>) serialize.load("person.out");  

           System.out.println("After Restored: " + "\n" + gtRestored + "\n");        
        
        } else{
           // MVP 
           View view = new Console();        
           GeoTree<Animal> gtAnimal = new GeoTree<Animal>();
           new Presenter(view, gtAnimal, serialize);
           view.start();
        }        
    }
}
    
