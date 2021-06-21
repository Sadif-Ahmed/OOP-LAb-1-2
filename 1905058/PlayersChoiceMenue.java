import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayersChoiceMenue {
    List<PlayerInfo> PlayerList = new ArrayList();
    PlayersChoiceMenue(List<PlayerInfo> PlayerList)
    {
        this.PlayerList=PlayerList;
    }
    public static void PrintListpc(List<PlayerInfo> Players) {
        for (int i = 0; i < Players.size(); i++) {
            System.out.println("Player Number : "+"-------------"+ (i+1));
            System.out.print("Name          : " + Players.get(i).getName()+"\n");

            System.out.print("Country Name  : " + Players.get(i).getCountry()+"\n");

            System.out.print("Age           : "+ Players.get(i).getAge()+"\n");

            System.out.print("Height        : "+ Players.get(i).getHeight()+"\n");

            System.out.print("Club Name     : "+ Players.get(i).getClub()+"\n");

            System.out.print("Position      : "+ Players.get(i).getPosition()+"\n");

            System.out.print("Number        : "+ Players.get(i).getNumber()+"\n");

            System.out.print("Weekly Salary : "+ Players.get(i).getSalary()+"\n");
        }
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
            SearchList=PlayerSearch.Search_by_Name(name,Players);
            if(SearchList.size()==0)
            {
                System.out.println("No such player with this name");
            }
            else
            {
                System.out.println("The folllowing player with this name:");
                PrintListpc(SearchList);
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

            SearchList=PlayerSearch.Search_by_Club_and_Country(country,club,Players);
            if(SearchList.size()==0)
            {
                System.out.println("No such player with this country and club");
            }
            else
            {
                if(club.equalsIgnoreCase("ANY")) {
                    System.out.println("The folllowing player with this country:");
                    PrintListpc(SearchList);
                }
                else
                {
                    System.out.println("The folllowing player with this club and country:");
                    PrintListpc(SearchList);
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
            SearchList=PlayerSearch.Search_by_Position(position,Players);
            if(SearchList.size()==0)
            {
                System.out.println("No such player with this position");
            }
            else
            {
                System.out.println("The folllowing player with this position:");
                PrintListpc(SearchList);
            }
            Player_Choice(Players);
        }
        if(choice == 4)
        {
            double down_range;
            double up_range;
            System.out.println("Please input two numbers as Range :");
            down_range=pch.nextDouble();
            up_range=pch.nextDouble();
            List<PlayerInfo> SearchList = new ArrayList();
            SearchList=PlayerSearch.Search_by_SalaryRange(down_range,up_range,Players);
            if(SearchList.size()==0)
            {
                System.out.println("No such player with this weekly salary range");
            }
            else
            {
                System.out.println("The folllowing player within weekly salary range:");
                PrintListpc(SearchList);
            }
            Player_Choice(Players);
        }
        if(choice == 5)
        {
            List<PlayerInfo> SearchList = new ArrayList();
            SearchList=PlayerSearch.Country_list(Players);
            int [] Count=PlayerSearch.Country_PlayerCount(SearchList,Players);
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
}
