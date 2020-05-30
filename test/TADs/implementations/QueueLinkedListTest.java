package TADs.implementations;

import exceptions.EmptyQueueException;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueLinkedListTest {

	@Test
	public void enqueue() {

		QueueLinkedList<Integer> list = new QueueLinkedList<>();
		list.enqueue(4);
		try {
			assertEquals((int) list.dequeue(), 4);
		} catch (EmptyQueueException e) {
			fail();
		}

	}

	@Test
	public void dequeue() {

		QueueLinkedList<Integer> list = new QueueLinkedList<>();
		try {
			Integer element = list.dequeue();
			fail();
		} catch (EmptyQueueException e) {
			System.out.println("Empty queue");
		}
		list.enqueue(4);
		try {
			list.dequeue();
		} catch (EmptyQueueException e) {
			System.out.println("Empty queue");
		} finally {
			System.out.println("nice");
		}

	}

	@Test
	public void isEmpty() {

		QueueLinkedList<Integer> list = new QueueLinkedList<>();
		assertTrue(list.isEmpty());
		list.enqueue(4);
		assertFalse(list.isEmpty());

	}
}