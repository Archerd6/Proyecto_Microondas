package microwave;

/**This class represent a microwave that is opened, with a item inside of it
 * @author David RA
 * @version 1.1
 * */
public class MW_OpenWithItem implements Microwave_Interface
{
	/**The constructor must verify that the heating, turnable, Cooking and the door are off
	 * Must have a item inside and lamp turned on
	 *  */
	public MW_OpenWithItem(Microwave mw)
	{
		mw.setCooking(false); // Check cooking
		mw.setItem(true); // Check item
		mw.setOpen(true); // Check door
		mw.getLampComponent().lamp_on(); // Check lamp
		mw.getHeatComponent().heating_off(); // Check heat
		mw.getTurntComponent().turntable_stop(); // Check rotation
	}

	@Override
	public void door_opened(Microwave mw)
	{
		// Exception would be manage - Message written in English don't show to the users
		throw new IllegalStateException("You cant open a door in a opened microwave");
	}

	@Override
	public void door_closed(Microwave mw)
	{
		mw.setState(new MW_ClosedWithItem(mw));
	}

	@Override
	public void item_placed(Microwave mw)
	{
		// Exception would be manage - Message written in English don't show to the users
		throw new IllegalStateException("You cant place a item in a microwave that have some item inside");
	}

	@Override
	public void item_removed(Microwave mw)
	{
		mw.setState(new MW_OpenWithNoItem(mw));
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
	public void timer_reset(Microwave mw)
	{
		mw.setTime(0);
	}
	
	@Override
	public void cooking_start(Microwave mw)
	{
		// Exception would be manage - Message written in English don't show to the users
		throw new IllegalStateException("You must no be able to start the microwave with the door oppened");
	}

	@Override
	public void cooking_stop(Microwave mw)
	{
		// Exception would be manage - Message written in English don't show to the users
		throw new IllegalStateException("Microwave was stopped before");
	}

	@Override
	public void tick(Microwave m)
	{
		// Exception would be manage - Message written in English don't show to the users
		throw new IllegalStateException("Timer must not run when microwave not running");
	}
}