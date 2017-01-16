package awk.persistence.jpa;

import javax.persistence.*;

@Entity
public class Ansprechpartner
{
    // Merke aus ß wird ss
    @Id
    @Column(length = 50)
    private String nachname;
    @Column(length = 50)
    private String vorname;
    @Column(length = 50)
    private String straße;
    @Column(length = 10)
    private String hausnummer;
    @Column(length = 5)
    private String plz;
    @Column(length = 50)
    private String ort;



    public Ansprechpartner()
    {}

    public Ansprechpartner(String nachname, String vorname, String straße, String hausnummer, String plz, String ort) {
        this.nachname = nachname;
        this.vorname = vorname;
        this.straße = straße;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
    }


    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getStraße() {
        return straße;
    }

    public void setStraße(String straße) {
        this.straße = straße;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        hausnummer = hausnummer;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
}
