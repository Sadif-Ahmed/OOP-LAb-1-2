public class GreatWhiteShark extends Fish {
    GreatWhiteShark(String name, int age)
    {
        super(name,age);
    }
    public boolean isLethalToAdultHumans()
    {
        return true;
    }
    public String toString()
    {
        return getName()+ "is a GreatWhiteShark aged " + getAge() ;
    }
}
