package awk.vereinsverwaltung.entity;

import awk.vereinsverwaltung.entity.internal.Ansprechpartner;

import java.util.ArrayList;
import java.util.Collection;

public class AnsprechpartnerTO
{

    String nachname;
    String vorname;
    String straße;
    String hausnummer;
    String plz;
    String ort;

    Collection<String> Ansprechpartner = new ArrayList();


    public AnsprechpartnerTO()
    {}


    public Ansprechpartner toAnsprechpartner()
    {
        Ansprechpartner ansprechpartner = new Ansprechpartner();

        return ansprechpartner;
    }


    public String getNachname()
    {
        return nachname;
    }

    public void setNachname(String nachname)
    {
        this.nachname = nachname;
    }

    public String getVorname()
    {
        return vorname;
    }

    public void setVorname(String vorname)
    {
        this.vorname = vorname;
    }

    public String getStraße()
    {
        return straße;
    }

    public void setStraße(String straße)
    {
        this.straße = straße;
    }

    public String getHausnummer()
    {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer)
    {
        this.hausnummer = hausnummer;
    }

    public String getPlz()
    {
        return plz;
    }

    public void setPlz(String plz)
    {
        this.plz = plz;
    }

    public String getOrt()
    {
        return ort;
    }

    public void setOrt(String ort)
    {
        this.ort = ort;
    }

    public Collection<String> getAnsprechpartner()
    {
        return Ansprechpartner;
    }

    public void setAnsprechpartner(Collection<String> ansprechpartner)
    {
        Ansprechpartner = ansprechpartner;
    }
}
