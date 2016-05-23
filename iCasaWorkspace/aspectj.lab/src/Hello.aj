
/**
 *  A simple Hello aspect.
 *
 *@author     <a href="mailto:Sara.Bouchenak@inria.fr">Sara Bouchenak</a>
 *@version    1.0 - 13/01/2004
 */
public aspect Hello
{
	//private pointcut execConst() : execution ( Communicator.(*));
	private pointcut printCall() : call (* Communicator.print(..));

	declare warning : printCall() : "'printCall' pointcut";

	before() : printCall()
	{
		System.out.print("Hello! ");
	}

	after() : printCall()
	{
		System.out.print("Hello again! ");
	}


}