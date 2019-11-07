
public class Tester {
	public static void main(String args[]){
		Position letterInstance = new Position('J', 10);
		Position letterInstance2 = new Position('A', 1);
		Position numberInstance = new Position(1, 2);
		Position numberInstance2 = new Position(9, 9);
		System.out.println("row (Letter): " + letterInstance.row());
		System.out.println("column: " + letterInstance.column());
		System.out.println("What a Human would  call the Position: " + letterInstance.toString());
		System.out.println("rowIndex: " + letterInstance.rowIndex());
		System.out.println("columnIndex: " + letterInstance.columnIndex());
		System.out.println();
		System.out.println();
		System.out.println("row (Letter): " + letterInstance2.row());
		System.out.println("column: " + letterInstance2.column());
		System.out.println("What a Human would  call the Position: " + letterInstance2.toString());
		System.out.println("rowIndex: " + letterInstance2.rowIndex());
		System.out.println("columnIndex: " + letterInstance2.columnIndex());
		System.out.println();
		System.out.println();
		System.out.println("row (Letter): " + numberInstance.row());
		System.out.println("column: " + numberInstance.column());
		System.out.println("What a Human would  call the Position: " + numberInstance.toString());
		System.out.println("rowIndex: " + numberInstance.rowIndex());
		System.out.println("columnIndex: " + numberInstance.columnIndex());

		System.out.println();
		System.out.println();
		System.out.println("row (Letter): " + numberInstance2.row());
		System.out.println("column: " + numberInstance2.column());
		System.out.println("What a Human would  call the Position: " + numberInstance2.toString());
		System.out.println("rowIndex: " + numberInstance2.rowIndex());
		System.out.println("columnIndex: " + numberInstance2.columnIndex());


		/*System.out.println(a.row());
		System.out.println(a.column());
		System.out.println(a.toString());
		System.out.println(b.row());
		System.out.println(b.column());
		System.out.println(b.toString());*/
	}
}
