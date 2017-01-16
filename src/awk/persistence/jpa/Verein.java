package awk.persistence.jpa;

import javax.persistence.*;

@Entity
public class Verein
{
    @Id
    @Column(length = 100)
    private String name;
    @Column(length = 100)
    private String ansprechpartner;


    public Verein()
    {}

    public Verein(String name, String ansprechpartner)
    {
        this.name = name;
        this.ansprechpartner = ansprechpartner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnsprechpartner() {
        return ansprechpartner;
    }

    public void setAnsprechpartner(String ansprechpartner) {
        this.ansprechpartner = ansprechpartner;
    }
}
