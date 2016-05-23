
/**
 * A Communicator class.
 *
 * @author <a href="mailto:Sara.Bouchenak@inria.fr">Sara Bouchenak</a>
 * @version 1.0 - 13/01/2004
 */
public class Communicator {

	private int num;

	/**
	 * Prints a message.
	 *
	 * @param message
	 *            The message to print
	 */
	public static void print(String message) {
		System.out.println(message);
	}

	/**
	 * Prints a message to a given person.
	 *
	 * @param person
	 *            A person
	 * @param message
	 *            The message to print
	 */
	public static void print(String person, String message) {
		System.out.println(person + ", " + message);
	}

	public Communicator() {
		this.num = 1;
		System.out.println(num);
	}
}
