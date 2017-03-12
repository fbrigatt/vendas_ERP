/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller_view;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import model.Usuarios;
import dao.UsuariosDao;
import interfaces.ITelaCadastro;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import util.Mensagens;

/**
 * FXML Controller class
 *
 * @author frede
 */
public class UsuariosController implements Initializable, ITelaCadastro {

    private Stage stage;

    @FXML
    private Label lblPosicaoBanco;

    @FXML
    private TabPane tabPrincipal;

    @FXML
    private Tab tbPesquisa;

    @FXML
    private Tab tbCadastro;

    @FXML
    private TableView<Usuarios> tblUsuarios;

    @FXML
    private TableColumn<Usuarios, String> clNome;

    @FXML
    private TableColumn<Usuarios, String> clInativo;

    @FXML
    private TableColumn<Usuarios, String> clDataCadastro;

    @FXML
    private TextField tfPesquisar;

    @FXML
    private TextField tfNome;

    @FXML
    private CheckBox ckAtivo;

    @FXML
    private PasswordField tfSenha;

    @FXML
    private Button btnNovo;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnFechar;

    private List<Usuarios> lista = new ArrayList();
    private ObservableList<Usuarios> listaFiltro = FXCollections.observableArrayList();
    int id_atual_usu = 0;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        
        btnNovo.setDisable(false);
        btnSalvar.setDisable(true);
        btnExcluir.setDisable(true);
        
        // Seta o Nome dos Campos da Tabela Usuários nas Colunas do Componente tblUsuarios
        clNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        clInativo.setCellValueFactory(new PropertyValueFactory<>("inativo"));
        clDataCadastro.setCellValueFactory(new PropertyValueFactory<>("data_cadastro"));

        tblUsuarios.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        // Carrega os dados do banco na tblUsuarios
        listar();

        // Posiciona no Primeiro Registro
        tblUsuarios.getSelectionModel().selectFirst();

        // Seta o Campo Data_Cadastro na coluna
        clDataCadastro.setCellValueFactory(
                usuarios -> {
                    SimpleStringProperty property = new SimpleStringProperty();
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    property.setValue(dateFormat.format(usuarios.getValue().getData_Cadastro()));
                    return property;
                }
        );

        // Seta o Campo Inativo na coluna
        clInativo.setCellValueFactory(
                usuarios -> {
                    SimpleStringProperty property = new SimpleStringProperty();
                    property.setValue(usuarios.getValue().isInativo() ? "Sim" : "Não");
                    return property;
                }
        );

