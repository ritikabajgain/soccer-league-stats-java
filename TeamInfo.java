/**
*Class that represents TeamInfo
*/
public class TeamInfo
{ 
   //Declare instance variables
   private String name;
   private int wins;
   private int losses;
   private int draws;
   private int goalsAgainst;
   private int goalsFor;
   
   /**
   *Creates a one argument constructor
   *@param teamName name of the team
   */
   public TeamInfo(String teamName)
   {
      name = teamName;
      wins = 0;
      losses = 0;
      draws = 0;
      goalsAgainst = 0;
      goalsFor = 0; 
   }
   
   /**
   *Method to get the name of the team
   *@return name the name of the team
   */
   public String getName()
   {
      return name;
   }
   
   /**
   *Method to get the number of wins
   *@return wins number of times the team won
   */
   public int getWins()
   {
      return wins;
   }
   
   /**
   *Method to get the number of losses
   *@return losses number of times the team losse
   */
   public int getLoss()
   {
      return losses;
   }
   
   /**
   *Method to get the number of draws
   *@return draws number of draws
   */
   public int getDraws()
   {
      return draws; 
   }
   
   /**
   *Method to get the number of goals scored by a team
   *@return goalsAgainst the number of goals scored
   */
   public int getGoalsScored()
   {
      return goalsAgainst;
   }
   
   /**
   *Method to get the number of goals scored against the team
   *@return goalsFor the number of goals got
   */
   public int getGoalsGet()
   {
      return goalsFor;
   }
   
   /**
   *Method to calculate and get the points of the team
   *@points of the team
   */
   public int calculatePoints()
   {
      return wins * 3 + draws;
   }
   
   /**
   *Method to update the team status 
   *@param scoredGoals goals scored by the team
   *@param getGoals goals scored against the team
   */
   public void teamStatus(int scoredGoals, int getGoals)
   {
      goalsAgainst += scoredGoals;
      goalsFor += getGoals;
      if (scoredGoals > getGoals)
      {
         wins++;
      }
      else if (scoredGoals < getGoals)
      {
         losses++;
      }
      else
      {
         draws++;
      }
   }
}