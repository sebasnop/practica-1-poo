package uIMain;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

import baseDatos.Deserializador;
import baseDatos.Serializador;
import gestorAplicacion.Comparador;
import gestorAplicacion.EquipoFutbol;
import gestorAplicacion.Jornada;
import gestorAplicacion.Jugador;
import gestorAplicacion.Liga;
import gestorAplicacion.Partido;
import gestorAplicacion.PartidoJugado;
import gestorAplicacion.Jugador.Posicion;

public class Menu {
	
	static Scanner scanner = new Scanner(System.in);

	static Liga liga = new Liga(4);
	
	public static void main(String[] args) {
		
		cargar();
		
		/*
		ArrayList<Jugador> plantilla1 = new ArrayList<Jugador>(Arrays.asList(
				new Jugador("Marc Andre Ter Stegen",Posicion.PT,45000000),
				new Jugador("Gerard Pique",Posicion.DF,5000000),
				new Jugador("Gavi",Posicion.MC,60000000),
				new Jugador("Ansu Fati",Posicion.DL,60000000)
				));
		
		ArrayList<Jugador> plantilla2 = new ArrayList<Jugador>(Arrays.asList(
				new Jugador("Alisson",Posicion.PT,60000000),
				new Jugador("Virgil Van Dijk",Posicion.DF,55000000),
				new Jugador("Fabinho",Posicion.MC,60000000),
				new Jugador("Luis Diaz",Posicion.DL,45000000)
				));
		
		ArrayList<Jugador> plantilla3 = new ArrayList<Jugador>(Arrays.asList(
				new Jugador("Pau Lopez",Posicion.PT,12000000),
				new Jugador("William Saliba",Posicion.DF,30000000),
				new Jugador("Boubacar Kamara",Posicion.MC,25000000),
				new Jugador("Cenguiz Under",Posicion.DL,22000000)
				));
		
		ArrayList<Jugador> plantilla4 = new ArrayList<Jugador>(Arrays.asList(
				new Jugador("Gregor Kobel",Posicion.PT,20000000),
				new Jugador("Manuel Akanji",Posicion.DF,30000000),
				new Jugador("Jude Bellingham",Posicion.MC,75000000),
				new Jugador("Erling Haaland",Posicion.DL,150000000)
				));
		
		EquipoFutbol equipo1 = new EquipoFutbol("Barcelona", "Camp Nou"    , 100000000, plantilla1);
		EquipoFutbol equipo2 = new EquipoFutbol("Liverpool", "Anfield"     , 120000000, plantilla2);
		EquipoFutbol equipo3 = new EquipoFutbol("Marsella" , "Velodrome"   , 60000000 , plantilla3);
		EquipoFutbol equipo4 = new EquipoFutbol("Dortmund" , "Signal Iduna", 300000000, plantilla4);
		
		liga.anadirEquipo(equipo1);
		liga.anadirEquipo(equipo2);
		liga.anadirEquipo(equipo3);
		liga.anadirEquipo(equipo4);*/
		
		boolean salir = false;

		while(!salir) {
			
			System.out.println("----------------------");
			System.out.println("|        Menu De      |");
			System.out.println("|         La Liga     |");
			System.out.println("----------------------");
			System.out.println("");
			System.out.println("Cree un Equipo y anadalo a La Liga (presione 1)");
			System.out.println("Eliminar un Equipo de la Liga (presione 2)");
			System.out.println("Mostrar Equipos (presione 3)");
			System.out.println("Generar calendario (presione 4)");
			System.out.println("Mostrar calendario (presione 5)");
			System.out.println("Asignar arbitros y fechas a los enfrentamientos (presione 6)");
			System.out.println("Registrar resultados de jornada (presione 7)");
			System.out.println("Mostrar la tabla de la Liga (presione 8)");
			System.out.println("Mostrar las estadisticas por Equipo (presione 9)");
			System.out.println("Consultar mercado de jugadores (presione 10)");
			System.out.println("Salir (presione 11)");
			String linea = scanner.nextLine();
			int comando = 0;
			try {
				comando = Integer.parseInt(linea);
			} catch (Exception e) {
			}
	
			switch(comando) {
			case 1 :
				AnadirEquipo();
				break;
			case 2 :
				EliminarEquipo();
				break;
			case 3 :
				MostrarEquipos();
				break;
			case 4:
				GenerarCalendario();
				break;
			case 5:
				MostrarCalendario();
				break;
			case 6:
				AsignarArbitrosFechas();
				break;
			case 7 :
				RegistrarResultadosJornada();
				break;
			case 8:
				MostrarTablaLiga();
				break;
			case 9:
				MostrarEstadisticas();
				break;
			case 10:
				MostrarMercado();
				break;
				
			case 11:
				SalirDelSistema();
				break;
				
	
	
			default:
				System.out.println("Comando Incorrecto");
	
			}
		}
	
	}
	
