package dlg_fx;

import awk.vereinsverwaltung.entity.VereinTO;
import awk.vereinsverwaltung.factory.impl.VereinsverwaltungsFactory;
import awk.vereinsverwaltung.usecase.IAnsprechpartnerPflegen;
import awk.vereinsverwaltung.usecase.IVereinSuchen;
import awk.vereinsverwaltung.usecase.IVereinsdatenPflegen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class VereinSuchenController
{
    //Suchkriterien
    @FXML
    private TextField sVereinsname;
    @FXML
    private TextField sAnsprechpartner;
    @FXML
    private Button bSuchen;

    //Suchergebnisse
    @FXML
    private TextField seVereinsname;
    @FXML
    private TextField seAnsprechpartner;
    @FXML
    private Button bAendern;
    @FXML
    private Button bAbbrechen;
    @FXML
    private Label lmeldungen;


    // Sucht nach Vereinsname oder Ansprechpartner
    @FXML
    public void suchen(ActionEvent event) throws Exception
    {
        // Wenn keine Kriterien eingegeben wurden
        if (sVereinsname.getText().isEmpty() & sAnsprechpartner.getText().isEmpty())
        {
            lmeldungen.setText("Suchkriterien eingeben.");

            // Alternativ könnten alle Vereine angezeigt werden...dazu die Methode: vereineAnzeigen
        }

        // Wenn Vereinsname nicht leer ist
        if(!sVereinsname.getText().isEmpty())
        {
            VereinsverwaltungsFactory vwFactory = new VereinsverwaltungsFactory();
            IVereinSuchen vereinSuchen = vwFactory.getVereinSuchenPerName(sVereinsname.getText());

            VereinTO vereinTO = vereinSuchen.vereinSuchenPerName(sVereinsname.getText());

            seVereinsname.setText(vereinTO.getName());

            if(vereinTO.getAnsprechpartner().isEmpty())
            {
                seAnsprechpartner.setText("Leer.");
            }
            else
            {
                seAnsprechpartner.setText(vereinTO.getAnsprechpartner());
            }
        }


        // Wenn Ansprechpartner nicht leer ist
        if(!sAnsprechpartner.getText().isEmpty())
        {
            VereinsverwaltungsFactory vwFactory = new VereinsverwaltungsFactory();
            IVereinSuchen vereinSuchen = vwFactory.getVereinSuchenPerName(sAnsprechpartner.getText());

            VereinTO vereinTO1 = vereinSuchen.vereinSuchenPerAnsprechpartner(sAnsprechpartner.getText());

            seVereinsname.setText(vereinTO1.getName());

            try
            {
             seAnsprechpartner.setText(vereinTO1.getAnsprechpartner());
            }
            catch (NullPointerException ex)
            {
                seAnsprechpartner.setText("Leer.");
            }




        }
  
    }



    // Aenderung von Vereinsname bzw. Ansprechpartner
    // Die Änderung wird in die Felder des Suchergebnis geschrieben
    @FXML
    public void aendern(ActionEvent event) throws Exception
    {
        VereinsverwaltungsFactory vwFactory = new VereinsverwaltungsFactory();
        IVereinsdatenPflegen vereinsdatenPflegen = vwFactory.getVereinPflegen();

        boolean ok;
        // Problem: Transportobjekt kann keine zwei Namen annehmen. Workaround mit String Parametern
        // Lösungsidee: Übergabe von zwei Objekten?
        ok = vereinsdatenPflegen.vereinAendern(seVereinsname.getText(), sVereinsname.getText());

        if (ok)
        {
            lmeldungen.setText("Verein geändert.");
        }
        else
        {
            lmeldungen.setText("Verein konnte nicht geändert werden.");
        }

    }


    // nulled den Ansprechpartner in der Datenbank. Vorher wird nach dem Verein gesucht, wo der
    // Ansprechpartner gelöscht werden soll.
    @FXML
    public void loeschen(ActionEvent event) throws Exception
    {
        VereinsverwaltungsFactory vwFactory = new VereinsverwaltungsFactory();
        IAnsprechpartnerPflegen ansprechpartnerPflegen = vwFactory.getAnsprechpartnerPflegen();


        boolean ok;

        // schöner wäre mit einer AlertBox das Löschen nochmal bestätigen lassen.
        ok = ansprechpartnerPflegen.ansprechpartnerLoeschen(seVereinsname.getText());

        if (ok)
        {
            lmeldungen.setText("Ansprechpartner gelöscht.");
        }
        else
        {
            lmeldungen.setText("Ansprechpartner konnte nicht gelöscht werden.");
        }
    }


    // Kehrt zurueck in die Vereinsverwaltung
    @FXML
    public void abbrechen(ActionEvent event) throws Exception
    {
        try
        {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Vereinsverwaltung.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }



}
