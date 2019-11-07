
public class ComputerBattleshipPlayer extends BattleshipPlayer {
	public void updatePlayer(Position pos, boolean hit, char 
			initial, String boatName, boolean sunk, boolean gameOver, 
			boolean tooManyTurns, int turns){
		updateGrid(pos,hit,initial);

	}
	public String playerName() {
		return "Computer Player";
	}
	public Position shoot() {
		Ocean ocean = new Ocean();
		boolean hit = false;
		char initial = 'L';
		int randomXPosition = (int )Math.random()*10 ;
		int randomYPosition = (int )Math.random()*10 ;
		Position pos = new Position(0,0);
		boolean empty = false;
		while(!empty) {
			randomXPosition = (int )Math.random()*10 ;
			randomYPosition = (int )Math.random()*10 ;
			pos = new Position(randomXPosition,randomYPosition);
			empty = Grid.empty(pos);
		
		
		}
		return pos;
		
	}
	public void  startGame() {
		initializeGrid();
	}
}
