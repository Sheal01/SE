package awk.vereinsverwaltung.usecase.impl;

import awk.vereinsverwaltung.entity.VereinTO;
import awk.vereinsverwaltung.entity.internal.Ansprechpartner;
import awk.vereinsverwaltung.entity.internal.Verein;
import awk.vereinsverwaltung.usecase.IVereinSuchen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class VereinSuchen implements IVereinSuchen
{

    public VereinSuchen(){

    }


    // Zeigt eine Liste aller gespeicherten Vereine an
    public Collection<VereinTO> vereineAnzeigen()
    {
        MannschaftsManager mannschaftsManager = new MannschaftsManager();
        Collection vereinListe = mannschaftsManager.vereineAnzeigen();

        if(vereinListe.isEmpty())
        {
            return new ArrayList();
        }
        else
        {
            ArrayList vereineTOListe = new ArrayList();
            Iterator var1 = vereinListe.iterator();

            while(var1.hasNext())
            {
                Verein einVerein = (Verein)var1.next();
                vereineTOListe.add(einVerein.toVereinTO());
            }

            return vereineTOListe;
        }
    }



    // Sucht nach EINEM Verein in der Datenbank anhand des Vereinsnamens
    // Problem: Was ist, wenn mehrere Daten in der DB sind?
    // Lösungsidee: Collection returnen und anschließend durchsuchen.
    @Override
    public VereinTO vereinSuchenPerName(String var5)
    {
        MannschaftsManager mannschaftsManager = new MannschaftsManager();
        VereinTO verein = mannschaftsManager.vereinSuchenPerName(var5);

        return verein;

    }


    // Sucht nach EINEM Ansprechpartner in der Datenbank anhand des Ansprechpartners
    // Problem: Was ist, wenn mehrere Daten in der DB sind?
    // Lösungsidee: Collection returnen und anschließend durchsuchen.
    public VereinTO vereinSuchenPerAnsprechpartner(String var6)
    {
        MannschaftsManager mannschaftsManager = new MannschaftsManager();
        VereinTO verein = mannschaftsManager.vereinSuchenPerAnsprechpartner(var6);

        return verein;
    }


}
