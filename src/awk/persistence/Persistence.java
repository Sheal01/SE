package awk.persistence;

import java.sql.*;

// Verbindung zur Datenbank aufbauen und SQL Statements durchführen

public class Persistence
{
    private String username;
    private String password;


    public Persistence(){}

    // Verbindung zur Datenbank herstellen
    public static Connection getConnection()
    {
        Connection aConnection = null;
        // PC

        // change me
        String pfad = "jdbc:h2:tcp://localhost/~/test";

        try
        {
            Class.forName("org.h2.Driver");
        }
        catch(ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }

        try
        {
            // change me
            aConnection = DriverManager.getConnection(pfad,"sa","admin");
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }

        return aConnection;

    }




    public static void closeConnection(Connection aConnection)
    {
        try
        {
            aConnection.close();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }



    public static void executeUpdateStatement(Connection aConnection, String aStatement) throws SQLException
    {
        Statement stmt = aConnection.createStatement();
        stmt.executeUpdate(aStatement);
    }


    public static ResultSet executeQueryStatement(Connection aConnection, String aStatement) throws SQLException
    {
        ResultSet aResultSet = null;
        Statement stmt = aConnection.createStatement();
        aResultSet = stmt.executeQuery(aStatement);

        return aResultSet;
    }
}
