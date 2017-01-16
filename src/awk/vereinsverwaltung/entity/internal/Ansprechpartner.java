package awk.vereinsverwaltung.entity.internal;

import awk.vereinsverwaltung.entity.AnsprechpartnerTO;

import java.util.ArrayList;
import java.util.Collection;

public class Ansprechpartner {

    String nachname;
    String vorname;
    String straße;
    String hausnummer;
    String plz;
    String ort;

    Collection<String> Ansprechpartner = new ArrayList();

    public Ansprechpartner() {
    }


    public Ansprechpartner(String nachname, String vorname, String straße, String hausnummer, String plz, String ort) {
        this.nachname = nachname;
        this.vorname = vorname;
        this.straße = straße;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
    }


    public AnsprechpartnerTO toAnsprechpartnerTO() {
        AnsprechpartnerTO ansprechpartnerTO = new AnsprechpartnerTO();

        ansprechpartnerTO.setNachname(this.nachname);
        ansprechpartnerTO.setVorname(this.vorname);
        ansprechpartnerTO.setStraße(this.straße);
        ansprechpartnerTO.setHausnummer(this.hausnummer);
        ansprechpartnerTO.setPlz(this.plz);
        ansprechpartnerTO.setOrt(this.ort);

        return ansprechpartnerTO;
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
        this.hausnummer = hausnummer;
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

    public Collection<String> getAnsprechpartner() {
        return Ansprechpartner;
    }

    public void setAnsprechpartner(Collection<String> ansprechpartner) {
        Ansprechpartner = ansprechpartner;
    }
}

