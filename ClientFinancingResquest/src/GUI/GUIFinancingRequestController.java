package GUI;

import ServerAPIs.FinancingRequestRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.rmi.RemoteException;

public class GUIFinancingRequestController
{
    //private FinancingRequestRepositoryConcrete repository;

    FinancingRequestRepository objPR;

    @FXML AnchorPane scenePane;
    Stage stage;

    @FXML Button bt_Add;
    @FXML TextField tf_tf_requesterName;
    @FXML TextField tf_propertyType;

    @FXML
    public void onCloseWindow(ActionEvent event) {
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }

    @FXML
    public boolean onAddButtonClicked()
    {
        if (tf_tf_requesterName.getText().equals("")) {
            GUIAlerts.showAlert("Peça não adicionada", "A peça precisa ter um nome.", "Adição inválida.", Alert.AlertType.ERROR);
            return false;
        }

        if (tf_propertyType.getText().equals("")) {
            GUIAlerts.showAlert("Peça não adicionada", "A peça precisa ter uma descrição.", "Adição inválida.", Alert.AlertType.ERROR);
            return false;
        }

        //==============================================================================================================
        // Adição da peça ao repositório

        try {
            this.objPR.addPartToRepository(tf_tf_requesterName.getText(), tf_propertyType.getText());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        //==============================================================================================================

        GUIAlerts.showAlert("Peça adicionada", "A peça " + tf_tf_requesterName.getText() + " foi adicionada ao repositório.", "Peça adicionada com sucesso!", Alert.AlertType.INFORMATION);
        tf_tf_requesterName.setText("");
        tf_propertyType.setText("");

        return true;
    }

    @FXML
    public void receivePartRepositoryObject(FinancingRequestRepository obj){
        this.objPR = obj;
    }
}
