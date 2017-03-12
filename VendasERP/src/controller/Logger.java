/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.persistor.generalClasses.PersistenceLog;
import br.com.persistor.interfaces.IPersistenceLogger;

/**
 *
 * @author fbrigatt
 */
public class Logger implements IPersistenceLogger
{

    @Override
    public void newNofication(PersistenceLog pl)
    {
        System.out.println("Erro!");        
        System.out.println("Classe: " + pl.getClassName());
        System.out.println("Método: " + pl.getMethodName());
        System.out.println("Query: "  + pl.getQuery());
        System.out.println("Descrição: "  + pl.getDescription());
    }
    
}
