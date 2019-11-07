public class BattleshipGrid {
	private int [][] grid = new int[][] {{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0}};
		private char[][] initGrid = new char[10][10];
		/*	This method is called when a player has shot at a position.
		 *  Hit is a Boolean that is true if the shot was a hit and false if it was a miss. 
		 *  Initial is the initial (A,B,C,D or S) of the ship that was hit. 
	This value is ignored if hit is false.*/
		public void shotAt(Position pos, boolean hit, char initial) {
			if(hit) {
				//System.out.println("RowIndex: " + pos.rowIndex() +"\n ColumnIndex: " +  pos.columnIndex());
				grid[pos.rowIndex()][pos.columnIndex()] = 1; // 1 means hit
				initGrid[pos.rowIndex()][pos.columnIndex()] = initial;
			}else {
				grid[pos.rowIndex()][pos.columnIndex()] = 2; // 2 means miss
				// NO INITIAL NEEDED BC IT IS A MISS
			}

		}

		//This method returns true if the position has been shot at and is a hit, false otherwise.
		public boolean hit(Position pos) {
			if (grid[pos.rowIndex()][pos.columnIndex()] == 1) {
				return true;
			} else {
				return false;
			}
			
		}

		//This method returns true if the position has been shot at and is a miss, false otherwise.
		public boolean miss(Position pos) {
			if (grid[pos.rowIndex()][pos.columnIndex()] == 2) {
				return true;
			} else {
				return false;
			}
		}


		/*This method returns true if the position has not been shot at.*/
		public boolean empty(Position pos) {
			if (grid[pos.rowIndex()][pos.columnIndex()] == 0) {
				return true;
			} else {
				return false;
			}
		}


		/*This method should only be called if the position has been shot at and is a hit. 
	It returns the initial of the boat that has been hit.*/
		public char boatInitial(Position pos) {

			return initGrid[pos.rowIndex()][pos.columnIndex()];
		}

}
