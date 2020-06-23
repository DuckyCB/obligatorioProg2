package utils;

import entities.Rating;
import exceptions.InvalidInformationException;
import tads.implementations.LinkedList;

public class Functions {

	public static float linkedListAverage(LinkedList<Rating> list) {

		long summation = 0;
		int n = 0;

		try {

			while (list.size() > 0) {

				summation += list.get(0).getRating();
				n++;

			}

			return summation / n;

		} catch (InvalidInformationException e) {

			e.printStackTrace();

		}

		return summation / n;

	}

	public static

}
