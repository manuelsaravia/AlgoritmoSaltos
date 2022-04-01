package Principal;

import java.util.ArrayList;

public class Jugar {

	public boolean jugar(String pathI, String leapI) {
		boolean victoria=false;
		try {
			String path[] = pathI.split(",");

			// Validaciones
			this.validarTamanio(path);
			this.validarComienzoVector(path);
			this.validarUnoCero(path);

			int leap = Integer.parseInt(leapI);
			
			// jugar
			victoria = this.validarVictoria(path, leap);

		} catch (NumberFormatException ne) {
			System.out.println("Error por: Valor no valido para el Leap");
			return false;
		} catch (Exception e) {
			System.out.println("Error por: " + e.getMessage());
			return false;
		}
		return victoria;
	}
	
	private void validarTamanio(String[] path) throws Exception {
		if (path.length < 2) {
			throw new Exception("Tamaño de path no valido");
		}
	}

	private void validarComienzoVector(String[] path) throws Exception {
		if (!path[0].equals("1")) {
			throw new Exception("Comienzo no valido para el path");
		}
	}

	private void validarUnoCero(String[] path) throws Exception {
		for (int i = 0; i < path.length; i++) {
			if (!path[i].equals("0") && !path[i].equals("1")) {
				throw new Exception("Valor no valido dentro del path");
			}
		}
	}

	private boolean validarVictoria(String[] path, int leap) {
		int longitud = path.length;
		boolean victoria = false;
		boolean uno = false;
		boolean dos = false;
		boolean tres = false;
		boolean[] visitados = new boolean[path.length];
		int[] posicionUno = new int[1];
		int[] posicionDos = new int[1];
		int[] posicionTres = new int[1];
		int posicion;
		visitados[0] = true;
		ArrayList<Integer> pendientes = new ArrayList();
		pendientes.add(0);
		do {
			posicion = pendientes.remove(0);
			posicionUno[0] = posicion;
			posicionDos[0] = posicion;
			posicionTres[0] = posicion;
			uno = caminoUno(path, leap, posicionUno, visitados);
			dos = caminoDos(path, leap, posicionDos, visitados);
			tres = caminoTres(path, leap, posicionTres, visitados);
			
			if(uno)
				pendientes.add(posicionUno[0]);
			if(dos)
				pendientes.add(posicionDos[0]);
			if(tres)
				pendientes.add(posicionTres[0]);
			
			if(posicionUno[0] == longitud-1 || posicionDos[0] >= longitud) {
				victoria = true;
				break;
			}
		} while (!pendientes.isEmpty());
		return victoria;
	}

	private boolean caminoUno(String[] path, int leap, int[] posicion, boolean[] visitados) {
		int longitud = path.length;
		boolean victoria = false;
		if (posicion[0] == longitud - 1) {
			return true;
		}
		if (path[posicion[0] + 1].equals("1") && !visitados[posicion[0] + 1]) {
			posicion[0]++;
			visitados[posicion[0]] = true;
			victoria = true;
		}
		return victoria;
	}

	private boolean caminoDos(String[] path, int leap, int[] posicion, boolean[] visitados) {
		int longitud = path.length;
		boolean victoria = false;
		if (posicion[0] + leap >= longitud) {
			victoria = true;
			posicion[0] += leap;
		} else {
			if (path[posicion[0] + leap].equals("1") && !visitados[posicion[0] + leap]) {
				posicion[0] += leap;
				visitados[posicion[0]] = true;
				victoria = true;
			}
		}
		return victoria;
	}

	private boolean caminoTres(String[] path, int leap, int[] posicion, boolean[] visitados) {
		boolean victoria = false;
		if (posicion[0] == 0) {
			return false;
		}
		if (path[posicion[0] - 1].equals("1") && !visitados[posicion[0] - 1]) {
			posicion[0]--;
			visitados[posicion[0]] = true;
			victoria = true;
		}
		return victoria;
	}

}
