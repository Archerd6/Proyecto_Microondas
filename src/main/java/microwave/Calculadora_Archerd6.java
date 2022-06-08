package microwave;

/**
 * Esta clase implementa las operaciones del interfaz ICalculadora
 * del primer ejercicio del curso. 
 * En esta version la mayoria de las operaciones no estan implementadas
 * 
 * @author  David Ram�rez Arco
 * @version 0.2
 *
 */

public class Calculadora_Archerd6 implements ICalculadora
{
	/**
	 * CONSTRUCTOR. Inicialmente no hace nada porque la calculadora no tiene estado ni necesita guardar nada en memoria.
	 */
	public Calculadora_Archerd6()
	{
		
	}

	/** 
	 * El metodo suma calcula la suma de dos numeros reales, que son pasados como parametros. 
	 * @param a :double -- el sumando 1
	 * @param b :double -- el sumando 2
	 * @return  :double -- el resultado de la suma
	 */
	public double suma(double a, double b)
	{
		double op; //variable respuesta
		op = a + b; //operacion
		return op;
	}

	/** 
	 * El metodo resta calcula la diferencia de dos numeros reales, que son pasados como parametros. 
	 * @param a :double -- el numero del cual hay que detraer el parametro b
	 * @param b :double -- el numero a restar al parametro a
	 * @return  :double -- el resultado de la resta
	 */
	public double resta(double a, double b)
	{
		double op; //variable respuesta
		op = a - b; //operacion
		return op;
	}

	/** 
	 * El metodo mult calcula el producto de dos numeros reales, que son pasados como parametros. 
	 * @param a :double -- el primer numero
	 * @param b :double -- el segundo numero
	 * @return  :double -- el resultado del producto
	 */
	public double mult(double a, double b)
	{
		double op; //variable respuesta
		op = a * b; //operacion
		return op;
	}

	/** 
	 * El metodo divide calcula la division de dos numeros reales, que son pasados como parametros. 
	 * @param a :double -- el dividendo
	 * @param b :double -- el divisor
	 * @return  :double -- el resultado de la division
	 * @throws ArithmeticException (if b==0) 	//precondition
	 * @throws ArithmeticException (if (result*b!=a)) 	//postcondicion (large numbers or lack of precision)
	 */
	public double divide(double a, double b)
	{
		if(b == 0)
			throw new ArithmeticException();
		
		double op;  //variable respuesta
		op = a / b; //operacion
		
		if(op*b!=a)
			throw new ArithmeticException(); // Falta de precision
		
		return op;
	}
	/** 
	 * El metodo fact calcula el factorial de un numero entero. 
	 * @param n :int -- numero del cual se quiere calcular el factorial
	 * @return  :int -- el factorial de n (n!)
	 * @throws IllegalArgumentException (if n<0) //precondition
	 * @throws IllegalArgumentException (if n>=14) //precondition
	 */
	public int fact(int n)
	{
		if (n<0)
			throw new IllegalArgumentException();
		if (n>=14)
			throw new IllegalArgumentException();
		
		if (n==0)
			return 1;
		else
			// El factorial se puede resolver por recursion
			return n*fact(n-1); 
	}

	/** 
	 * El metodo esPrimo determina si un numero es primo o no. 
	 * @param n :int -- el numero que se desea saber si es primo o no
	 * @return  :boolean -- true si el numero es primo, false en otro caso.
	 */
	public boolean esPrimo(int n)
	{
		// No numeros negativos
		if (n<0)
			return false;
		
		// El 0, 1y 4 no son primos
		if (n == 0 || n == 1 || n == 4)
			return false;
		// Si es divisible por algun numero entre 2 y la mitad de n no puede ser un numero primo
		for (int i = 2; i<(n/2); i++)
		{
			if (n % i == 0) // El resto es 0 == es divisible  
				return false;
		}
		// Si no se pudo dividir por ninguno de los de arriba, si es primo
		return true;
	}
}