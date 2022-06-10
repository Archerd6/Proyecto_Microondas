package microwave;

/**This class represent a microwave that is cooking (so have a item, ligth on, rotating ...)
 * @author David RA
 * @version 1.2
 * */
public class MW_Cooking implements Microwave_Interface
{	
	/**The constructor must verify that the lamp, heating, turnable, Cooking are on
	 * Must have a item inside and the door closed
	 *  */
	public MW_Cooking(Microwave mw)
	{
		mw.setCooking(true); // Check cooking
		mw.setOpen(false);  // Check door
		mw.setItem(true); // Check item
		
		mw.getHeatComponent().setPower(mw.getPower()); // Set power value saved in the microwave variable
		
		mw.getLampComponent().lamp_on(); // Check lamp
		mw.getHeatComponent().heating_on(); // Check heat
		mw.getTurntComponent().turntable_start(); // Check rotation
	}
	
	@Override
	public void door_opened(Microwave mw)
	{
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
	public void power_inc(Microwave m)
	{
		m.setPower(m.getPower() + 10);  // Increment on 10w the power as said in interface
		m.getDisplayComponent().setDisplay(Integer.toString(m.getPower()));
	}

	@Override
	public void power_dec(Microwave mw)
	{
		if (mw.getPower() > 0)
		{
			mw.setPower(mw.getPower() - 10);  // Decrement on 10w the power as said in interface
			mw.getDisplayComponent().setDisplay(Integer.toString(mw.getPower()));
		}
		if(mw.getPower() == 0)
		{
			cooking_stop(mw);
		}
	}
	
	@Override
	public void power_reset(Microwave mw)
	{
		mw.setState(new MW_ClosedWithItem(mw));
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
		if (mw.getTime() == 0)
		{
			mw.getBeepComponent().beep(3);
			mw.getDisplayComponent().setDisplay("Item ready");
			cooking_stop(mw);
		}
	}

	@Override
	public void timer_reset(Microwave mw)
	{
		mw.setState(new MW_ClosedWithItem(mw));
		mw.setTime(0);
	}
	
	
	@Override
	public void cooking_start(Microwave mw)
	{
		// Exception would be manage - Message written in English don't show to the users
		throw new IllegalStateException("You cant start cooking if the microwave was already cooking ...");
	}

	@Override
	public void cooking_stop(Microwave mw)
	{
		mw.setState(new MW_ClosedWithItem(mw));
	}
	
	@Override
	public void tick(Microwave mw)
	{
		if (mw.getTime() > 1)
		{
			mw.timer_dec();
			try
			{
				Thread.sleep(1); // TODO Implement real tick in the GUI
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			mw.timer_dec();
			mw.getBeepComponent().beep(3);
			mw.getDisplayComponent().setDisplay("Item ready");
			cooking_stop(mw);
		}
	}
}