	private static void AnadirEquipo() {
    	
    	if ( liga.ligaCompleta() ) {
    		System.out.println("No se puede agregar mas equipos a la Liga");
    		return;
    	}
    	EquipoFutbol equipo = new EquipoFutbol();
    	
    	System.out.println("Ingrese el nombre Del equipo");
    	String linea = scanner.nextLine();
    	equipo.setNombre(linea);
    	
    	if ( liga.equipoPertenece(equipo) ) {
    		System.out.println("Este Equipo ya esta en la liga");
    		return;
    	}
    	
    	System.out.println("Ingrese la ubicacion del equipo");
    	linea = scanner.nextLine();
    	equipo.setUbicacion(linea);
    	
    	System.out.println("Ingrese presupuesto del equipo mayor a 0");
    	linea = scanner.nextLine();
    	 
    	 try {
    		 
    		 equipo.setPresupuesto(Integer.parseInt(linea)) ;
         
    	 } catch (Exception e) {
    		 
    		 System.out.println("tienes que ingresar un presupuesto valido");
    		 return;
         
         }
    	 
    	 
    	 
    	 liga.anadirEquipo(equipo);
    	 
	}
	
	private static void RegistrarResultadosJornada() {
		
		int numeroJornadaARegistrar = liga.getProximaJornada();
		List<Jornada> calendario = liga.getCalendario();
		
		// Se valida que si haya calendario completo
		if ( !liga.isCalendarioListo() ) {
			
			System.out.println("Primero se debe generar el calendario y asignarle arbitros y fechas");
			return;
		
		// Se valida que todavia no se hayan agregado los resultados de todas las jornadas
		} else if ( numeroJornadaARegistrar == calendario.size() ) {
			
			System.out.println("Ya se han registrado los resultados de todas las jornadas");
			return;
		
		// Luego de todas las validaciones, se procede a ejecutar el codigo
		} else {
			
			Jornada jornadaNoJugada = calendario.get(numeroJornadaARegistrar);
			Jornada jornadaJugada = new Jornada();
			
			// Para cada Fixture de la jornadaNoJugada se pediran los goles de los equipos
			jornadaNoJugada.getPartidos().forEach((partido) -> {
				
				EquipoFutbol local = partido.getEquipoLocal();
				EquipoFutbol visitante = partido.getEquipoVisitante();
				
				// Se muestra cual es el partido del que se pediran los goles
				System.out.println("\n" + local.getNombre() + " vs " + visitante.getNombre() + "\n");
				
				// Se piden los goles del equipo local
				System.out.println("Ingrese los goles del " + local.getNombre() + ": ");
				String linea = scanner.nextLine();
				int golesLocal = -1;
				
				try {
					golesLocal = Integer.parseInt(linea);
				} catch (Exception e) {
						
					}
				
				if (golesLocal <= -1) {
					System.out.println("Tienes que ingresar un numero de goles");
					return;
				}

				// Se piden los goles del equipo visitante
				System.out.println("Ingrese los goles del " + visitante.getNombre() + ": ");
				linea = scanner.nextLine();
				int golesVisitante = -1;
				
				try {
					golesVisitante= Integer.parseInt(linea);                
				} catch (Exception e) { 
						
				}
				
				if (golesVisitante <= -1) {
					System.out.println("Tienes que ingresar un numero de goles");
					return;
				}
				
				// Se crea el partido jugado, solo es tomar el partido sin jugar y agregarle la info de goles
				PartidoJugado partidoJugado = new PartidoJugado(partido, golesLocal, golesVisitante);
				
				// luego se agrega el partido jugado en la nueva jornada
				jornadaJugada.agregarPartido(partidoJugado);
				
				// Se registran los partidos en los equipos para actualizar sus estadisticas 
				local.registrarPartido(golesLocal, golesVisitante);
				visitante.registrarPartido(golesVisitante, golesLocal);
				
			});
			
			jornadaJugada.setFecha(jornadaNoJugada.getFecha());
			jornadaJugada.setIndice(jornadaNoJugada.getIndice());
			// Se registra la nueva jornada en la liga
			liga.registrarJornada(jornadaJugada);
			
		}
		
	}

	
	    private static void MostrarMercado() {
	    	System.out.println("Ingrese el nombre del equipo para consultar presupuesto");
	    	String linea = scanner.nextLine();
	    	
	    	int presupuesto=0;
	    	EquipoFutbol equipo =liga.identificarEquipo(linea);
	        if (liga.equipoPertenece(equipo)) {
	        	presupuesto=equipo.getPresupuesto();
	        	
	        }
	    			
	    	System.out.println("Ingrese la posicion del jugador");
	    	 linea = scanner.nextLine();
	    	 //for (Jugador jugador:liga.getJugadoresEnVenta()) {
	    		 //try {
	    		 //if(Posicion.valueOf(linea).equals(linea));
	    		 
	    			 
	    		 
	    			//liga.getJugadoresDisponibles().add(jugador.getNombre());
	    		// System.out.println(Posicion.valueOf(linea));
	    		// }
	    	//catch(IllegalArgumentException e) {
	    			//System.out.println("Comando invalido");
	    			
	    		//}
	    		 
	    		 
	    	 }
	    		//System.out.println("Los jugadores que estan disponibles son "+liga.getJugadoresDisponibles());	
	    		//return;
	    	//}
	    	
