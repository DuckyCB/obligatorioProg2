package utils;

import entities.Rating;
import entities.Tuple;
import exceptions.EmptyQueueException;
import tads.implementations.QueueLinkedList;

public class Functions {

	public static float linkedListAverage(QueueLinkedList<Rating> list) throws EmptyQueueException {

		long summation = 0;
		int n = list.size();

		for (int i = 0; i < n; i++) {

			Rating rating = list.dequeue();
			summation += rating.getRating();
			list.enqueue(rating);

		}

		return (float) summation / n;

	}

	public static void addToLangage(String lang, Tuple<Integer, String>[] languages) {

		switch (lang) {
			case "eng":
			case "en":
			case "en-CA":
			case "en-GB":
			case "en-US":
				languages[0].setKey(languages[0].getKey() + 1);
				break;
			case "ara":
				languages[1].setKey(languages[1].getKey() + 1);
				break;
			case "dan":
				languages[2].setKey(languages[2].getKey() + 1);
				break;
			case "fil":
				languages[3].setKey(languages[3].getKey() + 1);
				break;
			case "fre":
				languages[4].setKey(languages[4].getKey() + 1);
				break;
			case "ger":
				languages[5].setKey(languages[5].getKey() + 1);
				break;
			case "ind":
				languages[6].setKey(languages[6].getKey() + 1);
				break;
			case "ita":
				languages[7].setKey(languages[7].getKey() + 1);
				break;
			case "jpn":
				languages[8].setKey(languages[8].getKey() + 1);
				break;
			case "mul":
				languages[9].setKey(languages[9].getKey() + 1);
				break;
			case "nl":
				languages[10].setKey(languages[10].getKey() + 1);
				break;
			case "nor":
				languages[11].setKey(languages[11].getKey() + 1);
				break;
			case "per":
				languages[12].setKey(languages[12].getKey() + 1);
				break;
			case "pol":
				languages[13].setKey(languages[13].getKey() + 1);
				break;
			case "por":
				languages[14].setKey(languages[14].getKey() + 1);
				break;
			case "rum":
				languages[15].setKey(languages[15].getKey() + 1);
				break;
			case "rus":
				languages[16].setKey(languages[16].getKey() + 1);
				break;
			case "spa":
				languages[17].setKey(languages[17].getKey() + 1);
				break;
			case "swe":
				languages[18].setKey(languages[18].getKey() + 1);
				break;
			case "tur":
				languages[19].setKey(languages[19].getKey() + 1);
				break;
			case "vie":
				languages[20].setKey(languages[20].getKey() + 1);
				break;

		}

	}

	public static Tuple<Integer, String>[] createLangArray() {

		Tuple<Integer, String>[] langages = new Tuple[21];

		langages[0] = new Tuple<>(0, "eng");
		langages[1] = new Tuple<>(0, "ara");
		langages[2] = new Tuple<>(0, "dan");
		langages[3] = new Tuple<>(0, "fil");
		langages[4] = new Tuple<>(0, "fre");
		langages[5] = new Tuple<>(0, "ger");
		langages[6] = new Tuple<>(0, "ind");
		langages[7] = new Tuple<>(0, "ita");
		langages[8] = new Tuple<>(0, "jpn");
		langages[9] = new Tuple<>(0, "mul");
		langages[10] = new Tuple<>(0, "nl");
		langages[11] = new Tuple<>(0, "nor");
		langages[12] = new Tuple<>(0, "per");
		langages[13] = new Tuple<>(0, "pol");
		langages[14] = new Tuple<>(0, "por");
		langages[15] = new Tuple<>(0, "rum");
		langages[16] = new Tuple<>(0, "rus");
		langages[17] = new Tuple<>(0, "spa");
		langages[18] = new Tuple<>(0, "swe");
		langages[19] = new Tuple<>(0, "tur");
		langages[20] = new Tuple<>(0, "vie");

		return langages;

	}

}
