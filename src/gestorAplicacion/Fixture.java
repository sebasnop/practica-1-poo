package gestorAplicacion;

public class Fixture extends Partido {

    EquipoFutbol equipoLocal;
    EquipoFutbol equipoVisitante;
    Arbitro arbitro;
	

    public Fixture(EquipoFutbol equipoLocal, EquipoFutbol equipoVisitante, Arbitro arbitro) {
    	this.equipoLocal = equipoLocal;
    	this.equipoVisitante = equipoVisitante;
    	this.arbitro = arbitro;
	}
    
    public Fixture(EquipoFutbol equipoLocal, EquipoFutbol equipoVisitante) {
		this(equipoLocal, equipoVisitante, Arbitro.escogerAleatoriamente());
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

    // Se coloca solo aqui porque a un PartidoJugado no se le puede reasignar el Arbitro
	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
		arbitro.setPartidos(arbitro.getPartidos()+1);
	}

}
