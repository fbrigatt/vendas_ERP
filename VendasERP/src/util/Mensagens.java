/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author frede
 */
public class Mensagens {

    public static final int CONFIRMACAO = 1;
    public static final int ERRO = 2;
    public static final int INFORMACAO = 3;
    public static final int NENHUM = 4;
    public static final int ALERTA = 5;
   
    private static Alert dialogoInfo;

    public static void mensagem(String titulo, String texto, int tipo) {
        switch (tipo) {
            case CONFIRMACAO:
                dialogoInfo = new Alert(Alert.AlertType.CONFIRMATION);
                break;
            case ERRO:
                dialogoInfo = new Alert(Alert.AlertType.ERROR);
                break;
            case INFORMACAO:
                dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                break;
            case NENHUM:
                dialogoInfo = new Alert(Alert.AlertType.NONE);
                break;
            case ALERTA:
                dialogoInfo = new Alert(Alert.AlertType.WARNING);
                break;
            default: dialogoInfo = new Alert(Alert.AlertType.NONE);
        }

        dialogoInfo.setTitle(titulo);
        dialogoInfo.setHeaderText(texto);
        dialogoInfo.setContentText(null);
        dialogoInfo.show();
    }
    
    public static boolean confirmacao(String texto){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação");
        alert.setHeaderText(texto);
        alert.setContentText(null);
        
        Optional<ButtonType> result = alert.showAndWait();
        return (result.get() == ButtonType.OK);
    }

}
