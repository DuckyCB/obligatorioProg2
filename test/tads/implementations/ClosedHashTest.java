package tads.implementations;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ClosedHashTest {

	@Test
	public void iterator() {

		ClosedHash<Integer, Integer> myHash = new ClosedHash<>(50);
		myHash.put(5,5);
		myHash.put(7,9);
		myHash.put(10,89);
		int[] array = {5,9,89};
		Iterator<Integer> hashIterator = myHash.iterator();
		int i = 0;
		while(hashIterator.hasNext()) {
			assertEquals(array[i], (int) hashIterator.next());
			i++;
		}

	}
}