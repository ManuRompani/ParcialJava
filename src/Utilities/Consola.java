package Utilities;
import Modelo.Personaje;
public class Consola {
	public void mostrarMenu() {
		System.out.println("Menu");
		System.out.println("1_Mostrar listado de personajes.");
		System.out.println("2_Comprar estrella.");
		System.out.println("3_Jugar ronda.");
		System.out.println("4_Trabajar");
		System.out.println("0_Terminar juego");
	}
	
	public void mostrarJugador(Personaje personaje) {
		System.out.println(personaje.getNombre()
				+ " - Nivel" + personaje.getNivelActual()
				+ " - " + this.obtenerProfesion(personaje.getProfesion())
				+ " - " + personaje.getPuntajeActual() + "p"
				+ " - " + this.tieneEstrella(personaje.getEstrella()));
	}
	
	public void mostrarJugadorConMoneda(Personaje personaje) {
		System.out.println(personaje.getNombre()
				+ " - Monedas" + personaje.getMoneda());
	}
	
	public String obtenerProfesion(char caracter) {
		if(caracter == 'D') {
			return "Doctor";
		}else if(caracter == 'C') {
			return "Chef";
		}else if(caracter == 'P') {
			return "Plomero";
		}else {
			return "Profesion desconocida.";
		}
	}
	
	public String tieneEstrella(boolean estrella) {
		if(estrella) {
			return "Con estrella";
		}
		else {
			return "Sin bonus";
		}
	}
	
	public void mensajeCompraDeMoneda(boolean fueComprado) {
		if(fueComprado) {
			System.out.println("La compra fue posible.Ahora tienes una estrella");
		}
		else {
			System.out.println("No fue posible comprar una moneda");
		}
	}
	
	public void mensajeJugarRonda(boolean resultadoRonda, String personaje) {
		if(resultadoRonda) {
			System.out.println("El personaje " + personaje + " gano la ronda.");
		}
		else {
			System.out.println("El personaje " + personaje + " perdio la ronda.");
		}
	}
	
	public String mostrProfesiones() {
		return "D:Doctor, C:Chef, P:Plomero";
	}
	
	public void MensajeTrabajo(boolean pudoTrabajar) {
		if(pudoTrabajar) {
			System.out.println("El personaje ha podido trabajar.");
		}
		else {
			System.out.println("El personaje no ha podido trabajar.");
		}
	}
}
