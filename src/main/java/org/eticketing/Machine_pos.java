package org.eticketing;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Machine_pos {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_MACHINE_POS;
	@NotNull
	private String NUMERO_SERIE;
	@NotNull
	private String NUMERO_IMEI;
	
	@OneToMany(mappedBy = "machine_pos")
	private List<Affectation> affectations;

	public Machine_pos(String nUMERO_SERIE, String nUMERO_IMEI) {
		super();
		NUMERO_SERIE = nUMERO_SERIE;
		NUMERO_IMEI = nUMERO_IMEI;
	}
	
	
	

}
