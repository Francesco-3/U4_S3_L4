package francescodicecca.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "event")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_evento", discriminatorType = DiscriminatorType.STRING)
public abstract class Event {
    @Id
    @GeneratedValue
    private long id;

    private String titolo;
    private LocalDate dataEvento;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private EventType eventType;
    private int numeroMassimoPartecipanti;

    @ManyToOne
    @JoinColumn(name = "luogo_evento_id")
    private Location luogoEvento;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.REMOVE)
    private List<Attendance> listaPartecipazioni;

    public Event() {
    }

    public Event(String titolo, LocalDate dataEvento, String descrizione, EventType eventType, int numeroMassimoPartecipanti, Location location) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.eventType = eventType;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.luogoEvento = location;
    }

    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Location getLuogoEvento() {
        return luogoEvento;
    }

    public void setLuogoEvento(Location luogoEvento) {
        this.luogoEvento = luogoEvento;
    }

    public List<Attendance> getListaPartecipazioni() {
        return listaPartecipazioni;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + eventType +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                ", location=" + luogoEvento +
                '}';
    }
}
