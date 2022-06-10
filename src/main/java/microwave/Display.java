package microwave;

/**Display that allows the microwave to show different messages (for example, “The food is ready")*/
public class Display
{
	//Variable
	private String display;
	
	/**The operation clearDisplay() clears the contents of the screen and turns it off*/
	public void clearDisplay()
	{
		display = null;
	}
	/**The screen turns back on when calls the setDisplay() operation
	 * @param s - String that will show the GUI
	 * */
	public void setDisplay(String s)
	{
		display = s;
	}
	/**Getter of the display*/
	public String getDisplay()
	{
		return display;
	}	
}