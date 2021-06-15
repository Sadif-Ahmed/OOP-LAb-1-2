public class Player {
    private int number;
    private String name;
    private double salary;

    // you are not allowed to write any other constructor
    public Player(int number, String name) {
        setNumber(number);
        setName(name);
    }
    void setNumber(int number)
    {
        this.number=number;
    }
    void setName(String name)
    {
        this.name=name;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
   double getSalary()
   {
       return this.salary;
   }
    public String getName()
    {
        return this.name;
    }
    // add your code here
}
