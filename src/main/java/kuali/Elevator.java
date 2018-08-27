package kuali;

public class Elevator
{
	private int carID;
	private int currentFloor;
	private int topfloor;
	private boolean occupied;
	private ElevatorStatus status;


	public void Elevator( int carID, Building building )
	{
		this.carID = carID;
		this.currentFloor = 1;
		this.topfloor = building.floors;
		this.occupied = false;
		this.status = ElevatorStatus.available;
	}

	public void maintanceCycle( )
	{

	}

	private void move( elevatorDirection direction )
	{
		if( currentFloor < topfloor )
			currentFloor++;

		// would like to report via thread progress
		// 	or through messsaging client like kafka or kinesis
		// for testing for now, will write to log

	}


	private void doorEvent()
	{

	}

	private void reportFloor_log(int floor)
	{
		//logger.info( ) // elevator number and floor number
	}
	
	private void report_bus( Event event, String message )
	{

	}
}
