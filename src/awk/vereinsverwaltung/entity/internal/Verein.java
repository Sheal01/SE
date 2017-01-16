package awk.vereinsverwaltung.entity.internal;

import awk.vereinsverwaltung.entity.VereinTO;
import java.io.Serializable;


public class Verein implements Serializable
{

    private String name;
    private String ansprechpartner;
    private String mannschaft;


    public Verein()
    {}

    public Verein(String name)
    {
        this.name = name;
    }


    public Verein(String name, String ansprechpartner)
    {
        this.name = name;
        this.ansprechpartner = ansprechpartner;
    }

    public Verein(String name, String ansprechpartner, String mannschaft)
    {
        this.name = name;
        this.ansprechpartner = ansprechpartner;
        this.mannschaft = mannschaft;
    }


    public Verein(VereinTO einVereinTO)
    {
        this.name = einVereinTO.getName();
        this.ansprechpartner = einVereinTO.getAnsprechpartner();
    }


    public VereinTO toVereinTO()
    {
        VereinTO vereinTO = new VereinTO();
        vereinTO.setName(this.name);
        vereinTO.setAnsprechpartner(this.ansprechpartner);

        return vereinTO;
    }


    public String getName()
    {
        return this.name;
    }

    public String getAnsprechpartner()
    {
        return this.ansprechpartner;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAnsprechpartner(String ansprechpartner)
    {
        this.ansprechpartner = ansprechpartner;
    }


    public String getMannschaft()
    {
        return this.mannschaft;
    }


    public void setMannschaft(String mannschaft)
    {
        this.mannschaft = mannschaft;
    }


    public boolean equals(Object o)
    {
        Verein v = (Verein)o;
        return this.name.equalsIgnoreCase(v.name) && this.ansprechpartner.equals(v.ansprechpartner);
    }


}
