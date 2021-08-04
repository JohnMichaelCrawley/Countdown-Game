package countdowngame;

///////////////////////////
//       IMPORT LIST     //
///////////////////////////
import javax.swing.JOptionPane;         //Input, message etc//

/**
 * May 7th 2020 
 * CountdownGame.java
 * @author johncrawley
 */
public class CountdownGame 
{  
    /////////////////////////////////////////////////////
    //             COUNTDOWNGAME VARIABLES             //
    /////////////////////////////////////////////////////
    private static boolean isGameRunning = true;            //Boolean to run the game, if TRUE = game is running, if FALSE = game is not running//
    private static String input = "";                       //String to store the input//
    /////////////////////////////////////////////////////
    //                  PLAYER OBJECTS                 //
    /////////////////////////////////////////////////////
    public static Player playerOne = new Player("", 0);     //Declared player#1 object here to add the name and score later on//
    public static Player playerTwo = new Player("", 0);     //Declared player#2 object here to add the name and score later on//
    //MAIN METHOD//
    public static void main(String[] args) 
    {  
        //While the isGameRunning is TRUE, it will run the game, if FALSE it means the game is NOT running//
        while(isGameRunning == true)
        {
            //Display a welcome message to the user/s that they are welcomed to the game//
            JOptionPane.showMessageDialog(null, "Welcome to Countdown. \nThis is a two player game that you'll need to generate a word\nfrom the given amount of letters. The longest valid word wins.", "Welcome to Countdown", JOptionPane.PLAIN_MESSAGE);

            //Set up the two players//
            setupPlayers();
           //Set up the game round amount//
            roundAmountPrompt();

            //Round/s//
            rounds();

            //IF round is equal to the amount specificed//
            if(Game.getCurrentRound() == Game.getRoundAmount())
            {
                //Show if player#1 won based on the score//
                if(playerOne.getPlayerScore() > playerTwo.getPlayerScore())
                {
                    JOptionPane.showMessageDialog(null, playerOne.getPlayerName() + " wins!.");
                }
                //Show if player#2 won based on the score//
                else if(playerOne.getPlayerScore() < playerTwo.getPlayerScore())
                {
                    JOptionPane.showMessageDialog(null, playerTwo.getPlayerName() + " wins!.");
                }
                //Show if game ends in a draw//
                else if(playerOne.getPlayerScore() == playerTwo.getPlayerScore())
                {
                    JOptionPane.showMessageDialog(null, "The game ends in a draw!");
                }  
                //Ask the user/s if they want to play the game again//
                int result = JOptionPane.showConfirmDialog(null, "Do you want to play the game again?");
                
                //If the choice is, "YES" then the game starts again//
                if(result == JOptionPane.YES_OPTION)
                {
                    //Reset the two players//
                    playerOne.resetPlayer();
                    playerTwo.resetPlayer();
                    //Reset rounds of the game//
                    Game.resetRounds();
                    Game.resetLetters(); 
                    //Continue to the next iteration of the loop//
                    continue; 
                }
                //ELSE IF the choice is, "NO" then the game ends//
                else if(result == JOptionPane.NO_OPTION)
                {
                    //Print out to the user//
                    JOptionPane.showMessageDialog(null, "Thank you for playing the game");
                    isGameRunning = false;  //Turn off the boolean that keeps the game running//
                    break;                  //Break out the loop and end the game//
                }
            }
            else
            {
                
            }
        }

    }
      /////////////////////////////////////////////////////
     //        METHOD TO SET UP THE TWO PLAYERS         //
    /////////////////////////////////////////////////////  
    private static void setupPlayers()
    {
      ////////////////////////////////
     //   SETUP PLAYER VARIABLES   //
    /////////////////////////////////
        //String variables to hold the names temporarily//
        String tempNameOne = "", tempNameTwo = ""; 
        //Boolean variables to loop a while loop until the condition is TRUE//
        boolean isNameOneEntered = false, isNameTwoEntered = false;
      ////////////////////////////////
     //        SETUP PLAYER #1     //
    /////////////////////////////////
        while(isNameOneEntered == false)
        {
            //PROMPT user to enter their name in a JOptionPane and store it in the variable tempNameOne//
            tempNameOne = JOptionPane.showInputDialog(null, "Enter player #1 name", "Player #1 name", JOptionPane.INFORMATION_MESSAGE);
            //Ask user if they want the name they entered or if they want to change the name to something else//
            int dialogButtonOne = JOptionPane.showConfirmDialog (null, "Are you sure you want to use the name " + tempNameOne + " ?","WARNING",JOptionPane.YES_NO_OPTION);
            //IF: user picked, option 'YES' then set the name as what they entered//
            if(dialogButtonOne == JOptionPane.YES_OPTION) 
            {
                //SET player#1 name by using the temporary variable to enter the data//
                playerOne.setPlayerName(tempNameOne);
                //Set TRUE to break out of while loop and continue to the next player//
                isNameOneEntered = true;
            }
            //ELSE IF: the user picked the option, 'NO' the reset the while loop to change the name//
            else if (dialogButtonOne == JOptionPane.NO_OPTION)
            {
                //isNameOneEntered is set to FALSE//
                isNameOneEntered = false;       //Set the boolean to FALSE//
            }
            //ELSE: it will just be false and to repeat the loop//
            else
            {
                isNameOneEntered = false;       //Set the boolean to FALSE//
                continue;                       //Continue to the next iteration of the loop//
            }
        }
        
      ////////////////////////////////
     //       SETUP PLAYER #2       //
    //////////////////////////////////
    while(isNameTwoEntered == false)
        {                   
             //PROMPT user to enter their name in a JOptionPane and store it in the variable tempNameTwo//
            tempNameTwo = JOptionPane.showInputDialog(null, "Enter player #2 name", "Player #2 name", JOptionPane.INFORMATION_MESSAGE);
            //Ask user if they want the name they entered or if they want to change the name to something else//
            int dialogButtonOne = JOptionPane.showConfirmDialog (null, "Are you sure you want to use the name " + tempNameTwo + " ?","WARNING",JOptionPane.YES_NO_OPTION);
            //IF: user picked, option 'YES' then set the name as what they entered//
            if(dialogButtonOne == JOptionPane.YES_OPTION) 
            {
                //SET player#2 name by using the temporary variable to enter the data//
                playerTwo.setPlayerName(tempNameTwo);
                //Set TRUE to break out of while loop and continue to the next player//
                isNameOneEntered = true;    //Set the boolean to TRUE to end the loop//
                break;                      //Break out of the while loop//
            }
            //ELSE IF: the user picked the option, 'NO' the reset the while loop to change the name//
            else if (dialogButtonOne == JOptionPane.NO_OPTION)
            {
                //isNameOneEntered is set to FALSE//
                isNameTwoEntered = false;  
            }
            //ELSE: it will just be false and to repeat the loop//
            else
            {
                isNameTwoEntered = false;   //Set boolean to FALSE//
                continue;                   //Continue to next iteration of the loop//
            }
        }
        //Display the two players names in an output//
        JOptionPane.showMessageDialog(null, "Welcome, \nPlayer #1: " + playerOne.getPlayerName() + "\nPlayer #2: " + playerTwo.getPlayerName(), "Welcome " + playerOne.getPlayerName() + " & " + playerTwo.getPlayerName(), JOptionPane.PLAIN_MESSAGE);
       
        }  
      /////////////////////////////////////////////////////
     //    ROUND AMOUNT PROMPT FOR USER TO SPECIFIY     //
    /////////////////////////////////////////////////////
    public static void roundAmountPrompt()
    {
        //While round is equal to 0, loop until an amount is specified//
        while(Game.getRoundAmount() == 0)
        {
            //Get the round amount in an the int variable//
            input = JOptionPane.showInputDialog(null, "How many rounds do you want to play?", "Rounds", JOptionPane.INFORMATION_MESSAGE);
            //Set the round amount//
            Game.setRoundAmount(Integer.parseInt(input));
        }
        //Output the round/s amount to the user//
        JOptionPane.showMessageDialog(null, "Round/s amount = " + Game.getRoundAmount(), "Round/s", JOptionPane.WARNING_MESSAGE);
        
    }
      /////////////////////////////////////////////////////
     //             METHOD TO LOOP THE ROUNDS           //
    /////////////////////////////////////////////////////
    public static void rounds()
    {
        while (Game.getCurrentRound() < Game.getRoundAmount())
        {
            JOptionPane.showMessageDialog(null,"Current round is " + Game.getCurrentRound() + "\nRounds left: " + ((Game.getCurrentRound() - Game.getRoundAmount()) )  );
            System.out.println("CURRENT ROUND: " + Game.getCurrentRound());
            //Set the random letters up//
            Game.setupLettersForThePlayer();
            //Player#1 - enters their word//
            String playerOneWord = JOptionPane.showInputDialog(null, "Your letters are: " + Game.getRandomLetters() + "\n" + playerOne.getPlayerName() + " enter a Java keyword", playerOne.getPlayerName() + " enter a Java keyword", JOptionPane.QUESTION_MESSAGE);
            playerOne.setPlayerWord(playerOneWord);
            //Game.CheckInputMatchesKeyword(playerOneWord);  
            //Player#2 - enters their word/
            String playerTwoWord = JOptionPane.showInputDialog(null, "Your letters are: " + Game.getRandomLetters() + "\n" + playerTwo.getPlayerName() + " enter a Java keyword", playerTwo.getPlayerName() + " enter a Java keyword", JOptionPane.QUESTION_MESSAGE);
            playerTwo.setPlayerWord(playerTwoWord);
            //Game.CheckInputMatchesKeyword(playerTwoWord);   
             //Display the score of this round to the user//
             playerScoreSystem();                
            //Display who won the round//
            Game.roundWinner(playerOne.getPlayerWord(), playerTwo.getPlayerWord());
            //Reset the letters array//
            Game.resetLetters();   
            //Decrease current round//
            Game.setCurrentRound(1);
        }   
    } 
      /////////////////////////////////////////////////////
     //      PLAYER SCORE SYSTEM FOR THE TWO USERS      //
    /////////////////////////////////////////////////////
    public static void playerScoreSystem()
    {
        //If player#1 word matches keyword//
        if(Game.wordMatchesKeyword(playerOne.getPlayerWord()) == true)
        {
            //Add 10 points to the score
            playerOne.setPlayerScore(10);
        } 
        else if (Game.wordMatchesKeyword(playerOne.getPlayerWord()) == false)
        {
             //Add 10 points to the score
            playerOne.setPlayerScore(0);
        }
        else if (playerOne.getPlayerWord().isEmpty() || playerOne.getPlayerWord() == "")
        {
            playerOne.setPlayerScore(0);
        }
        //If player#2 word matches keyword//
        if(Game.wordMatchesKeyword(playerTwo.getPlayerWord()) == true)
        {
            //Add 10 points to the score
            playerTwo.setPlayerScore(10);
        }
        else if (Game.wordMatchesKeyword(playerTwo.getPlayerWord()) == false)
        {
             //Add 10 points to the score
            playerTwo.setPlayerScore(0);
        }
        else if (playerTwo.getPlayerWord().isEmpty() || playerTwo.getPlayerWord() == "")
        {
            playerOne.setPlayerScore(0);
        }
        //Display the two scores of the two players//
        JOptionPane.showMessageDialog(null, playerOne.getPlayerName() + " score = " + playerOne.getPlayerScore() + 
                "\n" + playerTwo.getPlayerName() + " score = " + playerTwo.getPlayerScore());    
    }  
}
