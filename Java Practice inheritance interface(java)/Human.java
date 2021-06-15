public class Human extends Mammal {
    Human(String name, int age)
    {
        super(name,age);
    }
    public boolean isLethalToAdultHumans()
    {
        return false;
    }
    public String toString()
    {
        return getName()+ "is a Human aged " + getAge() ;
    }
}
