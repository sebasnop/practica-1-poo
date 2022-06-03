package gestorAplicacion;

import java.util.ArrayList;
//import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class GeneradorFixture {
	
public List<Jornada> getFixtures(Liga liga, boolean incluirFixturesAlReves) {
    	
    	LinkedList<EquipoFutbol> equipos = liga.getEquipos();
        int cantidadEquipos = equipos.size();

        // Genera los fixtures usando un algoritmo c�clico.
        int jornadasTotales = cantidadEquipos - 1;
        int partidosPorJornada = cantidadEquipos / 2;
        List<Jornada> jornadas = new LinkedList<Jornada>();

        for (int numeroDeJornada = 0; numeroDeJornada < jornadasTotales; numeroDeJornada++) {
            
        	Jornada jornada = new Jornada(new ArrayList<Partido>());
            
            for (int partido = 0; partido < partidosPorJornada; partido++) {
            	
                int local = (numeroDeJornada + partido) % (cantidadEquipos - 1);
                int visitante = (cantidadEquipos - 1 - partido + numeroDeJornada) % (cantidadEquipos - 1);
                // El �ltimo equipo permanece en el mismo lugar mientras los dem�s rotan a su alrededor.
                if (partido == 0) {
                    visitante = cantidadEquipos - 1;
                }
                jornada.agregarPartido(new Fixture(equipos.get(local), equipos.get(visitante)));
            }
            jornadas.add(jornada);
        }

        // Intercalar para que los juegos locales y fuera de casa est�n dispersos de manera uniforme.
        List<Jornada> intercalado = new LinkedList<Jornada>();

        int evn = 0;
        int odd = (cantidadEquipos / 2);
        for (int i = 0; i < jornadas.size(); i++) {
            if (i % 2 == 0) {
                intercalado.add(jornadas.get(evn++));
            } else {
                intercalado.add(jornadas.get(odd++));
            }
        }

        jornadas = intercalado;

        // El �ltimo equipo no puede ser visitante siempre,
        // as� que se cambia a locales en jornadas impares.
        for (int numeroDeJornada = 0; numeroDeJornada < jornadas.size(); numeroDeJornada++) {
        	
            if (numeroDeJornada % 2 == 1) {
                Partido fixture = jornadas.get(numeroDeJornada).getPartidos().get(0);
                jornadas.get(numeroDeJornada).getPartidos().set(0, new Fixture(fixture.getEquipoVisitante(), fixture.getEquipoLocal()));
            }
        }
        
        if(incluirFixturesAlReves){
            List<Jornada> fixturesAlReves = new LinkedList<Jornada>();
            
            for(Jornada jornada: jornadas){
                
            	Jornada jornadaAlReves = new Jornada();
                
                for(Partido fixture: jornada.getPartidos()){
                    
                	jornadaAlReves.agregarPartido(new Fixture(fixture.getEquipoVisitante(), fixture.getEquipoLocal()));
                	
                }
                
                fixturesAlReves.add(jornadaAlReves);
            }
            jornadas.addAll(fixturesAlReves);
        }

        return jornadas;
    }

}
