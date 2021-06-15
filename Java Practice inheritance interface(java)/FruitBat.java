public class FruitBat extends Mammal
{
    FruitBat(String name, int age)
    {
        super(name,age);
    }
    public boolean isLethalToAdultHumans()
    {
        return false;
    }
    public String toString()
    {
        return getName()+ "is a FruitBat aged " + getAge() ;
    }
}
