package uIMain;


import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

import java.util.Scanner;

import baseDatos.Deserializador;
import baseDatos.Serializador;
import gestorAplicacion.Comparador;
import gestorAplicacion.EquipoFutbol;
import gestorAplicacion.Jornada;
import gestorAplicacion.Liga;
import gestorAplicacion.Partido;
import gestorAplicacion.PartidoJugado;



public class Menu {
	
	static Scanner scanner = new Scanner(System.in);

	static Liga liga = new Liga(4);
	
	public static void main(String[] args) {
		 Deserializador.deserializarTodo();
		 
		//EquipoFutbol equipo1 = new EquipoFutbol("Barcelona", "Camp Nou", 100000000);
		//EquipoFutbol equipo2 = new EquipoFutbol("Liverpool", "Anfield", 120000000);
		 //EquipoFutbol equipo3 = new EquipoFutbol("Marsella", "Velodrome", 60000000);
		 //EquipoFutbol equipo4 = new EquipoFutbol("Dortmund", "Signal Iduna", 300000000);
		
		 //liga.anadirEquipo(equipo1);
		 //liga.anadirEquipo(equipo2);
		 //liga.anadirEquipo(equipo3);
		 //liga.anadirEquipo(equipo4);
		
		Serializador.serializarTodo();
		boolean salir = false;

		while(!salir) {
			
			System.out.println("----------------------");
			System.out.println("|        Menu De      |");
			System.out.println("|         La Liga     |");
			System.out.println("----------------------");
			System.out.println("");
			System.out.println("Cree Un Nuevo Equipo Y Anadalo A La Liga (presione 1)");
			System.out.println("Eliminar Un Equipo Existente (presione 2)");
			System.out.println("Mostrar las Estadisticas Por Equipo (presione 3)");
			System.out.println("Mostrar La Tabla De La Liga (presione 4)");
			System.out.println("Registrar resultados de jornada (presione 5)");
			
			// Creo que deberiamos quitar la siguiente:
			System.out.println("Mostrar calendario y Encontrar un Partido (presione 6)");
			
			System.out.println("Consultar Mercado De Jugadores (presione 7)");
			System.out.println("Generar fixture (presione 8)");
			System.out.println("Mostrar jornadas (presione 9)");
			System.out.println("Salir (presione 10)");
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
				MostrarEstadisticas();
				break;
			case 4 :
				MostrarTablaLiga();
				break;
			case 5:
				RegistrarResultadosJornada();
				break;
			case 6:
				//MostrarCalendario();
				break;
	
			case 7:
				MostrarMercado();
				break;
			
			case 8:
				GenerarFixture();
				break;
			
			case 9:
				MostrarJornadas();
				break;
				
			case 10:
				salir=true;
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
		
		// Se valida que si haya calendario
		if ( calendario.isEmpty() ) {
			
			System.out.println("Primero se debe generar el calendario");
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
		
		LinkedList<EquipoFutbol> equipos = liga.getEquipos();
   	 
		Collections.sort(equipos, new Comparador());
		for(EquipoFutbol equipo : equipos) {
			System.out.println("Equipo: " + equipo.getNombre()+" Puntos: "+ equipo.getPuntos()+" Diferencia de Gol: "+ (equipo.getGolesAnotados()-equipo.getGolesRecibidos()));
		}
	}
	
	private static void MostrarJornadas() {
		
		List<Jornada> jornadas = liga.getCalendario();
		
		if (jornadas.isEmpty()) {
			
			System.out.println("Aun no se ha generado el Fixture");
		
		} else {
		
			for(int i=0; i<jornadas.size(); i++){
			    System.out.println("\n" + "JORNADA " + (i+1));
			    List<Partido> jornada = jornadas.get(i).getPartidos();
			    for(Partido fixture: jornada){
			        System.out.println(fixture);
			    }
			    System.out.println("");
			}
			
		}
		
	}
	
	private static void GenerarFixture() {
		
		// Si la liga aun no tiene fixture y ya fueron agregados todos los equipos
		if ( liga.getCalendario().isEmpty() && liga.ligaCompleta()) {
			
			liga.generarFixture();
			MostrarJornadas();
			
		// Si la liga no esta completa
		} else if (!liga.ligaCompleta()) {
			System.out.println("Faltan equipos por agregar");
			return;
		
		// Si la liga ya tiene fixture
		} else {
			System.out.println("El fixture ya fue creado, no se puede crear nuevamente");
			return;
		}
		
	}
	
	private static void AsignarArbitros() {
		
	}
	
	private static void PredecirResultados() {
		
	}
	

}