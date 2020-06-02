package tads.implementations;

import exceptions.InvalidInformationException;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

	@Test
	public void add() {

		LinkedList<Integer> list = new LinkedList<>();
		list.add(4);

		try {
			assertEquals((int) list.get(0), 4);
		} catch (InvalidInformationException e) {
			fail();
		}

	}

	@Test
	public void remove() {

		LinkedList<Integer> list = new LinkedList<>();

		try {
			list.remove(0);
			fail();
		} catch (InvalidInformationException e) {
			System.out.println("Empty list");
		}

		list.add(4);

		try {
			list.remove(0);
		} catch (InvalidInformationException e) {
			fail();
		}

		try {
			list.remove(0);
			fail();
		} catch (InvalidInformationException e) {
			System.out.println("Informacion invalida");
		}

	}

	@Test
	public void get() {

		LinkedList<Integer> list = new LinkedList<>();

		try {
			assertEquals((int) list.get(0), 4);
		} catch (InvalidInformationException e) {
			System.out.println("Informacion invalida");
		}

		list.add(4);

		try {
			assertEquals((int) list.get(0), 4);
		} catch (InvalidInformationException e) {
			fail();
		}

	}

}