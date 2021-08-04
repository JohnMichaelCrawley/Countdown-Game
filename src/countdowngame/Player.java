package countdowngame;
/**
 * May 7th 2020 
 * Player.java
 * @author johncrawley
 */
public class Player 
{
    /////////////////////////////////////////////////////
    //         PRIVATE PLAYER CLASS VARIABLES          //
    /////////////////////////////////////////////////////
    //STRINGS Variables//
    private String playerName;                       //Player's name//
    private String word;                             //Player's words entered each round//
    //INT Variables//
    private int score = 0;                           //Player's score//
 
    /////////////////////////////////////////////////////
    //         DEFAULT PLAYER CLASS CONSTRUCTOR        //
    /////////////////////////////////////////////////////
     public Player()
    {
        this.playerName = "";                       //Give value of pName String to playerName//  
        this.score = 0;                            //Give value of pScore int to score//    
    } 
    /////////////////////////////////////////////////////
    //              PLAYER CLASS CONSTRUCTOR           //
    /////////////////////////////////////////////////////
    public Player(String pName , int pScore)
    {
        this.playerName = pName;                        //Give value of pName String to playerName//  
        this.score = pScore;                            //Give value of pScore int to score//      
    } 
     /////////////////////////////////////////////////////
    //                    SETTERS                      //
    /////////////////////////////////////////////////////
    //Set Player One Name - METHOD//
    public void setPlayerName(String playerNameSetter)
    {
        this.playerName = playerNameSetter;           //Give value that was given in the parentheses to playerNameOne//
    }
    //Set Player One Score - METHOD//
    public void setPlayerScore(int playerScoreSetter)
    { 
        this.score += playerScoreSetter;               //Give value that was given in the parentheses to playerOneScore//
    } 
    //Set Player Word - METHOD//
    public void setPlayerWord(String wordSetter)
    {
        this.word = wordSetter;                         //Give value that was given in the parentheses to the word variable// 
    } 
    /////////////////////////////////////////////////////
    //                    GETTERS                      //
    /////////////////////////////////////////////////////
    //Get Player Name - String METHOD//
    public String getPlayerName()
    {
        return playerName;                            //Return the value of playerName//
    }
    //Get Player Words - String METHOD//
    public String getPlayerWord()
    {     
        return word;                                 //Return the word player used in the round//
    }
    //Get Player Score - int METHOD//
    public int getPlayerScore()
    {
        return score;                               //Return the value of playerOneScore//
    }
     /////////////////////////////////////////////////////
    //                     RESETTERS                    //
    /////////////////////////////////////////////////////
    //Completely reset the player values//
    public void resetPlayer()
    {
        playerName = "";                       //RESET: Player name//
        resetWord();                           //RESET: Player word//
        score = 0;                             //RESET: Player score//
    }
    //Reset the player word they entered//
    public  void resetWord()
    {
        word = "";                                  //Remove word//
    }  
}
