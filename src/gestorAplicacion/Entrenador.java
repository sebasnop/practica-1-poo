package gestorAplicacion;

public class Entrenador implements IntegrantesPartido {
	
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

	
	public void ficharJugador (String posicion) {
		
		// Solo se puede fichar si el entrenador dirije un equipo
		if (getEquipo() != null) {
			
		}
		
	}

	@Override
	public int predecirResultadoLocal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int predecirResultadoVisitante() {
		// TODO Auto-generated method stub
		return 0;
	}

}