        listar();
        tblUsuarios.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    if (mouseEvent.getClickCount() == 2) {
                        // Seleciona 2ª Aba - CADASTRO
                        tabPrincipal.getSelectionModel().select(1);
                        tbCadastro.setDisable(false);
                        btnNovo.setDisable(true);
                        btnSalvar.setDisable(false);
                        btnExcluir.setDisable(false);
                        Usuarios usu = tblUsuarios.getSelectionModel().getSelectedItem();
                        id_atual_usu = usu.getId();
                        carregar();
                    }
                }
            }
        });

    }

 //-------------------------------------------------------------------------\\    
 // MÉTODOS DE EVENTOS E BOTÕES DO FXML USUAÁRIOS                           \\    
 //-------------------------------------------------------------------------\\
    
    // Click do botão Novo
    @FXML
    private void onClickNovoUsuario(ActionEvent event) {
        tabPrincipal.getSelectionModel().select(1);
        tbCadastro.setDisable(false);
        setarBotoes(true, false, true);
        tfNome.requestFocus();
    }

    // Click do botão Salvar
    @FXML
    private void onClickSalvarUsuario(ActionEvent event) {
        if (!validarCampos()) {
            return;
        }
        salvar();
        tabPrincipal.getSelectionModel().select(0);
        tbCadastro.setDisable(true);
        setarBotoes(true, false, true);
        tfNome.requestFocus();
        listar();
    }

    // Click do botão Excluir
    @FXML
    private void onClickExcluirUsuario(ActionEvent event) {
        String nome = tfNome.getText().toUpperCase();
        if (Mensagens.confirmacao("Deseja excluir o Usuário: " + nome + "?")) {
            excluir();
            listar();
            tabPrincipal.getSelectionModel().select(0);
            tbCadastro.setDisable(true);
        }

    }

    // Click do botão Pesquisar
    @FXML
    private void onClickPesquisaUsuario(ActionEvent event) {
        listar();
    }

    // Click do botão Fechar
    @FXML
    private void onClickFecharUsuario(ActionEvent event) {

    }

    @FXML
    private void onKeyPressed(KeyEvent keyEvent) {
        listar();
        if (!keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.TAB) {
            keyEvent.consume();
            Mensagens.mensagem("Cadastro de Usuários", "Disparou Evento onKeyPressed!", Mensagens.INFORMACAO);
        }
    }
    
  //-------------------------------------------------------------------------\\    
  // FIM DOS MÉTODOS DE EVENTOS E BOTÕES DO FXML USUAÁRIOS                   \\    
  //-------------------------------------------------------------------------\\   

 //-------------------------------------------------------------------------\\    
 // MÉTODOS DA INTERFACE ITELACADASTRO (SALVAR, EXCLUIR, CARREGAR E LISTAR) \\    
 //-------------------------------------------------------------------------\\
    
 //SALVAR
    @Override
    public void salvar() {
        UsuariosDao dao = new UsuariosDao();

        Usuarios usuariosBanco = dao.usuariosPorID(id_atual_usu);

        usuariosBanco.setId(id_atual_usu);
        usuariosBanco.setNome(tfNome.getText());
        usuariosBanco.setInativo(ckAtivo.isSelected());
        usuariosBanco.setData_Cadastro(Calendar.getInstance().getTime());
        usuariosBanco.setSenha(tfSenha.getText());

        dao.salvarUsuario(usuariosBanco);
        dao.commit();
        id_atual_usu = 0;

        if (usuariosBanco.saved || usuariosBanco.updated) {
            Mensagens.mensagem("Sucesso", "Usuário salvo com sucesso!", Mensagens.CONFIRMACAO);
        } else {
            Mensagens.mensagem("Erro", "Usuário não foi salvo. Verifique!", Mensagens.ERRO);
        }
    }

 // EXCLUIR    
    @Override
    public void excluir() {
        Usuarios usuario = retornaUsuarioTabela();
        UsuariosDao dao = new UsuariosDao(true);
        dao.deletarUsuario(usuario);
        if (usuario.deleted) {
            Mensagens.mensagem("Sucesso", "Usuário excluído com sucesso!", Mensagens.INFORMACAO);
        } else {
            Mensagens.mensagem("Erro", "Usuário não foi excluído!", Mensagens.ERRO);
        }
    }
    
 // CARREGAR    
    @Override
    public void carregar() {
        UsuariosDao dao = new UsuariosDao(true);
        Usuarios usuariosBanco = dao.usuariosPorID(id_atual_usu);
        tfNome.setText(usuariosBanco.getNome());
        ckAtivo.setSelected(usuariosBanco.isInativo());
        tfSenha.setText(usuariosBanco.getSenha());
    }

 // LISTAR    
    @Override
    public void listar() {
        tblUsuarios.getItems().clear();
        String pesquisa = tfPesquisar.getText();
        UsuariosDao dao = new UsuariosDao();
        List<Usuarios> listaUsuarios = dao.listaUsuarios(pesquisa);
        dao.commit();
        tblUsuarios.getItems().addAll(listaUsuarios);
    }
    
    private Usuarios retornaUsuarioTabela() {
        return tblUsuarios.getSelectionModel().getSelectedItem();
    }
    
    @Override
    public void setarBotoes(boolean... params) {
      btnNovo.setDisable(params[0]);
      btnSalvar.setDisable(params[1]);
      btnExcluir.setDisable(params[2]);
    }

    
 //--------------------------------------------\\
 // FIM DOS MÉTODOS DA INTERFACE ITELACADASTRO \\
 //--------------------------------------------\\
 
 //-----------------------------------------------\\
 // MÉTODOS DIVERSOS DA CLASSE USUARIOSCONTROLLER \\
 //-----------------------------------------------\\
 
  
 // VALIDAR CAMPOS 
    private boolean validarCampos() {
        // Campo Nome
        if (tfNome.getText().isEmpty()) {
            Mensagens.mensagem("Alerta", "Campo Nome é obrigatório", Mensagens.ALERTA);
            tfNome.requestFocus();
            return false;
        }
        
        // Campo Senha
        if (tfSenha.getText().isEmpty()) {
            Mensagens.mensagem("Alerta", "Campo Senha é obrigatório", Mensagens.ALERTA);
            tfSenha.requestFocus();
            return false;
        }
        return true;
    }
    
}
