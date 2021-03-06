
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

public class Clientes extends Entity 
{
   private int id; 
   private String nome; 
   private String apelido; 
   private String email; 
   private String telefone; 
   private String celular; 
   private String logradouro; 
   private String municipio; 
   private String bairro; 
   private int numero; 
   private String cep; 
   private String uf;
   private String cpf;
   private String rg;

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

   public void setEmail(String email)
   {
       this.email = email;
   }
 
   public String getEmail()
   {
       return email;
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

   public void setUf(String uf)
   {
       this.uf = uf;
   }
 
   public String getUf()
   {
       return uf;
   }
   
       public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

}