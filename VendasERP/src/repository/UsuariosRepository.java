/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import br.com.persistor.enums.FILTER_TYPE;
import br.com.persistor.enums.MATCH_MODE;
import br.com.persistor.enums.RESULT_TYPE;
import br.com.persistor.generalClasses.Restrictions;
import br.com.persistor.interfaces.ICriteria;
import br.com.persistor.sessionManager.Query;
import dao.UsuariosDao;
import java.util.List;
import model.Usuarios;

/**
 *
 * @author fbrigatt
 */
public class UsuariosRepository extends RepositoryImpl<Usuarios>
{
    public List<Usuarios> listaUsuarios (String nome) {
        Usuarios usuarios = new Usuarios();
        ICriteria c = createCriteria(usuarios, RESULT_TYPE.MULTIPLE);
        c.add(Restrictions.like(FILTER_TYPE.WHERE, "nome", nome, MATCH_MODE.ANYWHERE));
        c.execute();
        return usuarios.toList();
    }
    
    public boolean login(String nome, String senha){
        Usuarios usuarios = new Usuarios();
        Query query = getSession().createQuery(usuarios, "SELECT * from usuarios WHERE nome = ? and senha = ?");
        query.setParameter(1, nome);
        query.setParameter(2, senha);
        query.setResult_type(RESULT_TYPE.UNIQUE);
        query.execute();
        if (usuarios.getNome() == null) return false;
        boolean logado = (usuarios.getNome().equals(nome) && usuarios.getSenha().equals(senha));
        if (logado){
            UsuariosDao.logado = usuarios;
            return true;
        }
        return false;
        //return usuarios.toList().size() > 0;
    }
}
