import java.util.ArrayList;
import java.util.List;

public class Club  {
    private int id;
    private String name;
    List<Player> Players = new ArrayList();
    private int playerCount;
    // add your code here

    // you are not allowed to write any other constructor
    public Club() {
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public int getId()
    {
        return this.id;
    }
    public void addPlayer(Player obj)
    {
       Players.add(obj);
    }
}
