package com.futbol;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.futbol.model.Asociacion;
import com.futbol.model.Club;
import com.futbol.model.Competicion;
import com.futbol.model.Entrenador;
import com.futbol.model.Jugador;
import com.futbol.repository.AsociacionRepository;
import com.futbol.repository.ClubRepository;
import com.futbol.repository.CompeticionRepository;
import com.futbol.repository.EntrenadorRepository;
import com.futbol.repository.JugadorRepository;

@Component
public class DatosPrueba implements CommandLineRunner {

    private final ClubRepository clubRepo;
    private final EntrenadorRepository entrenadorRepo;
    private final JugadorRepository jugadorRepo;
    private final AsociacionRepository asociacionRepo;
    private final CompeticionRepository competicionRepo;

    public DatosPrueba(ClubRepository clubRepo, EntrenadorRepository entrenadorRepo,
                       JugadorRepository jugadorRepo, AsociacionRepository asociacionRepo,
                       CompeticionRepository competicionRepo) {
        this.clubRepo = clubRepo;
        this.entrenadorRepo = entrenadorRepo;
        this.jugadorRepo = jugadorRepo;
        this.asociacionRepo = asociacionRepo;
        this.competicionRepo = competicionRepo;
    }

    @Override
    @Transactional
    public void run(String... args) {

        // 1) Primero se guardan las entidades de las que depende el Club
        Entrenador entrenador = new Entrenador();
        entrenador.setNombre("Carlos");
        entrenador.setApellido("Gómez");
        entrenador.setEdad(52);
        entrenador.setNacionalidad("Colombiana");
        entrenadorRepo.save(entrenador);

        Jugador j1 = nuevoJugador("Luis", "Pérez", 1, "Portero");
        Jugador j2 = nuevoJugador("Andrés", "Rojas", 4, "Defensa");
        Jugador j3 = nuevoJugador("Mateo", "Díaz", 10, "Mediocampista");
        jugadorRepo.saveAll(List.of(j1, j2, j3));

        Asociacion fcf = new Asociacion();
        fcf.setNombre("Federación Colombiana de Fútbol");
        fcf.setPais("Colombia");
        fcf.setPresidente("Presidente de prueba");
        asociacionRepo.save(fcf);

        Competicion c1 = nuevaCompeticion("Copa Libertadores", 20000000,
                LocalDate.of(2026, 2, 1), LocalDate.of(2026, 11, 28));
        Competicion c2 = nuevaCompeticion("Copa Postobón", 5000000,
                LocalDate.of(2026, 3, 1), LocalDate.of(2026, 10, 30));
        competicionRepo.saveAll(List.of(c1, c2));

        // 2) Ahora sí el Club, con sus 4 relaciones
        Club club = new Club();
        club.setNombre("Santa Fe");
        club.setEntrenador(entrenador);
        club.setJugadores(List.of(j1, j2, j3));
        club.setAsociacion(fcf);
        club.setCompeticiones(List.of(c1, c2));
        clubRepo.save(club);

        // 3) Comprobación en consola
        Club guardado = clubRepo.findById(club.getId()).orElseThrow();
        System.out.println("===== RESULTADO =====");
        System.out.println("Club: " + guardado.getNombre());
        System.out.println("Entrenador: " + guardado.getEntrenador().getNombre());
        System.out.println("Jugadores: " + guardado.getJugadores().size());
        System.out.println("Asociación: " + guardado.getAsociacion().getNombre());
        System.out.println("Competiciones: " + guardado.getCompeticiones().size());
        System.out.println("=====================");
    }

    private Jugador nuevoJugador(String nombre, String apellido, int numero, String posicion) {
        Jugador j = new Jugador();
        j.setNombre(nombre);
        j.setApellido(apellido);
        j.setNumero(numero);
        j.setPosicion(posicion);
        return j;
    }

    private Competicion nuevaCompeticion(String nombre, int premio, LocalDate inicio, LocalDate fin) {
        Competicion c = new Competicion();
        c.setNombre(nombre);
        c.setMontoPremio(premio);
        c.setFechaInicio(inicio);
        c.setFechaFin(fin);
        return c;
    }
}