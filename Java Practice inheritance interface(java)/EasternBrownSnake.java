public class EasternBrownSnake extends Reptile implements Venomous{
    EasternBrownSnake(String name, int age)
        {
            super(name,age);
        }
    public boolean isLethalToAdultHumans()
    {
        return true;
    }
    public String toString()
    {
        return getName()+ "is a EasternBrownSnake aged " + getAge() ;
    }
}
