package powerSetDemo;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class PowerSetGeneratorTest {

	
	@Test
	public void EmptyNotNull() {
		String setString = "";
		
		PoweredHashSet<PoweredHashSet<String>> powerSet = PowerSetGenerator.getPowerSetFromString(setString);
		
		assertNotNull(powerSet);
	}
	
	@Test
	public void PowerSetFromStringBase() {
			String setString = "x,y,z";
			
			PoweredHashSet<PoweredHashSet<String>> powerSet = PowerSetGenerator.getPowerSetFromString(setString);
			
			Set<HashSet<String>> set =  new HashSet<HashSet<String>>();
			HashSet<String> s1 = new HashSet<String>(Arrays.asList("x"));
			HashSet<String> s2 = new HashSet<String>(Arrays.asList("y"));
			HashSet<String> s3 = new HashSet<String>(Arrays.asList("z"));
			HashSet<String> s12 = new HashSet<String>(Arrays.asList("x","y"));
			HashSet<String> s13 = new HashSet<String>(Arrays.asList("x","z"));
			HashSet<String> s23 = new HashSet<String>(Arrays.asList("y","z"));
			HashSet<String> s123 = new HashSet<String>(Arrays.asList("x","y","z"));
			
			set.add(new HashSet<String>());
			set.addAll(Arrays.asList(s1,s2,s3,s12,s13,s23,s123));
			
			assertEquals(set, powerSet);	
	}

}
