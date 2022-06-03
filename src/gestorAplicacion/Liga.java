package gestorAplicacion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import gestorAplicacion.Jugador.Posicion;

public class Liga implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private final int numeroDeEquipos;
	private final LinkedList<EquipoFutbol> equipos;
	private final ArrayList<Jugador> jugadoresLibres = new ArrayList<Jugador>(Arrays.asList(new Jugador("Maradona",Posicion.DL,10000000),new Jugador("Messi",Posicion.DL,20000000),new Jugador("Cristiano Ronaldo",Posicion.DL,20000000),new Jugador("Carles Puyol",Posicion.DF,5000000),new Jugador("Pepe",Posicion.DF,4500000),new Jugador("Rio Ferdinand",Posicion.DF,7000000),new Jugador("Keylor Navas",Posicion.PT,11000000),new Jugador("Manuel Neuer",Posicion.PT,15000000),new Jugador("Oliver Kahn",Posicion.PT,18000000)));
	
	private Date fechaInicio;
	private List<Jornada> calendario = new LinkedList<Jornada>();
	private int proximaJornada;
	
	// El calendario esta listo cuando este generado y se le asignen fechas y arbitros
	private boolean calendarioListo = false;
	
	public Liga(int numeroDeEquipos) {
		
		this.numeroDeEquipos = numeroDeEquipos;
		equipos = new LinkedList<EquipoFutbol>();
		proximaJornada = 0;
		
	}
	
	
	// Getters y Setters:

	public List<Jornada> getCalendario() {
		return calendario;
	}

	public void setCalendario(List<Jornada> calendario) {
		this.calendario = calendario;
	}

	public ArrayList<Jugador> getJugadoresLibres() {
		return jugadoresLibres;
	}
	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public LinkedList<EquipoFutbol> getEquipos() {
		return equipos;
	}

	public int getNumeroDeEquipos() {
		return numeroDeEquipos;
	}
    
	public int getProximaJornada() {
		return proximaJornada;
	}
	public void setProximaJornada(int proximaJornada) {
		this.proximaJornada = proximaJornada;
	}

	public boolean isCalendarioListo() {
		return calendarioListo;
	}
	public void setCalendarioListo(boolean calendarioListo) {
		this.calendarioListo = calendarioListo;
	}
	
	
	// Metodos


	// Permite saber si la liga ya contiene la cantidad de equipos esperada
    public boolean ligaCompleta() {
    	if (getEquipos().size() == getNumeroDeEquipos()) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    // Permite saber un equipo pertenece a la liga
    public boolean equipoPertenece(EquipoFutbol equipo) {
    	if (getEquipos().contains(equipo)) {
    		return true;
    	} else {
    		return false;
    	}
    }

	public void anadirEquipo(EquipoFutbol equipo) {
    	equipos.add(equipo);
	}
	
	public void eliminarEquipo(EquipoFutbol equipo) {
		equipos.remove(equipo);
		this.eliminarCalendario();
	}
	
	// Retorna la instancia del equipo ingresando su nombre
	public EquipoFutbol identificarEquipo (String nombreEquipo) {
		for (EquipoFutbol equipo: equipos) {
			if (equipo.getNombre().equals(nombreEquipo)){
				return equipo;
			}
		}
		return null;
	}
	
	// Se genera el calendario de partidos
	public void generarFixture(){
		GeneradorFixture generadorFixture = new GeneradorFixture();
		List<Jornada> calendario = generadorFixture.getFixtures(this, true);
		this.setCalendario(calendario);
	}
	
	public void eliminarCalendario() {
		calendario.clear();
		this.setCalendarioListo(false);
		
		equipos.forEach((equipo) -> {
			equipo.setPuntos(0);
			equipo.setPartidosJugados(0);
			equipo.setVictorias(0);
			equipo.setEmpates(0);
			equipo.setDerrotas(0);
			equipo.setGolesAnotados(0);
			equipo.setGolesRecibidos(0);
		});
		
		Arbitro.federacionArbitros.forEach((arbitro) -> {
			arbitro.setPartidos(0);
			arbitro.setSalario(1000);
		});
	
	}
	
	public void registrarJornada(Jornada registroJornada) {
		
		calendario.set(proximaJornada, registroJornada);
		
		proximaJornada++;
	
	}
	
	public void asignarArbitrosFechas() {
		
		int indiceJornada = 0;
		
		for (Jornada jornada: calendario) {

			// Asignacion de fechas
			jornada.setIndice(indiceJornada);
			jornada.fechaJornada(fechaInicio);
			
			// Asignacion de Arbitros
			ArrayList<Arbitro> arbitrosAleatorios = Arbitro.listaAleatoriaArbitros();
			int indicePartido = 0;
			
			for (Partido fixture: jornada.getPartidos()) {
				Arbitro arbitroAleatorio = arbitrosAleatorios.get(indicePartido);
				System.out.println(arbitroAleatorio);
				fixture.setArbitro(arbitroAleatorio);
				
				indicePartido++;
			}
			
			indiceJornada++;
			
		}
		
		this.setCalendarioListo(true);
		
	}
				    	
}