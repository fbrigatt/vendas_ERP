
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

public class Tipos_Movimentos extends Entity 
{
   private int id; 
   private String descricao; 
   private int movimentacao_estoque; 
   private int movimentacao_caixa; 
   private int cfop; 
   private boolean utiliza_fornecedor; 
   private boolean gera_comissao; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.AUTO)
   public int getId()
   {
       return id;
   }

   public void setDescricao(String descricao)
   {
       this.descricao = descricao;
   }
 
   public String getDescricao()
   {
       return descricao;
   }

   public void setMovimentacao_Estoque(int movimentacao_estoque)
   {
       this.movimentacao_estoque = movimentacao_estoque;
   }
 
   public int getMovimentacao_Estoque()
   {
       return movimentacao_estoque;
   }

   public void setMovimentacao_Caixa(int movimentacao_caixa)
   {
       this.movimentacao_caixa = movimentacao_caixa;
   }
 
   public int getMovimentacao_Caixa()
   {
       return movimentacao_caixa;
   }

   public void setCfop(int cfop)
   {
       this.cfop = cfop;
   }
 
   public int getCfop()
   {
       return cfop;
   }

   public void setUtiliza_Fornecedor(boolean utiliza_fornecedor)
   {
       this.utiliza_fornecedor = utiliza_fornecedor;
   }
 
   public boolean isUtiliza_Fornecedor()
   {
       return utiliza_fornecedor;
   }

   public void setGera_Comissao(boolean gera_comissao)
   {
       this.gera_comissao = gera_comissao;
   }
 
   public boolean isGera_Comissao()
   {
       return gera_comissao;
   }
}