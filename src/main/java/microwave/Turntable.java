package microwave;

/**Turntable triggered by the <b>turntable_start()</b> operation when the microwave is running and 
 * stops (via the turntable_stop() operation) when the door is opened or cooking time is running out.<br>
 * <br>
 * It implements an <b>isMoving()</b> query operation that lets you know where all the time whether the platter is spinning or not.
 * @author ap27r
 * */
public class Turntable
{
	private boolean turntableOn = false;
	
	/**Setter to true*/
	public void turntable_start()
	{
		turntableOn = true;
	}
	
	/**Setter to false*/
	public void turntable_stop()
	{
		turntableOn = false;
	}
	
	/**Allows the microwave to know if the platterplatter is spinning*/
	public boolean isMoving()
	{
		return turntableOn;
	}	
}