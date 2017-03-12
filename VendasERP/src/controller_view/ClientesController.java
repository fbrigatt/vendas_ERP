/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_view;

import interfaces.ITelaCadastro;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import util.Mensagens;

/**
 * FXML Controller class
 *
 * @author frede
 */
public class ClientesController implements Initializable, ITelaCadastro {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button btnTeste;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    public void onClickTeste(ActionEvent event){
      salvar();    
    }

    
    @Override
    public void salvar() {
        Mensagens.mensagem("Cadastro de Usuários", "Exclusão Cancelada pelo usuário!", Mensagens.INFORMACAO);
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void carregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setarBotoes(boolean... params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
