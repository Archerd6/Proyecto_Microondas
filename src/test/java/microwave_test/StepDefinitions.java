package microwave_test;

import org.junit.jupiter.api.Assertions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import microwave.Calculadora_Archerd6;

public class StepDefinitions
{
    private Calculadora_Archerd6 calculadora;
    private double Resultado;
    private Boolean Resultado_booleano;
    
    @Given("I have a Calculator")
    public void i_have_a_calculator()
    {
    	// Write code here that turns the phrase above into concrete actions
    	calculadora = new Calculadora_Archerd6();
    }
    
    @When("I sum {int} and {int}")
    public void i_sum_and(double int1, double int2)
    {
    	Resultado = calculadora.suma(int1, int2);
    }
	@When("I substract {int} value {int}")
	public void i_substract_value(double int1, double int2)
	{
		Resultado = calculadora.resta(int1, int2);
	}
	@When("I multiply {int} value {int}")
	public void i_multiply_value(double int1, double int2)
	{
		Resultado = calculadora.mult(int1, int2);
	}
	@When("I divide {int} value {int}")
	public void i_divide_value(Integer int1, Integer int2)
	{
		Resultado = calculadora.divide(int1, int2);
	}
	@When("I select the factorial of {int}")
	public void i_select_the_factorial_of(Integer int1)
	{
		Resultado = calculadora.fact(int1);
	}
	
    @Then("the result is {double}")
    public void the_result_is(double Entrante)
    {
    	// Write code here that turns the phrase above into concrete actions
    	Assertions.assertEquals(Entrante, Resultado);
    }
    
    
    @When("I ask if {int} is prime")
    public void i_ask_if_is_prime(Integer int1)
    {
    	Resultado_booleano = calculadora.esPrimo(int1);
    }
    
    @Then("the result boolean as int is {int}")
    public void the_result_boolean_as_int_is(Integer int1)
    {
    	Assertions.assertEquals(int1, Resultado_booleano?1:0);
    }
    



}
