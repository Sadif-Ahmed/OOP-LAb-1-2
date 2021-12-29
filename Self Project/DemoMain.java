import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DemoMain {
    public static void main(String[] args) throws Exception{
        List<PlayerInfo> Players = new ArrayList();
        Players = FileInputOutput.readFromFile();
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


        int leagueIndex = 0;
        int clubIndex = 0;
        // club and league indexes may be changed during evaluation
        // you can take it as input or leave it as it is (optional)
        System.out.println("Give the League index(you want to remove) :");
        leagueIndex=scn.nextInt();
        System.out.println("Give the Club index(you want to remove):");
        clubIndex=scn.nextInt();
        l[leagueIndex].removeClub(Clublist.get(clubIndex));
        l[leagueIndex].printLeagueInfo();
        l[leagueIndex].scheduleMatches();
        l[leagueIndex].simulateMatches();
        l[leagueIndex].printMatches();
        l[leagueIndex].showStandings();
        l[leagueIndex].printLeagueInfo();




    }
    }
