package kuali;

import javafx.event.Event;

import java.util.EventListener;

public class Elevator
{
	private int carID;
	private int currentFloor;
	private int destinationFloor;
	private int topfloor;
	private boolean occupied;
	private int trips;
	private ElevatorStatus status;
	private int maxTrips = 100;


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


	public boolean moveRequest( int destinationFloor )
	{
		this.destinationFloor = destinationFloor;

		// if moving in opposite direction
		// 1. either cancel request
		// 2. append request to end of current request

		// assuming no other current request
		int moving = destinationFloor - currentFloor;

		if( moving < 0 )
			move( elevatorDirection.down );
		else if( moving > 0 )
			move( elevatorDirection.up );
		else if( moving == 0 )
			openDoor( );
	}

	private void move(elevatorDirection direction )
	{
		if( currentFloor < topfloor )
			currentFloor++;

		//publish move event to bus

		// if destination floor = current floor
		openDoor( );

		// check number of trips
		if( trips >= maxTrips )
		{
			status = ElevatorStatus.maintenance;
			// publish maintenance event to bus
		}
	}

	private void moveToFloor( int floor )
	{
		reportEvent( ElevatorEvent.movedToFloor, floor );
	}

	private void openDoor()
	{
		//publish open door event
		reportEvent( ElevatorEvent.doorOpened, "" );
	}

	private void reportEvent( ElevatorEvent event, String message )
	{
		// publish event to message bus
	}
}
