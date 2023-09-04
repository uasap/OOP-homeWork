package geo_group;



import java.io.Serializable;
import java.util.List;

public abstract class Animal implements Serializable, Comparable<Animal> {
    
    private String fullName;
    private int yearBirth;
    private int yearDie;

    private Animal mother;
    private Animal father;

    private List<Animal> children;
    
    static enum Gender{ 
        MALE,
        FEMALE        
    }

    private Gender gender;

    public Animal(String fullName, int yearBirth, int yearDie,  Gender gender) {
        this.fullName = fullName;       
        this.yearBirth = yearBirth;
        this.yearDie = yearDie;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private int GetCurYear(){
        return 2023;
    }

    public int getAge() {        
        int lastYear = (this.yearDie < 0 ) ? GetCurYear() : this.yearDie;
        int t_age = lastYear - yearBirth;
        return t_age;
    }

    public void addChild(Animal animal) {
        if (!children.contains(animal)) {
            this.children.add(animal);
            if (this.gender == Gender.MALE) {
                animal.father = this;
            } else
                animal.mother = this;
        }
    }

    public Animal getFather() {
        return father;
    }

    public Animal getMother() {
        return mother;
    }

    @Override
    public String toString() {
        String res = "Имя: " + fullName + ",\t Пол: " + gender + ", Возраст: " + getAge();      

        return res;
    }
}
