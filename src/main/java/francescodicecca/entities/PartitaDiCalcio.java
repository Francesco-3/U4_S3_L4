package francescodicecca.entities;

import javax.persistence.Entity;

@Entity
public class PartitaDiCalcio extends Event {
    private String squadraDiCasa;
    private String ospite;
    private String squadraVincente;
    private int GOLCasa;
    private int GOLospite;

    public PartitaDiCalcio() {}

    public PartitaDiCalcio(String squadraDiCasa, String ospite, String squadraVincente, int GOLCasa, int GOLospite) {
        this.squadraDiCasa = squadraDiCasa;
        this.ospite = ospite;
        this.squadraVincente = squadraVincente;
        this.GOLCasa = GOLCasa;
        this.GOLospite = GOLospite;
    }

    public String getSquadraDiCasa() { return squadraDiCasa; }
    public void setSquadraDiCasa(String squadraDiCasa) { this.squadraDiCasa = squadraDiCasa; }

    public String getSquadraVincente() { return squadraVincente; }
    public void setSquadraVincente(String squadraVincente) { this.squadraVincente = squadraVincente; }

    public String getOspite() { return ospite; }
    public void setOspite(String ospite) { this.ospite = ospite; }

    public int getGOLCasa() { return GOLCasa; }
    public void setGOLCasa(int GOLCasa) { this.GOLCasa = GOLCasa; }

    public int getGOLospite() { return GOLospite; }
    public void setGOLospite(int GOLospite) { this.GOLospite = GOLospite; }

    @Override
    public String toString() {
        return "Partita: " + '\n' +
                "Squadra di Casa: " + squadraDiCasa + '\n' +
                "Squadra Ospite: " + ospite + '\n' +
                "Squadra Vincente: " + squadraVincente + '\n' +
                "Gol di Casa: " + GOLCasa + '\n' +
                "Gol ospite: " + GOLospite + '\n';
    }
}
