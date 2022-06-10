package microwave;

/**This class represent a microwave that is closed, with no item inside of it
 * @author David RA
 * @version 1.1
 * */
public class MW_ClosedWithNoItem implements Microwave_Interface
{
	/**The constructor must verify that the lamp, heating, turnable, Cooking and the door are off
	 * An must have a item inside
	 *  */
	public MW_ClosedWithNoItem(Microwave m)
	{
		m.getLampComponent().lamp_off(); // Check lamp
		m.getHeatComponent().heating_off(); // Check heat
		m.getTurntComponent().turntable_stop(); // Check rotation
		m.setCooking(false); // Check cooking
		m.setOpen(false); // Check door
		m.setItem(false); // Check item
		m.getDisplayComponent().clearDisplay(); // Display restarted, as this is the state created by default in the microwave
	}
	
	@Override
	public void door_opened(Microwave m)
	{
		m.setState(new MW_OpenWithNoItem(m));
	}

	@Override
	public void door_closed(Microwave m)
	{
		// Exception would be manage - Message written in English don't show to the users
		throw new IllegalStateException("You cant close the door of a already closed microwave");
	}

	@Override
	public void item_placed(Microwave m)
	{
		// Exception would be manage - Message written in English don't show to the users
		throw new IllegalStateException("You cant place a item in a closed microwave");
	}

	@Override
	public void item_removed(Microwave m)
	{
		// Exception would be manage - Message written in English don't show to the users
		throw new IllegalStateException("You cant remove a item having the door closed");
	}
	
	@Override
	public void power_inc(Microwave m)
	{
		m.setPower(m.getPower() + 10); // Increment on 10w the power as said in interface
		m.getDisplayComponent().setDisplay(Integer.toString(m.getPower()));
	}
	
	@Override
	public void power_dec(Microwave m)
	{
		if (m.getPower() > 0)
		{
			m.setPower(m.getPower() - 10); // Decrement on 10w the power as said in interface
			m.getDisplayComponent().setDisplay(Integer.toString(m.getPower()));
		}
	}

	@Override
	public void power_reset(Microwave m)
	{
		m.setPower(0);
		m.getDisplayComponent().setDisplay(Integer.toString(m.getPower()));
	}
	
	@Override
	public void timer_inc(Microwave mw)
	{
		mw.setTime(mw.getTime() + 1);
		mw.getDisplayComponent().setDisplay(Integer.toString(mw.getTime()));
	}
	
	@Override
	public void timer_dec(Microwave m)
	{
		if (m.getTime() > 0)
		{
			m.setTime(m.getTime() - 1);
			m.getDisplayComponent().setDisplay(Integer.toString(m.getTime()));
		}
	}
	
	@Override
	public void timer_reset(Microwave m)
	{
		m.setTime(0);
	}
	
	@Override
	public void cooking_start(Microwave m)
	{
		// Exception would be manage - Message written in English don't show to the users
		throw new IllegalStateException("You cant start cook with no item inside");
	}

	@Override
	public void cooking_stop(Microwave m)
	{
		// Exception would be manage - Message written in English don't show to the users
		throw new IllegalStateException("Microwave was already stopped");
	}

	@Override
	public void tick(Microwave m)
	{
		// Exception would be manage - Message written in English don't show to the users
		throw new IllegalStateException("Timer must not run when microwave not running");
	}


}