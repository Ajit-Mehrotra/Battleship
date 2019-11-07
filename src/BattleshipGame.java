/*This class will play a Battleship game with a player by creating an Ocean and calling the Ocean method placeAllBoats.
 It then repeatedly calls the BattleshipPlayer method shoot to get a position to shoot at
 , passes that position to the Ocean and then relays the result of the shot back to the player via the updatePlayer method. The BattleshipGame class will implement 2 methods:*/
public class BattleshipGame {
	int numberOfTurns;
	Ocean ocean = new Ocean();
	BattleshipPlayer playerT = new BattleshipPlayer();

	/*This constructor creates an Ocean and initializes the number of turns to zero. It also calls 
	the startGame method for the player.*/
	BattleshipGame(BattleshipPlayer player){
		numberOfTurns = 1;
		playerT = player;
		playerT.startGame();
	}


	/*This method allows the user to play Battleship. 
	It contains a loop that gets a shot from the player, gets the result back from the ocean and updates the player. 
	It does this until either the game is over (all ships are sunk), or the user has taken 100 turns. 
	It does not need to do any checking on whether the position has already been shot at. 
	It is up to the player to make sure that the same position is not shot at twice.*/

	// WARNING

	/*	The play method should not communicate to the player in any way other than calling methods from the BattleshipPlayer class, 
	since there will be subclasses of that are computer players and will not “see” what is printed to the screen.

	 * The method returns the number of turns the player took to finish.

	 */


	/*public void updatePlayer(Position pos, boolean hit, char 
			initial, String boatName, boolean sunk, boolean gameOver, 
			boolean tooManyTurns, int turns) {*/
	public int Play() {



		ocean.placeAllBoats();
		//ocean.printBoatLocations();
		Position pos = null;
		boolean hit = false;
		char initial = 'L';
		String boatName = "";
		boolean sunk = false;
		boolean gameOver = false;
		boolean tooManyTurns = false;



		while(numberOfTurns < 101 &&  !ocean.allSunk() ) {

			pos = playerT.shoot();
			ocean.shootAt(pos);
			if(ocean.hit(pos)) {

				hit =  true;
				initial =  ocean.boatInitial(pos);

			}else {

				hit = false;
			}
			playerT.getGrid().shotAt(pos, hit, initial);

			initial = playerT.getGrid().boatInitial(pos);
			boatName = ocean.boatName(pos);
			sunk = ocean.sunk(pos);
			if(  ocean.allSunk() ) {
				gameOver = true;
			}else {
				gameOver = false;
			}


			playerT.updatePlayer(pos,hit,initial,boatName,sunk,gameOver,tooManyTurns,numberOfTurns );
			//System.out.println("NumberOfTurns: "+numberOfTurns);
			numberOfTurns++;


		}
		if(numberOfTurns > 100) {
			tooManyTurns = true;
		}


		if(tooManyTurns) {
			playerT.updatePlayer(pos,hit,initial,boatName,sunk,gameOver,tooManyTurns,numberOfTurns );
		}
		return numberOfTurns;

	}





}
