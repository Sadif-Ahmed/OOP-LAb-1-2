import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<PlayerInfo> readFromFile() throws Exception {
        List<PlayerInfo> PlayerList = new ArrayList();
        BufferedReader br = new BufferedReader(new FileReader("players.txt"));

        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] tokens = line.split(",");
            PlayerInfo p = new PlayerInfo();
            p.setName(tokens[0]);
            p.setCountry(tokens[1]);
            p.setAge(Integer.parseInt(tokens[2]));
            p.setHeight(Double.parseDouble(tokens[3]));
            p.setClub(tokens[4]);
            p.setPosition(tokens[5]);
            p.setNumber(Integer.parseInt(tokens[6]));
            p.setSalary(Double.parseDouble(tokens[7]));
            PlayerList.add(p);
        }
        br.close();
        return PlayerList;
    }

    public static void PrintList(List<PlayerInfo> Players) {
        for (int i = 0; i < Players.size(); i++) {
            System.out.println(Players.get(i).getName() + " , " + Players.get(i).getCountry() + " , " + Players.get(i).getAge() + " , " + Players.get(i).getHeight() + " , " + Players.get(i).getClub() + ", " + Players.get(i).getPosition() + " , " + Players.get(i).getNumber() + " , " + Players.get(i).getSalary());
        }
    }

    public static List<PlayerInfo> Search_by_Name(String name, List<PlayerInfo> Players) {
        int i;

        List<PlayerInfo> SearchList = new ArrayList();

        for (i = 0; i < Players.size(); i++) {
            if (Players.get(i).getName().equalsIgnoreCase(name)) {
                SearchList.add(Players.get(i));
                break;
            }
        }
        return SearchList;
    }

    public static List<PlayerInfo> Search_by_Position(String Position, List<PlayerInfo> Players) {
        int i;

        List<PlayerInfo> SearchList = new ArrayList();


        for (i = 0; i < Players.size(); i++) {
            if (Players.get(i).getPosition().equalsIgnoreCase(Position)) {
                SearchList.add(Players.get(i));
            }
        }
        return SearchList;
    }

    public static List<PlayerInfo> Search_by_SalaryRange(double minSalary, double maxSalary, List<PlayerInfo> Players) {
        int i;

        List<PlayerInfo> SearchList = new ArrayList();


        for (i = 0; i < Players.size(); i++) {
            if ((Players.get(i).getSalary() > minSalary) && (Players.get(i).getSalary() < maxSalary)) {
                SearchList.add(Players.get(i));
            }
        }
        return SearchList;
    }
    public static List<PlayerInfo>  Country_list(List<PlayerInfo> Players) {
        List<PlayerInfo> SearchList = new ArrayList();
        SearchList.add(Players.get(0));
        for(int i=0;i< Players.size();i++)
        {
            boolean Repeater=false;
            for (int j = 0; j <= (SearchList.size()-1); j++) {
                if(SearchList.get(j).getCountry().equalsIgnoreCase(Players.get(i).getCountry()))
                {
                    Repeater = true;
                    break;
                }
            }
            if(Repeater == false)
            {

                SearchList.add(Players.get(i));
            }
        }
        return SearchList;
    }
    public static int [] Country_PlayerCount(List<PlayerInfo> Countrylist,List<PlayerInfo> Players) {
        int [] country_count=new int[Countrylist.size()];
        for (int i = 0; i < Countrylist.size(); i++) {
           for(int j=0;j<Players.size();j++)
           {
               if(Countrylist.get(i).getCountry().equalsIgnoreCase(Players.get(j).getCountry()))
               {
                   country_count[i]++;
               }
           }
        }
        return country_count;
    }

    public static List<PlayerInfo> Search_by_Club_and_Country(String Country, String Club, List<PlayerInfo> Players) {
        int i;

        List<PlayerInfo> SearchList = new ArrayList();
        if (Club.equalsIgnoreCase("ANY")) {
            for (i = 0; i < Players.size(); i++) {
                if (Players.get(i).getCountry().equalsIgnoreCase(Country)) {
                    SearchList.add(Players.get(i));
                }
            }
        } else {
            for (i = 0; i < Players.size(); i++) {
                if (Players.get(i).getCountry().equalsIgnoreCase(Country) && (Players.get(i).getClub().equalsIgnoreCase(Club))) {
                    SearchList.add(Players.get(i));
                }
            }
        }
        return SearchList;
    }

    public static List<PlayerInfo> Search_Club_Highest_Salary(String Club, List<PlayerInfo> Players) {
        int i;
        double max = 0;
        List<PlayerInfo> SearchList = new ArrayList();
        for (i = 0; i < Players.size(); i++) {
            if ((Players.get(i).getSalary() >= max) && (Players.get(i).getClub().equalsIgnoreCase(Club))) {
                max = Players.get(i).getSalary();
            }
        }
        for (i = 0; i < Players.size(); i++) {
            if (Players.get(i).getClub().equalsIgnoreCase(Club) && (Players.get(i).getSalary() == max)) {
                SearchList.add(Players.get(i));
            }
        }
        return SearchList;
    }

    public static List<PlayerInfo> Search_Club_Max_Age(String Club, List<PlayerInfo> Players) {
        int i;
        double max = 0;
        List<PlayerInfo> SearchList = new ArrayList();
        for (i = 0; i < Players.size(); i++) {
            if ((Players.get(i).getAge() >= max) && (Players.get(i).getClub().equalsIgnoreCase(Club))) {
                max = Players.get(i).getAge();
            }
        }
        for (i = 0; i < Players.size(); i++) {
            if (Players.get(i).getClub().equalsIgnoreCase(Club) && (Players.get(i).getAge() == max)) {
                SearchList.add(Players.get(i));
            }
        }
        return SearchList;
    }

    public static List<PlayerInfo> Search_Club_Max_Height(String Club, List<PlayerInfo> Players) {
        int i;
        double max = 0;
        List<PlayerInfo> SearchList = new ArrayList();
        for (i = 0; i < Players.size(); i++) {
            if ((Players.get(i).getHeight() >= max) && (Players.get(i).getClub().equalsIgnoreCase(Club))) {
                max = Players.get(i).getHeight();
            }
        }
        for (i = 0; i < Players.size(); i++) {
            if (Players.get(i).getClub().equalsIgnoreCase(Club) && (Players.get(i).getHeight() == max)) {
                SearchList.add(Players.get(i));
            }
        }
        return SearchList;
    }

    public static double Yearly_Club_Salary(String Club, List<PlayerInfo> Players) {
        int i;
        double salary = 0;

        for (i = 0; i < Players.size(); i++) {
            if (Players.get(i).getClub().equalsIgnoreCase(Club)) {
                salary += Players.get(i).getSalary();
            }
        }
        salary *= 52;
        return salary;
    }
    public static List<PlayerInfo> Add_Player(PlayerInfo NewPlayer,List<PlayerInfo> Players)
    {
        Players.add(NewPlayer);
        return Players;
    }
    public static void writeToFile(List<PlayerInfo> Players) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("players.txt"));

        for(int i=0;i<Players.size();i++) {
            bw.write(Players.get(i).getName() + "," + Players.get(i).getCountry() + "," + Players.get(i).getAge() + "," + Players.get(i).getHeight() + "," + Players.get(i).getClub() + "," + Players.get(i).getPosition() + "," + Players.get(i).getNumber() + "," + Players.get(i).getSalary());
            bw.write("\n");
        }
            bw.close();
    }
    public static int Club_Counter(String Club, List<PlayerInfo> Players) {
        int club_count = 0;
        for (int i = 0; i < Players.size(); i++) {
            if (Players.get(i).getClub().equalsIgnoreCase(Club)) {
                club_count++;
            }
        }
        return club_count;
    }
    public static void Player_Choice(List<PlayerInfo> Players)
    {   int choice;
        System.out.println("(1) By Player Name");
        System.out.println("(2) By Club and Country");
        System.out.println("(3) By Position");
        System.out.println("(4) By Salary Range");
        System.out.println("(5) Country-wise player count");
        System.out.println("(6) Back to Main Menu");
        System.out.print("Enter any number between 1 and 6: ");
        Scanner pch = new Scanner(System.in);
        choice = pch.nextInt();
        pch.nextLine();
        if(choice == 1)
        {   String name;
            System.out.println("Please input the player name: ");
            name=pch.nextLine();
            List<PlayerInfo> SearchList = new ArrayList();
            SearchList=Search_by_Name(name,Players);
            if(SearchList.size()==0)
            {
                System.out.println("No such player with this name");
            }
            else
            {
                System.out.println("The folllowing player with this name:");
                PrintList(SearchList);
            }
            Player_Choice(Players);
        }
        if(choice == 2)
        {  String country;
            String club;
            System.out.println("Please input the country name: ");
            country=pch.nextLine();
            System.out.println("Please input the club name: ");
            club=pch.nextLine();
            List<PlayerInfo> SearchList = new ArrayList();
            SearchList=Search_by_Club_and_Country(country,club,Players);
            if(SearchList.size()==0)
            {
                System.out.println("No such player with this country and club");
            }
            else
            {
                if(club.equalsIgnoreCase("ANY")) {
                    System.out.println("The folllowing player with this country:");
                    PrintList(SearchList);
                }
                else
                {
                    System.out.println("The folllowing player with this club and country:");
                    PrintList(SearchList);
                }
            }
            Player_Choice(Players);
        }
        if(choice == 3)
        {
            String position;
            System.out.println("Please input the player position: ");
            position=pch.nextLine();
            List<PlayerInfo> SearchList = new ArrayList();
            SearchList=Search_by_Position(position,Players);
            if(SearchList.size()==0)
            {
                System.out.println("No such player with this position");
            }
            else
            {
                System.out.println("The folllowing player with this position:");
                PrintList(SearchList);
            }
            Player_Choice(Players);
        }
        if(choice == 4)
        {
           int down_range;
           int up_range;
            System.out.println("Please input two numbers as Range :");
            down_range=pch.nextInt();
            up_range=pch.nextInt();
            List<PlayerInfo> SearchList = new ArrayList();
            SearchList=Search_by_SalaryRange(down_range,up_range,Players);
            if(SearchList.size()==0)
            {
                System.out.println("No such player with this weekly salary range");
            }
            else
            {
                System.out.println("The folllowing player within weekly salary range:");
                PrintList(SearchList);
            }
            Player_Choice(Players);
        }
        if(choice == 5)
        {
            List<PlayerInfo> SearchList = new ArrayList();
            SearchList=Country_list(Players);
            int [] Count=Country_PlayerCount(SearchList,Players);
            System.out.println("The countrywise playercount is:");
            for(int i=0;i<SearchList.size();i++)
            {
                System.out.println(SearchList.get(i).getCountry()+" "+Count[i]);
            }
            Player_Choice(Players);
        }
        if(choice >6 || choice <1)
        {
            System.out.println("Number not between 1 and 6. Try again");
            Player_Choice(Players);
        }

    }
    public static void Club_Choice( List<PlayerInfo> Players)
    {
        System.out.println("(1) Player(s) with the maximum salary of a club");
        System.out.println("(2) Player(s) with the maximum age of a club");
        System.out.println("(3) Player(s) with the maximum height of a club");
        System.out.println("(4) Total Yearly Salary of a club");
        System.out.println("(5) Back to Main Menu");
        System.out.print("Enter any number between 1 and 5: ");
        Scanner cch = new Scanner(System.in);
        int choice = cch.nextInt();
        cch.nextLine();
        if(choice == 1)
        {   String club;
            List<PlayerInfo> SearchList = new ArrayList();
            System.out.println("Give your desired club name:");
            club=cch.nextLine();
           SearchList=Search_Club_Highest_Salary(club,Players);
           if(SearchList.size()==0)
           {
               System.out.println("No such club with this name");
           }
           else if(SearchList.size()==1)
           {
               System.out.println("The Player with maximum salary:");
               PrintList(SearchList);
           }
           else
           {
               System.out.println("The Players with maximum salary:");
               PrintList(SearchList);
           }
            Club_Choice(Players);
        }
        if(choice == 2)
        {   String club;
            List<PlayerInfo> SearchList = new ArrayList();
            System.out.println("Give your desired club name:");
            club=cch.nextLine();
            SearchList=Search_Club_Max_Age(club,Players);
            if(SearchList.size()==0)
            {
                System.out.println("No such club with this name");
            }
            else if(SearchList.size()==1)
            {
                System.out.println("The Player with maximum Age:");
                PrintList(SearchList);
            }
            else
            {
                System.out.println("The Players with maximum Age:");
                PrintList(SearchList);
            }
            Club_Choice(Players);
        }
        if(choice == 3)
        {
            String club;
            List<PlayerInfo> SearchList = new ArrayList();
            System.out.println("Give your desired club name:");
            club=cch.nextLine();
            SearchList=Search_Club_Max_Height(club,Players);
            if(SearchList.size()==0)
            {
                System.out.println("No such club with this name");
            }
            else if(SearchList.size()==1)
            {
                System.out.println("The Player with maximum Height:");
                PrintList(SearchList);
            }
            else
            {
                System.out.println("The Players with maximum Height:");
                PrintList(SearchList);
            }
            Club_Choice(Players);
        }
        if(choice == 4)
        {
            String club;
            System.out.println("Give your desired club name:");
            club=cch.nextLine();
            System.out.println("The yearly salary of the club"+" "+club+" is: ");
            System.out.printf("%10f \n",Yearly_Club_Salary(club,Players));
            Club_Choice(Players);
        }
        if(choice >5 || choice <1)
        {
            System.out.println("Number not between 1 and 5. Try again");
            Club_Choice(Players);
        }
    }
    public static void Add_Player_Choice(List<PlayerInfo> Players)
    {
        Scanner adp = new Scanner(System.in);
        System.out.println("Give you Player info: ");
        System.out.print("Name          : ");
        String name = adp.nextLine();
        System.out.print("Country Name  : ");
        String country = adp.nextLine();
        System.out.print("Age           : ");
        int age = Integer.parseInt(adp.nextLine());
        System.out.print("Height        : ");
        double height = Double.parseDouble(adp.nextLine());
        System.out.print("Club Name     : ");
        String club = adp.nextLine();
        System.out.print("Position      : ");
        String pos = adp.nextLine();
        System.out.print("Number        : ");
        int num = Integer.parseInt(adp.nextLine());
        System.out.print("Weekly Salary : ");
        double sal = Double.parseDouble(adp.nextLine());
        PlayerInfo New_player = new PlayerInfo( name, country, age, height,club,pos, num,sal );
        if(Club_Counter(New_player.getClub(),Players)>6)
        {
            System.out.println("The Club already has maximum members");
        }
        else
        {
            if(Search_by_Name(New_player.getName(), Players).size()!=0)
            {
                System.out.println("There already exists a player with this name");
            }
            else
            {

               Players=Add_Player(New_player,Players);
            }
        }
    }
    static void main_menu_Outlet(int choice,List<PlayerInfo> Players) throws Exception
    {
        if(choice == 4)
        {

           writeToFile(Players);
            System.exit(1);
        }
        if(choice != 4)
        {
            if(choice >4 || choice <1)
            {
                System.out.println("Number not between 1 and 4. Try again");
            }
            if(choice == 1) {
                Player_Choice(Players);
            }
            if(choice == 2) {
                Club_Choice(Players);
            }
            if(choice == 3) {
                Add_Player_Choice(Players);
            }
            System.out.println("(1) Search Players");
            System.out.println("(2) Search Clubs");
            System.out.println("(3) Add Player");
            System.out.println("(4) Exit System");
            System.out.print("Enter any number between 1 and 4: ");
            Scanner mout = new Scanner(System.in);
            choice = mout.nextInt();
            main_menu_Outlet(choice,Players);

        }
    }
    public static void main(String[] args) throws Exception {

        List<PlayerInfo> Players = readFromFile();
        int choice;
        System.out.println("(1) Search Players");
        System.out.println("(2) Search Clubs");
        System.out.println("(3) Add Player");
        System.out.println("(4) Exit System");
        System.out.print("Enter any number between 1 and 4: ");
        Scanner mn = new Scanner(System.in);
        choice = mn.nextInt();
        main_menu_Outlet(choice,Players);
    }
}

