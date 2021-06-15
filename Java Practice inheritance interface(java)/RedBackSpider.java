public class RedBackSpider extends Arachnid implements Venomous{
    RedBackSpider(String name, int age)
    {
        super(name,age);
    }
    public boolean isLethalToAdultHumans()
    {
        return false;
    }
    public String toString()
    {
        return getName()+ "is a RedBackSpider aged " + getAge() ;
    }
}
