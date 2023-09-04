package geo_group;

import geo_group.Animal.Gender;

public class Presenter {
    

    private View view;
    private IO serialize;
    private GeoTree<Animal> geoConnect;
    //private AnimalComporatorByAge sortAge;

    public Presenter(View view, GeoTree<Animal> gtAnimal, IO serialize 
                     /*,NodeComparatorByAge<Animal> sortAge*/) {
        this.geoConnect = (GeoTree<Animal>) gtAnimal;
        this.view = view;
        this.serialize = serialize;        
        view.setPresenter(this);
    }

    public void addAnimalNew(String fullName1, int yearBirth1, int yearDie1,  Gender gender1,
                             String fullName2, int yearBirth2, int yearDie2,  Gender gender2       ) {
       
        Person p1 = new Person(  fullName1,  yearBirth1, yearDie1, gender1);
        Person p2 = new Person(  fullName2,  yearBirth2, yearDie2, gender2);

        geoConnect.appendPerentChild(p1, p2); // Ирина родитель Васи
    }

    public void geoPrint() {
        String family = geoConnect.toString();
        view.print(family);
    }

    public void animalSearch(String name) {
        Animal animal =  geoConnect.getByName(name);
        if (animal == null)
            view.print("Такого человека нет в семье !");

        else {
            String foundAnimal = animal.toString();
            view.print(foundAnimal);
        }
    }


    public void saveGeo() {
        geoConnect.saveObj(serialize, geoConnect, null);
        view.print("Семейное древо сохранено !");
    }

    public void loadGeo() {
        serialize.load("TreeGeo.data");
    }

    public void sortGeoName() {
        geoConnect.sortByName();
        view.print("Сортировка завершена !");
    }

    public void sortGeoAge() {
        geoConnect.sortByAge();
        view.print("Сортировка завершена !");
    }

   }