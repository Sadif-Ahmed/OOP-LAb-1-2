import jdk.swing.interop.SwingInterOpUtils;

public class League {
    private Match[] matches;
    private int matchCount;
    private int clubCount;
    // add your variables here, if required
    String name;
    private Club [] clubs;
    private int [] scores;

    public League() {
        // assume a league can have at most 5 clubs, add code for initialization accordingly
       this.clubs=new Club[5];
       this.scores=new int [5];
        clubCount = 0;
        matchCount = 0;
    }

    public void printLeagueInfo(){
        System.out.println("League : " + name);
        printClubs();
    }

    public void printClubs(){
        System.out.println("Clubs:");
        // print the name of the clubs of this league, each one on a line
        for(int i=0;i<clubCount;i++)
        {
            System.out.println(clubs[i].getName());
        }
    }

    public void scheduleMatches(){
        matchCount = (clubCount*(clubCount-1));
        matches = new Match[matchCount];
        int matchNo = 0;
        for (int i=0; i<clubCount; i++){
            for (int j=0; j<clubCount; j++){
                // check the constructor of the Match class and add your code here
                // note that there will be two matches between club A and club B
                // in the first match, club A will play as the home team and in the second match, as the away team
           if(i!=j)
           {
               matches[matchNo++]=new Match(matchNo,clubs[i],clubs[j]);
           }
            }
        }
        for(int i=0;i<clubCount;i++)
        {
            scores[i]=0;
        }
    }

    public void simulateMatches(){
        for (int i=0; i<matchCount; i++){
            matches[i].play();
            if(matches[i].getMatchstatus()==0)
            {
                scores[clubfinder(matches[i].getHomeTeam())]+=1;
                scores[clubfinder(matches[i].getAwayTeam())]+=1;
            }
            else if(matches[i].getMatchstatus()==1)
            {
                scores[clubfinder(matches[i].getHomeTeam())]+=2;
            }
            else if(matches[i].getMatchstatus()==-1)
            {
                scores[clubfinder(matches[i].getAwayTeam())]+=2;
            }
        }
    }
    public void printMatches()
    {
        System.out.println("Matches:");
        for (int i=0; i<matchCount; i++){
            matches[i].showResult();
        }
    }

    public void showStandings(){
       Club[] Tempclubs;
       Tempclubs=new Club[clubCount];
       for(int i=0;i<clubCount;i++)
       {
           Tempclubs[i]=clubs[i];
       }
        // sort the clubs in descending order of points
      sortclubs(Tempclubs);
        // note that, the sequence in which clubs were added to the league, should be unchanged
        // check the given sample output for clarification
        // (carefully observe the output of showStandings() followed by printLeagueInfo() method calls
        // you can use additional arrays if needed
        System.out.println("Sl. - Club - Points");
        // print the clubs in descending order of points
        for(int i=0;i<clubCount;i++)
        {
            System.out.println((i+1)+". - "+Tempclubs[i].getName()+" - "+scores[i]);
        }
    }

    // add your methods here, if required
    public void setName(String leagueName)
    {
        this.name=leagueName;
    }
     public void addClub(Club obj)
     {
         clubs[clubCount]=obj;
         scores[clubCount]=0;
         clubCount++;
     }
    public void sortclubs(Club[] temp) {
        Club tm;
        int tempscore;
        for(int i=0;i<clubCount;i++)
        {
            for (int j = i + 1; j < clubCount; j++)
            {
                if (scores[j] >= scores[i])
                {
                    tm = temp[i];
                    tempscore=scores[i];
                    temp[i] = temp[j];
                    scores[i]=scores[j];
                    temp[j] = tm;
                    scores[j]=tempscore;
                }
            }
        }
    }

     public void removeClub(Club rmv)
     {
         Club [] temp;
         int [] tempscores;
         if(clubfinder(rmv)!=clubCount) {

             temp = new Club[clubCount - 1];
             tempscores = new int[clubCount - 1];
             int count = 0;
             for (int i = 0; i < clubCount; i++) {
                 if (this.clubs[i].getId() != rmv.getId()) {
                     temp[count] = clubs[i];
                     tempscores[count] = scores[i];
                     count++;
                 }
             }

             this.clubCount = count;
             for (int j = 0; j < count; j++) {
                 this.clubs[j] = temp[j];
                 this.scores[j] = tempscores[j];
             }
             for(int i=0;i<clubCount;i++)
             {
                 scores[i]=0;
             }
         }
         else
         {
             System.out.println("The club does not exist in this League.");
         }

     }
     public int clubfinder(Club obj) {
         int j;
         for (j = 0; j < clubCount; j++) {
             if (clubs[j].getId() == obj.getId()) {
                 break;
             }
         }

         return j;
     }

}