	    //}

	private static void EliminarEquipo() {
		System.out.println("Ingrese el nombre del equipo");
		String linea = scanner.nextLine();
		
		EquipoFutbol equipo = liga.identificarEquipo(linea);
		
		if ( liga.equipoPertenece(equipo) ) {
			liga.eliminarEquipo(equipo);
			System.out.println("Equipo " + equipo.getNombre() + " eliminado");
		} else {
			System.out.println("Ese equipo no esta en la liga");
		}
		
	}
	
	private static void MostrarEquipos() {
		
		System.out.println("\nEquipos de la Liga: \n");
		
		liga.getEquipos().forEach((equipo) -> {
			System.out.println(equipo.getNombre());
		});
		
		// Si la liga no esta completa
		if (!liga.ligaCompleta()) {
			int equiposFaltantes = liga.getNumeroDeEquipos() - liga.getEquipos().size();
			System.out.println("\n" + "Falta anadir " + equiposFaltantes + " equipos a la Liga" + "\n");
		}
		
	}
	
	private static void MostrarEstadisticas() {
        
        System.out.println("Ingrese el nombre del equipo: ");
        String linea = scanner.nextLine();
        
        EquipoFutbol equipo = liga.identificarEquipo(linea);
        
        if ( liga.equipoPertenece(equipo) ) {
        	System.out.println("Estadisticas del " + equipo.getNombre() + "\n");
        	System.out.println("Partidos Ganados: " + equipo.getVictorias());
            System.out.println("Partidos Perdidos: " + equipo.getDerrotas());
            System.out.println("Partidos Empatados: " + equipo.getEmpates());
            System.out.println("Goles Anotados: " + equipo.getGolesAnotados());
            System.out.println("Goles Recibidos: " + equipo.getGolesRecibidos());
            System.out.println("Puntos: " + equipo.getPuntos());
            System.out.println("Partidos Jugados: " + equipo.getPartidosJugados());
            return;
        }
        
        System.out.println("Ese equipo no esta en la liga");
    }
	
