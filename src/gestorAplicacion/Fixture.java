package gestorAplicacion;

import java.util.Date;

public class Fixture extends Partido {

    EquipoFutbol equipoLocal;
    EquipoFutbol equipoVisitante;
    Arbitro arbitro;

    public Fixture(EquipoFutbol equipoLocal, EquipoFutbol equipoVisitante, Date fecha, Arbitro arbitro) {
		super(equipoLocal, equipoVisitante, fecha, arbitro);
	}
    
    public Fixture(EquipoFutbol equipoLocal, EquipoFutbol equipoVisitante) {
		this(equipoLocal, equipoVisitante, null, null);
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
