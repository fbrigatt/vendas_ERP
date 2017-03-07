
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

public class Produtos_Fornecedores extends Entity 
{
   private int id; 
   private int fornecedor_id; 
   private Fornecedores fornecedores; 
   private int produto_id; 
   private Produtos produtos; 
   private double preco_custo; 
   private int unidade_id; 
   private Unidades unidades; 
   private int fato_conversao; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.AUTO)
   public int getId()
   {
       return id;
   }

 
   public void setFornecedores(Fornecedores fornecedores)
   {
       this.fornecedores = fornecedores;
   }
   public void setFornecedor_Id(int fornecedor_id)
   {
       this.fornecedor_id = fornecedor_id;
   }
 
   public int getFornecedor_Id()
   {
       return fornecedor_id;
   }

   @OneToOne(source = "fornecedor_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Fornecedores getFornecedores()
   {
       return fornecedores;
   }

 
   public void setProdutos(Produtos produtos)
   {
       this.produtos = produtos;
   }
   public void setProduto_Id(int produto_id)
   {
       this.produto_id = produto_id;
   }
 
   public int getProduto_Id()
   {
       return produto_id;
   }

   @OneToOne(source = "produto_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Produtos getProdutos()
   {
       return produtos;
   }

   public void setPreco_Custo(double preco_custo)
   {
       this.preco_custo = preco_custo;
   }
 
   public double getPreco_Custo()
   {
       return preco_custo;
   }

 
   public void setUnidades(Unidades unidades)
   {
       this.unidades = unidades;
   }
   public void setUnidade_Id(int unidade_id)
   {
       this.unidade_id = unidade_id;
   }
 
   public int getUnidade_Id()
   {
       return unidade_id;
   }

   @OneToOne(source = "unidade_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Unidades getUnidades()
   {
       return unidades;
   }

   public void setFato_Conversao(int fato_conversao)
   {
       this.fato_conversao = fato_conversao;
   }
 
   public int getFato_Conversao()
   {
       return fato_conversao;
   }
}