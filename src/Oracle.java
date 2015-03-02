//Oracle class
//Ben Gittelson (bwg2109)
//Creates the solution for a single Bulls and Cows game and counts the number
// of bulls and cows for a single guess

//***********************************
// This is a template for your Oracle
// class
//
//***********************************

//imports Random
import java.util.Random;

public class Oracle {
    
    private String solution;
    
    //provides the information necessary to construct an Oracle object
    public Oracle(){
    	solution = "";
    }
    
    //counts the number of bulls in the player's guess
    public int getBulls(String guess){
    	System.out.println("guess: " + guess); 
    	int bullCounter = 0; 
    	for (int i = 0; i < solution.length(); i++) {
    		if (solution.charAt(i) == (guess.charAt(i))) {
    			bullCounter++; 
    		}
    	}
    	return bullCounter; 
    }
        // your code here for 
	// determining the number
	// of bulls the String
	// guess should earn

    //counts the number of cows in the player's guess
    public int getCows(String guess){
    	int cowCounter = 0; 
    	String cowsString = ""; 
    	String charI = ""; 
    	for (int i = 0; i < solution.length(); i++) {
    		for (int j = 0; j < guess.length(); j++) {
    			if (i != j && solution.charAt(i) != guess.charAt(i)) {
    				if (solution.charAt(i) == guess.charAt(j)) {
    					charI = Character.toString(solution.charAt(i)); 
    					if(!cowsString.contains(charI)) {
    						cowsString = cowsString + solution.charAt(i); 
    						cowCounter++; 
    					}
    				}
    			}
    		}
    	}
    	return cowCounter; 
        // your code here for
	// determining the number
	// of cows the String
	// guess should earn

    // any other methods you might want
    // in this class can go here 
    } 
     
    //creates the solution string of four non-repeating random numbers
    public String getSolution() {
    	solution = ""; 
    	Random gen = new Random(); 
    	while (solution.length() < 4) {
    		String num = Integer.toString(gen.nextInt(10));
    		while (!solution.contains(num)) {
    			solution = solution + num; 
    		}
    	}
    	return solution; 
    }
}
    

