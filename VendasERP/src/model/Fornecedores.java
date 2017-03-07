
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

public class Fornecedores extends Entity 
{
   private int id; 
   private String razao_social; 
   private String nome_fantasia; 
   private String cnpj; 
   private String inscricao_estadual; 
   private String inscricao_municipal; 
   private String logradouro; 
   private String municipio; 
   private String bairro; 
   private int numero; 
   private String cep; 
   private String telefone; 
   private String celular; 
   private String email; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.AUTO)
   public int getId()
   {
       return id;
   }

   public void setRazao_Social(String razao_social)
   {
       this.razao_social = razao_social;
   }
 
   public String getRazao_Social()
   {
       return razao_social;
   }

   public void setNome_Fantasia(String nome_fantasia)
   {
       this.nome_fantasia = nome_fantasia;
   }
 
   public String getNome_Fantasia()
   {
       return nome_fantasia;
   }

   public void setCnpj(String cnpj)
   {
       this.cnpj = cnpj;
   }
 
   public String getCnpj()
   {
       return cnpj;
   }

   public void setInscricao_Estadual(String inscricao_estadual)
   {
       this.inscricao_estadual = inscricao_estadual;
   }
 
   public String getInscricao_Estadual()
   {
       return inscricao_estadual;
   }

   public void setInscricao_Municipal(String inscricao_municipal)
   {
       this.inscricao_municipal = inscricao_municipal;
   }
 
   public String getInscricao_Municipal()
   {
       return inscricao_municipal;
   }

   public void setLogradouro(String logradouro)
   {
       this.logradouro = logradouro;
   }
 
   public String getLogradouro()
   {
       return logradouro;
   }

   public void setMunicipio(String municipio)
   {
       this.municipio = municipio;
   }
 
   public String getMunicipio()
   {
       return municipio;
   }

   public void setBairro(String bairro)
   {
       this.bairro = bairro;
   }
 
   public String getBairro()
   {
       return bairro;
   }

   public void setNumero(int numero)
   {
       this.numero = numero;
   }
 
   public int getNumero()
   {
       return numero;
   }

   public void setCep(String cep)
   {
       this.cep = cep;
   }
 
   public String getCep()
   {
       return cep;
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

   public void setEmail(String email)
   {
       this.email = email;
   }
 
   public String getEmail()
   {
       return email;
   }
}