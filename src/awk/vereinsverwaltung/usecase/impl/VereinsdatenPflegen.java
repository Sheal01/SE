package awk.vereinsverwaltung.usecase.impl;

import awk.persistence.jpa.DataManager;
import awk.vereinsverwaltung.entity.internal.Verein;
import awk.vereinsverwaltung.usecase.IVereinsdatenPflegen;




public class VereinsdatenPflegen implements IVereinsdatenPflegen
{

    public VereinsdatenPflegen()
    {}

    public boolean vereinAnlegen(String name, String nachname)
    {
        MannschaftsManager mannschaftManager = new MannschaftsManager();

        // Eingaben überprüfen - nur auf Nullwerte
        if(name.isEmpty() || nachname.isEmpty())
        {
            return false;
        }

        mannschaftManager.vereinHinzufügen(new Verein(name, nachname) );
        return true;
    }


    public boolean vereinAnlegenJPA(String name, String ansprechpartner)
    {
        // Daten überprüfen
        if (name.isEmpty() || ansprechpartner.isEmpty())
        {
            return false;
        }

        DataManager dm = new DataManager();
        dm.insertDataVerein(name, ansprechpartner);
        return true;
    }


    // return immer true => fehlerhafte Ausführung?
    public boolean vereinAendern(String vereinsnameNeu, String vereinsnameAlt)
    {
        MannschaftsManager mannschaftsManager = new MannschaftsManager();

        mannschaftsManager.vereinAendern(vereinsnameNeu, vereinsnameAlt);

        return true;
    }




}
