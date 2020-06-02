import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		mainMenu();

	}

	public static void mainMenu() {

		System.out.println("Seleccione la opción que desee :\n");
		System.out.println(" 1. Carga de datos");
		System.out.println(" 2. Ejecutar consultas");
		System.out.println(" 3. Salir\n");

		Scanner myObj = new Scanner(System.in);
		System.out.print("Opción : ");
		String option = myObj.nextLine();

		switch (option) {
			case "1":

				loadData();

				break;
			case "2":

				runQueries();

				break;
			case "3":

				System.exit(0);

			default:

				System.out.println("Entrada invalida");

				break;
		}

	}

	private static void loadData() {

		System.out.print("Carga de datos exitosa, tiempo de ejecución de la carga : ");

	}

	private static void runQueries() {

		System.out.println("Seleccione la opción que desee :\n");
		System.out.println(" 1. Indicar el Top 10 de libros que más lecturas tienen por parte de usuarios.");
		System.out.println(" 2. Indicar el Top 20 de libros que más cantidad de lecturas tienen.");
		System.out.println(" 3. Indicar el Top 10 de usuarios que realizaron mayor cantidad de\n" +
				"evaluaciones a libros y ordenarlo por rating promedio descendente");
		System.out.println(" 4. Indicar el Top 5 de los idiomas asociados a libros que han tenido más\n" +
				"reservas.");
		System.out.println(" 5. Indicar el Top 20 de autores que más publicaciones han hecho por año.");
		System.out.println(" 6. Salir.");

		Scanner myObj = new Scanner(System.in);
		System.out.print("Opción : ");
		String option = myObj.nextLine();

		switch (option) {

			case "1":
				top10Books();
				break;
			case "2":
				top20Books();
				break;
			case "3":
				top10Users();
				break;
			case "4":
				top5Language();
				break;
			case "5":
				top20Authors();
				break;
			case "6":
				mainMenu();
				break;
			default:

				break;

		}

	}

	private static void top10Books() {

		runQueries();

	}

	private static void top20Books() {

		runQueries();

	}

	private static void top10Users() {

		runQueries();

	}

	private static void top5Language() {

		runQueries();

	}

	private static void top20Authors() {

		runQueries();

	}



}
