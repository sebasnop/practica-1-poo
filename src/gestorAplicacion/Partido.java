package gestorAplicacion;

import java.util.Date;


public abstract class Partido {
	
	private EquipoFutbol equipoLocal;
	private EquipoFutbol equipoVisitante;
	private Date fecha;
	
	public Partido(EquipoFutbol equipoLocal, EquipoFutbol equipoVisitante, Date fecha) {
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.fecha = fecha;
	}
	
	public EquipoFutbol getEquipoA() {
		return equipoLocal;
	}
	public void setEquipoA(EquipoFutbol equipoA) {
		this.equipoLocal = equipoA;
	}
	public EquipoFutbol getEquipoB() {
		return equipoVisitante;
	}
	public void setEquipoB(EquipoFutbol equipoB) {
		this.equipoVisitante = equipoB;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public abstract String mostrarResultado();

}
