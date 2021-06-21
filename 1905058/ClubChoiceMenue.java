import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClubChoiceMenue {
    List<PlayerInfo> PlayerList = new ArrayList();
   ClubChoiceMenue(List<PlayerInfo> PlayerList)
    {
        this.PlayerList=PlayerList;
    }
    public static void PrintListcc(List<PlayerInfo> Players) {
        for (int i = 0; i < Players.size(); i++) {
            System.out.println("Player Number : "+"-------------"+": "+(i+1));
            System.out.print("Name          : " + Players.get(i).getName()+"\n");

            System.out.print("Country Name  : " + Players.get(i).getCountry()+"\n");

            System.out.print("Age           : "+ Players.get(i).getAge()+"\n");

            System.out.print("Height        : "+ Players.get(i).getHeight()+"\n");

            System.out.print("Club Name     : "+ Players.get(i).getClub()+"\n");

            System.out.print("Position      : "+ Players.get(i).getPosition()+"\n");

            System.out.print("Number        : "+ Players.get(i).getNumber()+"\n");

            System.out.print("Weekly Salary : "+ Players.get(i).getSalary()+"\n");
            System.out.println("");
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
            SearchList=ClubSearch.Search_Club_Highest_Salary(club,Players);
            if(SearchList.size()==0)
            {
                System.out.println("No such club with this name");
            }
            else if(SearchList.size()==1)
            {
                System.out.println("The Player with maximum salary:");
                PrintListcc(SearchList);
            }
            else
            {
                System.out.println("The Players with maximum salary:");
                PrintListcc(SearchList);
            }
            Club_Choice(Players);
        }
        if(choice == 2)
        {   String club;
            List<PlayerInfo> SearchList = new ArrayList();
            System.out.println("Give your desired club name:");
            club=cch.nextLine();
            SearchList=ClubSearch.Search_Club_Max_Age(club,Players);
            if(SearchList.size()==0)
            {
                System.out.println("No such club with this name");
            }
            else if(SearchList.size()==1)
            {
                System.out.println("The Player with maximum Age:");
                PrintListcc(SearchList);
            }
            else
            {
                System.out.println("The Players with maximum Age:");
                PrintListcc(SearchList);
            }
            Club_Choice(Players);
        }
        if(choice == 3)
        {
            String club;
            List<PlayerInfo> SearchList = new ArrayList();
            System.out.println("Give your desired club name:");
            club=cch.nextLine();
            SearchList=ClubSearch.Search_Club_Max_Height(club,Players);
            if(SearchList.size()==0)
            {
                System.out.println("No such club with this name");
            }
            else if(SearchList.size()==1)
            {
                System.out.println("The Player with maximum Height:");
                PrintListcc(SearchList);
            }
            else
            {
                System.out.println("The Players with maximum Height:");
                PrintListcc(SearchList);
            }
            Club_Choice(Players);
        }
        if(choice == 4)
        {
            String club;
            System.out.println("Give your desired club name:");
            club=cch.nextLine();
            System.out.println("The yearly salary of the club"+" "+club+" is: ");
            System.out.printf("%10f \n",ClubSearch.Yearly_Club_Salary(club,Players));
            Club_Choice(Players);
        }
        if(choice >5 || choice <1)
        {
            System.out.println("Number not between 1 and 5. Try again");
            Club_Choice(Players);
        }
    }
}
