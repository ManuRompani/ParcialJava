package Main;

import java.util.Scanner;
import Utilities.Consola;
import Modelo.Personaje;

public class Main {
	public static void main(String[] args) {
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		Personaje[] vecPersonaje = new Personaje[2];
		Consola consola = new Consola();
		
		//Se cargan e inicializan los personajes
		for(int i=0; i<vecPersonaje.length;i++) {
			vecPersonaje[i] = new Personaje();
			System.out.println("Ingrese nombre");
			vecPersonaje[i].setNombre(sc.next());
			
			System.out.println("Ingrese habilidad");
			vecPersonaje[i].setHabilidad(sc.nextInt());
			
			System.out.println("Ingrese profesion");
			System.out.println(consola.mostrProfesiones());
			vecPersonaje[i].setProfesion(sc.next().charAt(0));
		}
		
		//Se muesta el menu
		do {
			consola.mostrarMenu();
			opcion = sc.nextInt();
			switch(opcion){
				case 1:
					for(int i=0; i<vecPersonaje.length; i++) {
						consola.mostrarJugador(vecPersonaje[i]);
					}
					break;
				case 2:
					System.out.println("Selecciona la posicion del personaje al que deseas comprarle una estrella.");
					for(int i=0; i<vecPersonaje.length; i++) {
						consola.mostrarJugadorConMoneda(vecPersonaje[i]);
					}
					int posicionPersonaje = sc.nextInt();
					consola.mensajeCompraDeMoneda(vecPersonaje[posicionPersonaje].comprarEstrella());
					break;
				case 3:
					for(int i=0; i<vecPersonaje.length; i++) {
						Personaje personajeActual = vecPersonaje[i];
						consola.mensajeJugarRonda(personajeActual.jugarRonda(), 
								personajeActual.getNombre());
					}
					break;
				case 4:
					System.out.println("Selecciona la posicion del personaje para trabajar.");
					for(int i=0; i<vecPersonaje.length; i++) {
						consola.mostrarJugador(vecPersonaje[i]);
					}
					int posicionTrabajador = sc.nextInt();
					consola.MensajeTrabajo(vecPersonaje[posicionTrabajador].trabajar());
					break;
				case 0:
					System.out.println("Gracias por jugar.");
					break;
				default:
					System.out.println("Opcion invalda");
					break;
			}
		}while(opcion!=0);
	}

}
