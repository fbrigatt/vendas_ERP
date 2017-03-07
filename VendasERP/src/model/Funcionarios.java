
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

public class Funcionarios extends Entity 
{
   private int id; 
   private String nome; 
   private String apelido; 
   private Date data_admissao; 
   private String telefone; 
   private String celular; 
   private String cpf; 
   private String rg; 
   private Date data_nascimento; 
   private double comissao; 
   private int usuario_id; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.AUTO)
   public int getId()
   {
       return id;
   }

   public void setNome(String nome)
   {
       this.nome = nome;
   }
 
   public String getNome()
   {
       return nome;
   }

   public void setApelido(String apelido)
   {
       this.apelido = apelido;
   }
 
   public String getApelido()
   {
       return apelido;
   }

   public void setData_Admissao(Date data_admissao)
   {
       this.data_admissao = data_admissao;
   }
 
   public Date getData_Admissao()
   {
       return data_admissao;
   }

   public void setTelefone(String telefone)
   {
       this.telefone = telefone;
   }
 
   public String getTelefone()
   {
       return telefone;
   }

   public void setCelular(String celular)
   {
       this.celular = celular;
   }
 
   public String getCelular()
   {
       return celular;
   }

   public void setCpf(String cpf)
   {
       this.cpf = cpf;
   }
 
   public String getCpf()
   {
       return cpf;
   }

   public void setRg(String rg)
   {
       this.rg = rg;
   }
 
   public String getRg()
   {
       return rg;
   }

   public void setData_Nascimento(Date data_nascimento)
   {
       this.data_nascimento = data_nascimento;
   }
 
   public Date getData_Nascimento()
   {
       return data_nascimento;
   }

   public void setComissao(double comissao)
   {
       this.comissao = comissao;
   }
 
   public double getComissao()
   {
       return comissao;
   }

   public void setUsuario_Id(int usuario_id)
   {
       this.usuario_id = usuario_id;
   }
 
   public int getUsuario_Id()
   {
       return usuario_id;
   }
}