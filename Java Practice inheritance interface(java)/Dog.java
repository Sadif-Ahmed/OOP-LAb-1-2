public  class Dog extends Mammal
{
    Dog(String name, int age)
    {
        super(name,age);
    }
    public boolean isLethalToAdultHumans()
    {
        return false;
    }
    public String toString()
    {
        return getName()+ "is a Dog aged " + getAge() ;
    }
}