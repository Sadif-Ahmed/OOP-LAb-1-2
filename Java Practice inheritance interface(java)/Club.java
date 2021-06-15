public class Club {
    private String clubname;
    private int id;
    public void setId(int id)
    {
        this.id=id;
    }
    public Club()
    {

    }
    public Club(String clubname,int id)
    {
        this.clubname=clubname;
        this.id=id;
    }
    public void setName(String clubname)
    {
        this.clubname=clubname;
    }
    public String getName()
    {
        return this.clubname;
    }
    public int getId()
    {
        return id;
    }
}
