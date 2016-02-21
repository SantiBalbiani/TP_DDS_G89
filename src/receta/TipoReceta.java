package receta;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TIPO_RECETA")
public class TipoReceta {

	
	private int idTipoReceta;
	private String tipoReceta;
	private Set<Receta> receta = new HashSet<Receta>(0);
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "listaCategorias")
	public Set<Receta> getReceta() {
		return receta;
	}

	public void setReceta(Set<Receta> receta) {
		this.receta = receta;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "ID_TIPORECETA")
	public int getIdTipoReceta() {
		return idTipoReceta;
	}

	public void setIdTipoReceta(int idTipoReceta) {
		this.idTipoReceta = idTipoReceta;
	}

	@Column(name= "TIPORECETA")
	public String getTipoReceta() {
		return tipoReceta;
	}

	public void setTipoReceta(String tipoReceta) {
		this.tipoReceta = tipoReceta;
	}
	@Transient
	public List<String> getListaCategoria() {
		return listaCategoria;
	}

	public void setListaCategoria(List<String> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}

	
	List<String> listaCategoria = new ArrayList<String>() {
		{
			add("Desayuno");
			add("Almuerzo");
			add("Merienda");
			add("Cena");
		}
		
		
		
		
	};

	
	
	
}