import java.util.ArrayList;

public class Ocean extends GoodOcean{
	private ArrayList <String> Boats= new ArrayList<String>();

	//	You will create a method called 
	//	placeAllBoats
	//	 that takes no arguments 
	//	and will place each type of boat somewhere on the ocean using the PlaceBoat method 
	//	you created in the previous assignment.
	private int randomInteger() {
		return (int) (Math.random()* 10);
	}
	private String randomDirection() {
		int randomNumber = (int) (Math.random()* 2);
		if(randomNumber == 1) {
			return"horizontal";
		}else {
			return "vertical";
		}
	}
	public void placeAllBoats(){
		Boats.add("Aircraft Carrier");
		Boats.add("Battleship");
		Boats.add("Cruiser");
		Boats.add("Submarine");
		Boats.add("Destroyer");
		while(Boats.size() < 6 && Boats.size() > 0) {
			try {
				//System.out.println("Goes through : "  + numberOfBoatsOnBoard);
				//System.out.println(Boats.get(0));
				this.placeBoat(Boats.get(0),randomDirection(), new Position(randomInteger(), randomInteger()));
				Boats.remove(0);
				//System.out.println(a);
				//a++;

			} catch (Exception e) {

			}	

		}



	}
	public static void main(String args[]) {

	}
}
