public class Reptile extends Animal{
    Reptile(String name,int age)
    {
        super(name,age);
    }
    public String toString()
    {
        return getName()+ "is a Reptile aged " + getAge() ;
    }
}
