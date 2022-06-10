package microwave;
/**Listener to the Beeper class, as Beeper don't have variables to save in the UML diagram
 * @author ap27r
 * */
public class BeeperCounter
{	
	/**Variables to save the number of beeps*/
	private static int num_beeps;
	
	/**Main metod used by the Beeper class
	 * @param times_beeped
	 * */
	public static void listen(int times_beeped)
	{
		num_beeps = times_beeped;
	}
	
	/**Has the beep beeped?*/
	public static boolean isBeeped(int t)
	{
		return (clear() == t);
	}
	
	/**Reset number of beep and return old value*/
	private static int clear()
	{
		int bp = num_beeps;
		num_beeps = 0;      
		return bp;
	}
}