
public class Battleship3Tester {
	public static void main(String[] args) {
		Position legit = new Position(4,4);
		Boat yeet = new Boat("Aircraft Carrier", legit, "horizontal" );
		System.out.println(yeet.name());
	}
}
