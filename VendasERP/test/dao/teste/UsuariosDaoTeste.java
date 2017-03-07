/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.teste;

import dao.UsuariosDao;
import java.util.List;
import junit.framework.Assert;
import model.Usuarios;
import org.junit.Test;

/**
 *
 * @author fbrigatt
 */
public class UsuariosDaoTeste
{
    @Test
    
    public void deveSalvarUmUsuario(){
        Usuarios usuarios = new Usuarios();
        
        
        usuarios.setNome("Frederico Brigatte");
        usuarios.setData_Cadastro(br.com.persistor.generalClasses.Util.getCalendar(07, 03, 2017).getTime());
        usuarios.setInativo(false);
        usuarios.setSenha("1234");
        
        UsuariosDao dao = new UsuariosDao(true);
        dao.salvarUsuario(usuarios);
        Assert.assertEquals(true, usuarios.saved);
    }
    
    @Test
    public void deveVoltarUmaListaDeUsuarios(){
        List<Usuarios> listaUsuarios = new UsuariosDao().listaUsuarios("M");
        Assert.assertTrue(listaUsuarios.size() > 0);
    } 
    
    @Test
    public void deveExcluirUmUsuario(){
        UsuariosDao dao = new UsuariosDao(true);
        Usuarios usuarios = dao.usuariosPorID(2);
      //  dao.deletarUsuario(usuarios);
      //  Assert.assertEquals(true, usuarios.deleted);
    }
    
    @Test
    public void deveAtualizarUmUsuario(){
       UsuariosDao dao = new UsuariosDao();
       Usuarios usuarios = dao.usuariosPorID(1);
       usuarios.setNome("Marcos Vinicius");
       dao.salvarUsuario(usuarios);
       dao.commit();
       Assert.assertEquals(true, usuarios.updated);
    }
}
