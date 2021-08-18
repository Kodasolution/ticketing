package org.eticketing;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.AssertTrue;

import org.hibernate.annotations.Type;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profil_utilisateur {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_PROFIL_UTILISATEUR;
	@NotNull
	private String PROFIL_UTILISATEUR;
	@NotNull
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean GERER_EVENEMENT;
	@NotNull
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean VENDRE_TICKET;
	@NotNull
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean VALIDER_TICKET;
	@NotNull
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean GERER_UTILISATEUR;
	@NotNull
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean CONSULTER_RAPPORT;
	@NotNull
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean CONSULTER_DASHBORD;
	@NotNull
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean AFFECTER_UTILISATEUR_EVENEMENT;
	
	@OneToMany(mappedBy = "profil_utilisateur")
	private List<Utilisateur> utilisateurs;

	public Profil_utilisateur(String pROFIL_UTILISATEUR, Boolean gERER_EVENEMENT, Boolean vENDRE_TICKET,
			Boolean vALIDER_TICKET, Boolean gERER_UTILISATEUR, Boolean cONSULTER_RAPPORT, Boolean cONSULTER_DASHBORD,
			Boolean aFFECTER_UTILISATEUR_EVENEMENT) {
		super();
		PROFIL_UTILISATEUR = pROFIL_UTILISATEUR;
		GERER_EVENEMENT = gERER_EVENEMENT;
		VENDRE_TICKET = vENDRE_TICKET;
		VALIDER_TICKET = vALIDER_TICKET;
		GERER_UTILISATEUR = gERER_UTILISATEUR;
		CONSULTER_RAPPORT = cONSULTER_RAPPORT;
		CONSULTER_DASHBORD = cONSULTER_DASHBORD;
		AFFECTER_UTILISATEUR_EVENEMENT = aFFECTER_UTILISATEUR_EVENEMENT;
	}

	
	
	
	

}
