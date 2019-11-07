
public class PlayerEvaluator {
	int maxTurns = 0;
	int minTurns = 0;
	double averageTurns = 0;

	
	/*	This constructor will iterate runs times, where each iteration creates a BattleshipGame 
	with player and calls the play method to play a game. During those iterations, it will 
	keep track of the maximum, minimum, and average number of turns it took to sink all the 
	boats. Note that your PlayerEvaluator does not need to do any work to determine where boats 
	are, or whether they are hit, sunk, etc. The BattleshipGame class takes care of all of 
	those details. The only thing your PlayerEvaluator needs to do is to create a 
	BattleshipGame and use the number of turns that it returns.*/
	
	PlayerEvaluator(ComputerBattleshipPlayer player, int runs){
		for(int a = 0; a <= runs; a++ ) {
			player.startGame();
			BattleshipGame game = new BattleshipGame( player);
			game.Play();
			player.shoot();
			//player.updateGrid(pos, hit, initial);
			if( game.numberOfTurns > maxTurns) {
		System.out.println("ok wtf");
		
				maxTurns = game.numberOfTurns;
			}
			if( game.numberOfTurns < minTurns ) {
				System.out.println("hard yeet min");
				minTurns = game.numberOfTurns;
			}
			averageTurns = (averageTurns + game.numberOfTurns) / a;
			
		}
		
		
	}
	
	public int maxTurns() {
		return maxTurns;
	}
	
	public int minTurns() {
		return minTurns;
	}
	
	public float averageTurns() {
		float averageNumberOfTurns = (float)averageTurns ;
		return averageNumberOfTurns;
	}
	
	
}
