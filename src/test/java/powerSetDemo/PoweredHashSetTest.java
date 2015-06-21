package powerSetDemo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.*;

public class PoweredHashSetTest {

	@Test
	public void sanityCheck() {
		List<String> stringList = Arrays.asList("foo", "bar", "hello", "world");
	
		Set<String> set = new HashSet<String>(stringList);
		PoweredHashSet<String> powerSet = new PoweredHashSet<String>(stringList);
		
		assertEquals(set, powerSet);
	}
	
	@Test
	public void powerSetCheckZero() {
		PoweredHashSet<Integer> powerSet = new PoweredHashSet<Integer>();
	
		Set<HashSet<Integer>> set =  new HashSet<HashSet<Integer>>();
		set.add(new HashSet<Integer>());

		System.out.println(set.toString());
		System.out.println(powerSet.getPowerSet().toString());
		
		assertEquals("Base Case of Empty Set", set, powerSet.getPowerSet());
	}
	
	@Test
	public void powerSetCheckOne() {
		List<Integer> intList = Arrays.asList(1);
		PoweredHashSet<Integer> powerSet = new PoweredHashSet<Integer>(intList);
	
		Set<HashSet<Integer>> set =  new HashSet<HashSet<Integer>>();
		HashSet<Integer> s1 = new HashSet<Integer>(Arrays.asList(1));
		
		set.add(new HashSet<Integer>());
		set.add(s1);
		
		System.out.println(set.toString());
		System.out.println(powerSet.getPowerSet().toString());
		
		assertEquals("Base Case of Set of size 1", set, powerSet.getPowerSet());
	}
	
	@Test
	public void powerSetCheckThree() {
		List<Integer> intList = Arrays.asList(1,2,3);
		PoweredHashSet<Integer> powerSet = new PoweredHashSet<Integer>(intList);
	
		Set<HashSet<Integer>> set =  new HashSet<HashSet<Integer>>();
		HashSet<Integer> s1 = new HashSet<Integer>(Arrays.asList(1));
		HashSet<Integer> s2 = new HashSet<Integer>(Arrays.asList(2));
		HashSet<Integer> s3 = new HashSet<Integer>(Arrays.asList(3));
		HashSet<Integer> s12 = new HashSet<Integer>(Arrays.asList(1,2));
		HashSet<Integer> s13 = new HashSet<Integer>(Arrays.asList(1,3));
		HashSet<Integer> s23 = new HashSet<Integer>(Arrays.asList(2,3));
		HashSet<Integer> s123 = new HashSet<Integer>(Arrays.asList(1,2,3));
		
		set.add(new HashSet<Integer>());
		set.addAll(Arrays.asList(s1,s2,s3,s12,s13,s23,s123));
		
		System.out.println(set.toString());
		System.out.println(powerSet.getPowerSet().toString());
		
		assertEquals("Base Case of Set of size 1", set, powerSet.getPowerSet());
	}
	
	@Test
	public void powerSetCheckThreeString() {
		List<String> stringList = Arrays.asList("x","y","z");
		PoweredHashSet<String> powerSet = new PoweredHashSet<String>(stringList);
	
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
		
		System.out.println(set.toString());
		System.out.println(powerSet.getPowerSet().toString());
		
		assertEquals("Base Case of Set of size 1", set, powerSet.getPowerSet());
	}

}
  