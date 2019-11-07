import java.util.ArrayList;

public class AjitMehrotraStrategy extends ComputerBattleshipPlayer {
	BattleshipPlayer roboPlayer = new BattleshipPlayer();
	private ArrayList <Position> hitPositions = new ArrayList<Position>();
	private ArrayList <Position> missPositions = new ArrayList<Position>();
	private ArrayList <Position> emptyPositions = new ArrayList<Position>();
	int diagonalNumber = 1 ;
	public void startGame(){
		roboPlayer.initializeGrid();
		BattleshipPlayer player = new BattleshipPlayer();
		player.initializeGrid();
		roboPlayer.Grid =  player.getGrid();
		/*All instance and class variables must be set to their initial values in startGame. 
	Do not rely on the constructor or initializing declarations to do this.
	A single instance of your strategy will be used for multiple games. 
	DO NOT SKIP THIS.
If you are unsure what it means, ask.
Many strategies fail because this was ignored.*/

	}
	public void updatePlayer(Position pos, boolean hit, char initial, String boatName, boolean sunk, boolean gameOver, boolean tooManyTurns, int turns) {
		super.updatePlayer(pos, hit, initial, boatName, sunk, gameOver, tooManyTurns, turns);
	}
	public String playerName(){
		return "AjitMehrotraStrategy";
	}
	public String author() {
		return "Ajit Mehrotra";
	}
	public Position shoot() {
		int indexOfLastMissPosition;
		int numberOfMissedDiagonals = 0;
		int numberOfMissedDiagonals2 = 0;
		Position positionBeingShotAt;
		/*if(hitPositions.size() == 0 ) {
			//This if-statement pertains to the beginning of the game  - if begining of the game
			if(missPositions.size() == 0) {
				//shoot the first square
				return new Position (0,0);
			}
			// if not the beginning of the game and also have no hit Positions
			else if(numberOfMissedDiagonals <= 0 && numberOfMissedDiagonals < 10){
				// i do not remember why I did this come back to understand logic
				if(numberOfMissedDiagonals == 0) {
					numberOfMissedDiagonals = 1;
				}
				indexOfLastMissPosition = missPositions.size() - 1;
				positionBeingShotAt =  new Position(missPositions.get(indexOfLastMissPosition).rowIndex() + 1,missPositions.get(indexOfLastMissPosition).columnIndex() + 1);
				//probably add an updateplater
				// if miss, add to the missPositions arraylist
				return positionBeingShotAt;
				//NEED TO ADD BEFORE THE RETURN STATEMENT A WAY TO CHECK IF IT IS HIT OR MISS. IF IT IS A MISS, ADD THAT POSITION TO THE ARRAYLIST
			}else if(numberOfMissedDiagonals >= 10 && numberOfMissedDiagonals < 20) {
				indexOfLastMissPosition = missPositions.size() - 1;

				positionBeingShotAt =  new Position(missPositions.get(indexOfLastMissPosition).rowIndex() + 1,missPositions.get(indexOfLastMissPosition).columnIndex() + 1);
			}
		}*/
		//should be able to comment out everything before this point in the shoot method
		Position positionToShoot;
		while (diagonalNumber < 11) {
			positionToShoot =  new Position(diagonalNumber - 1,diagonalNumber - 1 );
			checkHitPositions();// this is not the method to check whether that position has been hit or not. It merely only labels it onto the chart
			diagonalNumber++;
			return positionToShoot;
		}
		while(diagonalNumber >=11  && diagonalNumber < 21) {
			// if the position is in the middle of the board (has already been hit by the other while loop)
			if(diagonalNumber == 15) {
				diagonalNumber++;
			}
			positionToShoot = new Position(diagonalNumber - 11,diagonalNumber - 11);
			// need to add a method which shoots at the position
			checkHitPositions();// this is not the method to check whether that position has been hit or not. It merely only labels it onto the chart
			diagonalNumber++;
			return positionToShoot;
		}
		if(hitPositions.size() == 0) {
			while(diagonalNumber >=21 && diagonalNumber < 29) {
				positionToShoot = new Position(((diagonalNumber + 1) - 21),((diagonalNumber + 0) - 21));
				checkHitPositions();// this is not the method to check whether that position has been hit or not. It merely only labels it onto the chart
				diagonalNumber++;
				return positionToShoot;
			}
			while(diagonalNumber >= 29 && diagonalNumber < 37) {
				positionToShoot = new Position(((diagonalNumber + 0) - 29),((diagonalNumber + 1) - 29));
				checkHitPositions();// this is not the method to check whether that position has been hit or not. It merely only labels it onto the chart
				diagonalNumber++;
				return positionToShoot;
			}
			while(diagonalNumber >= 37) {
				int x = 0;
				int y= 0;
				//creates random number between 0 and 9
				x = (int) Math.random()*10;
				y = (int) Math.random()*10;
				boolean previousNumber = true;

				while (previousNumber) {
					for(Position a : missPositions ) {
						if(a.rowIndex() == x && a.columnIndex() == y) {
							previousNumber = true;
						}else {
							previousNumber = false;
						}
					}
				}
				checkHitPositions();// this is not the method to check whether that position has been hit or not. It merely only labels it onto the chart
				diagonalNumber++;
				return new Position(x,y);



			}
		}else if(hitPositions.size() > 0) {
			if(hitPositions.get(0).columnIndex() == 0 && (hitPositions.get(0).rowIndex() == 0)) {
				if() {

				}
			}
		}


	}
	//Now that all of the diagonals have been shot at, I will now check to see if there are any hits. If there are not, skip to the next step

