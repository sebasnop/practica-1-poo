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
	


    // Se coloca solo aqui porque a un PartidoJugado no se le puede reasignar el Arbitro
	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
		arbitro.setPartidos(arbitro.getPartidos()+1);
	}
	
	// Metodos
	
	@Override
	public String toString() {
		
		if (arbitro == null) {
			return  "\n" + getEquipoLocal().getNombre() + " vs " + getEquipoVisitante().getNombre() + "\n" + 
					getEquipoLocal().getUbicacion() + " | Arbitro: Por definir";
		} else {
			return  "\n" + getEquipoLocal().getNombre() + " vs " + getEquipoVisitante().getNombre() + "\n" + 
					getEquipoLocal().getUbicacion() + " | Arbitro: " + getArbitro();
		}
		
	}

}

