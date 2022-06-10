package microwave;

/**This class represent a microwave that is closed, with a item inside of it
 * @author David RA
 * @version 1.1
 * */
public class MW_ClosedWithItem implements Microwave_Interface
{
	/**The constructor must verify that the lamp, heating, turnable, Cooking and the door are off
	 * An must have a item inside
	 *  */
	public MW_ClosedWithItem(Microwave mw)
	{
		mw.getLampComponent().lamp_off(); // Check lamp
		mw.getHeatComponent().heating_off(); // Check heat
		mw.getTurntComponent().turntable_stop(); // Check rotation
		mw.setCooking(false); // Check cooking
		mw.setOpen(false); // Check door
		mw.setItem(true); // Check item
	}

	@Override
	public void door_opened(Microwave mw)
	{
		// Exception would be manage - Message written in English don't show to the users
		mw.setState(new MW_OpenWithItem(mw));
	}

	@Override
	public void door_closed(Microwave mw)
	{
		// Exception would be manage - Message written in English don't show to the users
		throw new IllegalStateException("You cant close the door of a already closed microwave");
	}

	@Override
	public void item_placed(Microwave mw)
	{
		// Exception would be manage - Message written in English don't show to the users
		throw new IllegalStateException("You cant place a item in a closed microwave");
	}

	@Override
	public void item_removed(Microwave mw)
	{
		// Exception would be manage - Message written in English don't show to the users
		throw new IllegalStateException("You cant remove a item having the door closed");
	}
	
	@Override
	public void power_inc(Microwave mw)
	{
		mw.setPower(mw.getPower() + 10); // Increment on 10w the power as said in interface
		mw.getDisplayComponent().setDisplay(Integer.toString(mw.getPower()));
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
	public void power_reset(Microwave mw)
	{
		mw.setPower(0);
		mw.getDisplayComponent().setDisplay(Integer.toString(mw.getPower()));
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
		if(!(mw.getTime() > 0) && !(mw.getPower() > 0))
		{
			// Exception would be manage - Message written in English don't show to the users
			throw new IllegalStateException("You cant start cook with no time neither power");
		}
		
		if(mw.getTime() > 0 && mw.getPower() > 0)
		{
			mw.setState(new MW_Cooking(mw));
		}
		else
		{
			if(mw.getTime() > 0)
			{
				// Exception would be manage - Message written in English don't show to the users
				throw new IllegalStateException("You cant start cook with no time");
			}
			else
			{
				// Exception would be manage - Message written in English don't show to the users
				throw new IllegalStateException("You cant start cook with no power");
			}
		}
	}

	@Override
	public void cooking_stop(Microwave mw)
	{
		// Exception would be manage - Message written in English don't show to the users
		throw new IllegalStateException("Microwave was already stopped");
	}
	
	@Override
	public void tick(Microwave mw)
	{
		// Exception would be manage - Message written in English don't show to the users
		throw new IllegalStateException("Timer must not run when microwave not running");
	}

}