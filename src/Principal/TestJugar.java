package Principal;

import junit.framework.TestCase;

public class TestJugar extends TestCase {

	private Jugar juego;
	
	public void iniciarJuego() {
		this.juego = new Jugar();
	}
	
	public void testPruebaUno() {
		this.iniciarJuego();
		String path="1,1,0,0,1,1,0,1,0,1,1";
		String leap="3";
		assertTrue(this.juego.jugar(path, leap));
	}
	
	public void testPruebaDos() {
		this.iniciarJuego();
		String path="1,1,0,0,1,0,0,1,1,0,0,1,0,0,0,1";
		String leap="4";
		assertTrue(this.juego.jugar(path, leap));
	}
	
	public void testPruebaTres() {
		this.iniciarJuego();
		String path="1,1,1,0,1,1,0,1";
		String leap="1";
		assertFalse(this.juego.jugar(path, leap));
	}
	
	public void testPruebaCuatro() {
		this.iniciarJuego();
		String path="1,0,0,0";
		String leap="5";
		assertTrue(this.juego.jugar(path, leap));
	}
	
	public void testPruebaCinco() {
		this.iniciarJuego();
		String path="1,0,0,0";
		String leap="3";
		assertFalse(this.juego.jugar(path, leap));
	}
	
	public void testPruebaSeis() {
		this.iniciarJuego();
		String path="1,1";
		String leap="1";
		assertTrue(this.juego.jugar(path, leap));
	}
	
	public void testPruebaSiete() {
		this.iniciarJuego();
		String path="1,1";
		String leap="2";
		assertTrue(this.juego.jugar(path, leap));
	}
	
	public void testPruebaOcho() {
		this.iniciarJuego();
		String path="1,1,1,1,1,1,0,0,1,0,1,0,0,1,0,1,1,0,1,1,0,0,0,0,1,0,0,0,0";
		String leap="5";
		assertTrue(this.juego.jugar(path, leap));
	}
	
	public void testPruebaNueve() {
		this.iniciarJuego();
		String path="1,1,1,1,1,1,0,0,1,0,1,0,0,1,0,1,0,0,1,1,0,0,0,0,1,0,0,0,0,0";
		String leap="5";
		assertFalse(this.juego.jugar(path, leap));
	}
	
	public void testPruebaDiez() {
		this.iniciarJuego();
		String path="1,1,1,1,1,1,0,0,1,0,1,0,0,1,0,1,1,0,1,1,0,0,0,0,1,0,0,0,0,0";
		String leap="5";
		assertFalse(this.juego.jugar(path, leap));
	}
	
	public void testPruebaOnce() {
		this.iniciarJuego();
		String path="1,1,1,1,1,1,0,0,1,0,1,0,0,1,0,1,0,0,1,1,0,0,0,0,1,0,0,0,0";
		String leap="5";
		assertTrue(this.juego.jugar(path, leap));
	}
	
}
