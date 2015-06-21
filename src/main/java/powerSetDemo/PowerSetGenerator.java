/**
 * 
 */
package powerSetDemo;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author Dusan
 *
 */
public class PowerSetGenerator {

	/**
	 * @param args Program Arguments, consisting of input file path, and output file path.
	 */
	public static void main(String[] args) {
		
		if (args.length != 3) { //check argument length
			System.out.println("Incorrect Number of Arguments");
			System.out.println("Arg0: Mode (ser=serialized, csv=csv text file, nl=newline textfile)");
			System.out.println("Arg1: Input file");
			System.out.println("Arg2: Output file");
			
		} else { //if 3 arguments, we are good
			try {
				
				if (args[0].equalsIgnoreCase("csv")) {
					//csv mode
					textFileHelper(args[1],args[2]);
				} else if (args[0].equalsIgnoreCase("nl")) {
					//newline mode
					newlineHelper(args[1],args[2]);
				} else if (args[0].equalsIgnoreCase("ser")) {
					//serialized mode
					serializedHelper(args[1],args[2]);
				} else {
					System.out.println("Uknown Mode. (s=serialized, t=text)");
				}
				
			} catch (IOException e) {
				System.err.println("IO Exception, make sure files and paths are correct.");
				System.err.println(e.getMessage());
			} catch (ClassNotFoundException e) {
				System.err.println("Something went wrong getting Hashset from file.");
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
	
	
	/**
	 * Generates power set from a CSV Text file.
	 * @param inputFile Filepath to input file
	 * @param outputFile Filepath to output file
	 * @throws IOException
	 */
	private static void textFileHelper(String inputFile, String outputFile) throws IOException {
		//get content from first file
		String content = new String(Files.readAllBytes(Paths.get(inputFile)));	
		
		//write power set to second file
		Files.write(Paths.get(outputFile), getPowerSetFromString(content).toString().getBytes());
	}
	
	/**
	 * Generates power set from a Serialized Java object stored in a file.
	 * Stores power set to file as a serialized object.
	 * @param inputFile Filepath to input file
	 * @param outputFile Filepath to output file
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("rawtypes") //no idea what this could be holding in terms of typing
	private static void serializedHelper(String inputFile, String outputFile) throws IOException, ClassNotFoundException {
		// read serialized object
		FileInputStream fis = new FileInputStream(inputFile);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Set result = (HashSet) ois.readObject();
		ois.close();
		
		//generate the power set
		@SuppressWarnings({ "unchecked" }) //again, could be of any typing
		PoweredHashSet poweredSet = new PoweredHashSet(result);
		Set powerSet = poweredSet.getPowerSet();
		
		// write serialized power set
		FileOutputStream fos = new FileOutputStream(outputFile);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(powerSet);
		oos.close();
	}
	
	/**
	 * Generates power set from a text file where each element of the set is
	 * on its own line.
	 * @param inputFile Filepath to input file
	 * @param outputFile Filepath to output file
	 * @throws IOException
	 */
	private static void newlineHelper(String inputFile, String outputFile) throws IOException {
		PoweredHashSet<String> set = new PoweredHashSet<String>();
		StringBuilder outputString = new StringBuilder(); //builder because needed in a loop
		
		//each line in the file is an element of a set
		try(Stream<String> lines = Files.lines(Paths.get(inputFile))){
			  lines.forEach(set::add);
		}
		
		//get the Power Set
		PoweredHashSet<PoweredHashSet<String>> powerSet = set.getPowerSet();
		
		//generate the new output string
		for (PoweredHashSet<String> subset: powerSet) {
			//
			outputString.append(subset.toString()+'\n');
		}
		//delete the last newline as it will add an extra element of empty
		outputString.deleteCharAt(outputString.length()-1);
		
		//out the data goes to the output file
		Files.write(Paths.get(outputFile), outputString.toString().getBytes());
		
	}

}
