package dlg_fx;

import awk.vereinsverwaltung.factory.impl.VereinsverwaltungsFactory;
import awk.vereinsverwaltung.usecase.IAnsprechpartnerPflegen;
import awk.vereinsverwaltung.usecase.IVereinsdatenPflegen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class VereinAnlegenController
{
    //verein
    @FXML
    private TextField vereinsname;

    //Ansprechpartner
    @FXML
    private TextField vorname;
    @FXML
    private TextField nachname;
    @FXML
    private TextField straße;
    @FXML
    private TextField hausnr;
    @FXML
    private TextField ort;
    @FXML
    private TextField plz;
    @FXML private Label sLabel;

    // Legt den Verein samt Ansprechpartner an
    @FXML
    public void anlegen(ActionEvent event) throws Exception
    {
        VereinsverwaltungsFactory vwFactory = new VereinsverwaltungsFactory();
        IVereinsdatenPflegen vereinsdatenPflegen = vwFactory.getVereinPflegen();

        try
        {
            String eingabeplz = plz.getText();


            // Durch umwandlung in int PLZ 01234 nicht mehr möglich.
            // Aus Fairnessgründen nicht mehr geändert.
            int eplz = Integer.parseInt(eingabeplz);

            Boolean ok, ok2;
            // Datenbank eintrag entweder per SQL oder JPA auswählbar.
            //ok = Boolean.valueOf(vereinsdatenPflegen.vereinAnlegen(vereinsname.getText(), nachname.getText()));
            ok = Boolean.valueOf(vereinsdatenPflegen.vereinAnlegenJPA(vereinsname.getText(), nachname.getText()));


            IAnsprechpartnerPflegen ansprechpartnerPflegen = vwFactory.getAnsprechpartnerPflegen();

            //ok2 = Boolean.valueOf(ansprechpartnerPflegen.ansprechpartnerAnlegen(nachname.getText(), vorname.getText(),straße.getText(),hausnr.getText(),plz.getText(), ort.getText()));
            ok2 = Boolean.valueOf(ansprechpartnerPflegen.ansprechpartnerAnlegenJPA(nachname.getText(), vorname.getText(), straße.getText(), hausnr.getText(), plz.getText(), ort.getText()));

            // Wenn beide Daten erfolgreich eingetragen wurden
            if (ok2 & ok)
            {
                sLabel.setText("Daten angelegt.");
                //System.out.println("Daten angelegt.");
            }
            else
            {
                sLabel.setText("Konnte nicht angelegt werden.");
                //System.out.println("Daten konnten nicht angelegt werden.");
            }

        }
        catch (NumberFormatException ex)
        {
            System.out.println("PLZ muss numerisch sein.");
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
