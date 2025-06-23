package Modelo;

public class Personaje {
	private String nombre;
	private char profesion;
	
	private int habilidad;
	private int nivelActual = 1;
	private int moneda = 0;
	
	private boolean isPuedeTrabajar = true;
	private boolean estrella = false;
	//
	//Geters
	public String getNombre() {
		return this.nombre;
	}
	public char getProfesion() {
		return this.profesion;
	}
	public int getHabilidad() {
		return this.habilidad;
	}
	public int getNivelActual() {
		return this.nivelActual;
	}
	public int getMoneda() {
		return this.moneda;
	}
	public boolean getEstrella() {
		return this.estrella;
	}
	private int getDificultad() {
		return this.nivelActual * 30;
	}
	//
	//
	//Seters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setProfesion(char profesion) {
		this.profesion = profesion;
	}
	public void setHabilidad(int habilidad) {
		this.habilidad = habilidad;
	}
	public void setNivelActual(int nivel) {
		this.nivelActual = nivel;
	}
	//
	//
	//Calculable
	//
	//Puntaje Acutal
	public int getPuntajeActual() {
		return (25 * this.nivelActual) + (2 * this.moneda);
	}
	//
	//
	//Acciones
	public boolean trabajar() {
		if(this.isPuedeTrabajar) {
			this.isPuedeTrabajar = false;
			
			if(this.profesion=='C') {
				this.moneda += 20;
			}else if(this.profesion=='D') {
				this.moneda += 30;
			}else if(this.profesion=='P') {
				this.moneda += 35;
			}
			return true;
		}
		return false;
	}
	public boolean comprarEstrella() {
		if(this.moneda >= 50) {
			this.estrella = true;
			if(this.getPuntajeActual() > 120) {
				this.moneda -= 50 * 0.8;
			}
			else {
				this.moneda -= 50;
			}
			return true;
		}
		
		return false;
	}
	
	public boolean jugarRonda() {
		int dificultad = this.getDificultad();
		
		if(!this.estrella) {
			if(this.habilidad * 50 < dificultad) {
				this.isPuedeTrabajar = true;
				return false;
			}
		}
		else {
			this.estrella = false;
		}
		this.aumentarNivel();
		return true;
	}
	
	private void aumentarNivel() {
		if(this.nivelActual<5){
			this.nivelActual ++;
		}
	}

}
