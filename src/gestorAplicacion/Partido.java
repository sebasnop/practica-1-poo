package gestorAplicacion;

import java.util.Date;
import java.io.Serializable;


public abstract class Partido implements Serializable {
	
	protected EquipoFutbol equipoLocal;
	protected EquipoFutbol equipoVisitante;
	protected Date fecha;
	protected Arbitro arbitro;
	
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

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Arbitro getArbitro() {
		return arbitro;
	}
	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
	}
	

	public abstract String mostrarResultado();

}
