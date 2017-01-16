package awk.vereinsverwaltung.usecase.impl;


import awk.persistence.jpa.DataManager;
import awk.vereinsverwaltung.entity.internal.Ansprechpartner;
import awk.vereinsverwaltung.usecase.IAnsprechpartnerPflegen;

public class AnsprechpartnerPflegen implements IAnsprechpartnerPflegen
{

    public AnsprechpartnerPflegen()
    {}

    public boolean ansprechpartnerAnlegen(String nachname, String vorname, String straße, String hausnummer, String plz, String ort)
    {
        MannschaftsManager mannschaftManager = new MannschaftsManager();
        mannschaftManager.ansprechpartnerHinzufügen(new Ansprechpartner(nachname, vorname, straße, hausnummer,plz,ort));


        // Eingaben überprüfen
        // Textfelder nicht leer
        // PLZ numerisch und fünfstellig
        if (nachname.isEmpty() | vorname.isEmpty() | straße.isEmpty() | hausnummer.isEmpty() | plz.isEmpty() | ort.isEmpty())
        {
            return false;
        }

        if (!plz.matches("[0-9]+") & plz.length() == 5)
        {
            return false;
        }

        return true;

    }


    public boolean ansprechpartnerAnlegenJPA(String nachname, String vorname, String strasse, String hausnummer, String plz, String ort)
    {

        if (nachname.isEmpty() | vorname.isEmpty() | strasse.isEmpty() | hausnummer.isEmpty() | plz.isEmpty() | ort.isEmpty())
        {
            return false;
        }

        if (!plz.matches("[0-9]+") & plz.length() == 5)
        {
            return false;
        }

        DataManager dm = new DataManager();

        dm.insertDataAnsprechpartner(nachname,vorname,strasse,hausnummer,plz,ort);
        return true;
    }


    public boolean ansprechpartnerLoeschen(String nachname)
    {
        MannschaftsManager mannschaftsManager = new MannschaftsManager();
        mannschaftsManager.ansprechpartnerLöschen(nachname);

        return true;
    }



}
