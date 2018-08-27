package kuali;

public class ElevatorController
{
	private final int minTotal = 1;

	private int totalFloors;
	private int totalElevators;
	private Building building;

	public void init( int totalFloors, int totalElevators )
	{
		building.floors = totalFloors;
		building.elevators = totalElevators;
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

	}
}
