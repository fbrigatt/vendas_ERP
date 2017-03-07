
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

public class Estoque extends Entity 
{
   private int id; 
   private int loja_id; 
   private Lojas lojas; 
   private int produto_id; 
   private Produtos produtos; 
   private String lote; 
   private String sublote; 
   private double quant; 
   private Date data_validade; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.AUTO)
   public int getId()
   {
       return id;
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

   public void setLote(String lote)
   {
       this.lote = lote;
   }
 
   public String getLote()
   {
       return lote;
   }

   public void setSublote(String sublote)
   {
       this.sublote = sublote;
   }
 
   public String getSublote()
   {
       return sublote;
   }

   public void setQuant(double quant)
   {
       this.quant = quant;
   }
 
   public double getQuant()
   {
       return quant;
   }

   public void setData_Validade(Date data_validade)
   {
       this.data_validade = data_validade;
   }
 
   public Date getData_Validade()
   {
       return data_validade;
   }
}