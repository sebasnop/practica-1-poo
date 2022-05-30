package gestorAplicacion;

import java.util.Date;

public class PartidoJugado extends Partido {
	
	private boolean resena;
	private int golesLocal;
	private int golesVisitante;
	
	

	public PartidoJugado(EquipoFutbol equipoLocal, EquipoFutbol equipoVisitante, Date fecha, boolean resena,
			int golesLocal, int golesVisitante) {
		super(equipoLocal, equipoVisitante, fecha);
		this.resena = resena;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
	}
	
	public PartidoJugado() {
		this(null, null, null, false, 0, 0);
	}
	
	

	@Override
	public String mostrarResultado() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isResena() {
		return resena;
	}

	public void setResena(boolean resena) {
		this.resena = resena;
	}

	public int getGolesLocal() {
		return golesLocal;
	}

	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

}
