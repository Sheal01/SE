package awk.vereinsverwaltung.usecase;

import awk.vereinsverwaltung.entity.VereinTO;

public interface IAnsprechpartnerPflegen
{

    boolean ansprechpartnerAnlegen(String nachname, String vorname, String straße, String hausnummer, String plz, String ort);

    boolean ansprechpartnerAnlegenJPA(String nachname, String vorname, String straße, String hausnummer, String plz, String ort);

    boolean ansprechpartnerLoeschen(String nachname);


}
