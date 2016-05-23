
package tests.pointcuts.methodcall;

/**
 * A simple aspect that tests the <code>around</code> advice 
 * type for a <code>method call</code> pointcut.
 *
 *@author     <a href="mailto:Sara.Bouchenak@inria.fr">Sara Bouchenak</a>
 *@version    1.0 - 13/01/2004
 */
public aspect AroundMethodCall
{
	void around() : MethodCall.methodCall()
	{
		System.out.println("---> Around: " + thisJoinPoint);
		proceed();
		System.out.println("<--- Around: " + thisJoinPoint);
	}
	
}