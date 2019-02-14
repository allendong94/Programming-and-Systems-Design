// Name: Hang Dong
// USC NetID: donghang
// CS 455 PA4
// Fall 2018

import java.util.Map;
import java.util.HashMap;
/**
 * that is a mapping class which map every letter with its values.
 * @author hangdong
 *
 */
public class ScoreTable {
	//the ScoreTable is in alpha oder.
	//private static final int[] ScoreTable = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
    private static Map<Character, Integer> WordValue = new HashMap<Character, Integer>();
    private int score;
    public ScoreTable() {new HashMap<Character, Integer>();
     	WordValue.put('a', 1);
     	WordValue.put('b', 3);
     	WordValue.put('c', 3);
     	WordValue.put('d', 2);
     	WordValue.put('e', 1);
     	WordValue.put('f', 4);
     	WordValue.put('g', 2);
     	WordValue.put('h', 4);
     	WordValue.put('i', 1);
     	WordValue.put('j', 8);
     	WordValue.put('k', 5);
     	WordValue.put('l', 1);
     	WordValue.put('m', 3);
     	WordValue.put('n', 1);
     	WordValue.put('o', 1);
     	WordValue.put('p', 3);
     	WordValue.put('q', 10);
     	WordValue.put('r', 1);
     	WordValue.put('s', 1);
     	WordValue.put('t', 1);
     	WordValue.put('u', 1);
     	WordValue.put('v', 4);
     	WordValue.put('w', 4);
     	WordValue.put('x', 8);
     	WordValue.put('y', 4);
     	WordValue.put('z', 10);
    }
    public int GetScore(String s) {
        	score = 0;
       	    s=s.toLowerCase();
    	    for (int i = 0; i < s.length(); i++) {             
    		   score += WordValue.get(s.charAt(i));
      	}
      	return score;
    }
}
