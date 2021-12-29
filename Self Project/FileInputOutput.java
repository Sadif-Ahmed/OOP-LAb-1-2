import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileInputOutput {
    final private static String TEXTFILE="players.txt";
    public static List<PlayerInfo> readFromFile() throws Exception {
        List<PlayerInfo> PlayerList = new ArrayList();
        BufferedReader br = new BufferedReader(new FileReader(TEXTFILE));

        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] tokens = line.split(",");
            PlayerInfo p = new PlayerInfo();
            p.setName(tokens[0]);
            p.setCountry(tokens[1]);
            p.setAge(Integer.parseInt(tokens[2]));
            p.setHeight(Double.parseDouble(tokens[3]));
            p.setClub(tokens[4]);
            p.setPosition(tokens[5]);
            p.setNumber(Integer.parseInt(tokens[6]));
            p.setSalary(Double.parseDouble(tokens[7]));
            PlayerList.add(p);
        }
        br.close();
        return PlayerList;
    }
    public static void writeToFile(List<PlayerInfo> Players) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(TEXTFILE));

        for(int i=0;i<Players.size();i++) {
            bw.write(Players.get(i).getName() + "," + Players.get(i).getCountry() + "," + Players.get(i).getAge() + "," + Players.get(i).getHeight() + "," + Players.get(i).getClub() + "," + Players.get(i).getPosition() + "," + Players.get(i).getNumber() + "," + Players.get(i).getSalary());
            bw.write("\n");
        }
        bw.close();
    }
    public static List<Player>  Player_List_update(List<PlayerInfo> Players)
    {    List<Player> Playerlist = new ArrayList();
        for(int i=0;i<Players.size();i++)
        {
            Player temp = new Player(Players.get(i).getNumber(),Players.get(i).getName(),Players.get(i).getAge(),Players.get(i).getCountry(),Players.get(i).getHeight(),Players.get(i).getPosition(),Players.get(i).getSalary());
            Playerlist.add(temp);
        }
        return Playerlist;
    }
    public static List<Club>  Club_List_update(List<PlayerInfo> Players)
    {    List<Club> Clublist = new ArrayList();
        for(int i=0;i<Players.size();i++)
        {   Club temp= new Club();
            temp.setId(i+1);
            temp.setName(Players.get(i).getClub());
            Clublist.add(temp);
        }
        return Clublist;
    }
    public static void Add_to_Clublist(List<Club> Clublist,List<Player> Playerlist,List<PlayerInfo> Players)
    {
       for(int i=0;i<Players.size();i++)
       {
           for(int j=0;j<Clublist.size();j++)
           {
               if(Clublist.get(j).getName().equalsIgnoreCase(Players.get(i).getClub()))
               {
                  Clublist.get(j).addPlayer(Playerlist.get(i));
               }
           }
       }
    }
}
