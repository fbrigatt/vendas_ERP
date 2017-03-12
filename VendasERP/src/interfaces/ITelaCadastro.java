/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javafx.event.ActionEvent;

/**
 *
 * @author frede
 */
public interface ITelaCadastro {
    
    void salvar();
    void excluir();
    void carregar();
    void listar();
    void setarBotoes(boolean... params);
}
