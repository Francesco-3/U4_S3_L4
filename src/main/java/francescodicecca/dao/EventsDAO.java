package francescodicecca.dao;

import francescodicecca.entities.Event;
import francescodicecca.entities.PartitaDiCalcio;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.List;

public class EventsDAO {
    private final EntityManager em;

    public EventsDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Event evento) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(evento);
            t.commit();
            System.out.println("Evento - " + evento.getTitolo() + " - creato!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Event findById(long id) {
        return em.find(Event.class, id);
    }

    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Event found = em.find(Event.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Evento eliminato");
            } else System.out.println("Evento non trovato");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<PartitaDiCalcio> getPartitaDiCalcio() {
        TypedQuery<PartitaDiCalcio> query = em.createQuery("SELECT pc FROM PartitaDiCalcio pc ", PartitaDiCalcio.class);
        return query.getResultList();
    }
}
