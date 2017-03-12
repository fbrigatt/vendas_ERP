/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import br.com.persistor.enums.RESULT_TYPE;
import br.com.persistor.interfaces.ICriteria;
import br.com.persistor.interfaces.Session;
import controller.SessionProvider;
import interfaces.IRepository;

/**
 *
 * @author fbrigatt
 * @param <T>
 */
public abstract class RepositoryImpl <T> implements IRepository <T>
{
    private Session mainSession = null;
    private boolean autoCommit = false;
    
    private void checkInitialization(){
        try{
            if (mainSession == null)
                mainSession = SessionProvider.openSession();
            if (mainSession.getActiveConnection().isClosed())
                mainSession = SessionProvider.openSession();
        } catch (Exception erro){
            System.out.println("Erro ao abrir conexão!");
        }
    }
    
    @Override
    public void setSession(Session session)
    {
        mainSession = session;
    }

    @Override
    public Session getSession()
    {
        checkInitialization();
        return mainSession;
    }

    @Override
    public void save(T Entity)
    {
        checkInitialization();
        mainSession.save(Entity);
        if(autoCommit) commit(true);
    }

    @Override
    public void update(T Entity)
    {
        checkInitialization();
        mainSession.update(Entity);
        if(autoCommit) commit(true);
    }

    @Override
    public void delete(T Entity)
    {
        checkInitialization();
        mainSession.delete(Entity);
        if(autoCommit) commit(true);
    }

    @Override
    public T find(Class entityClass, int id)
    {
        checkInitialization();
        T Entity = mainSession.onID(entityClass, id);
        if(autoCommit) close();
        return Entity;
    }

    @Override
    public boolean exists(Class entityClass, String field, Object value)
    {
        checkInitialization();
        int result = mainSession.count(entityClass, field + "=" + value);
        return result > 0;
    }

    @Override
    public void commit(boolean close)
    {
        mainSession.commit();
        if(close) close();
    }

    @Override
    public void close()
    {
        mainSession.close();
    }

    @Override
    public void setAutoCommit(boolean value)
    {
        autoCommit = value;
    }
    
    @Override
    public ICriteria createCriteria(Object o, RESULT_TYPE rt){
        checkInitialization();
        return mainSession.createCriteria(o, rt);
    }
}
