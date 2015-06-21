package powerSetDemo;

import java.util.Collection;
import java.util.HashSet;

public class PoweredHashSet<E> extends HashSet<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public PoweredHashSet() {
	}

	public PoweredHashSet(Collection<E> arg0) {
		super(arg0);
	}

	public PoweredHashSet(int arg0) {
		super(arg0);
	}

	public PoweredHashSet(int arg0, float arg1) {
		super(arg0, arg1);
	}
	
	/**
	 * @return Returns the Power Set as a PoweredHashSet of PoweredHashSets
	 */
	public PoweredHashSet<PoweredHashSet<E>> getPowerSet() {
		PoweredHashSet<PoweredHashSet<E>> powerSet = new PoweredHashSet<PoweredHashSet<E>>();
	
		powerSet.add(new PoweredHashSet<E>()); //add the base case of empty set
		
		/*
		 * For every element in this set, iterate through every subset in the
		 * current power set and subset and the union of the subset and element
		 * to a new power set. This new power set becomes the current power set.
		 */
		for (E ele : this) {
			PoweredHashSet<PoweredHashSet<E>> newPowerSet = new PoweredHashSet<PoweredHashSet<E>>();
			
			for (PoweredHashSet<E> sub : powerSet) {
				newPowerSet.add(sub);
				
				PoweredHashSet<E> newSub = new PoweredHashSet<E>(sub);
				newSub.add(ele);  //Subset UNION current element
				newPowerSet.add(newSub);
			}
			
			powerSet = newPowerSet;
		}
		
		return powerSet;
	}

}
