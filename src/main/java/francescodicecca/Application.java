package francescodicecca;

import com.github.javafaker.Faker;
import francescodicecca.dao.AttendancesDAO;
import francescodicecca.dao.EventsDAO;
import francescodicecca.dao.LocationsDAO;
import francescodicecca.dao.PeopleDAO;
import francescodicecca.entities.*;
import francescodicecca.exceptions.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventsDAO eventsDAO = new EventsDAO(em);
        Faker faker = new Faker(Locale.ITALY);
        LocationsDAO locationsDAO = new LocationsDAO(em);
        PeopleDAO peopleDAO = new PeopleDAO(em);
        AttendancesDAO attendancesDAO = new AttendancesDAO(em);
        Random rndm = new Random();

        /* ******************** SALVATAGGIO LOCATIONS, UTENTI E EVENTI ************************

        Location location1 = new Location(faker.address().city(), faker.address().cityName());
        locationsDAO.save(location1);

        Location location2 = new Location(faker.address().city(), faker.address().cityName());
        locationsDAO.save(location2);

        Person person1 = new Person(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(),  LocalDate.now(), rndm.nextInt(0, 2) == 0 ? 'M' : 'F');
        peopleDAO.save(person1);

        for (int i = 0; i < 20; i++) {
            eventsDAO.save(new Event(
                    faker.chuckNorris().fact(),
                    LocalDate.of(rndm.nextInt(2023, 2025),
                            rndm.nextInt(1, 13),
                            rndm.nextInt(1, 29)),
                    faker.lorem().fixedString(50),
                    rndm.nextInt(1, 3) == 1 ? EventType.PRIVATO : EventType.PUBBLICO,
                    rndm.nextInt(1, 1000),rndm.nextInt(0, 2) == 0 ? location1: location2));
        }

        // ******************** PARTECIPAZIONE AD UN EVENTO ************************

        Person person = peopleDAO.findById(3);
        Event event = eventsDAO.findById(23);

        Attendance partecipazione = new Attendance(person, event);
        attendancesDAO.save(partecipazione);

        // Stampo eventi a cui partecipa la persona 23
        person.getListaPartecipazioni().forEach(System.out::println);

        // Stampo elenco partecipanti evento 24
        event.getListaPartecipazioni().forEach(System.out::println);

        // ******************** CASCADING ************************

        // Eliminando un evento dovrebbe eliminare anche le partecipazioni ad esso collegate
        eventsDAO.findByIdAndDelete(24);*/

        /*PartitaDiCalcio JuveMilan = new PartitaDiCalcio("Juve", "Milan", "Milan", 3, 5);
        PartitaDiCalcio InterRoma = new PartitaDiCalcio("Inter", "Roma", "Inter", 2, 1);
        PartitaDiCalcio NapoliLazio = new PartitaDiCalcio("Napoli", "Lazio", "Lazio", 0, 2);
        PartitaDiCalcio FiorentinaAtalanta = new PartitaDiCalcio("Fiorentina", "Atalanta", "Fiorentina", 4, 3);
        PartitaDiCalcio TorinoSampdoria = new PartitaDiCalcio("Torino", "Sampdoria", "Pareggio", 1, 1);

        eventsDAO.save(JuveMilan);
        eventsDAO.save(InterRoma);
        eventsDAO.save(NapoliLazio);
        eventsDAO.save(FiorentinaAtalanta);
        eventsDAO.save(TorinoSampdoria);*/

        List<PartitaDiCalcio> partite = eventsDAO.getPartitaDiCalcio();
        partite.forEach(System.out::println);

        em.close();
        emf.close();
    }
}
