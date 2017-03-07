
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

public class Produtos extends Entity 
{
   private int id; 
   private String referencia; 
   private String ean; 
   private String descricao; 
   private String ncm; 
   private double valor_unit; 
   private double margem_lucro; 
   private String localizacao; 
   private InputStream foto; 
   private boolean controla_lote; 
   private int unidade_id; 
   private Unidades unidades; 
   private int grupo_id; 
   private Grupos_Produtos grupos_produtos; 
   private int marca_id; 
   private Marcas marcas; 

   public void setId(int id)
   {
       this.id = id;
   }
 
   @PrimaryKey(increment = INCREMENT.AUTO)
   public int getId()
   {
       return id;
   }

   public void setReferencia(String referencia)
   {
       this.referencia = referencia;
   }
 
   public String getReferencia()
   {
       return referencia;
   }

   public void setEan(String ean)
   {
       this.ean = ean;
   }
 
   public String getEan()
   {
       return ean;
   }

   public void setDescricao(String descricao)
   {
       this.descricao = descricao;
   }
 
   public String getDescricao()
   {
       return descricao;
   }

   public void setNcm(String ncm)
   {
       this.ncm = ncm;
   }
 
   public String getNcm()
   {
       return ncm;
   }

   public void setValor_Unit(double valor_unit)
   {
       this.valor_unit = valor_unit;
   }
 
   public double getValor_Unit()
   {
       return valor_unit;
   }

   public void setMargem_Lucro(double margem_lucro)
   {
       this.margem_lucro = margem_lucro;
   }
 
   public double getMargem_Lucro()
   {
       return margem_lucro;
   }

   public void setLocalizacao(String localizacao)
   {
       this.localizacao = localizacao;
   }
 
   public String getLocalizacao()
   {
       return localizacao;
   }

   public void setFoto(InputStream foto)
   {
       this.foto = foto;
   }
 
   public InputStream getFoto()
   {
       return foto;
   }

   public void setControla_Lote(boolean controla_lote)
   {
       this.controla_lote = controla_lote;
   }
 
   public boolean isControla_Lote()
   {
       return controla_lote;
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

 
   public void setGrupos_Produtos(Grupos_Produtos grupos_produtos)
   {
       this.grupos_produtos = grupos_produtos;
   }
   public void setGrupo_Id(int grupo_id)
   {
       this.grupo_id = grupo_id;
   }
 
   public int getGrupo_Id()
   {
       return grupo_id;
   }

   @OneToOne(source = "grupo_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Grupos_Produtos getGrupos_Produtos()
   {
       return grupos_produtos;
   }

 
   public void setMarcas(Marcas marcas)
   {
       this.marcas = marcas;
   }
   public void setMarca_Id(int marca_id)
   {
       this.marca_id = marca_id;
   }
 
   public int getMarca_Id()
   {
       return marca_id;
   }

   @OneToOne(source = "marca_id", target = "id" , load = LOAD.AUTO, join_type = JOIN_TYPE.INNER)
   public Marcas getMarcas()
   {
       return marcas;
   }
}