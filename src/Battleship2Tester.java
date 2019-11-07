
public class Battleship2Tester {
public static void main(String args[]) {
	//The Position Constructor works well at first glance. Add more test cases
	/*Position pos = new Position('J',6);
	System.out.println(pos.columnIndex());
	System.out.println(pos.rowIndex());
	System.out.println(pos.row());
	System.out.println(pos.column());*/
	
	Position pos = new Position(1,5);
	System.out.println(pos.columnIndex());
	System.out.println(pos.rowIndex());
	System.out.println(pos.row());
	System.out.println(pos.column());
}
}
