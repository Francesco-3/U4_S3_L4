package francescodicecca.entities;

import javax.persistence.*;

@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Person persona;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Event evento;
    @Enumerated(EnumType.STRING)
    private State stato;

    public Attendance() {
    }

    public Attendance(Person persona, Event evento) {
        this.persona = persona;
        this.evento = evento;
        this.stato = State.DA_CONFERMARE;
    }

    public long getId() {
        return id;
    }


    public Person getPersona() {
        return persona;
    }

    public void setPersona(Person persona) {
        this.persona = persona;
    }

    public Event getEvento() {
        return evento;
    }

    public void setEvento(Event evento) {
        this.evento = evento;
    }

    public State getStato() {
        return stato;
    }

    public void setStato(State stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }
}
