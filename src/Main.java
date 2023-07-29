/*Реализовать, с учетом ооп подхода, приложение.
Для проведения исследований с генеалогическим древом.
Идея: описать некоторое количество компонент, например:
модель человека и дерева
Под “проведением исследования” можно понимать например получение всех детей выбранного человека. */

public class Main {
    public static void main(String[] args) {
        Person irina = new Person("Ирина", 56);
        Person igor = new Person("Игорь", 60);
        Person vasya = new Person("Вася", 30);
        Person masha = new Person("Маша", 27);
        Person jane = new Person("Женя", 10);
        Person ivan = new Person("Ваня", 8);
        Person Sasha = new Person("Саша", 9);
        Person Sasha10 = new Person("Саша", 10);
        Person Sasha11 = new Person("Саша", 11);
        Person Sasha12 = new Person("Саша", 12);
        Person Sasha3 = new Person("Саша", 3);
        GeoTree gt = new GeoTree();
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
    }
}
