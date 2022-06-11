package microwave;

/**This class represent a microwave, that might have a set of states, depending of de actions performed on it
 * @author David RA
 * @version 1.0
 * */
public class Microwave
{
	// Variables
	private int power;
	private int timer;
	private boolean doorOpen;
	private boolean cooking;
	private boolean withItem;
	
	// Variables componentes
	private Heating heatingComponent = new Heating();
	private Lamp lampComponent = new Lamp();
	private Turntable turnableComponent = new Turntable();
	private Beeper beeperComponent = new Beeper();
	private Display displayComponent = new Display();
	/**Class that implement the microwave_interface*/
	private Microwave_Interface state;
	
	/**Main constructor: creates a microwave closed with no item
	 * 
	 * Must verify that the power and timer are 0
	 *                  the door, cook, item variables are false
	 *  */
	public Microwave()
	{
		state = new MW_ClosedWithNoItem(this);
		
		power = 0;
		timer = 0;
		doorOpen = false;
		cooking = false;
		withItem = false;
	}
	
	public void power_inc()
	{
		state.power_inc(this);
	}
	
	public void power_dec()
	{
		state.power_dec(this);
	}
	
	public void power_reset()
	{
		state.power_reset(this);
		displayComponent.setDisplay("0");
	}
	
	public void timer_inc()
	{
		state.timer_inc(this);
	}
	
	public void timer_dec()
	{
		state.timer_dec(this);
	}
	
	public void timer_reset()
	{
		state.timer_reset(this);
		displayComponent.setDisplay("0");
	}
	
	
	public void door_opened()
	{
		state.door_opened(this);
	}
	
	public void door_closed()
	{
		state.door_closed(this);
	}
	
	public void item_placed()
	{
		state.item_placed(this);
	}
	
	public void item_removed()
	{
		state.item_removed(this);
	}
	
	public void cooking_start()
	{
		state.cooking_start(this);
	}

	public void cooking_stop()
	{
		state.cooking_stop(this);
	}
	
	/**An external clock is in charge of invoking the tick() operation of the microwave every second, allowing you to know the passage of time*/
	public void tick()
	{
		state.tick(this);
	}
	
	
	// Not represented in the main UML diagram but necessary
	
	public int getPower()
	{
		return power;
	}
	
	public void setPower(int power)
	{
		this.power = power;
	}
	
	public int getTime()
	{
		return timer;
	}
	
	public void setTime(int timer)
	{
		if(timer > 0)
		{
			this.timer = timer;
		}
		else
		{
			this.timer = 0; // Not negative numbers in the timer
		}
	}
	
	
	public boolean isOpen()
	{
		return doorOpen;
	}
	
	public void setOpen(boolean doorOpen)
	{
		this.doorOpen = doorOpen;
	}
	
	public boolean isItem()
	{
		return withItem;
	}
	
	public void setItem(boolean withItem)
	{
		this.withItem = withItem;
	}
	
	public boolean isCooking()
	{
		return cooking;
	}
	
	public void setCooking(boolean cooking)
	{
		this.cooking = cooking;
	}
	
	public Microwave_Interface getState()
	{
		return state;
	}
	
	public Heating getHeatComponent()
	{
		return heatingComponent;
	}
	
	public Lamp getLampComponent()
	{
		return lampComponent;
	}
	
	public Turntable getTurntComponent()
	{
		return turnableComponent;
	}
	
	public Beeper getBeepComponent()
	{
		return beeperComponent;
	}
	
	public Display getDisplayComponent()
	{
		return displayComponent;
	}
	
	/**Method to change the state automatically -Needed for some tests*/
	public void setState(Microwave_Interface status)
	{
		this.state = status;
	}
}