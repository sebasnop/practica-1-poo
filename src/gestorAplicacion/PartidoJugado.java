package gestorAplicacion;

public class PartidoJugado extends Partido {
	
	private int golesLocal;
	private int golesVisitante;
	
	public PartidoJugado(Partido partido, int golesLocal, int golesVisitante) {
		this.equipoLocal = partido.getEquipoLocal();
    	this.equipoVisitante = partido.getEquipoVisitante();
    	this.arbitro = partido.getArbitro();
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
	}
	
	
	public PartidoJugado() {
		super();
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
	
	
	@Override
	public String toString() {
			return  "\n" + equipoLocal.getNombre() + " " + golesLocal + " - " + golesVisitante + " " + equipoVisitante.getNombre();
	}

}
