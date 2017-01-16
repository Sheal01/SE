package awk.persistence.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataManager
{

    /*
     Entspricht dem DAO. Statt SQL allerdings mit JPA.
     Gehört eig. in ein anderes Package. Hier ist es nur demonstrativ alles was mit JPA zu tun hat in einem Package.
     */

    public void insertDataVerein(String name, String ansprechpartner)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(new Verein(name, ansprechpartner));

        em.flush();
        em.getTransaction().commit();
        em.close();
        emf.close();
    }


    public void insertDataAnsprechpartner(String nachname, String vorname, String straße, String hausnummer, String plz, String ort)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(new Ansprechpartner(nachname, vorname, straße, hausnummer, plz, ort));

        em.flush();
        em.getTransaction().commit();
        em.close();
        emf.close();

    }



    public void selectDataVerein()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em = emf.createEntityManager();

        for (int i = 1; i < 4; i++)
        {
            Verein v = em.find(Verein.class, i);

            if (v != null)
                System.out.println(v.getName() +" " + v.getAnsprechpartner());
            else
                System.out.println("Verein " + i + " nicht gefunden");
        }

        em.close();
        emf.close();

    }






}
