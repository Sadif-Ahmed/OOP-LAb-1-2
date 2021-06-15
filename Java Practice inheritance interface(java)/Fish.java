public class Fish extends Animal{
    Fish(String name, int age)
    {
        super(name,age);
    }
    public String toString()
    {
        return getName()+ "is a Fish aged " + getAge() ;
    }
}
