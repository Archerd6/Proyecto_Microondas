package microwave;

/**
 * Este interfaz proporciona las operaciones que tiene que implementar 
 * la calculadora del primer ejercicio del curso.
 * 
 * @author  Antonio Vallecillo
 * @version 1.1
 *
 */
public interface ICalculadora {
	/** 
	 * El metodo suma calcula la suma de dos numeros reales, que son pasados como parametros. 
	 * @param a :double -- el sumando 1
	 * @param b :double -- el sumando 2
	 * @return  :double -- el resultado de la suma
	 */
	public double suma(double a,double b);

	/** 
	 * El metodo resta calcula la diferencia de dos numeros reales, que son pasados como parametros. 
	 * @param a :double -- el numero del cual hay que detraer el parametro b
	 * @param b :double -- el numero a restar al parametro a
	 * @return  :double -- el resultado de la resta
	 */
	public double resta(double a,double b);

	/** 
	 * El metodo mult calcula el producto de dos numeros reales, que son pasados como parametros. 
	 * @param a :double -- el primer numero
	 * @param b :double -- el segundo numero
	 * @return  :double -- el resultado del producto
	 */
	public double mult(double a,double b);

	/** 
	 * El metodo divide calcula la division de dos numeros reales, que son pasados como parametros. 
	 * @param a :double -- el dividendo
	 * @param b :double -- el divisor
	 * @return  :double -- el resultado de la division
	 * @throws ArithmeticException (if b==0) 	//precondition
	 * @post result*b == a						//postcondicion
	 */
	public double divide(double a,double b);

	/** 
	 * El metodo fact calcula el factorial de un numero entero. 
	 * @param n :int -- numero del cual se quiere calcular el factorial
	 * @return  :int -- el factorial de n (n!)
	 */
	public int fact(int n);

	/** 
	 * El metodo esPrimo determina si un numero es primo o no. 
	 * @param n :int -- el numero que se desea saber si es primo o no
	 * @return  :boolean -- true si el numero es primo, false en otro caso.
	 */
	public boolean esPrimo(int n);
	
	

}
