package org.eticketing;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_UTILISATEUR;
	@NotNull
	private String NOM_UTILISATEUR;
	@NotNull
	private String PRENOM_UTILISATEUR;
	@NotNull
	private String TELEPHONE_UTILISATEUR;
	@NotNull
	private String PHOTO_UTILISATEUR;
	@NotNull
	@Email(message = "Email should be valid")
	private String EMAIL_UTILISATEUR;
	@NotNull
	private String PASSWORD_UTILISATEUR;
	
	@OneToMany(mappedBy = "utilisateur")
	private List<Affectation>affectations;
	
	
	@OneToMany(mappedBy = "utilisateur")
	private List<Ticket> tickets;
	
	@ManyToOne
	@JoinColumn(name = "id_profil_utilisateur")
	private Profil_utilisateur profil_utilisateur;

	public Utilisateur(String nOM_UTILISATEUR, String pRENOM_UTILISATEUR, String tELEPHONE_UTILISATEUR,
			String pHOTO_UTILISATEUR, @Email(message = "Email should be valid") String eMAIL_UTILISATEUR,
			String pASSWORD_UTILISATEUR, List<Affectation> affectations, List<Ticket> tickets,
			Profil_utilisateur profil_utilisateur) {
		super();
		NOM_UTILISATEUR = nOM_UTILISATEUR;
		PRENOM_UTILISATEUR = pRENOM_UTILISATEUR;
		TELEPHONE_UTILISATEUR = tELEPHONE_UTILISATEUR;
		PHOTO_UTILISATEUR = pHOTO_UTILISATEUR;
		EMAIL_UTILISATEUR = eMAIL_UTILISATEUR;
		PASSWORD_UTILISATEUR = pASSWORD_UTILISATEUR;
		this.affectations = affectations;
		this.tickets = tickets;
		this.profil_utilisateur = profil_utilisateur;
	}

	
	
	

}