	private Position checkPositionsAround(Position pos){
	/*	Position potentialPosition;
		Position returnedPosition;*/
	//	for(Position a: hitPositions) {
			// if the hit position is not on the edges of the battleship board (otherwise, this algorithm would create an exception as it checks for positions outside of the board)
			if(/*positionEquals(pos, a) &&*/ ( (pos.columnIndex() >= 1  && pos.columnIndex() <=8) && (pos.rowIndex() >= 1 && pos.rowIndex() <= 8 )))   {
				decideAppropriatenessOfPosition(pos);
				/*potentialPosition = new Position (pos.rowIndex() + 1, pos.columnIndex());
				if(hitPositions.contains(potentialPosition)) {
					potentialPosition = new Position (pos.rowIndex() - 1, pos.columnIndex());
					if(hitPositions.contains(potentialPosition)) {
						potentialPosition = new Position (pos.rowIndex() , pos.columnIndex() + 1);
				if(hitPositions.contains(potentialPosition)) {
							potentialPosition = new Position (pos.rowIndex() , pos.columnIndex() - 1);
				//If none of the surrounding Positions choose randomly..This should not be possible, but just in case
				if(hitPositions.contains(potentialPosition)) {
					int randomXPosition = (int )Math.random()*10 ;
					int randomYPosition = (int )Math.random()*10 ;
					boolean empty = false;
					while(!empty) {
						randomXPosition = (int )Math.random()*10 ;
						randomYPosition = (int )Math.random()*10 ;
						potentialPosition = new Position(randomXPosition,randomYPosition);
						empty = Grid.empty(pos);*/
			}else {
				
			}
		}
	







	private boolean positionEquals(Position pos, Position pos1) {
		if ((pos.columnIndex() == pos1.columnIndex()) && pos.rowIndex() == pos1.rowIndex()) {
			return true;
		}else {
			return false;
		}
	}
	
