
public class Battleship8Tester {
	public static void main(String args[]) {
		PlayerEvaluator eval = new PlayerEvaluator(new ComputerBattleshipPlayer(), 5);
		
		System.out.println(eval.maxTurns());
	}
	
}
