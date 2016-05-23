
package tests.pointcuts.methodcall;

/**
 * A simple aspect that tests the <code>after</code> advice 
 * type for a <code>method call</code> pointcut.
 *
 *@author     <a href="mailto:Sara.Bouchenak@inria.fr">Sara Bouchenak</a>
 *@version    1.0 - 13/01/2004
 */
public aspect AfterMethodCall
{
	after() : MethodCall.methodCall()
	{
		System.out.println("<--- After: " + thisJoinPoint);
	}
	
}