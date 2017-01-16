package awk.vereinsverwaltung.usecase;

import awk.vereinsverwaltung.entity.VereinTO;
import awk.vereinsverwaltung.entity.internal.Ansprechpartner;

import java.util.Collection;

public interface IVereinSuchen
{

    VereinTO vereinSuchenPerName(String var5);

    VereinTO vereinSuchenPerAnsprechpartner(String var6);

    Collection<VereinTO> vereineAnzeigen();


}
