package microwave_Junit_Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import microwave.*;

public class MicrowaveTest
{
	private Microwave mw = new Microwave();
	
	//COMPONENTS TESTS
	
	// Heating component test
	@Test
	public void MagnetronTest()
	{
		Heating h = new Heating();
		
		// Base
		assertEquals(0, h.getPower());
		assertEquals(false,h.isHeating());
		
		// On - Off
		h.heating_on();
		assertEquals(true,h.isHeating());
		h.heating_off();
		assertEquals(false,h.isHeating());
		
		// Increase Power
		h.setPower(888);
		assertEquals(h.getPower(), 888);
		h.setPower(0);
		assertEquals(h.getPower(), 0);
		
	}
	
	// Lamp component test
	@Test
	public void lumixTest()
	{
		Lamp l = new Lamp();
		
		// Base
		assertFalse(l.isLampOn());

		// On - Off
		assertFalse(l.isLampOn());
		l.lamp_on();
		assertTrue(l.isLampOn());
		l.lamp_off();
		assertFalse(l.isLampOn());
	}
	
	// Turntable component test
	@Test
	public void rotationTest()
	{
		Turntable t = new Turntable();
		
		// Base
		assertFalse(t.isMoving());
		
		// Start - Stop
		t.turntable_start();
		assertTrue(t.isMoving());
		t.turntable_stop();
		assertFalse(t.isMoving());
	}
	
	// Beeper component test
	@Test
	public void beeperTest()
	{
		Beeper b = new Beeper();
		
		// Beep
		b.beep(5);
		assertTrue(BeeperCounter.isBeeped(5));

		// No Beep
		assertTrue(BeeperCounter.isBeeped(0));
	}

	// Display component test
	@Test
	public void displayTest()
	{
		Display d = new Display();

		// Base
		assertNull(d.getDisplay());

		// Set - Clear
		d.setDisplay("Test");
		assertEquals("Test", d.getDisplay());
		d.clearDisplay();
		assertNull(d.getDisplay());
	}
	
	/** Metod to simulate the increase of the microwave power
	 * @param time - Amount of time to increase (Works fine with mult of 10)
	 * */
	private void increment_power(int p)
	{
		for (int i = 0; i < p; i = i + 10) // The increment is 10 by 10
		{
			mw.power_inc();
		}
	}
	
	/** Metod to simulate the decrease of the microwave power
	 *  @param time - Amount of time to decrease (Works fine with mult of 10)
	 * */
	private void decrease_power(int p)
	{
		for (int i = p; i > 0; i = i - 10) // The decrement is 10 by 10
		{
			mw.power_dec();
		}
	}
	
	/** Metod to simulate the action of increment the time remaining
	 * @param time - Amount of time to increase
	 * */
	private void timer_inc(int time)
	{
		for (int i = 0; i < time; i++)
		{
			mw.timer_inc();
		}
	}
	
	/** Metod to simulate the action of decrease the time remaining
	 * @param time - Amount of time to decrease
	 * */
	private void timer_dec(int time)
	{
		for (int i = 0; i < time; i++)
		{
			mw.timer_dec();
		}
	}
	
	/** Metod to simulate the action of time
	 * @param time - Amount of time passed
	 * */
	private void timer_works(int time)
	{
		for (int i = 0; i < time; i++)
		{
			mw.tick();
		}
	}
	
	// MICROWAVE TESTS
	
	// Test for power
	@Test
	public void testPower()
	{
		// Start
		mw.power_reset();
		assertEquals(0, mw.getPower());
		
		// Increase - Decrease
		increment_power(80);
		assertEquals(mw.getPower(), 80);
		assertEquals(mw.getDisplayComponent().getDisplay(),"80");
		decrease_power(100);
		assertEquals(mw.getPower(), 0);
		
		// End
		mw.power_reset();
		assertEquals(mw.getPower(), 0);
		assertEquals(mw.getDisplayComponent().getDisplay(), "0");		
	}
	
	// Test for timer
	@Test
	public void testTimer()
	{
		// Start
		mw.timer_reset();
		assertEquals(0, mw.getTime());
		
		// Increase - Decrease
		timer_inc(80);
		assertEquals(80, mw.getTime());
		assertEquals("80", mw.getDisplayComponent().getDisplay());
		timer_dec(35);
		assertEquals(45, mw.getTime());
		assertEquals("45", mw.getDisplayComponent().getDisplay());
		
		// End
		mw.timer_reset();
		assertEquals(mw.getTime(), 0);
		assertEquals(mw.getDisplayComponent().getDisplay(), "0");
	}

	// State 1: ClosedWithNoItem
	@Test
	public void closedWithNoItemTest()
	{
		mw.setState(new MW_ClosedWithNoItem(mw));
		// Exceptions check
		assertThrows(IllegalStateException.class, () -> mw.item_placed());
		assertThrows(IllegalStateException.class, () -> mw.item_removed());
		assertThrows(IllegalStateException.class, () -> mw.door_closed());
		assertThrows(IllegalStateException.class, () -> mw.cooking_start());
		assertThrows(IllegalStateException.class, () -> mw.cooking_stop());


		// Status check
		assertEquals(false,mw.isCooking());
		assertEquals(false,mw.isItem());
		assertEquals(false,mw.isOpen());
		assertEquals(false,mw.getHeatComponent().isHeating());
		assertEquals(false,mw.getLampComponent().isLampOn());
		assertEquals(false,mw.getTurntComponent().isMoving());
		assertEquals(true,mw.getState() instanceof MW_ClosedWithNoItem);
	}