	// Decides Appropriateness of Position given if it is in the middle of te board 
	private Position decideAppropriatenessOfPosition(Position pos) {
		// things to check
		// What type of boat
		// How many spaces there are on the left, right, top, bottom. If there are two choices, assess the rest of the hit positions
		char boatInitial;
		int spacesOnRightOfPos;
		int spacesOnLeftOfPos;
		int spacesOnBottomOfPos;
		int spacesOnTopOfPos;

		boatInitial = Grid.boatInitial(pos);
		spacesOnRightOfPos = 10 - (pos.columnIndex()+ 1);
		spacesOnLeftOfPos = pos.columnIndex()+ 1;
		spacesOnTopOfPos = pos.rowIndex() + 1;
		spacesOnBottomOfPos = 10 - (pos.rowIndex()+ 1 );

		//Now that everything has been set to the correct value, it is time to find out what positions near it are hit and which ones are a miss
		ArrayList <Position> suitablePositions = new ArrayList<Position>();

		//Position Below Position pos
		Position pos1 = new Position(pos.rowIndex() + 1, pos.columnIndex());
		//Position Above Position pos
		Position pos2 = new Position(pos.rowIndex() - 1, pos.columnIndex());
		//Position to the Right of Position pos
		Position pos3 = new Position(pos.rowIndex() , pos.columnIndex() + 1);
		//Position to the Left of Position pos
		Position pos4 = new Position(pos.rowIndex() , pos.columnIndex() - 1);


		// The following block of code checks whether surrounding positions are already hit
		//These are if there is already a hit position near it. Now I need to make one for the first hit
		if(Grid.hit(pos1) && Grid.boatInitial(pos1) == Grid.boatInitial(pos)) {
			//checks the positions around for hits
			for(int a = 1; a < initialToNumberOfSpaces(boatInitial); a++ ) {
				if(!Grid.hit(new Position(pos1.rowIndex() + a, pos1.columnIndex()) )&& Grid.boatInitial(pos) == Grid.boatInitial(new Position(pos1.rowIndex() + a, pos1.columnIndex()))) {
					suitablePositions.add(new Position(pos1.rowIndex() + a, pos1.columnIndex()));
					return new Position(pos1.rowIndex() + a, pos1.columnIndex());
				}
			}
		}

		if(Grid.hit(pos2) && Grid.boatInitial(pos2) == Grid.boatInitial(pos)) {
			//checks the positions around for hits
			for(int a = 1; a < initialToNumberOfSpaces(boatInitial); a++ ) {
				if(!Grid.hit(new Position(pos2.rowIndex() + a, pos2.columnIndex()) )&& Grid.boatInitial(pos) == Grid.boatInitial(new Position(pos2.rowIndex() + a, pos2.columnIndex()))) {
					suitablePositions.add(new Position(pos2.rowIndex() + a, pos2.columnIndex()));
					return new Position(pos2.rowIndex() + a, pos2.columnIndex());
				}
			}
		}

		if(Grid.hit(pos3) && Grid.boatInitial(pos3) == Grid.boatInitial(pos)) {
			//checks the positions around for hits
			for(int a = 1; a < initialToNumberOfSpaces(boatInitial); a++ ) {
				if(!Grid.hit(new Position(pos3.rowIndex() + a, pos3.columnIndex()) )&& Grid.boatInitial(pos) == Grid.boatInitial(new Position(pos3.rowIndex() + a, pos3.columnIndex()))) {
					suitablePositions.add(new Position(pos3.rowIndex() + a, pos3.columnIndex()));
					return new Position(pos3.rowIndex() + a, pos.columnIndex());
				}
			}
		}

		if(Grid.hit(pos4) && Grid.boatInitial(pos4) == Grid.boatInitial(pos)) {
			//checks the positions around for hits
			for(int a = 1; a < initialToNumberOfSpaces(boatInitial); a++ ) {
				if(!Grid.hit(new Position(pos4.rowIndex() + a, pos4.columnIndex()) )&& Grid.boatInitial(pos) == Grid.boatInitial(new Position(pos4.rowIndex() + a, pos4.columnIndex()))) {
					suitablePositions.add(new Position(pos4.rowIndex() + a, pos4.columnIndex()));
					return new Position(pos4.rowIndex() + a, pos.columnIndex());
				}
			}
		}
		// At this point in the code, the program knows that there have been no previous hits around it
		//This is regarding the first hit and the computer is trying to find the second hit
		if(Grid.hit(pos)) {
			// if the grid 
			if(boatInitial == 'A') {
				if(spacesOnRightOfPos >= 5) {
					return pos3;
				}else if(spacesOnLeftOfPos >= 5) {
					return pos4;
				}else if(spacesOnTopOfPos >= 5) {
					return pos2;
				}else if(spacesOnBottomOfPos >=5  ) {
					return pos1;
				}else {
					//if code reaches this point, something is wrong in my program
				}
			}else if(boatInitial == 'B'){
				if(spacesOnRightOfPos >= 4) {
					return pos3;
				}else if(spacesOnLeftOfPos >= 4) {
					return pos4;
				}else if(spacesOnTopOfPos >= 4) {
					return pos2;
				}else if(spacesOnBottomOfPos >=4  ) {
					return pos1;
				}else {
					//if code reaches this point, something is wrong in my program

				}
			}else if(boatInitial == 'C') {
				if(spacesOnRightOfPos >= 3) {
					return pos3;
				}else if(spacesOnLeftOfPos >= 3) {
					return pos4;
				}else if(spacesOnTopOfPos >= 3) {
					return pos2;
				}else if(spacesOnBottomOfPos >=3  ) {
					return pos1;
				}else {
					//if code reaches this point, something is wrong in my program
				}
			}else if(boatInitial == 'S') {
				if(spacesOnRightOfPos >= 3) {
					return pos3;
				}else if(spacesOnLeftOfPos >= 3) {
					return pos4;
				}else if(spacesOnTopOfPos >= 3) {
					return pos2;
				}else if(spacesOnBottomOfPos >=3  ) {
					return pos1;
				}else {
					//if code reaches this point, something is wrong in my program
				}
			}else if(boatInitial == 'D') {
				if(spacesOnRightOfPos >= 2) {
					return pos3;
				}else if(spacesOnLeftOfPos >= 2) {
					return pos4;
				}else if(spacesOnTopOfPos >= 2) {
					return pos2;
				}else if(spacesOnBottomOfPos >=2  ) {
					return pos1;
				}else {
					//if code reaches this point, something is wrong in my program
				}
			}else {


			}

		}
		return new Position (0,0);
	}
	
	private Position decideAppropriatenessOfPositionOnEdge(Position pos) {
		// needs to check boat size
		// needs to check the boat type (initial)
		// how many spaces there are on the left, right
		// pretty much same thing as the other method, but it makes sure NOT to check the one that is off the board whether that be ging off the top, bottom, right, or left
	}

	private int initialToNumberOfSpaces(char initial) {
		if (initial == 'A') {
			return 5;
		} else if(initial == 'B') {
			return 4;
		}else if(initial == 'C') {
			return 3;
		}else if(initial == 'S') {
			return 3;
		}else if(initial == 'D') {
			return 2;
		}else {
			return 100;
		}
	}

	//ToDo I need to make a method that shoots on the ocean and the grid and yeah 
	// This method only keeps track of what was hit and what was not.
	private void checkHitPositions() {
		for(int a  = 0; a < 10; a ++) {
			for(int b = 0; b < 10; b++) {
				if(Grid.hit(new Position (a,b))) {
					hitPositions.add(new Position(a,b));
				}else if(Grid.miss(new Position(a,b))){

					missPositions.add(new Position (a,b));
				}else{
					emptyPositions.add(new Position (a,b));
				}

			}
		}
	}
}

