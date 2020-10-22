package br.com.team.java.model;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import br.com.team.java.model.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "team_usuario")
@Entity
public class Usuario {
	
	@Id
	@GeneratedValue ( strategy = GenerationType.SEQUENCE, generator = "usuario_seq_id" )
	@SequenceGenerator ( sequenceName = "usuario_seq_id", name = "usuario_seq_id", allocationSize = 1 )
	private int id;
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	//Endereço
	
	
	//Perfil
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIS")
	private Set<Integer> perfis = new HashSet<>();
	
	
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		if (perfis == null) {
			perfis = new HashSet<>();
		}
		
		perfis.add( perfil.getCodigo() );
	}
}
