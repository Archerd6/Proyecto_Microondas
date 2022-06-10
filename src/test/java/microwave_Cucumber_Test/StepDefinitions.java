package microwave_Cucumber_Test;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.*;

import microwave.*;

/**Steps definition stores the mapping between each step of the scenario defined in the feature file with a code of function to be executed*/
public class StepDefinitions
{
	/**Our microwave instance that we are gona use for test*/
	private Microwave mw = new Microwave();
	
	// GIVEN
	
	@Given("Testing first State")
	public void first_State()
	{
		mw.setState(new MW_ClosedWithNoItem(mw));
	}

	@Given("Testing second State")
	public void second_State()
	{
		mw.setState(new MW_OpenWithNoItem(mw));
	}

	@Given("Testing third State")
	public void third_State()
	{
		mw.setState(new MW_OpenWithItem(mw));
	}

	@Given("Testing fourth State")
	public void fourth_State()
	{
		mw.setState(new MW_ClosedWithItem(mw));
	}

	@Given("A running microwave with {int} power and {int} timer")
	public void cooking(Integer power, Integer time)
	{
		mw.setState(new MW_ClosedWithItem(mw));
		mw.setTime(time);
		set_Power(power/10);
		mw.cooking_start();
	}

	// WHEN

	@When("Set power to {int}")
	public void set_Power(Integer new_power)
	{
		mw.power_reset();
		increase_Power(new_power);
	}
	
	@When("Increase the power {int} times")
	public void increase_Power(Integer simulated_times)
	{
		for (int i = 0; i < simulated_times; i++)
		{
			mw.power_inc();
		}
	}
	
	@When("We settle timer at {int} s")
	public void setTimer(Integer times)
	{
		mw.setTime(times);
		mw.timer_inc();
		mw.timer_dec();
	}

	@When("Press start cooking")
	public void try_to_cook()
	{
		try
		{
			mw.cooking_start();
		}
		catch (IllegalStateException e)
		{
			assertEquals(false, true);
		}
	}

	// THEN
	
	@Then("Heating heats")
	public void magnetronWorking()
	{
		assertEquals(mw.getHeatComponent().isHeating(), true);
	}

	@Then("Lamp turns on")
	public void lampIsOn()
	{
		assertEquals(mw.getLampComponent().isLampOn(), true);
	}
	
	@Then("Turntable turns")
	public void turntableIsTurnning()
	{
		assertEquals(mw.getTurntComponent().isMoving(), true);
	}
	
	@Then("Screen value is {string}")
	public void screenShows(String i)
	{
		assertEquals(mw.getDisplayComponent().getDisplay(), i);
	}
	
	@Then("We are in the fifth State")
	public void microwaveCooking()
	{
		assertEquals(mw.getState().getClass(), MW_Cooking.class);
	}
}