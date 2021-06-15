public class Platypus extends Mammal implements Venomous {
    Platypus(String name, int age)
    {
        super(name,age);
    }
    public boolean isLethalToAdultHumans()
    {
        return false;
    }
    public String toString()
    {
        return getName()+ "is a Platipus aged " + getAge() ;
    }
}
