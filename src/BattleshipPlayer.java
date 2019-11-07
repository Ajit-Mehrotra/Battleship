import java.util.ArrayList;
import java.util.Scanner;

/*This class will allow a human player to play Battleship with a computer. It will contain a 
BatteshipGrid that is updated each time the player makes a move*/
public class BattleshipPlayer {
	private String playerName;
	BattleshipGrid Grid = new BattleshipGrid();

	private Scanner numberScan  = new Scanner(System.in);

	BattleshipPlayer() {
		playerName = null;
	}

	/*This modifier method is called each time a new game is started. It creates the 
	BattleshipGrid used to keep the user informed. If name is null, it asks the user to enter a 
	name and welcomes the user to the game*/
	public void startGame() {
		if(playerName == null) {
			Scanner scan  = new Scanner(System.in);
			System.out.println("Enter your Name: ");
			String name = scan.nextLine();
			playerName = name;

		}
	}

	//This method returns the name of the human player
	public String playerName() {
		return playerName;
	}

	/*This observer method gets a position to shoot at. It prompts the user to enter a row (A-J) 
	and a column (1-10). It then returns that position. If the user enters an invalid row or 
	column, it prints out an error message and prompts the user again*/

	public Position shoot() {
		int firstLetterTry = 0;
		int firstNumberTry = 0;
		char letter ;
		int column = 0;
		String letterInput = " ";
		String numberInput = "100";
		Scanner letterScan  = new Scanner(System.in);
		Position pos;



		while(!(letterInput.equalsIgnoreCase("A")|| letterInput.equalsIgnoreCase("B")|| letterInput.equalsIgnoreCase("C")|| letterInput.equalsIgnoreCase("D")
				|| letterInput.equalsIgnoreCase("E")|| letterInput.equalsIgnoreCase("F")||letterInput.equalsIgnoreCase("G")
				|| letterInput.equalsIgnoreCase("H")||  letterInput.equalsIgnoreCase("I")|| letterInput.equalsIgnoreCase("J"))) {
			if(firstLetterTry > 0) {
				System.out.println("Error - Try Again: ");
			}
			System.out.println("Enter a Row Letter[(A-J) and no spaces] :");
			letterInput= letterScan.nextLine();
			firstLetterTry ++;

		}
		letter = letterInput.charAt(0);
		letter = Character.toUpperCase(letter);



		while(!(numberInput.equals("1")||numberInput.equals("2")||numberInput.equals("3")
				||numberInput.equals("4")||numberInput.equals("5")||numberInput.equals("6")||numberInput.equals("7")||numberInput.equals("8")||numberInput.equals("9")||numberInput.equals("10"))) {
			if(firstNumberTry > 0){
				System.out.println("Error - Try Again: ");
			}
			System.out.println("Enter a Column Number (1-10): ");
			numberInput = numberScan.nextLine();
			firstNumberTry++;
		} 

		column = Integer.parseInt(numberInput);
		//System.out.println("Char: "+ letter+ "\nColumn: " + column);
		/*System.out.println(new Position(letter,column));*/
		pos = new Position (letter, column);

		System.out.println("Shot Position: " + pos.toString());

		return pos;
	}

	/*This modifier method updates the grid based on the results of a shot. Note that this can be 
	done automatically by calling the shotAt method of the BattleshipGrid class*/
	public void updateGrid(Position pos, boolean hit, char initial) {
		Grid.shotAt(pos, hit, initial);

	}

	/*This observer returns the grid stored in the class. It is mainly so the grid is available for 
	use by subclasses of Battleship player.*/
	public BattleshipGrid getGrid() {
		return Grid;
	}

	//This modifiers resets the grid to a new grid where all spaces are empty.
	public void initializeGrid() {
		Grid = new BattleshipGrid();
	}


	/*This method informs the user of the result of his/her shot, including:








		.*/
	public void updatePlayer(Position pos, boolean hit, char 
			initial, String boatName, boolean sunk, boolean gameOver, 
			boolean tooManyTurns, int turns) {
		updateGrid(pos,hit,initial);
		boolean hitOrMiss = false;
		if(tooManyTurns) {
			System.out.println("The game has gone on for too long. The game is over.There are too many turns.");
		}else {
			hitOrMiss = Grid.hit(pos);
			//The number of turns the player has taken so far.

			System.out.print("Player " + playerName + ": Turn Number " + turns + "\nYour Shot was a ");
			if(hitOrMiss) {
				System.out.println( "hit:" + "\nName and Initial of hit Boat: " + initial+ "/" + boatName );
				if(sunk) {
					System.out.println("The " + boatName + " has sunken");
				}
			}else {
				System.out.println("miss");
			}



			//If the game is over.
			if(gameOver) {
				System.out.println("The game is over.");

				//If the game has gone on too long.

			}
			gridPrinter();
			//whether the position was a hit or miss





			/* gridPrinter method Prints the Grid. Specifications are in the gridPrinter method*/
		}

	}



	/*It also calls the updateGrid method and then outputs the grid as a graphical representation of the state of the game. This output should have the following characteristics:
	outputs the grid as a graphical representation of the state of the game. This output should have the following characteristics:
		The columns should be labeled with the numbers 1-10
		The rows should be labeled with the letters A-J
		Denote a square that has not been shot at with a period (.)
		Denote a square that has been shot at and is a miss with an asterisk (*)

		Denote a square that has been shot at and hit with the initial of the boat that has	been hit*/
	private void gridPrinter() {
		System.out.println("  1 2 3 4 5 6 7 8 9 10");

		for(int a = 0; a < 10; a ++) {
			System.out.print(numberToStringConverter(a));

			for(int b= 0; b < 10; b++) {
				if(Grid.empty(new Position(a,b))) {
					System.out.print(" .");
				}else if(Grid.miss(new Position(a,b))) {
					System.out.print(" *");
				}else if(Grid.hit(new Position(a,b))) {
					System.out.print(" " + Grid.boatInitial(new Position (a,b)));
				}
				if(b == 9) {
					System.out.println();
				}
			}
		}
	}
	private String numberToStringConverter(int a ) {
		if(a == 0) {
			return ("A");
		}else if(a == 1) {
			return ("B");
		}else if(a == 2) {
			return ("C");
		}else if(a == 3) {
			return ("D");
		}else if(a == 4) {
			return ("E");
		}else if(a == 5) {
			return ("F");
		}else if(a == 6) {
			return ("G");
		}else if(a == 7) {
			return ("H");
		}else if(a == 8) {
			return("I");
		}else if(a == 9) {
			return ("J");
		}else {
			return "L";
		}
	}

}
