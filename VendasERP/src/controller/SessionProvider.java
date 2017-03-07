/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.persistor.enums.DB_TYPE;
import br.com.persistor.generalClasses.DBConfig;
import br.com.persistor.interfaces.Session;
import br.com.persistor.sessionManager.SessionFactory;

/**
 *
 * @author fbrigatt
 */
public class SessionProvider
{

    private static SessionFactory sf;

    public static Session openSession()
    {
        try
        {
            if (sf == null)
                sf = new SessionFactory();
            DBConfig dbConfig = new DBConfig();
            dbConfig.setDb_type(DB_TYPE.MySQL);
            dbConfig.setDatabase("ERP");
            dbConfig.setHost("localhost");
            dbConfig.setPort(3306);
            dbConfig.setUser("root");
            dbConfig.setPassword("hp48gx");
            dbConfig.setPersistenceLogger(Logger.class);
            return sf.getSession(dbConfig);
        } catch (Exception erro)
        {
            return null;
        }
    }
}
