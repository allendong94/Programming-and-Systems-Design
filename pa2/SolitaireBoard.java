// Name:HANGDONG
// USC NetID:donghang
// CSCI455 PA2
// Fall 2018

import java.util.ArrayList;
import java.util.Random;

/*
  class SolitaireBoard
  The board for Bulgarian Solitaire.  You can change what the total number of cards is for the game
  by changing NUM_FINAL_PILES, below.  Don't change CARD_TOTAL directly, because there are only some values
  for CARD_TOTAL that result in a game that terminates.
  (See comments below next to named constant declarations for more details on this.)
*/


public class SolitaireBoard {
   
   public static final int NUM_FINAL_PILES = 9;
   // number of piles in a final configuration
   // (note: if NUM_FINAL_PILES is 9, then CARD_TOTAL below will be 45)
   
   public static final int CARD_TOTAL = NUM_FINAL_PILES * (NUM_FINAL_PILES + 1) / 2;
   // bulgarian solitaire only terminates if CARD_TOTAL is a triangular number.
   // see: http://en.wikipedia.org/wiki/Bulgarian_solitaire for more details
   // the above formula is the closed form for 1 + 2 + 3 + . . . + NUM_FINAL_PILES

   // Note to students: you may not use an ArrayList -- see assgt description for details.
   
   
   /**
      Representation invariant:
      The sum of cards of each pile should be CARD_TOTAL
      The number of piles at last should be NUM_FINAL_PILES
      The number of cards in each pile should 0<pile[i]<=CARD_TOTAL;
      <put rep. invar. comment here>

   */
   
   // <add instance variables here>
   private int piles[]=new int[CARD_TOTAL];
   //piles is an array to store the number of cards in each pile, for security assert number of piles equals to number of cards as        //upper bound;
   private Random r;
   // use r to build random number;
   private int number_pile;
   // pilenumber is the number of piles at each loop;
   /**
      Creates a solitaire board with the configuration specified in piles.
      piles has the number of cards in the first pile, then the number of cards in the second pile, etc.
      PRE: piles contains a sequence of positive numbers that sum to SolitaireBoard.CARD_TOTAL
   */
   public SolitaireBoard(ArrayList<Integer> piles) {

      number_pile=piles.size();
      for(int i=0;i<piles.size();i++)
      {
        this.piles[i] = piles.get(i);
      }
      assert isValidSolitaireBoard();   // sample assert statement (you will be adding more of these calls)
   }
 
   
   /**
      Creates a solitaire board with a random initial configuration.
   */
   public SolitaireBoard() {
      r= new Random();
      int sum = 0;
      int num = 0;
      int i = 0;
      while(sum != SolitaireBoard.CARD_TOTAL)
      {
         num=r.nextInt(SolitaireBoard.CARD_TOTAL-sum) + 1;
         piles[i] = num;
         i++;
         sum += num;     
      }
      number_pile = i;
      assert isValidSolitaireBoard();
   }
  
   
   /**
      Plays one round of Bulgarian solitaire.  Updates the configuration according to the rules
      of Bulgarian solitaire: Takes one card from each pile, and puts them all together in a new pile.
      The old piles that are left will be in the same relative order as before, 
      and the new pile will be at the end.
      @param: none
   */
   public void playRound() {
     boolean iszero = false;
     int new_pile = 0;
     int new_index=0;
     for(int i = 0;i < number_pile;i++)
     {
        if(piles[i] > 1)
        {
          piles[i]--;
          new_pile++;
          piles[new_index]=piles[i];
          new_index++;
        }
        else if(piles[i] == 1)
        {
          piles[i] = 0;
          new_pile++;        
        }      
     }
       piles[new_index] = new_pile; 
       number_pile = new_index+1;    
     assert isValidSolitaireBoard();
   }
   
   /**
      Returns true iff the current board is at the end of the game.  That is, there are NUM_FINAL_PILES
      piles that are of sizes 1, 2, 3, . . . , NUM_FINAL_PILES, in any order.
      @param: none
   */
   
   public boolean isDone() {
      boolean[] flags =new boolean[CARD_TOTAL+1];
      boolean res_key = true;
      for(int i = 0;i < piles.length; i++)
      {
         if(piles[i]>0)
         {
            flags[piles[i]] = true;
         }
      }
      for(int i = 1;i <= NUM_FINAL_PILES; i++)
      {
         if(flags[i] == false)
         {
            res_key = false;
         }
      }
      assert isValidSolitaireBoard();
      return res_key;  // dummy code to get stub to compile     
   }

   
   /**
      Returns current board configuration as a string with the format of
      a space-separated list of numbers with no leading or trailing spaces.
      The numbers represent the number of cards in each non-empty pile.
      @param: none
   */
   public String configString() {
      StringBuilder str = new StringBuilder();
      for(int i = 0;i < number_pile-1; i++)
      {
         if(piles[i]!=0)
         {
            str.append(piles[i]);
            str.append(" ");
         }
      }  
      str.append(piles[number_pile-1]);
      assert isValidSolitaireBoard();
      return str.toString();   // dummy code to get stub to compile
   }
   
   
   /**
      Returns true iff the solitaire board data is in a valid state
      (See representation invariant comment for more details.)
      auto use this check method by type"-ea"
      @param: none
   */
   private boolean isValidSolitaireBoard() {
        int total_cards = 0;
		for(int i =0; i < number_pile; i++)
		{
			if(piles[i] <= 0 || piles[i] > SolitaireBoard.CARD_TOTAL)
			{
				return false;
			}
			total_cards += piles[i];
		}
		if(total_cards == SolitaireBoard.CARD_TOTAL)
		{
			return true;  
		}
		else
		{
			return false;
		}
         // dummy code to get stub to compile
   }
   
}
