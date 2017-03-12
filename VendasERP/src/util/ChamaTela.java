/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
//import com.UsuariosController;
//import com.PrincipalController;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.stage.StageStyle;

/**
 *
 * @author frede
 */
public class ChamaTela {

    public void mostraTela(String nomeTela) {
        try {
            // CARREGA O XML
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nomeTela));
            loader.load();
            // CARREGA O RAIZ DO XML
            Parent root = loader.getRoot();
            // CRIA UMA CENA
            //Scene scene = new Scene(root, 800, 600);
            Scene scene = new Scene(root);
            // CRIA UM STAGE DA CENA
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            //stage.setMaximized(true);
            
            //stage.initStyle(StageStyle.UNDECORATED);

            stage.initModality(Modality.APPLICATION_MODAL);
            if (nomeTela.equals("Usuarios.fxml")) {
              //  UsuariosController usuariosController = loader.getController();
              //  usuariosController.setStage(stage);
            }
            stage.show();
        } catch (Exception ex) {
            //Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        }
    }
    
}