	private static void MostrarTablaLiga(){
		
		List<EquipoFutbol> equipos = liga.getEquipos();
   	 
		Collections.sort(equipos, new Comparador());
		for(EquipoFutbol equipo : equipos) {
			System.out.println("Equipo: " + equipo.getNombre()+" Puntos: "+ equipo.getPuntos()+" Diferencia de Gol: "+ (equipo.getGolesAnotados()-equipo.getGolesRecibidos()));
		}
	}
	
	private static void MostrarCalendario() {
		
		List<Jornada> jornadas = liga.getCalendario();
		
		if (jornadas.isEmpty()) {
			
			System.out.println("Aun no se ha generado el Calendario");
			return;
		
		} else {
			
			if ( liga.isCalendarioListo() ) {
				
				int indiceJornada = 1;
				
				for (Jornada jornada: jornadas) {
					
					System.out.println("\n" + "JORNADA " + indiceJornada + "\n" + jornada.mostrarFecha());
					
					for (Partido partido: jornada.getPartidos()) {
						System.out.println(partido);
					}
					
					System.out.println("");
					indiceJornada++;
					
				}
				
			} else {
				
				int indiceJornada = 1;
				
				for (Jornada jornada: jornadas) {
					
					System.out.println("\n" + "JORNADA " + indiceJornada  + "\nFecha por definir");
					
					for (Partido fixture: jornada.getPartidos()) {
						System.out.println(fixture);
					}
					
					System.out.println("");
					indiceJornada++;
					
				}
				
			}
			
		}
		
	}
	
	private static void GenerarCalendario() {
		
		// Si la liga aun no tiene fixture y ya fueron agregados todos los equipos
		if ( liga.getCalendario().isEmpty() && liga.ligaCompleta()) {
			
			liga.generarFixture();
			MostrarCalendario();
			
		// Si la liga no esta completa
		} else if (!liga.ligaCompleta()) {
			System.out.println("Faltan equipos por agregar");
			return;
		
		// Si la liga ya tiene fixture
		} else {
			System.out.println("El calendario ya fue creado, no se puede crear nuevamente");
			return;
		}
		
	}
	
	private static void AsignarArbitrosFechas() {
		
		if (liga.getCalendario().isEmpty()) {
			System.out.println("El calendario debe ser creado");
			return;
		} else {
			System.out.println("Ingrese la fecha de inicio de la liga: (dd-mm-aaaa)");
			String linea = scanner.nextLine();
			
			Date fechaInicio;
			
	        try {
	        	fechaInicio = new SimpleDateFormat("dd-MM-yyyy").parse(linea);
	        } catch (ParseException ex) {
	            System.out.println("Debes ingresar una fecha valida en formato dd-mm-aaaa");
	            return;
	        }
	        
	        liga.setFechaInicio(fechaInicio);
	        liga.asignarArbitrosFechas();
	        MostrarCalendario();
		}
		
	}
	
	private static void PredecirResultados() {
		
	}
	
	public static void guardar() {
		Serializador.serializarTodo(liga);
	}

	public static void cargar() {
		Deserializador.deserializarTodo(liga);
	}
	
	private static void SalirDelSistema() {
		guardar();
		System.exit(0);
	}
	

}