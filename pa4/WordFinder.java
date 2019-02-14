// Name: Hang Dong
// USC NetID: donghang
// CS 455 PA4
// Fall 2018
/*
 * this is the class include main method, 
 */
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
public class WordFinder {
	private static String file = "";
	private static boolean end = false;
	private static AnagramDictionary anagramdict;
	private static Map<String, Integer> wordmap;
    public static void main(String[] args) {
    	if(args == null || args.length == 0) {
    		file = "sowpods.txt";
    	}
    	else {
    		file = args[0];
    	}
   
    	try {
    		anagramdict = new AnagramDictionary(file);
    	}
    	catch(FileNotFoundException e){
    		System.out.println("This file doesn't exist");
    		System.exit(0);
    	}
    	System.out.println("Type . to quit.");
        Scanner s = new Scanner(System.in);
    	while(!end) {    	 
       	 System.out.print("Rack? ");
         String word = s.next();
		 if(word.equals(".")) {
			end = true;
         }
		 else {
			 char[] temp = word.toCharArray();
			 word ="";
			 for (int i =0; i < temp.length; i++) {
				 if (( temp[i] >= 'a' && temp[i] <= 'z') || ( temp[i] >= 'A' && temp[i] <= 'Z'))
				      word = word + temp[i] ;
				 
			 }
		    Rack rack = new Rack(word);
		    ArrayList<String> sets = rack.getRack();
		    output(sets, word);
		    
		 }
    }
 }
    public static void output( ArrayList<String> sets, String word ) {
    	   wordmap = new TreeMap<String, Integer>();
    	   ArrayList<String> ans = new ArrayList<String>(); 
    	   for (String s: sets) {
    		   if("".equals(s)) {
    			   continue;
    		   }
    		   if(anagramdict.getAnagramsOf(s) != null) {
    			   ans.addAll(anagramdict.getAnagramsOf(s));
    		   }
    	   }
    	   ScoreTable st = new ScoreTable();
    	   for (String s: ans) {
    		   int score = st.GetScore(s);
    		   wordmap.put(s, score);
    	   }
    	   System.out.println("We can make " +wordmap.size()+" words from \""+word+"\"");
           if (wordmap.size() > 0 ){
    	   System.out.println("All of the words with their scores (sorted by score):");
    	   ArrayList<Map.Entry<String , Integer>> list = new ArrayList<>(wordmap.entrySet()) ;
    	      Collections.sort(list, new Comparator<Map.Entry<String , Integer>>(){

    	         public int compare(Map.Entry<String , Integer> e1 , Map.Entry<String , Integer> e2){
                    if(e1.getValue() == e2.getValue()){
    	               return e1.getValue().compareTo(e2.getValue());
                    }
                    else{
                       return e2.getValue().compareTo(e1.getValue());
    	            } 
                 }
    	      });
    	   for(Map.Entry<String, Integer> entry : list)
   		{
   			System.out.println(entry.getValue() + ": " + entry.getKey());
   		}    	   
    }
    }
}