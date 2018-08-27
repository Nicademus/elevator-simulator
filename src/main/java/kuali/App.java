package kuali;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
    	Scanner keyboard = new Scanner(System.in);
    	int floorsCount;
    	int elevatorsCount;
		// get number of floors
		System.out.println( "Please enter the number of floors in simulator:" );
		floorsCount = keyboard.nextInt( );
		System.out.println( "Please enter the number of elevators for simulator:" );
		elevatorsCount = keyboard.nextInt( );

		ElevatorController controller = new ElevatorController(floorsCount, elevatorsCount );
    }
}
