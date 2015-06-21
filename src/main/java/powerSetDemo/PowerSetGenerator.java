/**
 * 
 */
package powerSetDemo;

import java.util.*;

/**
 * @author Dusan
 *
 */
public class PowerSetGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		List<String> stringList = Arrays.asList("x", "y", "z");
		PoweredHashSet<String> poweredSet = new PoweredHashSet<String>(stringList);
		
		System.out.println(poweredSet.getPowerSet().toString());
		
	}

}
