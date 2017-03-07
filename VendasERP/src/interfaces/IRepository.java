/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import br.com.persistor.enums.RESULT_TYPE;
import br.com.persistor.interfaces.ICriteria;
import br.com.persistor.interfaces.Session;

/**
 *
 * @author fbrigatt
 */
public interface IRepository <T>
{
   void setSession(Session session);
   Session getSession();
   void save(T Entity);
   void update(T Entity);
   void delete(T Entity);
   T find(Class entityClass, int id);
   boolean exists(Class entityClass, String field, Object value);
   void commit(boolean close);
   void close();
   void setAutoCommit(boolean value);
   ICriteria createCriteria(Object o, RESULT_TYPE rt);
}
