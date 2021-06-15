import java.util.Scanner;

public class DemoMain {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int clubCount = 3;
        int leagueCount = 2;
        // take clubCount and leagueCount as input
        Club c[] = new Club[clubCount];
        for (int i = 0; i < clubCount; i++) {
            c[i] = new Club();
            c[i].setId(i + 1);
            String clubName;
            // take clubName as input
            clubName = scn.nextLine();
            c[i].setName(clubName);
        }
        League l[] = new League[leagueCount];
        for (int i = 0; i < leagueCount; i++) {
            l[i] = new League();
            String leagueName;
            // take leagueName as input
            leagueName = scn.nextLine();
            l[i].setName(leagueName);
        }
        l[0].addClub(c[0]);
        l[0].addClub(c[1]);
        l[1].addClub(c[1]);
        l[1].addClub(c[2]);
        for (int i = 0; i < leagueCount; i++) {
            l[i].printLeagueInfo();
            l[i].scheduleMatches();
            l[i].simulateMatches();
            l[i].printMatches();
            l[i].showStandings();
            l[i].printLeagueInfo();
        }

    }
}
