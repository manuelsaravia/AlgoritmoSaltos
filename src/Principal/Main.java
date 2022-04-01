package Principal;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Jugar juego = new Jugar();
		try {
			Scanner scan = new Scanner(System.in);

			System.out.print("Path: ");
			String path = scan.next();
			
			System.out.println("Leap: ");
			String leap = scan.next();

			// jugar
			System.out.println("Este juego"+(juego.jugar(path, leap)?"":" no")+" es ganable");

		} catch (NumberFormatException ne) {
			System.out.println("Error por: Valor no valido para el Leap");
		} catch (Exception e) {

			System.out.println("Error por: " + e.getMessage());
		}

	}

}
