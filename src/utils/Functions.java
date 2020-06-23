package utils;

import entities.Rating;
import exceptions.InvalidInformationException;
import tads.implementations.LinkedList;

public class Functions {

	public static float linkedListAverage(LinkedList<Rating> list) {

		long summation = 0;
		int n = 0;

		while (list.size() > 0) {

			try {

				summation += list.get(0).getRating();
				n++;

			} catch (InvalidInformationException e) {

				e.printStackTrace();

			}

		}

		return summation / n;

	}

}
