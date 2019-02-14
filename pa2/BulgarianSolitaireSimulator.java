import java.util.ArrayList;
import java.util.Scanner;

// Name:HANG DONG
// USC NetID:donghang
// CSCI455 PA2
// Fall 2018


/**
 * Class BulgarianSolitaireSimulator
 * Simulates Bulgarian Solitaire game and displays the result of each round.
 * two ways to simulate. (1)User can input the initial configuration. (2) The program will construct a random initial state.
 * User can control the display mode-- single step or full speed.
*/

public class BulgarianSolitaireSimulator {

     /**
	 * Main method, entrance of project.
	 * @param args	argument list (for java execution configuration).
	 * 		-u Prompts for the initial configuration from the user, instead of generating a random configuration.
	 * 		-s Stops between every round of the game. The game only continues when the user hits enter (a.k.a., return).
	 */
   public static void main(String[] args) {
     
      boolean singleStep = false;
      boolean userConfig = false;

      for (int i = 0; i < args.length; i++) {
         if (args[i].equals("-u")) {
            userConfig = true;
         }
         else if (args[i].equals("-s")) {
            singleStep = true;
         }
      }
      SolitaireBoard s_Board;
      ArrayList<Integer> list = new ArrayList<Integer>();
      if(userConfig) 
      {
	   user_input(list);		      //user input
	   s_Board = new SolitaireBoard(list); //create the board if it is valid
	   user_mod(s_Board);		      //user input play
      }
   
      if(singleStep) 
      {
	   s_Board = new SolitaireBoard();
	   single_mod(s_Board);		     //single-step play
      }
      
      
   }
   /**
   * Returns true iff is valid to play
   * @param ArrayList<Integer> list, list is used to store user's input 
   */
  private static boolean valid_check(ArrayList<Integer> list )
  {
        int total_cards = 0;
		for(int i =0; i < list.size(); i++)
		{
			if(list.get(i) <=0 || list.get(i) > SolitaireBoard.CARD_TOTAL)
			{
				return false;
			}
			total_cards += list.get(i);
		}
		if(total_cards == SolitaireBoard.CARD_TOTAL)
		{
			return true;  
		}
		else
		{
			return false;
		}
  }
  /**
  * User input piles. keep on this step if the input is invalid. 
  * @param ArrayList<Integer> list is used to store user's inputs
  */
  private static void user_input(ArrayList<Integer> list)
  {
    System.out.println("Number of total cards is 45");
    System.out.println("You will be entering the initial configuration of the cards (i.e., how many in each pile).");
    System.out.println("Please enter a space-separated list of positive integers followed by newline:");
    Scanner in = new Scanner(System.in);
    String line = in.nextLine();
	Scanner lineScanner = new Scanner(line);
    while(lineScanner.hasNextInt())
    {
      int value = lineScanner.nextInt();
      list.add(value);
    }
    while(!valid_check(list))
    {
       System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be 45"); 
	   System.out.println("Please enter a space-separated list of positive integers followed by newline:");
       list.clear();
       line = in.nextLine();
       lineScanner = new Scanner(line);
       while(lineScanner.hasNextInt())
      {
        int value = lineScanner.nextInt();
        list.add(value);
      }
    }
  }
  /**
  * Single mode. Start BulgarianSolitaire game by step.
  * @param SolitaireBoard s_Board
  */ 
  private static void user_mod(SolitaireBoard s_Board)
  {
    int step_count=1;
    System.out.println("Initial configuration: " + s_Board.configString());
    while(!s_Board.isDone())
    {
       s_Board.playRound();
       System.out.println("[" + step_count + "] "+"Current configuration: " + s_Board.configString());
       step_count++;
    }
    System.out.println("Done!");
  }  
  /**
  * User mode. Start BulgarianSolitaire game by user input.
  * @param SolitaireBoard s_Board
  */
  private static void single_mod(SolitaireBoard s_Board)
  {
    int step_count=1;
    System.out.println("Initial configuration: " + s_Board.configString());
    Scanner in = new Scanner(System.in);
    while(!s_Board.isDone())
    {
       s_Board.playRound();
       System.out.println("[" + step_count + "] "+"Current configuration: " + s_Board.configString());
       step_count++;
       System.out.print("<Type return to continue>");
       in.nextLine();
    }
    System.out.println("Done!");
  } 
}
