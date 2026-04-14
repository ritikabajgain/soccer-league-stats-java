/**
Date: November 28, 2023
Course: CSCI 2073
Description: To keep track of team records and related statistics.
On my honor, I have neither given nor received unauthorized help while 
completing this assignment. 
Name: Ritika Bajgain
CWID: 30155503 
*/

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
*Class that represents SoccerStats
*/
public class SoccerStats
{
   //Declare a hash map
   private HashMap<String, TeamInfo> teams = new HashMap<>();
   
   /**
   *Create a one argument constructor to store game information
   *@param csvFile a csv file to read
   */
   public SoccerStats(String csvFile)
   {
      try
      {
         Scanner in = new Scanner(new File(csvFile));
         while (in.hasNext())
         {
            String line = in.nextLine();
            Scanner each = new Scanner(line);
            each.useDelimiter(",");
            String homeTeam = each.next();
            String awayTeam = each.next();
            int homeGoals = each.nextInt();
            int awayGoals = each.nextInt();
            updateInfo(homeTeam, homeGoals, awayGoals); //update home team information
            updateInfo(awayTeam, awayGoals, homeGoals); //update away team information
         }
         in.close();
      }//close try
      
      catch (FileNotFoundException ex)
      {
         System.out.println("Error!");
      }
   }//close constructor
   
   /**
   *Method to update team information
   *@param tName name of the team
   @param goalScored number of goals scored by the team
   @param goalGet number of goals scored against the team
   */
   private void updateInfo(String tName, int goalScored, int goalGet)
   {
      //Check if the hash map key contains the given team name
      if (!teams.containsKey(tName))
      {
         teams.put(tName, new TeamInfo(tName));
      }
      TeamInfo team = teams.get(tName);
      team.teamStatus(goalScored, goalGet); 
   }
   
   /**
   *Method to display the results as per the requests
   *@param statsFile a file containing a number of requests
   */
   public String getStats(String statsFile)
   {
      try
      {
         String output = "";
         Scanner in = new Scanner(new File(statsFile));
         while (in.hasNext())
         {
            String stats = "";
            String line = in.nextLine();
            if (line.equals("HSCORING"))
            {
               stats = highScore();
            }
            else if (line.equals("BEST"))
            {
               stats = "BEST: " + teamStats(bestTeam());
            }
            else
            {
               stats = "TEAM: " + teamStats(line.substring(6));
            }
            output += stats;
         }//close while
         in.close();
         return output;
      }//close try
      
      catch (FileNotFoundException ex)
      {
         return "Error!";
      }
   }// close getStats method
   
   /**
   *Method to get the name of the best team
   *@return name the name of the best team
   */
   private String bestTeam()
   {
      TeamInfo bTeam = null;
      int highPoints = 0;
      for (TeamInfo team: teams.values())
      {
         if (team.calculatePoints() > highPoints)
         {
            bTeam = team;
            highPoints = team.calculatePoints();
         }
         else if (team.calculatePoints() == highPoints)
         {
            int tGoalsDiff = team.getGoalsScored()-team.getGoalsGet();
            int bGoalsDiff = bTeam.getGoalsScored()-bTeam.getGoalsGet();
            if (tGoalsDiff > bGoalsDiff)
            {
               bTeam = team;
            }
            else if (tGoalsDiff == bGoalsDiff)
            {
               int tGoals = team.getGoalsScored();
               int bGoals = bTeam.getGoalsScored();
               if (tGoals > bGoals)
               {
                  bTeam = team;
               }
            }
         }
      }
      return bTeam.getName();
   }
   
   /**
   *Method to get the team names that have scored more goals than the best team
   */
   private String highScore()
   {
      String result = "";
      String bTeam = bestTeam();
      int maxScore = teams.get(bTeam).getGoalsScored();
      String hTeams = "";
      
      for (TeamInfo team: teams.values())
      {
         int goalsAgainst = team.getGoalsScored();
         if (goalsAgainst > maxScore)
         {
            hTeams += team.getName() + ", "; 
         }
      }
      if (hTeams.equals(""))
      {
         result = "HIGH SCORERS: NONE"; 
      }
      else
      {
         result = "HIGH SCORERS: " + hTeams.substring(0, hTeams.length()-2);
      }
      return result;
   }//close method
   
   /**
   *Method to display the team stats in the given format
   *@param teamN name of the team
   *@return result the stats of the team given in the required format
   */
   private String teamStats(String teamN)
   {
      String result = "";
      TeamInfo team = teams.get(teamN);
      if (team == null)
      {
         result = teamN + " NOT FOUND\n";
      }
      else 
      {
         result = teamN + " W: " + team.getWins() + " D: " + team.getDraws() +
                  " L: " + team.getLoss() + " GF: " + team.getGoalsScored() +
                  " GA: " + team.getGoalsGet() + " PTS: " + team.calculatePoints() + "\n"; 
      }
      return result;
   }
   
}//close class