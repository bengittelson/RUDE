//Game class
//Ben Gittelson (bwg2109)
//Provides methods that allow a player to play a session of Bulls and Cows

import java.util.Scanner; 

//**********************************************
// This is the Game class for the Bull and Cows
// program. You will need to modify this template
//
//**********************************************

public class Game{

    private int turns;
    private Oracle computer;
    private Scanner input;
    // you may need more instance variables here
    private int games;

    //provides the information necessary to create a game object
    public Game(){
    // your code for the Game constructor goes here
    	turns = 0; 
    	games = 0; 
    }

    //allows the user to play a session of Bulls and Cows and keeps track of 
    // their statistics
    public void play() {
    // your code for the Game play method goes here
    	computer = new Oracle();
    	input = new Scanner(System.in); 
    	System.out.println("Do you want to play Bulls and Cows? (yes/no)"); 
    	String newGame = input.nextLine(); 
    	
    	int best = 1000; 
    	int worst = 0; 
    	int bulls; 
    	int cows; 
    	int gameTurns; 
    	
    	while (newGame.equals("yes")) {
    		computer.getSolution(); 
    		bulls = 0;
    		cows = 0; 
    		gameTurns = 0; 
    		
    		while (bulls < 4) {
    			bulls = 0; 
    			System.out.println("Please input a four digit number."); 
    			String humanGuess = input.nextLine(); 
    			bulls = computer.getBulls(humanGuess); 
    			System.out.println("Bulls: " + bulls); 
    			cows = computer.getCows(humanGuess); 
    			System.out.println("Cows: " + cows); 
    			
    			turns++; 
    			gameTurns++; 
    		}
    		
    		if (gameTurns < best) {
    			best = gameTurns; 
    		}
    		
    		if (gameTurns > worst) {
    			worst = gameTurns; 
    		}
    		
    		games++; 
    		System.out.println("Do you want to play again? (yes/no)"); 
    		newGame = input.nextLine(); 
    	}
    	
    	if (newGame.equals("no") && games > 0) {
        	System.out.println("Best: " + best); 
        	System.out.println("Worst: " + worst); 
        	double average = ((double) turns)/((double) games); 
        	System.out.println("Average number of turns: " + average); 
    	}
    	
    }

    // any other methods you may need go here

}
