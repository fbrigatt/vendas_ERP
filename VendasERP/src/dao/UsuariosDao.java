/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Usuarios;
import repository.UsuariosRepository;

/**
 *
 * @author fbrigatt
 */
public class UsuariosDao
{
    public static Usuarios logado;
    private UsuariosRepository db;

    public UsuariosDao(boolean... autoCommit)
    {
        this.db = new UsuariosRepository();
        if(autoCommit.length > 0)
            db.setAutoCommit(autoCommit[0]);
    }

    public void salvarUsuario(Usuarios usuarios)
    {
        if (db.exists(Usuarios.class, "id", usuarios.getId()))
            db.update(usuarios);
        else
            db.save(usuarios);
    }
    
    public void deletarUsuario(Usuarios usuarios){
        db.delete(usuarios);
    }
    
    public Usuarios usuariosPorID(int id){
       return db.find(Usuarios.class, id);
    }
    
    public List<Usuarios> listaUsuarios(String nome){
        return db.listaUsuarios(nome);
    }
    
    public void commit(){
        db.commit(true);
    }
    
    public boolean verificaLogin(String nome, String senha){
       return db.login(nome, senha);
    }

}
