
package tests.pointcuts.methodcall;

/**
 * A simple aspect that declares a <code>method call</code> pointcut.
 *
 *@author     <a href="mailto:Sara.Bouchenak@inria.fr">Sara Bouchenak</a>
 *@version    1.0 - 13/01/2004
 */
public aspect MethodCall
{
	
	/**
	 * A pointcut for any method call.
	 * 
	 */
	protected static pointcut methodCall() : call (void *.*(..))&& !within(tests.pointcuts..*);
	protected static pointcut constructorCall() : call  (*.new()); 
	//protected static pointcut execCall() : execution (void *.*(..));
	
	/**
	 * Declare a warning for any method call.
	 * 
	 */
	declare warning : methodCall() : "'methodCall' pointcut";
	//declare warning : execCall() : "'execCall' pointcut";
	//declare error : execCall() : "error";
}