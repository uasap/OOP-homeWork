package geo_group;

public class Person  extends Animal {
   

    public Person(String fullName, int yearBirth, int yearDie,  Gender gender) {
        super(fullName,  yearBirth,  yearDie,   gender);
    }

    @Override
    public int compareTo(Animal o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

   
    
} 