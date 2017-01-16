package awk.vereinsverwaltung.usecase.impl;


import awk.vereinsverwaltung.entity.VereinTO;
import awk.vereinsverwaltung.entity.internal.Ansprechpartner;
import awk.vereinsverwaltung.entity.internal.Verein;
import awk.vereinsverwaltung.persistence.IvereinsverwaltungDAO;
import awk.vereinsverwaltung.persistence.impl.VereinsverwaltungDAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MannschaftsManager {
    private IvereinsverwaltungDAO einDatenverwalter = new VereinsverwaltungDAO();


    public MannschaftsManager()
    {
    }



    public void vereinHinzufügen(Verein verein)
    {
        this.einDatenverwalter.vereinAnlegen(verein.toVereinTO());
    }

    public void ansprechpartnerHinzufügen(Ansprechpartner ansprechpartner)
    {
        this.einDatenverwalter.ansprechpartnerAnlegen(ansprechpartner.toAnsprechpartnerTO());
    }


    public void vereinAendern(String vereinsnameNeu, String vereinsnameAlt)
    {
        this.einDatenverwalter.vereinÄndern(vereinsnameNeu, vereinsnameAlt);
    }


    public Collection<VereinTO> vereineAnzeigen()
    {
        ArrayList ergebnisListe = new ArrayList();
        VereinTO vereinTO;

        Iterator var3 =  this.einDatenverwalter.vereineAnzeigen().iterator();

        while (var3.hasNext())
        {
            vereinTO =(VereinTO)var3.next();
            ergebnisListe.add(vereinTO.toVerein());
        }

        return ergebnisListe;
    }



    // Suchbar  nach Name
    public VereinTO vereinSuchenPerName(String var1)
    {
        VereinTO suchVereinTO = this.einDatenverwalter.vereinSuchenPerName(var1);

        return suchVereinTO;

    }

    // Suchbar nach Ansprechpartner
    public VereinTO vereinSuchenPerAnsprechpartner(String var2)
    {
        VereinTO suchVereinTO = this.einDatenverwalter.vereinSuchenPerAnsprechpartner(var2);

        return suchVereinTO;

    }


    // nullen des Ansprechpartners in der Tabelle Verein
    public void ansprechpartnerLöschen(String vereinsname)
    {
        this.einDatenverwalter.ansprechpartnerLöschen(vereinsname);
    }


}
