package sample;

public class PlayerInfo {
    private String Name;
    private String Country;
    private  int Age;
    private double Height;
    private  String Club;
    private String Position;
    private int Number;
    private double Salary;
    PlayerInfo(String name,String country,int age,double height,String club,String position,int number,double salary)
    {
        Name=name;
        Country=country;
        Club=club;
        Age=age;
        Height=height;
        Position=position;
        Number=number;
        Salary=salary;
    }
    PlayerInfo()
    {

    }
    public  void setName(String name) {
        Name = name;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setClub(String club) {
        Club = club;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setHeight(double height) {
        Height = height;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public double getSalary() {
        return Salary;
    }

    public int getAge() {
        return Age;
    }

    public double getHeight() {
        return Height;
    }

    public int getNumber() {
        return Number;
    }

    public String getClub() {
        return Club;
    }

    public String getCountry() {
        return Country;
    }

    public String getName() {
        return Name;
    }

    public String getPosition() {
        return Position;
    }

}


