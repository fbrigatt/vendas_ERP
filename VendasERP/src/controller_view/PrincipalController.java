/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_view;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.ChamaTela;

/**
 * FXML Controller class
 *
 * @author frede
 */
public class PrincipalController extends ChamaTela implements Initializable {
    
    @FXML
    private Label lblPrincipal;
    
    @FXML
    private Label lblDataCompleta;
    
    @FXML
    private Label lblUsuarioLogado;

    @FXML
    private Label lblDataValidade;

    @FXML
    private Label lblVersao; 

    @FXML
    private ImageView imgLogo;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Efeito de Espelho no Logo
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        imgLogo.setEffect(r);
        
       /* 
        //Efeito de Sombra 
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
        lblPrincipal.setEffect(dropShadow);
       */ 
       

    }
    
    
    @FXML
    private void onClickUsuarios(ActionEvent event) {
        //mostraTela("Usuarios.fxml");
        mostraTela("/view/Usuarios.fxml");
    }
    
    @FXML
    private void onClickClientes(ActionEvent event){
        mostraTela("/view/Clientes.fxml");
    }
    
    
    public void GetUser(String usuario){
        //SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sd = new SimpleDateFormat("  EEEEEE ',' dd ' de 'MMMM ' de ' yyyy");
        Date dataAtual = new Date(System.currentTimeMillis());
        String data = sd.format(dataAtual);
        
       // lblPrincipal.setText(data + "  Usuário Logado: " + usuario);
        
//        lblDataCompleta.setPrefWidth(500);
        lblDataCompleta.setText(data);
        
//        lblUsuarioLogado.setPrefWidth(420);
        lblUsuarioLogado.setText("Usuário Logado: " + usuario);
        
//        lblDataValidade.setPrefWidth(200);
        lblDataValidade.setText("Data: 01/01/2017");
        
        //lblVersao.setPrefWidth(50);
//        lblVersao.autosize();
        lblVersao.setText("Versão dos Sistema: 1.0");
        
        
    }
    
}
