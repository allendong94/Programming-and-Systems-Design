// Name: Hang Dong
// USC NetID: donghang
// CS 455 PA4
// Fall 2018
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
/**
   A Rack of Scrabble tiles
 */

public class Rack {
   /**
      Finds all subsets of the multiset starting at position k in unique and mult.
      unique and mult describe a multiset such that mult[i] is the multiplicity of the char
           unique.charAt(i).
      PRE: mult.length must be at least as big as unique.length()
           0 <= k <= unique.length()
      @param unique a string of unique letters
      @param mult the multiplicity of each letter from unique.  
      @param k the smallest index of unique and mult to consider.
      @return all subsets of the indicated multiset
      @author Claire Bono
    */
	private String unique = "";
	private int[] mult;
	public Rack(String letters) {
		helper(letters);
	}
	public ArrayList<String> getRack() {		
		ArrayList< String >list = allSubsets(unique, mult, 0);
		return list;
	}
   private void helper(String letters) {
	   Map<Character, Integer> map = new HashMap<Character, Integer>();
	   for (int i = 0; i < letters.length(); i++) {
		   char letter = letters.charAt(i);
		   if(map.containsKey(letter)) {
			   
			   map.put(letter, map.get(letter)+1);
		   }
		   else {
			   map.put(letter, 1);
		   }
	   }
	   mult = new int[map.keySet().size()];
	   int i = 0;
	   for (Entry<Character, Integer> item: map.entrySet()) {
		   unique += item.getKey();
		   mult[i] = item.getValue();
		   i++;
	   }
   }
   
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();
      
      if (k == unique.length()) {  // multiset is empty
         allCombos.add("");
         return allCombos;
      }
      
      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k+1);
      
      // prepend all possible numbers of the first char (i.e., the one at position k) 
      // to the front of each string in restCombos.  Suppose that char is 'a'...
      
      String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {   
         for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets 
                                                        // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));  
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }
      
      return allCombos;
   }

   
}
