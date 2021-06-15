
    public class Club {
        private int id;
        private String name;
        private Player[] players;
        private int playerCount;
        // add your code here

        // you are not allowed to write any other constructor
        public Club() {
            this.players = new Player[11];
            playerCount=0;
        }

        public double getSalary() {
            double total = 0;
            for (int i = 0; i < playerCount; i++) {
                total += players[i].getSalary();
            }
            return total;
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
        public int getPlayerCount()
        {
            return this.playerCount;
        }
        public Player getMaxSalaryPlayer()
        {
            Player temp=players[0];
            for(int i=0;i<playerCount;i++)
            {
              if(players[i].getSalary()>= temp.getSalary())
              {
                  temp=players[i];
              }
            }
            return temp;
        }
        void addPlayer(Player obj)
        {
            players[playerCount]=obj;
            playerCount++;
        }
        // add your code here
    }

