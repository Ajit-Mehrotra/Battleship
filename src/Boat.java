import java.util.ArrayList;

public class Boat {
	private String boatType;
	private Position startingPosition;
	private String orientationOfBoat;
	private int size;
	private int rowIndex;
	private int columnIndex;
	//private int[] rowBoat = new int[size()] ;
	private ArrayList<Integer> rowBoat= new ArrayList<Integer>();
	private ArrayList<Integer> columnBoat= new ArrayList<Integer>();
	//private int[] columnBoat = new int[size()] ;
	private ArrayList<Position> hitPositions = new ArrayList<Position>();
	private int setRowIndex(Position pos) {
		rowIndex = pos.rowIndex();
		return rowIndex;
	}
	private int setColumnIndex(Position pos) {
		columnIndex = pos.columnIndex();
		return columnIndex;
	}
	Boat(String typeOfBoat, Position pos, String orientation){
		boatType = typeOfBoat;
		startingPosition = pos;// might have to change this
		orientationOfBoat = orientation;
		size = size();
		setRowIndex(pos);
		setColumnIndex(pos);
		setBoat(pos);


	}
	private void setBoat(Position pos){


		//throw new ArrayIndexOutOfBoundsException();// THIS IS SAFETY 
		if(orientationOfBoat.equalsIgnoreCase("vertical") && ((rowIndex > (9-size) || rowIndex < 0) || (columnIndex < 0 || columnIndex >9)) ) {
			throw new ArrayIndexOutOfBoundsException();
		} else if(orientationOfBoat.equalsIgnoreCase("horizontalu") && ((columnIndex > (9-size) ||columnIndex < 0 )|| (rowIndex < 0 || rowIndex >9)) ) {
			throw new ArrayIndexOutOfBoundsException();
		}
		else if(orientationOfBoat.equalsIgnoreCase("horizontal")) {
			for(int a = 0; a< size  ; a++) {
				rowBoat.add(pos.rowIndex());

				//System.out.println(rowBoat.get(a));
				columnBoat.add( pos.columnIndex() + a );
				//System.out.println(columnBoat.get(a));
				//positionOfBoat.add(new Position(rowIndex, columnIndex + a));

			}

		}else if(orientationOfBoat.equalsIgnoreCase("vertical")) {
			for(int a = 0; a< size  ; a++) {
				rowBoat.add(pos.rowIndex() + a);
				//System.out.println(rowBoat.get(a));
				columnBoat.add( pos.columnIndex() );
				//System.out.println(columnBoat.get(a));


			}
		}
	}



	public String name() {
		return boatType;
	}

	public char abbreviation() {
		if (boatType.equals("Aircraft Carrier")){
			return 'A';
		}else if (boatType.equals("Battleship")){
			return 'B';
		}else if (boatType.equals("Cruiser")){
			return 'C';
		} else if (boatType.equals("Submarine")){
			return 'S';
		} else if (boatType.equals("Destroyer")){
			return 'D';
		}
		return 'F';
	}

	public int size(){
		if (boatType.equals("Aircraft Carrier")){
			return 5;
		}else if (boatType.equals("Battleship")){
			return 4;
		}else if (boatType.equals("Cruiser")){
			return 3;
		} else if (boatType.equals("Submarine")){
			return 3;
		} else if (boatType.equals("Destroyer")){
			return 2;
		}
		return 100;
	}
	public boolean onBoat(Position pos) {// TWO PIECES OF "DEAD CODE"...I THINK THAT'S A LIE BUT TESTING TIME

		//int hitRow = pos.rowIndex();
		//int hitColumn = pos.columnIndex();
		boolean onBoat = false ;
		if(orientationOfBoat.equals("horizontal")) {
			if(pos.rowIndex() == rowBoat.get(0)) {
				for(int i = 0; i<columnBoat.size(); i++) {
					if(columnBoat.get(i) == pos.columnIndex()) {
						onBoat =  true;
					}


				}
			}

		}
		if(orientationOfBoat.equals("vertical")) {
			//System.out.println("Love");
			if(pos.columnIndex() == columnBoat.get(0)) {
				//System.out.println("To Yeet");
				for(int a = 0; a<size; a++) {
					if(rowBoat.get(a) == pos.rowIndex()) {
						onBoat = true;
					}
				}
			}
		}
		return onBoat; // THIS MIGHT BE REASON FOR ERROR INTHE FUTURE!!
	}
	public boolean isHit (Position pos) {
		boolean isHit = false;
		for(int a = 0; a < hitPositions.size(); a++) {
			if((hitPositions.get(a).rowIndex() == pos.rowIndex()) && hitPositions.get(a).columnIndex() == pos.columnIndex()) {
				isHit = true;
			}
		}
		return isHit;
	}
	public void hit(Position pos) {
		boolean hasAlreadyBeenHit = false;
		if (onBoat(pos)) {
			for(int a = 0; a < hitPositions.size(); a++ ) {
				if(hitPositions.get(a).rowIndex() == pos.rowIndex() && hitPositions.get(a).columnIndex() == pos.columnIndex()) {
					hasAlreadyBeenHit = true;
				}
			} 
			if(hasAlreadyBeenHit) {
				hitPositions.add(pos);
				hitPositions.remove(hitPositions.size() -1 );
			}else {
				hitPositions.add(pos);
			}
			
		}
	}
	public boolean sunk() { //REMOVE PRINT STATEMENT IN METHOD
		if(hitPositions.size() > size) {
			throw new ArrayIndexOutOfBoundsException();
			//System.out.println("Array List Null in Sunk method");

		}else if(hitPositions.size() == size) {
			return true;
		}else if(hitPositions.size() < size) {
			return false;
		}
		return false;
	}
	public String direction() {
		return orientationOfBoat;
	}
	public static void main(String args[]) {
		/*Boat a = new Boat("Aircraft Carrier", new Position (4,4), "horizontal");
		a.abbreviation(); */
	}
	public Position position() {
		return startingPosition;
	}
}





