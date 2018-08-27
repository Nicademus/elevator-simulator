package kuali;

public class Elevator
{
	protected int currentFloor;
	protected boolean occupied;
	protected int topfloor;

	public void init( int topfloor )
	{
		//
	}

	public void maintanceCycle( )
	{

	}

	private void moveUp( )
	{
		if( currentFloor < topfloor )
		currentFloor++;

		// would like to report to messsaging client like kafka or kinesis
		// for testing for now, will write to log

	}
}
