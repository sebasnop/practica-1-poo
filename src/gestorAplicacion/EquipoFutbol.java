package gestorAplicacion;

import java.io.Serializable;
import java.util.ArrayList;


public class EquipoFutbol extends ClubDeportivo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int victorias;
	private int empates;
	private int derrotas;
	private int golesAnotados;
	private int golesRecibidos;
	private int puntos;
	private int partidosJugados;
	private int presupuesto;
	private static ArrayList<EquipoFutbol> Equipos = new ArrayList<EquipoFutbol>();
	
	
	public static ArrayList<EquipoFutbol> getEquipos() {
		return Equipos;
	}

	

	public EquipoFutbol(String nombre, String ubicacion, int presupuesto){
		this.nombre = nombre;
		this.ubicacion = ubicacion;
	}
	
	public EquipoFutbol(){}
	
	public int getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}
	public int getVictorias() {
		return victorias;
	}
	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}
	public int getEmpates() {
		return empates;
	}
	public void setEmpates(int empates) {
		this.empates = empates;
	}
	public int getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}
	public int getGolesAnotados() {
		return golesAnotados;
	}
	public void setGolesAnotados(int golesAnotados) {
		this.golesAnotados = golesAnotados;
	}
	public int getGolesRecibidos() {
		return golesRecibidos;
	}
	public void setGolesRecibidos(int golesRecibidos) {
		this.golesRecibidos = golesRecibidos;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getPartidosJugados() {
		return partidosJugados;
	}
	public void setPartidosJugados(int partidosJugados) {
		this.partidosJugados = partidosJugados;
	}
	
	
	// Metodos
	
	public void registrarPartido (int golesAnotados, int golesRecibidos) {
		
		this.setGolesAnotados(getGolesAnotados() + golesAnotados);
		this.setGolesRecibidos(getGolesRecibidos() + golesRecibidos);
		this.setPartidosJugados(getPartidosJugados() + 1);
		
		if (golesAnotados > golesRecibidos) {
			
			puntos += 3;
			victorias += 1;
			
		} else if (golesAnotados == golesRecibidos) {
			
			puntos += 1;
			empates += 1;
			
		} else {
			
			derrotas += 1;
			
		}
		
	}

}
