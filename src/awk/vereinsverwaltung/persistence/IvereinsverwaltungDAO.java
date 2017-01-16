package awk.vereinsverwaltung.persistence;

import awk.vereinsverwaltung.entity.AnsprechpartnerTO;
import awk.vereinsverwaltung.entity.VereinTO;

import java.util.Collection;

public interface IvereinsverwaltungDAO
{
    void vereinAnlegen(VereinTO var1);

    void ansprechpartnerAnlegen(AnsprechpartnerTO var2);

    void ansprechpartnerLöschen(String var4);

    void vereinÄndern(String var5, String vereinsname);

    VereinTO vereinSuchenPerName(String var6);

    VereinTO vereinSuchenPerAnsprechpartner(String var7);

    Collection<VereinTO> vereineAnzeigen();
}
