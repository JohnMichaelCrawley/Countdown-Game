package countdowngame;
////////////////////////////
//       IMPORT LIST      //
//////// ///////////////////
import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * May 7th 2020 
 * Game.java
 * @author johncrawley
 */
public class Game 
{
    /////////////////////////////////////////////////////
    //           PRIVATE GAME CLASS VARIABLES          //
    /////////////////////////////////////////////////////
    //RANDOM// 
    private static Random randomize = new Random();                         //Way to randomize the array of vowels or consonants//
    //CHAR - Variables//
    //STRING ARRAY - Used to store all the vowels//
    private  static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};        //Array to store the vowels//
    //STRING ARRAY - Used to store all the consonant//
    private static char[] CONSONANTS =                                      //Array to store the consonants//
    {'b', 'c', 'd','f', 'g', 'h', 'k', 'l', 'm', 'n', 'p', 'r', 's', 't', 'v', 'w', 'y', 'z'};
    //STRING - Variables/
    //STRING ARRAY - Used to store all the keywords in the game and to compare to//    
    private static final String[] KEYWORDS =        //Array to store all 48 keywords for Java keywords//
    {
                        "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "continue", "default", "do", "double", "else", 
                        "enum", "extends", "final", "finally", "float", "for", "if", "import", "int", "interface", "long", "native", "new", "package", "private", 
                        "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "this", "throw", "throws", "transient", "try", 
                        "void", "volatile", "while"
    };
    
    private static char[] letters = new char[9];                           //Array to store the letters randomly made//


    //INT - Variables//
    //Storage for the amount of rounds the user entered//
    private static int rounds = 0;                                        //Int to store the round that there will be//
    //Storage of the current round that increases after the last round//
    private static int currentRound = 0;                                  //Int to store the current round of the game//
    private static int lettersLeft = 9;                                   //Int to store the letters remaining when getting the random letters//
    private static int index = 0;                                         //Int to store the index position of an array//
    
    
    //BOOLEAN - Variables//
    private static boolean isPlayerOneWordFoundInKeywords = false;        //Boolean to check player#1 word is found in keywords array if TRUE//
    private static boolean isPlayerTwoWordFoundInKeywords = false;        //Boolean to check player#2 word is found in keywords array if TRUE//
    
      /////////////////////////////////////////////////////
     //    CHECK INPUT MATCHES KEYWORD IN ARRAY/LIST    //
    /////////////////////////////////////////////////////
    //START CheckWord//
    public static void checkInputMatchesKeyword(String wordFromPlayer)
    {
       //Change the input to lowercase// 
       wordFromPlayer.toLowerCase();                                   
      //Loop through array//
       for(int i = 0 ; i < KEYWORDS.length;i++)
              {
                     //Check if word matches inside the KEYWORDS array//
                      if(KEYWORDS[i].contains(wordFromPlayer))
                      {       
                          //Display to the player word found and the entered word//
                          JOptionPane.showMessageDialog(null, "Your word: " + wordFromPlayer + " was found as a keyword");
                      }
                      else
                      {
                           //Display to the player word was NOT found and the entered word//
                          JOptionPane.showMessageDialog(null, "Your word: " + wordFromPlayer + " was NOT found as a keyword");
                      }
                  }
    }
    //END CheckWord//  
      /////////////////////////////////////////////////////
     //  CHECK WORD LENGTH WITH PLAYER#1 AND PLAYER#2   //
    /////////////////////////////////////////////////////
    //START CheckLength//
    /*
    SELF-NOTE: I can have two string inputs in the parentheses to get the words 
    */
    public static void checkWordLengthBetweenTwoPlayers(String pOneeWord, String pTwoWord)
    {
        //IF player#1 word length is longer than player#2 word length//
        if(pOneeWord.length() > pTwoWord.length())
        {
            CountdownGame.playerOne.setPlayerScore(10);                             //Add 10 points to player#1 score//
            JOptionPane.showMessageDialog(null, "Player #1 has the longest word");  //Display to the user that their word is the longest//
        }
        //IF player#2 word length is longer than player#1 word length//
        else if (pOneeWord.length() < pTwoWord.length())
        {
            CountdownGame.playerTwo.setPlayerScore(10);                             //Add 10 points to player#2 score//
            JOptionPane.showMessageDialog(null, "Player #21 has the longest word"); //Display to the user that their word is the longest//
        }
        //Finally, IF the words are equally the same length//
        else if (pOneeWord.length() == pTwoWord.length())
        {
            JOptionPane.showMessageDialog(null, "The round ended in a draw");       //Display that the round ended in a draw//
        }
        
    }
    //END CheckLength// 
      /////////////////////////////////////////////////////
     //             CHECK WHO WON THE ROUND             //
    /////////////////////////////////////////////////////
    //START//
    public static void roundWinner(String playerOneWord, String playerTwoWord)
    {
       //Change the words to lowercases//
       playerOneWord.toLowerCase();
       playerTwoWord.toLowerCase();
       
       //KEYWORDS.equals(playerOneWord);
       for(int b = 0; b < KEYWORDS.length; b++)
       {
           //Check keywords if word is found, if TRUE = word found, if FALSE = word not found//
           isPlayerOneWordFoundInKeywords =  KEYWORDS[b].contains(playerOneWord);
           isPlayerTwoWordFoundInKeywords =  KEYWORDS[b].contains(playerTwoWord);
       }

       //Check IF both words are inside the KEYWORDS array//
       if(isPlayerOneWordFoundInKeywords == true && isPlayerTwoWordFoundInKeywords == true)
       {
           //Pass the values into a method to check the length//
           checkWordLengthBetweenTwoPlayers(playerOneWord, playerTwoWord);
       }
       //Check if player 1 word was found and player 2 was not found//
       else if (isPlayerOneWordFoundInKeywords == true && isPlayerTwoWordFoundInKeywords == false)
       {
           JOptionPane.showMessageDialog(null, "Player #1 Won!!!!!");
       }
       //Check if player 2 word was found and player 1 was not found//
       else if (isPlayerOneWordFoundInKeywords == false && isPlayerTwoWordFoundInKeywords == true)
       {
          JOptionPane.showMessageDialog(null, "Player #2 Won!!!!!");
       }    
    } 
    //END//

      //////////////////////////////////////////////////////
     //SET UP THE RANDOM LETTERS FOR PLAYER TO MAKE A WORD//
    ///////////////////////////////////////////////////////
    public static void setupLettersForThePlayer()
    {
        for(int i = 0; i < 9; i++)
        {
            //Message box to get the letters//
            int l = JOptionPane.showConfirmDialog(null, "Check, 'YES' for vowels, CHECK, 'NO' for consonants " + "\n" + "Letters left: " + lettersLeft + "\nLetters = " + Arrays.toString(letters), "Countdown Game", JOptionPane.YES_NO_OPTION);
           
            lettersLeft--;  //Remove 1 from the int variable  
            //For loop to check for duplicates//
            
            //IF, 'YES' a vowel is selected//
            if(l == JOptionPane.YES_OPTION)
            {
                index = randomize.nextInt(VOWELS.length);
                letters[i] = VOWELS[index];
            }
            //ELSE IF, 'NO' a CONSONANTS is selected//
            else if (l == JOptionPane.NO_OPTION)
            {
                index = randomize.nextInt(CONSONANTS.length);
                
                /*
                  Using if statements to try reduce repeating letters
                  using basic form in 1D arrays
                */
                if(letters[i] == CONSONANTS[index])
                {
                    if(index > CONSONANTS.length)
                    {
                        index--;
                        letters[i] = CONSONANTS[index];
                    }
                    else if (index < CONSONANTS.length)
                    {
                        index++;
                        letters[i] = CONSONANTS[index];
                    }
                }
                else
                {
                    letters[i] = CONSONANTS[index];
                }           
            }    
        }
        
    }   
      //////////////////////////////////////////////////////
     // USED TO CHECK IF KEYWORD IS FOUND IN KEYWORDS //
    ///////////////////////////////////////////////////////
    /*
    NOTE: If return true, keyword is found, if false word isn't found in keyword
    */
    public static boolean wordMatchesKeyword(String userWordEntered)
    {
         boolean result = false;                    //Create boolean to store result//
         //userWordEntered.toLowerCase();     //Change the word to lowercase//
         //Loop through the array//
         for(int i = 0 ; i < KEYWORDS.length ; i++)
         {     
            //IF the word is found in the KEYWORDS array, return TRUE//
            if(userWordEntered.contains(KEYWORDS[i]))
            {
                //Return if the keyword is found//
                result = true;     
            }                 
        }
        //Return boolean results//
        return result; 
    }
      /////////////////////////////////////////////////////
     //                     SETTERS                     //
    /////////////////////////////////////////////////////
     //Round setter//
    //START//
    public static void setRoundAmount(int roundAmount)
    {       
       rounds = roundAmount;                            //Set roundAmount//
    }
    //END//
    
    //Current round setter//
    public static void setCurrentRound(int setCurrentRound)
    {
        currentRound += setCurrentRound;                //Set current round//     
    }
     /////////////////////////////////////////////////////
     //                     GETTERS                     //
    /////////////////////////////////////////////////////
  
    //Round getter//
    //START//
    public static int getRoundAmount()
    {
        return rounds;                                  //Return round//
    }
    //END//

    //Current round getter//
    //START//
    public static int getCurrentRound()
    {
        return currentRound;                            //Return current round//
    }
    //END//

    //START//
    public static String getRandomLetters()
    {
        return Arrays.toString(letters);                //Return char array to String//
    }
    //END//

      /////////////////////////////////////////////////////
     //                     RESETTER                    //
    ///////////////////////// ////////////////////////////
     //Clear rounds//
    //START//
    public static void resetRounds()
    {
       rounds = 0;                                      //Reset round amount//
    }
    
    //Reset all the letters and counter//
    public static void resetLetters()
    {
        for(int x = 0; x < letters.length; x++)
        {
            letters[x] -= letters[x];
        }
       
        lettersLeft = 9;
    }
    //END//   
    
}

