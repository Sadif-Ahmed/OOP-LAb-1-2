import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void PrintList(List<PlayerInfo> Players) {
        for (int i = 0; i < Players.size(); i++) {
            System.out.println(Players.get(i).getName() + " , " + Players.get(i).getCountry() + " , " + Players.get(i).getAge() + " , " + Players.get(i).getHeight() + " , " + Players.get(i).getClub() + ", " + Players.get(i).getPosition() + " , " + Players.get(i).getNumber() + " , " + Players.get(i).getSalary());
        }
    }

    public static List<PlayerInfo> Add_Player(PlayerInfo NewPlayer,List<PlayerInfo> Players)
    {
        Players.add(NewPlayer);
        return Players;
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
        List<PlayerInfo> SearchList = new ArrayList();
        PlayerSearch Test= new PlayerSearch(SearchList);
        if(Club_Counter(New_player.getClub(),Players)>6)
        {
            System.out.println("The Club already has maximum members");
        }
        else
        {
            if(Test.Search_by_Name(New_player.getName(), Players).size()!=0)
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
            FileInputOutput Test= new FileInputOutput(Players);
           Test.writeToFile(Players);
            System.exit(1);
        }
        if(choice != 4)
        {
            if(choice >4 || choice <1)
            {
                System.out.println("Number not between 1 and 4. Try again");
            }
            if(choice == 1) {
                PlayersChoiceMenue Test= new PlayersChoiceMenue(Players);
                Test.Player_Choice(Players);
            }
            if(choice == 2) {
                ClubChoiceMenue Test= new ClubChoiceMenue(Players);
                Test.Club_Choice(Players);
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
        List<PlayerInfo> Players = new ArrayList();;
        FileInputOutput Test= new FileInputOutput(Players);
        Players = Test.readFromFile();
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

