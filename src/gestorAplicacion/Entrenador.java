package gestorAplicacion;

import java.io.Serializable;

import gestorAplicacion.Jugador.Posicion;

public class Entrenador implements Serializable, IntegranteEquipo {
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private EquipoFutbol equipo;
	
	public Entrenador (String nombre, EquipoFutbol equipo) {
		this.nombre = nombre;
		this.equipo = equipo;
	}
	
	// Para crear un entrenador sin equipo
	public Entrenador (String nombre) {
		this(nombre,null);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public EquipoFutbol getEquipo() {
		return equipo;
	}

	public void setEquipo(EquipoFutbol equipo) {
		this.equipo = equipo;
	}

	
	public void ficharJugador (Jugador jugador) {
		equipo.setPresupuesto(equipo.getPresupuesto()-jugador.getValorMercado());
		equipo.anadirJugador(jugador);
	}

	@Override
	public String mostrar() {
		return this.getNombre();
	}

}
