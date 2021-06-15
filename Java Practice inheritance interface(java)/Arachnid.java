public class Arachnid extends Animal{
    Arachnid(String name, int age)
    {
        super(name,age);
    }

        public String toString()
    {
        return getName()+ "is an Archanid aged " + getAge() ;
    }
}
