
/* AUTO-GENERATED CLASS */
/* DOES NOT ADD ACCESSOR METHODS */
/* DOES NOT CHANGE NAME OF ACCESSOR METHODS */
package model;


 import br.com.persistor.abstractClasses.Entity;
 import br.com.persistor.abstractClasses.Entity;
 import br.com.persistor.annotations.PrimaryKey;
 import br.com.persistor.enums.INCREMENT;
 import br.com.persistor.annotations.OneToOne;
 import br.com.persistor.annotations.OneToMany;
 import br.com.persistor.enums.JOIN_TYPE;
 import br.com.persistor.enums.LOAD;
 import java.util.Date;
 import java.io.InputStream;

/**
 *
 * @author Persistor4J
 */ 

public class Permissoes extends Entity 
{
   private int id; 
   private int usuarios_id; 
   private Usuarios usuarios; 
   private int rotinas_id; 
   private Rotinas rotinas; 
   private boolean acesso; 
   private boolean incluir; 
   private boolean alterar; 
   private boolean excluir; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.AUTO)
   public int getId()
   {
       return id;
   }

 
   public void setUsuarios(Usuarios usuarios)
   {
       this.usuarios = usuarios;
   }
   public void setUsuarios_Id(int usuarios_id)
   {
       this.usuarios_id = usuarios_id;
   }
 
   public int getUsuarios_Id()
   {
       return usuarios_id;
   }

   @OneToOne(source = "usuarios_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Usuarios getUsuarios()
   {
       return usuarios;
   }

 
   public void setRotinas(Rotinas rotinas)
   {
       this.rotinas = rotinas;
   }
   public void setRotinas_Id(int rotinas_id)
   {
       this.rotinas_id = rotinas_id;
   }
 
   public int getRotinas_Id()
   {
       return rotinas_id;
   }

   @OneToOne(source = "rotinas_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Rotinas getRotinas()
   {
       return rotinas;
   }

   public void setAcesso(boolean acesso)
   {
       this.acesso = acesso;
   }
 
   public boolean isAcesso()
   {
       return acesso;
   }

   public void setIncluir(boolean incluir)
   {
       this.incluir = incluir;
   }
 
   public boolean isIncluir()
   {
       return incluir;
   }

   public void setAlterar(boolean alterar)
   {
       this.alterar = alterar;
   }
 
   public boolean isAlterar()
   {
       return alterar;
   }

   public void setExcluir(boolean excluir)
   {
       this.excluir = excluir;
   }
 
   public boolean isExcluir()
   {
       return excluir;
   }
}