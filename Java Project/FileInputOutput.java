import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileInputOutput {
    List<PlayerInfo> PlayerList = new ArrayList();
    FileInputOutput(List<PlayerInfo> PlayerList)
    {
        this.PlayerList=PlayerList;
    }
    public static List<PlayerInfo> readFromFile() throws Exception {
        List<PlayerInfo> PlayerList = new ArrayList();
        BufferedReader br = new BufferedReader(new FileReader("players.txt"));

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
        BufferedWriter bw = new BufferedWriter(new FileWriter("players.txt"));

        for(int i=0;i<Players.size();i++) {
            bw.write(Players.get(i).getName() + "," + Players.get(i).getCountry() + "," + Players.get(i).getAge() + "," + Players.get(i).getHeight() + "," + Players.get(i).getClub() + "," + Players.get(i).getPosition() + "," + Players.get(i).getNumber() + "," + Players.get(i).getSalary());
            bw.write("\n");
        }
        bw.close();
    }
}
