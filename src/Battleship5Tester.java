public class Battleship5Tester {
	public static char AircraftCarrier = 'A';
	public static char Battleship = 'B';
	public static char Submarine = 'S';
	public static char Cruiser = 'C';
	public static char Destroyer = 'D';
	public static void main (String args []) {

		boolean aircraftTrueTester = false;
		boolean BattleshipTrueTester = false;
		boolean CruiserTrueTester = false;
		boolean SubmarineTrueTester = false;
		boolean DestroyerTrueTester = false;

		boolean AircraftInitialTester = false;
		boolean BattleshipInitialTester = false;
		boolean CruiserInitialTester = false;
		boolean SubmarineInitialTester = false;
		boolean DestroyerInitialTester = false;

		// FOR AIRCRAFT CARRIER WHILE TRUE(TESTS HIT)
		BattleshipGrid yeet = new BattleshipGrid();
		for(int a = 0; a < 10; a++) {
			for (int b = 0;  b < 10; b++) {
				//System.out.println("A: " + a );
				//System.out.println("B: " + b );
				Position pos1 = new Position(a,b);
				yeet.shotAt(pos1, true, AircraftCarrier);
				aircraftTrueTester = !yeet.miss(pos1);
				aircraftTrueTester = yeet.hit(pos1);
				if(yeet.boatInitial(pos1) == AircraftCarrier) {
					AircraftInitialTester = true;
				}else {
					AircraftInitialTester = false;
				}


			}

		}
		// FOR BATTLSHIP WHILE TRUE (TESTS HIT)
		BattleshipGrid yeet1 = new BattleshipGrid();
		for(int a = 0; a < 10; a++) {
			for (int b = 0;  b < 10; b++) {
				//System.out.println("A: " + a );
				//System.out.println("B: " + b );
				Position pos1 = new Position(a,b);
				yeet1.shotAt(pos1, true, Battleship);
				BattleshipTrueTester = !yeet1.miss(pos1);
				BattleshipTrueTester = yeet1.hit(pos1);
				if(yeet1.boatInitial(pos1) == Battleship) {
					BattleshipInitialTester = true;
				}else {
					BattleshipInitialTester = false;
				}

			}

		}
		// FOR CRUISER WHILE TRUE (TESTS HIT)
		BattleshipGrid yeet2 = new BattleshipGrid();
		for(int a = 0; a < 10; a++) {
			for (int b = 0;  b < 10; b++) {
				//System.out.println("A: " + a );
				//System.out.println("B: " + b );
				Position pos1 = new Position(a,b);
				yeet2.shotAt(pos1, true, Cruiser);
				CruiserTrueTester = !yeet2.miss(pos1);
				CruiserTrueTester = yeet2.hit(pos1);
				if(yeet2.boatInitial(pos1) == Cruiser) {
					CruiserInitialTester = true;
				}else {
					CruiserInitialTester = false;
				}

			}

		}
		// FOR SUBMARINE WHILE TRUE (TESTS HIT)
		BattleshipGrid yeet3 = new BattleshipGrid();
		for(int a = 0; a < 10; a++) {
			for (int b = 0;  b < 10; b++) {
				//System.out.println("A: " + a );
				//System.out.println("B: " + b );
				Position pos1 = new Position(a,b);
				yeet3.shotAt(pos1, true, Submarine);
				SubmarineTrueTester = !yeet3.miss(pos1);
				SubmarineTrueTester = yeet3.hit(pos1);
				if(yeet3.boatInitial(pos1) == Submarine) {
					SubmarineInitialTester = true;
				}else {
					SubmarineInitialTester = false;
				}


			}

		}

		// FOR  DESTROYER WHILE TRUE (TESTS HIT)
		BattleshipGrid yeet4 = new BattleshipGrid();
		for(int a = 0; a < 10; a++) {
			for (int b = 0;  b < 10; b++) {
				//System.out.println("A: " + a );
				//System.out.println("B: " + b );
				Position pos1 = new Position(a,b);
				yeet4.shotAt(pos1, true, Destroyer);
				DestroyerTrueTester = !yeet4.miss(pos1);
				DestroyerTrueTester = yeet4.hit(pos1);
				if(yeet4.boatInitial(pos1) == Destroyer) {
					DestroyerInitialTester = true;
				}else {
					DestroyerInitialTester = false;
				}

			}

		}




		boolean aircraftFalseTester = false;
		boolean BattleshipFalseTester = false;
		boolean CruiserFalseTester = false;
		boolean SubmarineFalseTester = false;
		boolean DestroyerFalseTester = false; 

		boolean AircraftFalseEmptyTester = false;
		// FOR AIRCRAFT CARRIER WHILE FALSE(TESTS HIT)
		BattleshipGrid yeet5 = new BattleshipGrid();
		for(int a = 0; a < 10; a++) {
			for (int b = 0;  b < 10; b++) {
				//System.out.println("A: " + a );
				//System.out.println("B: " + b );
				Position pos1 = new Position(a,b);
				yeet5.shotAt(pos1, false, AircraftCarrier);
				AircraftFalseEmptyTester = !yeet5.empty(pos1);
				aircraftFalseTester = yeet5.miss(pos1);
				aircraftFalseTester = !yeet5.hit(pos1);


			}

		}
		boolean BattleshipFalseEmptyTester = false;
		// FOR BATTLSHIP WHILE FALSE (TESTS HIT)
		BattleshipGrid yeet6 = new BattleshipGrid();
		for(int a = 0; a < 10; a++) {
			for (int b = 0;  b < 10; b++) {
				//System.out.println("A: " + a );
				//System.out.println("B: " + b );
				Position pos1 = new Position(a,b);
				yeet6.shotAt(pos1, false, Battleship);
				BattleshipFalseEmptyTester = !yeet6.empty(pos1);
				BattleshipFalseTester = yeet6.miss(pos1);
				BattleshipFalseTester = !yeet6.hit(pos1);


			}

		}
		boolean CruiserFalseEmptyTester = false;
		// FOR CRUISER WHILE FALSE (TESTS HIT)
		BattleshipGrid yeet7 = new BattleshipGrid();
		for(int a = 0; a < 10; a++) {
			for (int b = 0;  b < 10; b++) {
				//System.out.println("A: " + a );
				//System.out.println("B: " + b );
				Position pos1 = new Position(a,b);
				yeet7.shotAt(pos1, false, Cruiser);
				CruiserFalseEmptyTester =!yeet7.empty(pos1);
				CruiserFalseTester = yeet7.miss(pos1);
				CruiserFalseTester = !yeet7.hit(pos1);


			}

		}
		boolean SubmarineFalseEmptyTester = false;
		// FOR SUBMARINE WHILE FALSE (TESTS HIT)
		BattleshipGrid yeet8 = new BattleshipGrid();
		for(int a = 0; a < 10; a++) {
			for (int b = 0;  b < 10; b++) {
				//System.out.println("A: " + a );
				//System.out.println("B: " + b );
				Position pos1 = new Position(a,b);
				yeet8.shotAt(pos1, false, Cruiser);
				SubmarineFalseEmptyTester = !yeet8.empty(pos1);
				SubmarineFalseTester = yeet8.miss(pos1);
				SubmarineFalseTester = !yeet8.hit(pos1);


			}

		}

		boolean DestroyerFalseEmptyTester = false;
		// FOR  DESTROYER WHILE FALSE (TESTS HIT)
		BattleshipGrid yeet9 = new BattleshipGrid();
		for(int a = 0; a < 10; a++) {
			for (int b = 0;  b < 10; b++) {
				//System.out.println("A: " + a );
				//System.out.println("B: " + b );
				Position pos1 = new Position(a,b);
				yeet9.shotAt(pos1, false, Cruiser);
				DestroyerFalseEmptyTester = !yeet9.empty(pos1);
				DestroyerFalseTester = yeet9.miss(pos1);
				DestroyerFalseTester = !yeet9.hit(pos1);



			}


		}
		BattleshipGrid yeet10 = new BattleshipGrid();
		Position pos1 = new Position(0,0);
		System.out.println("Works with no shotAt: " + yeet10.empty(pos1));

System.out.println("Aircraft Carrier Works While True: \n" + "Hit & Miss: " + aircraftTrueTester + "\nBoatInitial: " + AircraftInitialTester );
System.out.println("\nBattleship Works While True: \n" + "Hit & Miss: " + BattleshipTrueTester + "\nBoatInitial: " + BattleshipInitialTester);
System.out.println("\nCruiser Works While True: \n" + "Hit & Miss: " + CruiserTrueTester+ "\nBoatInitial: " + CruiserInitialTester );
System.out.println("\nSubmarine Works While True: \n" + "Hit & Miss: " + SubmarineTrueTester + "\nBoatInitial: " + SubmarineInitialTester);
System.out.println("\nDestroyer Works While True: \n" + "Hit & Miss: " + DestroyerTrueTester + "\nBoatInitial: " + DestroyerInitialTester);
		System.out.println("---------------------------------------------------------------------------");
System.out.println("Aircraft Carrier Works While False: \n" + "Hit&Miss: " + aircraftFalseTester + "\nEmpty: " + AircraftFalseEmptyTester );
System.out.println("\nBattleship Works While False: \n" + "Hit&Miss: " + BattleshipFalseTester + "\nEmpty: " + BattleshipFalseEmptyTester );
System.out.println("\nCruiser Works While False: \n" + "Hit&Miss: " + CruiserFalseTester + "\nEmpty: " + CruiserFalseEmptyTester );
System.out.println("\nSubmarine Works While False: \n" +"Hit&Miss: " + SubmarineFalseTester + "\nEmpty: " + SubmarineFalseEmptyTester);
System.out.println("\nDestroyer Works While False: \n" + "Hit&Miss: " + DestroyerFalseTester + "\nEmpty: " + DestroyerFalseEmptyTester );	
	}
}
