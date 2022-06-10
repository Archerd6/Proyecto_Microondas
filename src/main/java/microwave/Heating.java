package microwave;
/**Magnetron device that emits microwaves, in charge of heat the food to a certain power (<b>power</b>) <br>
 * <br>
 * The microwave turns it on and off using the <b>heating_on()</b> and <b>heating_off()</b> operations <br>
 * You can also know whether it is on or not with the <b>isHeating()</b> query operation <br>
 * The microwave component can also set the power and meet it with the <b>setPower()</b> and <b>getPower()</b> operations <br>
 * 
 * @author ap27r
 */
public class Heating
{
	// Variables
	private boolean heating = false;
	private int power = 0;
	
	/**Setter to true*/
	public void heating_on()
	{
		heating = true;
	}
	
	/**Setter to false*/
	public void heating_off()
	{
		heating = false;
	}
	
	/**Setter to value*/
	public void setPower(int power)
	{
		if (power >= 0) // Can't give negative power
		{
			this.power = power;
		}
	}
	
	// Getters
	public boolean isHeating()
	{
		return heating;
	}
	
	public int getPower()
	{
		return power;
	}
}