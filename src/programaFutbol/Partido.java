package programaFutbol;

import java.util.Date;


public class Partido {
	
	private EquipoFutbol equipoA;
	private EquipoFutbol equipoB;
	private int golesA;
	private int golesB;
	private Date fecha;
	private boolean resena;
	
	
	
	public boolean isResena() {
		return resena;
	}
	public void setResena(boolean resena) {
		this.resena = resena;
	}
	public EquipoFutbol getEquipoA() {
		return equipoA;
	}
	public void setEquipoA(EquipoFutbol equipoA) {
		this.equipoA = equipoA;
	}
	public EquipoFutbol getEquipoB() {
		return equipoB;
	}
	public void setEquipoB(EquipoFutbol equipoB) {
		this.equipoB = equipoB;
	}
	public int getGolesA() {
		return golesA;
	}
	public void setGolesA(int golesA) {
		this.golesA = golesA;
	}
	public int getGolesB() {
		return golesB;
	}
	public void setGolesB(int golesB) {
		this.golesB = golesB;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	 
	
	
	

}
