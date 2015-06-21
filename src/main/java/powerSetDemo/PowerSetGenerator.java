/**
 * 
 */
package powerSetDemo;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * @author Dusan
 *
 */
public class PowerSetGenerator {

	/**
	 * @param args Program Arguments, consisting of input file path, and output file path.
	 */
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Incorrect Number of Arguments");
			System.out.println("Arg0: Input file");
			System.out.println("Arg1: Output file");
			
		} else {
			try {
				String content = new String(Files.readAllBytes(Paths.get(args[0])));
				System.out.println(content);
				
				File file = new File(args[1]);
				FileOutputStream fop = new FileOutputStream(file);
				if (!file.exists()) {
					file.createNewFile();
				}
				
				fop.write(getPowerSetFromString(content).toString().getBytes());
				fop.flush();
				fop.close();
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
	}
	
	/**
	 * Takes a comma separated list of elements and computes the power set.
	 * @param args Input String. Assumes comma separated for different elements in set.
	 * @return Power set of input string. 
	 */
	public static PoweredHashSet<PoweredHashSet<String>> getPowerSetFromString(String input) {
		List<String> stringList = Arrays.asList(input.split(","));
		PoweredHashSet<String> set = new PoweredHashSet<String>(stringList);
		return set.getPowerSet();
	}

}
