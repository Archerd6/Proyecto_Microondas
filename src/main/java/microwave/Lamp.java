package microwave;

/** Lamp that turns on (<b>lamp_on()</b>) or off (<b>lamp_off()</b>) based on different events, such as: <br>
 * <br>
 * - Door open <br>
 * - Microwave working a query operation
 * 
 * @author ap27r
 */
public class Lamp
{
	private boolean lampOn = false;
	
	/**Setter to true*/
	public void lamp_on()
	{
		lampOn = true;
	}
	
	/**Setter to false*/
	public void lamp_off()
	{
		lampOn = false;
	}
	
	/**Allows the microwave to know if the light is on or not*/
	public boolean isLampOn()
	{
		return lampOn;
	}
}