
package tests.pointcuts.methodcall;

/**
 * A simple aspect that tests the <code>before</code> advice 
 * type for a <code>method call</code> pointcut.
 *
 *@author     <a href="mailto:Sara.Bouchenak@inria.fr">Sara Bouchenak</a>
 *@version    1.0 - 13/01/2004
 */
public aspect BeforeMethodCall
{
	before() : MethodCall.methodCall()
	{
		System.out.println("---> Before: " + thisJoinPoint);
	}
	
	
	before() : MethodCall.constructorCall() {
		
		System.out.println("----------> Before: " + thisJoinPoint);
	}
}