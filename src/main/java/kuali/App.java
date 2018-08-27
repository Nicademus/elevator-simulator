package kuali;

public class App
{
    public static void main( String[] args )
    {
    	int floorsCount;
    	int elevatorsCount;
		// get number of floors
		floorsCount = 10; // just for testing

		// get number of elevators
		elevatorsCount = 2;		// just for testing

		ElevatorController controller = new ElevatorController(floorsCount, elevatorsCount );
    }
}
