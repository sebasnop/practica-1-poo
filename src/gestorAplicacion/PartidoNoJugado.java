package gestorAplicacion;

import java.util.Date;

public class PartidoNoJugado extends Partido {

	public PartidoNoJugado(EquipoFutbol equipoLocal, EquipoFutbol equipoVisitante, Date fecha) {
		super(equipoLocal, equipoVisitante, fecha);
	}

	@Override
	public String mostrarResultado() {
		return "No se ha jugado aún";
	}


}
