public class Player {
    private int number;
    private String name;
    private double salary;
    private String Country;
    private  int Age;
    private double Height;
    private String Position;
    // you are not allowed to write any other constructor
    public Player(int number, String name,int age,String country,double height,String position,double salary) {
        setNumber(number);
        setName(name);
        this.Age=age;
        this.Country=country;
        this.Height=height;
        this.Position=position;
        this.salary=salary;
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
}
