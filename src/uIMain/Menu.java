package uIMain;

import java.util.Scanner;



public class Menu {
	public static void main(String[] args) {
		Menu menu= new Menu ();
		menu.printTitulo();
		menu.DisplayMenu();
	}
		
	


	 
	 
	 private void printTitulo() {
		 
		 
		 System.out.println("+-----------------------------------+");
		 System.out.println("|          Menu De                  |");
		 System.out.println("|             La Liga               |");
		 System.out.println("+-----------------------------------+");
	 }
	 	Scanner scanner = new Scanner(System.in);
	 	boolean salir =false;


	 	private void DisplayMenu() {
			
			 while(!salir) {
		            System.out.println("\n Menu De La Liga: ");
		            System.out.println("Cree Un Nuevo Equipo Y Añadalo A La Liga (presione 1)");
		            System.out.println("Eliminar Un Equipo Existente (presione 2)");
		            System.out.println("Mostrar las Estadisticas Por Equipo (presione 3)");
		            System.out.println("Mostrar La Tabla De La Liga (presione 4)");
		            System.out.println("Añadir un Partido Jugado (presione 5)");
		            System.out.println("Mostrar Calendario y Encontrar un Partido (presione 6)");
		            System.out.println("Consultar Mercado De Jugadores (presione 7)");
		            System.out.println("Salir (presione 8)");
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
		                    AnadirPartidoJugado();
		                   break;
		                case 6:
		                    MostrarCalendario();
		                   break;
		                   
		                case 7:
		                	MostrarMercado();
		                	break;
		                	
		                case 8:
		                	salir=true;
		                   
		               
		            default:
		            System.out.println("Comando Incorrecto");
		        }
			 }
		      
		
	 	
	}	
}