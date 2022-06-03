package gestorAplicacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Jornada implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int indice;
	private List<Partido> partidos;
	private Date fecha;
	private boolean jugada;
	
	public Jornada (List<Partido> partidos) {
		this.partidos = partidos;
	}
	
	public Jornada () {
		this(new ArrayList<Partido>());
	}
	
	// Getters y setters

	public List<Partido> getPartidos() {
		return partidos;
	}
	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

	public int getIndice() {
		return indice;
	}
	public void setIndice(int indice) {
		this.indice = indice;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public boolean isJugada() {
		return jugada;
	}
	public void setJugada(boolean jugada) {
		this.jugada = jugada;
	}
	
	
	// Metodos

	public void agregarPartido(Partido partido) {
		partidos.add(partido);
	}
	
	public String mostrarFecha() {
		
		Date fecha = getFecha();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		
		String diaTexto  = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
		String mesTexto  = Integer.toString(calendar.get(Calendar.MONTH));
		String anioTexto = Integer.toString(calendar.get(Calendar.YEAR));
		
		return diaTexto + " / " + mesTexto + " / " + anioTexto;
	}
	
	// Establece la fecha de la jornada. Las jornadas se juegan cada 7 dias
	public void fechaJornada(Date fechaInicio) {
		Calendar c = Calendar.getInstance();
		c.setTime(fechaInicio); // Localiza la jornada inicial en el calendario
		c.add(Calendar.DATE, (indice*7)); // Agrega 7 dias por cada jornada que haya pasado 
		this.setFecha(c.getTime());  // Establece la fecha correspondiente
	}
	
}
