package awk.vereinsverwaltung.entity;

import awk.vereinsverwaltung.entity.internal.Ansprechpartner;
import awk.vereinsverwaltung.entity.internal.Verein;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public  class VereinTO implements Serializable
{

    private String name;
    private String ansprechpartner;
    private String mannschaft;

    Collection<String> vereine = new ArrayList();


    public VereinTO(){}


    public Verein toVerein()
    {
        Verein verein = new Verein(this.name, this.ansprechpartner, this.mannschaft);

        return verein;
    }

    public String getName()
    {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getMannschaft()
    {
        return this.mannschaft;
    }

    public void setMannschaft(String mannschaft)
    {
        this.mannschaft = mannschaft;
    }



    public Collection<String> getVereine()
    {
        return this.vereine;
    }


    public String getAnsprechpartner()
    {
        return ansprechpartner;
    }

    public void setAnsprechpartner(String test)
    {
        this.ansprechpartner = test;
    }
}

