import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddPlayer {
    public static List<PlayerInfo> Add_Player(PlayerInfo NewPlayer, List<PlayerInfo> Players)
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
    public static boolean Position_Checker(PlayerInfo New_Player)
    {   boolean ret=false;
        if(New_Player.getPosition().equalsIgnoreCase("Forward"))
        {
            ret=true;
        }
        else if(New_Player.getPosition().equalsIgnoreCase("Goalkeeper"))
        {
            ret=true;
        }
        else if(New_Player.getPosition().equalsIgnoreCase("Midfielder"))
        {
            ret=true;
        }
        else if(New_Player.getPosition().equalsIgnoreCase("Defender"))
        {
            ret=true;
        }
        return ret;
    }
    public static List<PlayerInfo> Number_Checker(PlayerInfo New_Player,List<PlayerInfo> Players)
    {
        List<PlayerInfo> Searchlist = new ArrayList();
        for(int i=0;i<Players.size();i++)
        {
            if((New_Player.getClub().equalsIgnoreCase(Players.get(i).getClub())) && (New_Player.getNumber()==Players.get(i).getNumber()))
            {
                Searchlist.add(Players.get(i));
            }

        }
        return Searchlist;

    }
    public static int getInt() {
        Scanner input = new Scanner(System.in);

        while (!input.hasNextInt()) {
            System.out.println("Please enter a valid positive integer:");
            input.next();
        }

        return input.nextInt();
    }
    public static double getDouble() {
        Scanner input = new Scanner(System.in);

        while (!input.hasNextDouble()) {
            System.out.println("Please enter a valid double/integer:");
            input.next();
        }

        return input.nextDouble();
    }


    public static void Add_Player_Choice(List<PlayerInfo> Players)
    {
        Scanner adp = new Scanner(System.in);
        int tempi;
        double tempd;
        System.out.println("Give you Player info: ");
        System.out.print("Name          : ");
        String name = adp.nextLine();
        System.out.print("Country Name  : ");
        String country = adp.nextLine();
        System.out.print("Age           : ");
        int age=0;
        tempi=getInt();
        while(tempi<=0) {
            System.out.println("The age is negative.Please give another age:");
            tempi = getInt();
        }
        age=tempi;
        System.out.print("Height        : ");
        double height=0;
        tempd=getDouble();
        while(tempd<=0) {
            System.out.println("The height is negative.Please give another height:");
            tempd = getDouble();
        }
        height=tempd;
        System.out.print("Club Name     : ");
        String club = adp.nextLine();
        System.out.print("Position      : ");
        String pos = adp.nextLine();
        System.out.print("Number        : ");
        int num=0;
        tempi=getInt();
        while(tempi<=0) {
            System.out.println("The number is negative.Please give another Number:");
            tempi = getInt();
        }
        num=tempi;
        System.out.print("Weekly Salary : ");
        double sal = 0;
        tempd=getDouble();
        while(tempd<=0) {
            System.out.println("The salary is negative.Please give another salary:");
            tempd = getDouble();
        }
        sal=tempd;
        PlayerInfo New_player = new PlayerInfo( name, country, age, height,club,pos, num,sal );
        if(Club_Counter(New_player.getClub(),Players)>6)
        {
            System.out.println("The Club already has maximum members.Give another Player info");
            Add_Player_Choice(Players);
        }
        else {
            if (!Position_Checker(New_player)) {
                System.out.println("The position is invalid.Give another Player info");
                Add_Player_Choice(Players);
            } else {
                if (PlayerSearch.Search_by_Name(New_player.getName(), Players).size() != 0) {
                    System.out.println("There already exists a player with this name.Give another Player info.");
                    Add_Player_Choice(Players);
                } else {
                    if(Number_Checker(New_player,Players).size() != 0)
                    {
                        System.out.println("There already exists a player with this number.Give another Player info.");
                        Add_Player_Choice(Players);
                    }
                    else {
                        System.out.println("The Player is Added to the database successfully.");
                        Players = Add_Player(New_player, Players);
                    }
                }
            }
        }
    }
}
