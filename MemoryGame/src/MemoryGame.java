

import java.util.Random;

import java.util.Scanner;



public class MemoryGame {
	// Creates an empty array -- this array will store whether or not the value is  paired up
    public static boolean[][] Match2 = new boolean[6][6];

    // Initializes the array of values
	public static String[] create() {
		
		String[] arr = {

				"     Hyena     ", "     Hyena     ", 

				"     Bonobo    ", "     Bonobo    ", 

				"     Slug      ", "     Slug      ",
				"     Squid     ", "     Squid     ", 

				"     Frog      ", "     Frog      ",

				"   Armadillo   ", "   Armadillo   ", 

				"  Black Widow  ", "  Black Widow  ",

				"   Anaconda    ", "   Anaconda    ",

				"      Swan     ", "      Swan     ",

				"Sandhill Crane ", "Sandhill Crane ",

				"European Rabbit", "European Rabbit",

				"    Octopus    ", "    Octopus    ",

				"  Anglerfish   ", "  Anglerfish   ", 

				"     Ferret    ", "     Ferret    ",

				"     Salmon    ","     Salmon    ",
				" Wooly Mammoth ", " Wooly Mammoth ",

				"  Bengal Tiger ", "  Bengal Tiger ",

				"     Sloth     ", "     Sloth     "};

		return arr;

	}


	// Shuffles the array
	public static String [] shuffle (String [] cards) {

		Random rnd = new Random();

	    for (int i = cards.length - 1; i > 0; i--)

	    {

	      int index = rnd.nextInt(i+1);

	      String a = cards[index];

	      cards[index] = cards[i];

	      cards[i] = a;

	    }

	    return cards;

	}


	// The main play game method
	public static void playGame() {

		Scanner reader = new Scanner(System.in);

		String[] arr = shuffle(create());

	    String[][] Match = new String[6][6];
	    // Converts 1d array into 2d array
	    for ( int i = 0; i < 6; i++) System.arraycopy(arr, (i*6), Match[i], 0, 6);
	    // Makes match two array all false
	    for(int i = 0; i < Match2.length; i++) for(int j = 0; j < Match2.length; j++) Match2[i][j] = false;



	    boolean pair = false;

	    int loops = 0; int r1, c1, r2, c2;

	    display(Match);
	    // Runs loop till all pairs found
	    while(!(pair)) {
	    // Enter all the inputs
	    do {

	    	System.out.println("For card One: \nEnter Row: "); 

			r1 = reader.nextInt();

	    }while (r1>6);

	    do {

			System.out.println("For card One: \nEnter Column: ");

			c1 = reader.nextInt();

	    }while(c1>6);

	    do {

		    do {

				System.out.println("For card Two: \nEnter Row: ");

				r2 = reader.nextInt();

		    }while(r2>6);

	  

		    do {

				System.out.println("For card Two: \nEnter Column: ");

				c2 = reader.nextInt();

		    }while(c2>6);

		    

		    if(c1==c2 && r1==r2) {

		    	System.out.println("Enter the location of a different card than the first selection.");

		    }

	    }while(c1 == c2 && r1 == r2);

	    	// If inputs match eachother then the values are set to true
			if(Match[r1 - 1][c1 - 1].equals(Match[r2 - 1][c2 - 1])) {Match2[r1 - 1][c1 - 1] = true; Match2[r2 - 1][c2 - 1] = true;}

			else { displayWithoutX(Match, r1 - 1,c1 - 1,r2 - 1,c2 - 1); }

			display(Match);
			int count = 0;
			// Checks if all the pairs are found
			for(int i = 0; i < Match2.length; i++) {
				for(int j = 0; j < Match2.length; j++) {
					if(Match2[i][j] == true) count++;
				}
			}
			if(count == 36) pair = true;
			loops++;

	    }

	    System.out.println(loops);

	    

	}
	// Checks if input is valid
	public static boolean validateInput ( int r, int c, String[][] grid ) {

		if(grid[r][c] != null) return true;

		else return false;

	}
	// SHows the grid with the columns and rows inputted
	public static void displayWithoutX ( String[][] grid, int row1, int col1, int row2, int col2) {

		String space = new String(new char[8]).replace("\0", " "); 

		System.out.print("  ");

		for(int i = 1; i < grid.length + 1; i++) {

			if(i == 1) System.out.print(space + i);

			else System.out.print(space + "           " + i);

		}

		System.out.println();

		for(int i = 0; i < grid.length; i++) {

			System.out.print((i + 1)+ " ");

			for(int j = 0; j < grid.length; j++) {


				// Prints out the value if its in the parameter
				if(((i == row1) && (j == col1)) || ((j == col2) && (i == row2))) {

					System.out.print(grid[i][j]);

				}

				else {

					

					if((i != 0 && j!= 0) && ((i-1 == row1 && j-1 == col1) || (i-1 == row1 && j-1 == col1))) {

						String spaces = new String(new char[20 - grid[i-1][j-1].length()]).replace("\0", " "); 

						System.out.print(spaces + "x");

					}

					else System.out.print("         X           ");

				}
				

			}

			System.out.println("\n");

		}

	}
	// SHows the grid with all the found values
	public static void display ( String[][] grid ) {

		System.out.println();

		String space = new String(new char[8]).replace("\0", " "); 

		System.out.print("  ");

		for(int i = 1; i < grid.length + 1; i++) {

			if(i == 1) System.out.print(space + i);

			else System.out.print(space + "           " + i);

		}

		System.out.println();

		for(int i = 0; i < grid.length; i++) {

			System.out.print((i + 1)+ " ");

			for(int j = 0; j < grid.length; j++) {

				
				// If found then display else display an x
				if(Match2[i][j] == true) {

					System.out.print(grid[i][j]); 

				}else { 

					System.out.print("         X           ");

				}

				

			}

			System.out.println("\n");

		}

	}
	// Plays the game
	public static void main (String [] args) { playGame();}

}

