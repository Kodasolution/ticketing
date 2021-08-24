package org.eticketing;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Affectation {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID_AFFECTATION;
	private Date DATE_AFFECTATION;
	
    @ManyToOne 
    @JoinColumn(name = "ID_EVENEMENT", referencedColumnName = "ID_EVENEMENT")
    private Evenement evenement;

    
    @ManyToOne
    @JoinColumn(name = "ID_UTILISATEUR", referencedColumnName = "ID_UTILISATEUR")
    private Utilisateur utilisateur;
    
   
    @ManyToOne
    @JoinColumn(name = "ID_MACHINE_POS", referencedColumnName = "ID_MACHINE_POS")
    private Machine_pos machine_pos;
    
    private String TACHE;
}
