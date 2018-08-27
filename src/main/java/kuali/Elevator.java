package kuali;

import javafx.event.Event;

import java.util.EventListener;

// @EnableAsync
public class Elevator
{
	private int carID;
	private int currentFloor;
	private int floorRequest;
	private int destinationFloor;
//	private priorityQueue destinationFloors;		// add the destinations to a simple priority queue - based on the current floor and direction
	private int topfloor;
	private int firstfloor = 1;
	private boolean occupied;
	private int trips;
	private ElevatorStatus status;
	private elevatorDirection direction;
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

	// called to floor by controller
	public void CallCar(int floor )
	{
		this.floorRequest = destinationFloor;
		// validation: if moving in opposite direction
		// 	1. either cancel request
		// 	2. append request to end of current request

		if(this.destinationFloor == -1)
		{
			this.destinationFloor = floorRequest;
			moveRequest( floorRequest );
		}
		else
		{
			// add to queue
		}
	}


	// run this in a seperate thread
	// button inside elevator pushed
	// @async
	public void moveRequest( int destinationFloor )
	{
		occupied = true;
		int moving = destinationFloor - currentFloor;

		if( moving < 0 )
			direction = elevatorDirection.down;
		else if( moving > 0 )
			direction = elevatorDirection.up;
		else if( moving == 0 )
		{
			openDoor( );
			return;
		}

		while( currentFloor != destinationFloor )		// with this threaded, the destinationFloor could be updated in transit to pick up another person going the same direction
		{
			if( direction == elevatorDirection.down )
				moveToFloor( --currentFloor );
			else if( direction == elevatorDirection.up )
				moveToFloor( currentFloor++ );


			// check for request on current path
			// if a new request occurs
		}

		if(currentFloor == destinationFloor )		// check in case the while loop exited by interrupt, etc.
		{
			if( ++trips == maxTrips )
				status = ElevatorStatus.maintenance;

			occupied = false;
			openDoor( );
		}
	}

	private void moveToFloor( int floor )
	{
		if( floor <= topfloor && floor >= firstfloor )
			currentFloor = floor;

		reportEvent( ElevatorEvent.movedToFloor, "floor" + floor );
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


	private void openDoor( )
	{
		//publish open door event
		reportEvent( ElevatorEvent.doorOpened, "" );

		//start timer to close door
	}

	private void closeDoor( )
	{
		reportEvent( ElevatorEvent.doorClosed, "" );

		if( destinationFloor != currentFloor )
			moveToFloor( destinationFloor );
	}

	private void reportEvent( ElevatorEvent event, String message )
	{
		// publish event to message bus
	}
}
