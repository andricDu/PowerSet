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
		
		assertEquals("Base Case of Empty Set", powerSet.getPowerSet());
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

}
  