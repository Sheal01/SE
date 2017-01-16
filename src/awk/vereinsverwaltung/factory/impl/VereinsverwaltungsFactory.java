package awk.vereinsverwaltung.factory.impl;

import awk.vereinsverwaltung.factory.IVereinsverwaltungsFactory;
import awk.vereinsverwaltung.usecase.IAnsprechpartnerPflegen;
import awk.vereinsverwaltung.usecase.IVereinSuchen;
import awk.vereinsverwaltung.usecase.IVereinsdatenPflegen;
import awk.vereinsverwaltung.usecase.impl.AnsprechpartnerPflegen;
import awk.vereinsverwaltung.usecase.impl.VereinSuchen;
import awk.vereinsverwaltung.usecase.impl.VereinsdatenPflegen;


// Zugriff auf die Implementierung der Use Cases

public class VereinsverwaltungsFactory implements IVereinsverwaltungsFactory
{

    public VereinsverwaltungsFactory()
    {}

    public IVereinSuchen vereineAnzeigen()
    {
        return new VereinSuchen();
    }

    public IVereinsdatenPflegen getVereinPflegen()
    {
        return new VereinsdatenPflegen();
    }

    public IAnsprechpartnerPflegen getAnsprechpartnerPflegen()
    {
        return new AnsprechpartnerPflegen();
    }

    public IVereinSuchen getVereinSuchenPerName(String var1)
    {
        return new VereinSuchen();
    }

}
