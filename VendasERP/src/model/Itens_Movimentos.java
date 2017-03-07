
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

public class Itens_Movimentos extends Entity 
{
   private int id; 
   private int movimento_id; 
   private int produto_id; 
   private Produtos produtos; 
   private double valor_unit; 
   private double desconto; 
   private double acrescimo; 
   private double valor_final; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.MANUAL)
   public int getId()
   {
       return id;
   }

   public void setMovimento_Id(int movimento_id)
   {
       this.movimento_id = movimento_id;
   }
 
   @PrimaryKey(increment = INCREMENT.MANUAL)
   public int getMovimento_Id()
   {
       return movimento_id;
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

   public void setValor_Unit(double valor_unit)
   {
       this.valor_unit = valor_unit;
   }
 
   public double getValor_Unit()
   {
       return valor_unit;
   }

   public void setDesconto(double desconto)
   {
       this.desconto = desconto;
   }
 
   public double getDesconto()
   {
       return desconto;
   }

   public void setAcrescimo(double acrescimo)
   {
       this.acrescimo = acrescimo;
   }
 
   public double getAcrescimo()
   {
       return acrescimo;
   }

   public void setValor_Final(double valor_final)
   {
       this.valor_final = valor_final;
   }
 
   public double getValor_Final()
   {
       return valor_final;
   }
}