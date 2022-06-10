package microwave;

/**This class represent a microwave that is opened, with no item inside of it
 * @author David RA
 * @version 1.1
 * */
public class MW_OpenWithNoItem implements Microwave_Interface
{
	/**The constructor must verify that the heating, turnable, Cooking and the door are off
	 * Must have a item inside and lamp turned on
	 *  */
	public MW_OpenWithNoItem(Microwave mw)
	{
		mw.setCooking(false); // Check cooking
		mw.setItem(false); // Check item
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
		mw.setState(new MW_ClosedWithNoItem(mw));
	}

	@Override
	public void item_placed(Microwave mw)
	{
		mw.setState(new MW_OpenWithItem(mw));
	}

	@Override
	public void item_removed(Microwave mw)
	{
		// Exception would be manage - Message written in English don't show to the users
		throw new IllegalStateException("There is no item to be removed in the microwave");
	}
	
	@Override
	public void power_inc(Microwave m)
	{
		m.setPower(m.getPower() + 10); // Increment on 10w the power as said in interface
		m.getDisplayComponent().setDisplay(Integer.toString(m.getPower()));
	}
	
	@Override
	public void power_dec(Microwave mw)
	{
		if (mw.getPower() > 0)
		{
			mw.setPower(mw.getPower() - 10); // Decrement on 10w the power as said in interface
			mw.getDisplayComponent().setDisplay(Integer.toString(mw.getPower()));
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
	public void timer_dec(Microwave mw)
	{
		if (mw.getTime() > 0)
		{
			mw.setTime(mw.getTime() - 1);
			mw.getDisplayComponent().setDisplay(Integer.toString(mw.getTime()));
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
	public void tick(Microwave mw)
	{
		// Exception would be manage - Message written in English don't show to the users
		throw new IllegalStateException("Timer must not run when microwave not running");
	}
}