package gestorAplicacion;

import java.util.Date;

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

	@Override
	public String mostrarResultado() {
		return "No se ha jugado aún";
	}

}
