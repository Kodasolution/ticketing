package org.eticketing;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_TICKET;
	@NotNull
	private String QR_CODE_TICKET;
	@NotNull
	private Date DATE_SORTIE_TICKET;
	@NotNull
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean VERIFIE;
	
	@ManyToOne
	@JoinColumn(name = "id_evenement")
	private Evenement evenement;
	
	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name = "id_type_ticket")
	private Type_ticket type_ticket;
	
	

}
