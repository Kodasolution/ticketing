package org.eticketing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type_ticket {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_TYPE_TICKET;
	@NotNull
	private String TYPE_TICKET;
	@NotNull
	private int PLACE_DISPONIBLE;
	@NotNull
    private Double PRIX_TYPE_TICKET;
	
	@OneToMany(mappedBy = "type_ticket")
	private List<Ticket> tickets; 
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "type_ticket")
    private Set<Evenement> evenements = new HashSet<>();

	public Type_ticket(String tYPE_TICKET, int pLACE_DISPONIBLE, Double pRIX_TYPE_TICKET) {
		super();
		TYPE_TICKET = tYPE_TICKET;
		PLACE_DISPONIBLE = pLACE_DISPONIBLE;
		PRIX_TYPE_TICKET = pRIX_TYPE_TICKET;
	}
	
	

	

}
