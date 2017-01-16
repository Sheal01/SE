package awk.vereinsverwaltung.persistence.impl;

import awk.vereinsverwaltung.entity.AnsprechpartnerTO;
import awk.vereinsverwaltung.entity.VereinTO;
import awk.vereinsverwaltung.persistence.IvereinsverwaltungDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import static awk.persistence.Persistence.*;


// SQL Befehle here

public class VereinsverwaltungDAO implements IvereinsverwaltungDAO {

    public VereinsverwaltungDAO() {}


    public void vereinAnlegen(VereinTO var1)
    {
        Connection aConnection = getConnection();

        try
        {
            // getAnsprechpartner = Nachname
            executeUpdateStatement(aConnection,
                    "INSERT INTO Verein VALUES ( \'" + var1.getName() + "\'," +  "\'" + var1.getAnsprechpartner() + "\'" + ")");
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            closeConnection(aConnection);
        }
    }


    public void ansprechpartnerAnlegen(AnsprechpartnerTO var2)
    {
        Connection aConnection = getConnection();

        try
        {
            executeUpdateStatement(aConnection,
                    "INSERT INTO Ansprechpartner VALUES ( \'" + var2.getNachname() + "\'," + "\'" + var2.getVorname() + "\'," + "\'" + var2.getStraße() + "\'," + "\'" + var2.getHausnummer() + "\'," + "\'" + var2.getPlz() + "\'," + "\'" + var2.getOrt() + "\'"+")");
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            closeConnection(aConnection);
        }
    }

    // Liest die Daten aus der Datenbank
    public VereinTO resultToVereinTO(ResultSet resultSet)
    {
        VereinTO vereinTO = new VereinTO();
        try
        {
            vereinTO.setName(resultSet.getString("NAME"));
            vereinTO.setAnsprechpartner((resultSet.getString(2)));
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        return vereinTO;
    }


    // Zeigt alle gespeicherten Vereine an.
    @Override
    public Collection<VereinTO> vereineAnzeigen()
    {
        Connection aConnection = getConnection();
        VereinTO foundVereineTO = null;
        ArrayList vereineTOListe = new ArrayList();

        String sql = "SELECT * FROM VEREIN";

        try
        {
            ResultSet resultSet = executeQueryStatement(aConnection, sql);

            while(resultSet.next())
            {
                foundVereineTO = this.resultToVereinTO(resultSet);
                vereineTOListe.add(foundVereineTO);
            }

        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return vereineTOListe;
        }
        finally
        {
            closeConnection(aConnection);
        }

        return vereineTOListe;
    }



    // Verein ändern bezieht sich lediglich auf den Vereinsnamen
    // Für die Änderung mit dem Ansprechpartner bedarf es zusätzlichen Parametern

    public void vereinÄndern(String var1, String vereinsname)
    {
        Connection aConnection = getConnection();

        try
        {
            // BeispielSql Befehl: UPDATE VEREIN SET NAME = 'Test' WHERE Name = 'Verein'
            executeUpdateStatement(aConnection,
                        "UPDATE VEREIN SET Name = '" + var1 +"\'" + "WHERE Name = '" + vereinsname + "\'");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            closeConnection(aConnection);
        }
    }



    public void ansprechpartnerLöschen(String var3)
    {
        Connection aConnection = getConnection();

        try
        {
            // UPDATE Verein Set Ansprechpartner = null WHERE Name = 'User01'
            executeUpdateStatement(aConnection,
                    "Update Verein SET Ansprechpartner = null WHERE Name = '" + var3 + "\'");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            closeConnection(aConnection);
        }
    }


    // Suche nach Vereinsname
    public VereinTO vereinSuchenPerName(String var4)
    {
        VereinTO foundVereineTO = null;

        Connection aConnection = getConnection();

        try
        {
           ResultSet rs = executeQueryStatement(aConnection,
                    "SELECT * FROM Verein WHERE Name = '" + var4 + "\'");

           while(rs.next())
           {
               foundVereineTO = this.resultToVereinTO(rs);
           }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            closeConnection(aConnection);
        }



        return foundVereineTO;
    }


    // Suche nach Ansprechpartner
    public VereinTO vereinSuchenPerAnsprechpartner(String var5)
    {
        VereinTO foundVereineTO = null;

        Connection aConnection = getConnection();

        try
        {
            ResultSet rs = executeQueryStatement(aConnection,
                    "SELECT Name, Ansprechpartner FROM Verein WHERE Ansprechpartner = '" + var5 + "\'");

            while(rs.next())
            {
                foundVereineTO = this.resultToVereinTO(rs);

            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            closeConnection(aConnection);
        }

        return foundVereineTO;

    }




}
