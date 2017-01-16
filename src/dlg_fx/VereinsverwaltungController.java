package dlg_fx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VereinsverwaltungController
{

    // Lädt Verein Anlegen GUI
    @FXML
    public void vereinAnlegenButton(ActionEvent event) throws Exception
    {
        try
        {
            ((Node) (event.getSource())).getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VereinsverwaltungAnlegen.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    // Lädt Verein Suchen GUI
    @FXML
    public void vereinSuchenButton(ActionEvent event) throws Exception
    {
        try
        {
            ((Node) (event.getSource())).getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VereinsverwaltungSuchen.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    // Beendet das Programm
    @FXML
    public void beendenButton(ActionEvent event) throws Exception
    {
        Platform.exit();
    }


}
