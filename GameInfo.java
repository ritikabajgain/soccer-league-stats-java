public class TeamInfo
{ 
   private String name;
   private int wins;
   private int looses;
   private int draws;
   private int goalsScored;
   private int goalsGet;
   
   public TeamInfo(String teamName)
   {
      name = teamName;
      wins = 0;
      losses = 0;
      draws = 0;
      goalsScored = 0;
      goalsGet = 0; 
   }
   
   public void setName(String tName)
   {
      name = tName;
   }
   public String getName()
   {
      return name;
   }
   
   public void setWins(int winn)
   {
      wins = winn;
   }
   public int getWins()
   {
      return wins;
   }
   
   public void setLoss(int loss)
   {
      looses = loss;
   }
   public int getLoss()
   {
      return losses;
   }
   
   public void setDraws(int draw)
   {
      draws = draw;
   }
   public int getDraws()
   {
      return draws; 
   }
   
   public int getGoalsScored()
   {
      return goalsScored;
   }
   
   public int getGoalsGet()
   {
      return goalsGet;
   }
   
   public int getPoints()
   {
      return wins * 3 + draws;
   }
   
   public void teamStatus(int socredGoals, int getGoals)
   {
      goalsScored += scoredGoals;
      goalsGet += getGoals;
      if (scoredGoals > getGoals)
      {
         wins++;
      }
      else if (getGoals < scoredGoals)
      {
         losses++;
      }
      else
      {
         draws++;
      }
   }
}