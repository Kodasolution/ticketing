package org.eticketing;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.FutureOrPresent;


import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evenement {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_EVENEMENT;
	@NotNull
	private String NOM_EVENEMENT;
	@NotNull
	private String LOGO_EVENEMENT;
	@NotNull
	@FutureOrPresent 
	private Date DATE_EVENEMENT;
	@NotNull
	private String HEURE_EVENEMENT;
	@NotNull
	private String LIEU_EVENEMENT;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "type_ticket_evenement",
            joinColumns = { @JoinColumn(name = "id_evenement") },
            inverseJoinColumns = { @JoinColumn(name = "id_type_ticket") })
    private Set<Type_ticket> type_ticket = new HashSet<>();
	
	@OneToMany(mappedBy = "evenement")
	private List<Ticket> tickets;
	
	@OneToMany(mappedBy = "evenement")
	private List<Affectation> affectations;

	public Evenement(String nOM_EVENEMENT, String lOGO_EVENEMENT, @FutureOrPresent Date dATE_EVENEMENT,
			String hEURE_EVENEMENT, String lIEU_EVENEMENT) {
		super();
		NOM_EVENEMENT = nOM_EVENEMENT;
		LOGO_EVENEMENT = lOGO_EVENEMENT;
		DATE_EVENEMENT = dATE_EVENEMENT;
		HEURE_EVENEMENT = hEURE_EVENEMENT;
		LIEU_EVENEMENT = lIEU_EVENEMENT;
	}
	
	

	
	

}
