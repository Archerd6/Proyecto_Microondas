package microwave;

public interface Microwave_Interface
{
	/**Increment on 10w the power*/
	public void power_inc(Microwave mw);
	/**Decrement on 10w the power*/
	public void power_dec(Microwave mw);
	/**Set power to 0w*/
	public void power_reset(Microwave mw);
	/**Increase the timer*/
	public void timer_inc(Microwave mw);
	/**Decrease the timer*/
	public void timer_dec(Microwave mw);
	/**Set the timer to 0*/
	public void timer_reset(Microwave mw);
	/**Try to start the microwave*/
	
	/**Try to open the door*/
	public void door_opened(Microwave mw);
	/**Try to close the door*/
	public void door_closed(Microwave mw);
	/**Try to place a item*/
	public void item_placed(Microwave mw);
	/**Try to remove a item*/
	public void item_removed(Microwave mw);
	
	public void cooking_start(Microwave mw);
	/**Try to stop the microwave*/
	public void cooking_stop(Microwave mw);
	/**Once invoked this reduce the time remaining in timer one unit*/
	public void tick(Microwave mw);
}