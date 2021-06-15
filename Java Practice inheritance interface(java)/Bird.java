public class Bird extends Animal{
    Bird(String name, int age)
    {
        super(name,age);
    }

    public String toString()
    {
        return getName()+ "is a Bird aged " + getAge() ;
    }
}