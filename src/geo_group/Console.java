package geo_group;

import java.util.Scanner;

import geo_group.Animal.Gender;

public class Console implements View {
    private Scanner scan;
    private Presenter presenter;
    private Menu menu;
    private boolean go;

    @Override
    public void start() {
        scan = new Scanner(System.in);
        menu = new Menu(this);
        go = true;
        while (go) {
            header();
            menuUi();
            System.out.print("Выберите пункт Меню -> ");
            String command = scan.nextLine();
           
            if (checkInput(command)) {
                menu.execute(Integer.parseInt(command));
            } else {
                ///System.out.println("Введите число!");
                go = false;
            }
            

            
        }
    }

    private void header() {
        System.out.println("\nПрограмма для работы с семейным древом");
    }

    private void menuUi() {
        System.out.println(menu.printMenu());
    }

    public void addHumanNew() {
        System.out.print("Введите имя1-> ");
        String fullName1 = scan();
        System.out.print("Введите пол1(муж./жен.)-> ");
        String sex = scan();

        Gender gender1 = Person.Gender.FEMALE;
        if(sex == "муж.")
           gender1 = Person.Gender.MALE;

        System.out.print("Введите Год Рож 1-> ");
        int yearBirth1 = Integer.parseInt(scan());

        System.out.print("Введите Год Смерт 1-> ");
        int yearDie1 = Integer.parseInt(scan());

        //===========================================================
        System.out.print("Введите имя2-> ");
        String fullName2 = scan();
        System.out.print("Введите пол2(муж./жен.)-> ");
        sex = scan();

        Gender gender2 = Person.Gender.FEMALE;
        if(sex == "муж.")
           gender1 = Person.Gender.MALE;

        System.out.print("Введите Год Рож 2-> ");
        int yearBirth2 = Integer.parseInt(scan());

        System.out.print("Введите Год Смерт 2-> ");
        int yearDie2 = Integer.parseInt(scan());

        presenter.addAnimalNew(fullName1,  yearBirth1,  yearDie1,   gender1,
                               fullName2,  yearBirth2,  yearDie2,   gender2 );//fullName, int yearBirth, int yearDie,  Gender gender
    }

    public void geoPrint() {
        presenter.geoPrint();
    }

    public void humanSearch() {
        System.out.print("Введите имя человека для поиска-> ");
        String name = scan();
        presenter.animalSearch(name);
    }

    public void saveGeo() {
        presenter.saveGeo();
    }

    public void loadGeo() {
        presenter.loadGeo();
    }

    public void sortFamilyName() {
        presenter.sortGeoName();
    }

    public void sortFamilyAge() {
        presenter.sortGeoAge();
    }

    public void end() {
        go = false;
        System.out.println("Спасибо, что пользуетесь нашим сервисом :D");
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public String scan() {
        scan = new Scanner(System.in, "Cp866");
        return scan.nextLine();
    }

    private boolean checkInput(String text) {
        return text.matches("[0-9]+");
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
