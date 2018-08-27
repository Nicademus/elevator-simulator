package kuali;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController
{
	private final int minTotal = 1;

	private int totalFloors;
	private int totalElevators;
	private Building building;
	private List<Elevator> availableElevators;

	public void init( int totalFloors, int totalElevators )
	{
		building.floors = totalFloors;
		building.elevators = totalElevators;

		availableElevators = new ArrayList<>(  );

		for( int i = 0; i < totalElevators; i++ )
		{
			availableElevators.add( new Elevator( i, building ));
		}
	}

	public ElevatorController( )
	{
		init( minTotal, minTotal );
	}

	public ElevatorController( int totalFloors, int totalElevators)
	{
		init( totalFloors, totalElevators );
	}

	/*
	 * elevator requests get routed from here to the individual elevators.
	 */
	public void requestElevator( int requestingFloor, elevatorDirection direction )
	{
		for( Elevator : availableElevators )
	}
}
