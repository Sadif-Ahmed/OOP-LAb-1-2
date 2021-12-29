import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void main_menu_Outlet(int choice,List<PlayerInfo> Players) throws Exception
    {
        if(choice == 5)
        {
           FileInputOutput.writeToFile(Players);
            System.exit(0);
        }
        if(choice != 5)
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
            if(choice == 4) {
                Scanner scn=new Scanner(System.in);
                List<Player> Playerlist = new ArrayList();
                Playerlist=FileInputOutput.Player_List_update(Players);
                List<Club> Clublist = new ArrayList();
                Clublist=FileInputOutput.Club_List_update(PlayerSearch.Club_list(Players));
                FileInputOutput.Add_to_Clublist(Clublist,Playerlist,Players);
                int clubCount=Clublist.size();
                int leagueCount;
                System.out.println("Give LeagueCount:");
                leagueCount=scn.nextInt();
                scn.nextLine();
                // take clubCount and leagueCount as input
                League l[] = new League[leagueCount];
                for (int i = 0; i < leagueCount; i++) {
                    l[i] = new League();
                    String leagueName;
                    // take leagueName as input
                    System.out.println("Give League-Name:");
                    leagueName=scn.nextLine();
                    l[i].setName(leagueName);
                }

                for (int i=0; i<clubCount; i++){
                    l[i%leagueCount].addClub(Clublist.get(i));
                }


                for (int i = 0; i < leagueCount; i++) {
                    l[i].printLeagueInfo();
                    l[i].scheduleMatches();
                    l[i].simulateMatches();
                    l[i].printMatches();
                    l[i].showStandings();
                    l[i].printLeagueInfo();
                }
            }
            System.out.println("(1) Search Players");
            System.out.println("(2) Search Clubs");
            System.out.println("(3) Add Player");
            System.out.println("(4) Simulate Matches");
            System.out.println("(5) Exit System");
            System.out.print("Enter any number between 1 and 5: ");
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
        System.out.println("(4) Simulate Matches");
        System.out.println("(5) Exit System");
        System.out.print("Enter any number between 1 and 5: ");
        Scanner mn = new Scanner(System.in);
        choice = mn.nextInt();
        main_menu_Outlet(choice,Players);
    }
}

