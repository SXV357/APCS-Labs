class Team {
    Player[] players;

    public Team(){
        players = new Player[9];
    }

    public Team(int numPlayers){
        players = new Player[numPlayers];
    }

    public void addPlayer(Player p, int index){
        players[index] = p;
    }

    public String returnPlayerAtParticularIndex(int index){
        return players[index].getName();
    }

    public String returnNumberPlayers(){
        String num = String.valueOf(players.length);
        return num;
    }

    public void printTeamStats(){
        for(int i = 0; i < players.length; i++){
            System.out.println(players[i].getName() + " " + "#" + players[i].getNumber() + " " + "average >>> " + players[i].getBattingAverageString());
        }
    }
}
