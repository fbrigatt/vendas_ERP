/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_view;

import dao.UsuariosDao;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author frede
 */
public class LoginController implements Initializable {

    private int tentativas = 0;
    
    public UsuariosDao loginModel = new UsuariosDao();

    @FXML
    private Label lblStatusConexao;

    @FXML
    private Label lblMensagem;

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtSenha;
    
    @FXML
    private Button btnLogin;
    
    private FadeTransition fadeIn = new FadeTransition(
        Duration.millis(2000)
    );

    @FXML
    private void Login(ActionEvent event) throws Exception {
        //if(txtLogin.getText().equals("Fred") && txtSenha.getText().equals("1234")){
            if (loginModel.verificaLogin(txtLogin.getText(), txtSenha.getText())) {
                 
                UsuariosDao login = new UsuariosDao();
                String usu = UsuariosDao.logado.getNome(); //login.logado(txtLogin.getText()).getUsu_nome();
                                
                ((Node) (event.getSource())).getScene().getWindow().hide();

                //lblMensagem.setText("Bem Vindo " + txtLogin.getText());
                //lblPrincipal.setText("Bem Vindo " + txtLogin.getText());
                
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root = loader.load(getClass().getResource("/view/Principal.fxml").openStream());
                PrincipalController principalController = (PrincipalController)loader.getController();
                //principalController.GetUser(txtLogin.getText());
                principalController.GetUser(usu);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.initModality(Modality.WINDOW_MODAL);
                
                //stage.initStyle(StageStyle.UNDECORATED);
                
                stage.setTitle("Tela Principal. Usuário Logado: " + txtLogin.getText());
                stage.setMinHeight(500);
                stage.setResizable(true);
                stage.setMinWidth(1100);
                stage.show();
            } else {
                lblMensagem.setText("Login ou Senha inválidos!");
                txtLogin.setText("");
                txtSenha.setText("");
             //  if (!lblMensagem.isVisible()) {
                   lblMensagem.setVisible(true);
                   fadeIn.playFromStart();
             //  }
                tentativas += 1;
                if(tentativas < 3){
                  lblMensagem.setText("Login ou Senha inválidos! Tentativa: " + tentativas);  
                } else {
                  Alert alert = new Alert(AlertType.INFORMATION);
                  alert.setTitle("Limite de Tentativas foi excedido");
                  alert.setHeaderText(null);
                  alert.setContentText("O sistema será encerrado!");
                  alert.showAndWait();
                  System.exit(1);
                }
            }
    }
    
    @FXML
    private void Sair(ActionEvent event){
        System.exit(1);
    }
   

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tentativas = 0;
        fadeIn.setNode(lblMensagem);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.setCycleCount(2);
        fadeIn.setAutoReverse(true);
        
        txtLogin.setOnKeyPressed(k ->{
              final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
            if (ENTER.match(k)) {
                txtSenha.requestFocus();
            }
        });
        
        txtSenha.setOnKeyPressed(k ->{
              final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
            if (ENTER.match(k)) {
                btnLogin.requestFocus();
            }
        });

        
    }
    
        

}
