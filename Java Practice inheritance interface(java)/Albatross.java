public class Albatross extends Bird
{
    Albatross(String name, int age)
    {
        super(name,age);
    }
    public String toString()
    {
        return getName()+ "is a Albatross aged " + getAge() ;
    }

}