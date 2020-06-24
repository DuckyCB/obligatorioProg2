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

	public static void addToLangage(String lang, Tuple<Integer, String>[] languages, int number) {

		System.out.println(lang);
		switch (lang) {
			case "eng":
			case "en":
			case "en-CA":
			case "en-GB":
			case "en-US":
				languages[0].setKey(languages[0].getKey() + number);
				System.out.println("entro");
				break;
			case "ara":
				languages[1].setKey(languages[1].getKey() + number);
				break;
			case "dan":
				languages[2].setKey(languages[2].getKey() + number);
				break;
			case "fil":
				languages[3].setKey(languages[3].getKey() + number);
				break;
			case "fre":
				languages[4].setKey(languages[4].getKey() + number);
				break;
			case "ger":
				languages[5].setKey(languages[5].getKey() + number);
				break;
			case "ind":
				languages[6].setKey(languages[6].getKey() + number);
				break;
			case "ita":
				languages[7].setKey(languages[7].getKey() + number);
				break;
			case "jpn":
				languages[8].setKey(languages[8].getKey() + number);
				break;
			case "mul":
				languages[9].setKey(languages[9].getKey() + number);
				break;
			case "nl":
				languages[10].setKey(languages[10].getKey() + number);
				break;
			case "nor":
				languages[11].setKey(languages[11].getKey() + number);
				break;
			case "per":
				languages[12].setKey(languages[12].getKey() + number);
				break;
			case "pol":
				languages[13].setKey(languages[13].getKey() + number);
				break;
			case "por":
				languages[14].setKey(languages[14].getKey() + number);
				break;
			case "rum":
				languages[15].setKey(languages[15].getKey() + number);
				break;
			case "rus":
				languages[16].setKey(languages[16].getKey() + number);
				break;
			case "spa":
				languages[17].setKey(languages[17].getKey() + number);
				break;
			case "swe":
				languages[18].setKey(languages[18].getKey() + number);
				break;
			case "tur":
				languages[19].setKey(languages[19].getKey() + number);
				break;
			case "vie":
				languages[20].setKey(languages[20].getKey() + number);
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
