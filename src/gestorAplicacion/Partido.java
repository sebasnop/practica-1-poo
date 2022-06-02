package gestorAplicacion;

import java.io.Serializable;


public abstract class Partido implements Serializable {
	
	protected EquipoFutbol equipoLocal;
	protected EquipoFutbol equipoVisitante;
	protected Arbitro arbitro;
	
	
	// Getters y Setters
	
	public EquipoFutbol getEquipoLocal() {
		return equipoLocal;
	}
	public void setEquipoLocal(EquipoFutbol equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public EquipoFutbol getEquipoVisitante() {
		return equipoVisitante;
	}
	public void setEquipoVisitante(EquipoFutbol equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	
	public Arbitro getArbitro() {
		return arbitro;
	}
	
	// Metodos
	
	@Override
	public String toString() {
		
		if (arbitro == null) {
			return  "\n" + getEquipoLocal().getNombre() + " vs " + getEquipoVisitante().getNombre() + "\n" + 
					getEquipoLocal().getUbicacion();
		} else {
			return  "\n" + getEquipoLocal().getNombre() + " vs " + getEquipoVisitante().getNombre() + "\n" + 
					getEquipoLocal().getUbicacion() + getArbitro();
		}
		
	}

	public abstract String mostrarResultado();

}

