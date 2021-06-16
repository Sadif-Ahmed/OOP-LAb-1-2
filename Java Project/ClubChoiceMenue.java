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
            System.out.println(Players.get(i).getName() + " , " + Players.get(i).getCountry() + " , " + Players.get(i).getAge() + " , " + Players.get(i).getHeight() + " , " + Players.get(i).getClub() + ", " + Players.get(i).getPosition() + " , " + Players.get(i).getNumber() + " , " + Players.get(i).getSalary());
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
            ClubSearch Test= new ClubSearch(SearchList);
            SearchList=Test.Search_Club_Highest_Salary(club,Players);
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
            ClubSearch Test= new ClubSearch(SearchList);
            SearchList=Test.Search_Club_Max_Age(club,Players);
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
            ClubSearch Test= new ClubSearch(SearchList);
            SearchList=Test.Search_Club_Max_Height(club,Players);
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
            ClubSearch Test= new ClubSearch(Players);
            System.out.println("Give your desired club name:");
            club=cch.nextLine();
            System.out.println("The yearly salary of the club"+" "+club+" is: ");
            System.out.printf("%10f \n",Test.Yearly_Club_Salary(club,Players));
            Club_Choice(Players);
        }
        if(choice >5 || choice <1)
        {
            System.out.println("Number not between 1 and 5. Try again");
            Club_Choice(Players);
        }
    }
}
