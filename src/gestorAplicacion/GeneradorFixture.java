package gestorAplicacion;

import java.util.LinkedList;
import java.util.List;

public class GeneradorFixture {

    public List<List<Fixture>> getFixtures(LinkedList<EquipoFutbol> equipos, boolean incluirFixturesAlReves) {

        int cantidadEquipos = equipos.size();

        // Genera los fixtures usando un algoritmo cíclico.
        int rondasTotales = cantidadEquipos - 1;
        int partidosPorRonda = cantidadEquipos / 2;
        List<List<Fixture>> rondas = new LinkedList<List<Fixture>>();

        for (int ronda = 0; ronda < rondasTotales; ronda++) {
            List<Fixture> fixtures = new LinkedList<Fixture>();
            for (int partido = 0; partido < partidosPorRonda; partido++) {
                int local = (ronda + partido) % (cantidadEquipos - 1);
                int visitante = (cantidadEquipos - 1 - partido + ronda) % (cantidadEquipos - 1);
                // Last team stays in the same place while the others
                // rotate around it.
                if (partido == 0) {
                    visitante = cantidadEquipos - 1;
                }
                fixtures.add(new Fixture(equipos.get(local), equipos.get(visitante)));
            }
            rondas.add(fixtures);
        }

        // Intercalar para que los juegos locales y fuera de casa estén dispersos de manera uniforme.
        List<List<Fixture>> intercalado = new LinkedList<List<Fixture>>();

        int evn = 0;
        int odd = (cantidadEquipos / 2);
        for (int i = 0; i < rondas.size(); i++) {
            if (i % 2 == 0) {
                intercalado.add(rondas.get(evn++));
            } else {
                intercalado.add(rondas.get(odd++));
            }
        }

        rondas = intercalado;

        // El último equipo no puede ser visitante siempre,
        // así que se cambia a locales en rondas impares.
        for (int numeroDeRonda = 0; numeroDeRonda < rondas.size(); numeroDeRonda++) {
            if (numeroDeRonda % 2 == 1) {
                Fixture fixture = rondas.get(numeroDeRonda).get(0);
                rondas.get(numeroDeRonda).set(0, new Fixture(fixture.getEquipoVisitante(), fixture.getEquipoLocal()));
            }
        }
        
        if(incluirFixturesAlReves){
            List<List<Fixture>> fixturesAlReves = new LinkedList<List<Fixture>>();
            for(List<Fixture> ronda: rondas){
                List<Fixture> rondaAlReves = new LinkedList<Fixture>();
                for(Fixture fixture: ronda){
                    rondaAlReves.add(new Fixture(fixture.getEquipoVisitante(), fixture.getEquipoLocal()));
                }
                fixturesAlReves.add(rondaAlReves);
            }
            rondas.addAll(fixturesAlReves);
        }

        return rondas;
    }
}
