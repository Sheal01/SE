package awk.vereinsverwaltung.factory;

import awk.vereinsverwaltung.usecase.IAnsprechpartnerPflegen;
import awk.vereinsverwaltung.usecase.IVereinSuchen;
import awk.vereinsverwaltung.usecase.IVereinsdatenPflegen;

public interface IVereinsverwaltungsFactory
{
    IVereinSuchen vereineAnzeigen();

    IVereinsdatenPflegen getVereinPflegen();

    IAnsprechpartnerPflegen getAnsprechpartnerPflegen();

    IVereinSuchen getVereinSuchenPerName(String var1);
}