	// State 2: OpenWithNoItem
	@Test
	public void openWithNoItemTest()
	{
		mw.setState(new MW_OpenWithNoItem(mw));
		
		// Exceptions check
		assertThrows(IllegalStateException.class, () -> mw.item_removed());
		assertThrows(IllegalStateException.class, () -> mw.cooking_start());
		assertThrows(IllegalStateException.class, () -> mw.door_opened());
		assertThrows(IllegalStateException.class, () -> mw.cooking_stop());

		
		// Status check
		assertEquals(false,mw.isCooking());
		assertEquals(false,mw.isItem());
		assertEquals(true,mw.isOpen());
		assertEquals(false,mw.getHeatComponent().isHeating());
		assertEquals(true,mw.getLampComponent().isLampOn());
		assertEquals(false,mw.getTurntComponent().isMoving());
		assertEquals(true,mw.getState() instanceof MW_OpenWithNoItem);
	}

	// Phase 3: Test for an OpenWithItem situation
	@Test
	public void openWithItemTest()
	{
		mw.setState(new MW_OpenWithItem(mw));
		
		// Exceptions check
		assertThrows(IllegalStateException.class, () -> mw.item_placed());
		assertThrows(IllegalStateException.class, () -> mw.cooking_start());
		assertThrows(IllegalStateException.class, () -> mw.door_opened());
		assertThrows(IllegalStateException.class, () -> mw.cooking_stop());

		
		// Status check
		assertEquals(false,mw.isCooking());
		assertEquals(true,mw.isItem());
		assertEquals(true,mw.isOpen());
		assertEquals(false,mw.getHeatComponent().isHeating());
		assertEquals(true,mw.getLampComponent().isLampOn());
		assertEquals(false,mw.getTurntComponent().isMoving());
		assertEquals(true,mw.getState() instanceof MW_OpenWithItem);
		
		// Removing item
		mw.item_removed();
		assertEquals(mw.getState().getClass(),MW_OpenWithNoItem.class);

	}

	// Phase 4: Test for a ClosedWithItem situation
	@Test
	public void closedWithItemTest()
	{
		mw.setState(new MW_ClosedWithItem(mw));
		
		// Exceptions check
		assertThrows(IllegalStateException.class, () -> mw.item_placed());
		assertThrows(IllegalStateException.class, () -> mw.item_removed());
		assertThrows(IllegalStateException.class, () -> mw.door_closed());
		assertThrows(IllegalStateException.class, () -> mw.cooking_stop());

		
		// Status check
		assertEquals(false,mw.isCooking());
		assertEquals(true,mw.isItem());
		assertEquals(false,mw.isOpen());
		assertEquals(false,mw.getHeatComponent().isHeating());
		assertEquals(false,mw.getLampComponent().isLampOn());
		assertEquals(false,mw.getTurntComponent().isMoving());
		assertEquals(true,mw.getState() instanceof MW_ClosedWithItem);
		
		// Opening door
		mw.door_opened();
		assertEquals(mw.getState().getClass(),MW_OpenWithItem.class);
	}
	
	// Phase 5: Test for a Cooking situation
	@Test
	public void cookingTest()
	{
		mw.setState(new MW_Cooking(mw));
		
		// Cooking with wrong inputs
		
		// time == 0  &  power == 0 
		mw.timer_reset();
		assertThrows(IllegalStateException.class, () -> mw.cooking_start());
		
		// time == 60  &  power == 0 
		timer_inc(60);
		assertThrows(IllegalStateException.class, () -> mw.cooking_start());
		
		// time == 0  &  power == 800
		mw.timer_reset();
		increment_power(800);
		assertThrows(IllegalStateException.class, () -> mw.cooking_start());
		
		// Start cooking
		timer_inc(25);
		increment_power(100);
		mw.cooking_start();
		
		// Exceptions check
		assertThrows(IllegalStateException.class, () -> mw.cooking_start());
		assertThrows(IllegalStateException.class, () -> mw.door_closed());
		
		assertThrows(IllegalStateException.class, () -> mw.item_placed());
		assertThrows(IllegalStateException.class, () -> mw.item_removed());
		
		// Status check
		assertEquals(mw.isCooking(),true);
		assertEquals(mw.isItem(),true);
		assertEquals(mw.isOpen(),false);
		assertEquals(mw.getHeatComponent().isHeating(),true);
		assertEquals(mw.getLampComponent().isLampOn(),true);
		assertEquals(mw.getTurntComponent().isMoving(),true);
		assertEquals(mw.getState() instanceof MW_Cooking,true);
		
		// Open door
		mw.door_opened();
		assertTrue(mw.getState() instanceof MW_OpenWithItem);
		assertFalse(BeeperCounter.isBeeped(3));
		
		mw.door_closed();
		mw.cooking_start();
		
		assertEquals(25, mw.getTime());
		assertEquals(mw.getState().getClass(),MW_Cooking.class);
		
		// Time ends
		timer_works(25);
		assertEquals("Item ready", mw.getDisplayComponent().getDisplay());
		assertTrue(BeeperCounter.isBeeped(3));
	}
}