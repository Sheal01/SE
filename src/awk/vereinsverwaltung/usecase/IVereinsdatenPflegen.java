package awk.vereinsverwaltung.usecase;


public interface IVereinsdatenPflegen
{
    boolean vereinAnlegen(String name, String nachname);

    boolean vereinAnlegenJPA(String name, String ansprechpartner);

    boolean vereinAendern(String vereinsnameNeu, String vereinsnameAlt);
}
