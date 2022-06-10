package microwave;

/**Bell that warns when the timer has reached zero
 * @author ap27r
 * */
public class Beeper
{
	/**Makes the bell ring as many times as indicated by the parameter
	 * @param d - Times to beep
	 * */
	public void beep(int d)
	{
		BeeperCounter.listen(d);
	}
}