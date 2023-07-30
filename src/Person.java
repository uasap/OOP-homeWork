
public class Person {
    private String fullName;
    ///private int age;
    //Вместо возраста создать поля даты рождения и смерти и высчитывать возраст в методе. 
    private int yearBirth;
    private int yearDie;

    public Person(String fullName, int yearBirth, int yearDie) {
        this.fullName = fullName;       
        this.yearBirth = yearBirth;
        this.yearDie = yearDie;
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


} 