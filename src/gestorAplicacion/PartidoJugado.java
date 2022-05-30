package gestorAplicacion;

import java.util.Date;

public class PartidoJugado extends Partido {
	
	private boolean resena;
	private int golesLocal;
	private int golesVisitante;
	
	

	public PartidoJugado(int golesLocal, int golesVisitante) {
		
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
		// Borrar partido no jugado de la lista de partidos de la liga
	}
	
	public PartidoJugado() {
		this(0,0);
	}

	@Override
	public String mostrarResultado() {
		
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
