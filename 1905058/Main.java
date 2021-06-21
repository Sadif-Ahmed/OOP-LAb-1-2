import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void main_menu_Outlet(int choice,List<PlayerInfo> Players) throws Exception
    {
        if(choice == 4)
        {
           FileInputOutput.writeToFile(Players);
            System.exit(0);
        }
        if(choice != 4)
        {
            if(choice >4 || choice <1)
            {
                System.out.println("Number not between 1 and 4. Try again");
            }
            if(choice == 1) {
                PlayersChoiceMenue.Player_Choice(Players);
            }
            if(choice == 2) {
                ClubChoiceMenue.Club_Choice(Players);
            }
            if(choice == 3) {
                AddPlayer.Add_Player_Choice(Players);
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
        List<PlayerInfo> Players = new ArrayList();
        Players = FileInputOutput.readFromFile();
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

