
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

public class Movimentos extends Entity 
{
   private int id; 
   private int tipo_movimento_id; 
   private Tipos_Movimentos tipos_movimentos; 
   private int usuario_id; 
   private Usuarios usuarios; 
   private int loja_id; 
   private Lojas lojas; 
   private Date data; 
   private int cliente_id; 
   private int fornecedor_id; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.AUTO)
   public int getId()
   {
       return id;
   }

 
   public void setTipos_Movimentos(Tipos_Movimentos tipos_movimentos)
   {
       this.tipos_movimentos = tipos_movimentos;
   }
   public void setTipo_movimento_Id(int tipo_movimento_id)
   {
       this.tipo_movimento_id = tipo_movimento_id;
   }
 
   public int getTipo_movimento_Id()
   {
       return tipo_movimento_id;
   }

   @OneToOne(source = "tipo_movimento_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Tipos_Movimentos getTipos_Movimentos()
   {
       return tipos_movimentos;
   }

 
   public void setUsuarios(Usuarios usuarios)
   {
       this.usuarios = usuarios;
   }
   public void setUsuario_Id(int usuario_id)
   {
       this.usuario_id = usuario_id;
   }
 
   public int getUsuario_Id()
   {
       return usuario_id;
   }

   @OneToOne(source = "usuario_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Usuarios getUsuarios()
   {
       return usuarios;
   }

 
   public void setLojas(Lojas lojas)
   {
       this.lojas = lojas;
   }
   public void setLoja_Id(int loja_id)
   {
       this.loja_id = loja_id;
   }
 
   public int getLoja_Id()
   {
       return loja_id;
   }

   @OneToOne(source = "loja_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Lojas getLojas()
   {
       return lojas;
   }

   public void setData(Date data)
   {
       this.data = data;
   }
 
   public Date getData()
   {
       return data;
   }

   public void setCliente_Id(int cliente_id)
   {
       this.cliente_id = cliente_id;
   }
 
   public int getCliente_Id()
   {
       return cliente_id;
   }

   public void setFornecedor_Id(int fornecedor_id)
   {
       this.fornecedor_id = fornecedor_id;
   }
 
   public int getFornecedor_Id()
   {
       return fornecedor_id;
   }
}