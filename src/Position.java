public class Position {


	private char rowLetter; // Letter (1 + the index which is what the computer gets it into)
	private int rowNumber; // rowNumber is the number corresponding to rowLetter -1 (so the index for arrays)
	private int columnNumber ;// the number corresponding for arrays 
	private char rowArray[] = {'A','B','C','D','E','F','G','H','I','J'};


	Position(char letter, int number ){ // 
		rowLetter = Character.toUpperCase(letter);
		columnNumber = number-1;
		rowNumber = charToIndex(letter);
	}

	Position(int givenRowIndex, int columnIndex){ // INDEX CONSTRUCTORS
		rowNumber = givenRowIndex;
		columnNumber = columnIndex;
		rowLetter = indexToLetter();
	}
	public char row() {// RETURNS A CHARACTER
		return rowLetter;
	}

	public int column() {// RETURNS WHAT HUMANS CALL IT
		return columnNumber + 1;
	}

	public  String toString() {
		String positionOfShip = "";
		String letterforRow = Character.toString(rowLetter); // conversion from character to String for the (char)rowLetter variable
		String columnNumberString = Integer.toString(columnNumber + 1); // conversion from integer to String for the (int)columnNumber variable. I don't think this is needed but I don't really care at this point.
		positionOfShip = letterforRow + "-" + columnNumberString;
		return positionOfShip;

	}

	private int charToIndex( char Letter) {  // takes an character and converts it into an Index. Implemented for use in the rowIndex. Used in construtor #1 for ease of use 
		int indexValue = 0;
		for(int a = 0; a < rowArray.length; a++) {
			if(rowArray[a] == Character.toUpperCase(Letter)) {
				indexValue = a;
			}
		}
		return indexValue;
	}

	public char indexToLetter() {  // takes an index and converts it into the corresponding char. Made for toString's output.
		char letter = 'L';
		for(int a = 0; a < rowArray.length ; a++) {
			if (a == rowNumber) {
				//System.out.println(Character.toUpperCase(rowLetter));
				//System.out.println(a);
				letter =  rowArray[a];
			}
		}
		return letter;


	}
	public int rowIndex() {
		return rowNumber;
	}
	public int columnIndex() {
		return columnNumber;
	}
	public  static void main(String args[]) {


	}

}
