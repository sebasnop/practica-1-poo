package gestorAplicacion;

import java.util.Date;
import java.io.Serializable;


public abstract class Partido implements Serializable {
	
	protected EquipoFutbol equipoLocal;
	protected EquipoFutbol equipoVisitante;
	protected Date fecha;
	
	public Partido(EquipoFutbol equipoLocal, EquipoFutbol equipoVisitante, Date fecha) {
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.fecha = fecha;
	}
	
	
	
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
	
	public abstract String mostrarResultado();

}
