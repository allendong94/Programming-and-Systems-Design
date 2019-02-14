// Name: Hang Dong
// USC NetID: donghang
// CS 455 PA4
// Fall 2018

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
   A dictionary of all anagram sets. 
   Note: the processing is case-sensitive; so if the dictionary has all lower
   case words, you will likely want any string you test to have all lower case
   letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {
   

   private Map<String, ArrayList<String>> wordsdict;
   /**
      Create an anagram dictionary from the list of words given in the file
      indicated by fileName.  
      PRE: The strings in the file are unique.
      @param fileName  the name of the file to read from
      @throws FileNotFoundException  if the file is not found
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException {
	   wordsdict = new HashMap<String, ArrayList<String>>();
	   File f = new File(fileName);
	   Scanner s = new Scanner(f);
	   while (s.hasNextLine()) {
		   String l = s.nextLine();
		   if(l.length()==0) {
			   continue;
		   }
		   char[] temp = l.toCharArray();
		   l ="";
			 for (int i =0; i < temp.length; i++) {
				 if (( temp[i] >= 'a' && temp[i] <= 'z') || ( temp[i] >= 'A' && temp[i] <= 'Z'))
				      l = l + temp[i] ;
				 
			 }
		   char[] chararr = l.toCharArray();
		   Arrays.sort(chararr);
		   String strarr = String.valueOf(chararr);
		   
		     if (!wordsdict.containsKey(strarr)) {
			   ArrayList<String> list = new ArrayList<>(); 
			   list.add(l);
			   wordsdict.put(strarr, list);
		     }
		     else {
			   wordsdict.get(strarr).add(l);
		     }
		   
	   }
	   s.close();
   }
   

   /**
      Get all anagrams of the given string. This method is case-sensitive.
      E.g. "CARE" and "race" would not be recognized as anagrams.
      @param s string to process
      @return a list of the anagrams of s
    */
   public ArrayList<String> getAnagramsOf(String s) {
	   char[] chararr = s.toCharArray();
	   Arrays.sort(chararr);
	   String strarr = String.valueOf(chararr);
	   if(wordsdict.containsKey(strarr)) {
		   return new ArrayList<String>(wordsdict.get(strarr));
	   }
	   else {
		   return null;
	   }
   }
}
