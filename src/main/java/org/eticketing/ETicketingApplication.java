package org.eticketing;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ETicketingApplication implements CommandLineRunner {
	
	@Autowired
	private EvenementRepository evenementRepository;
	
	
	@Autowired
	private Profil_utilisateurRepository profil_utilisateurRepository;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private Machine_posRepository machine_posRepository;
	
	@Autowired
	private AffectationRepository affectationRepository;
	
	@Autowired
	private TicketRepository ticketRepository;

	public static void main(String[] args) {
		SpringApplication.run(ETicketingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Create a profil
		Profil_utilisateur administrateur= new Profil_utilisateur("Admnistrateur",true,true,true,true, true, true, true);
		Profil_utilisateur agent_vente= new Profil_utilisateur("Vendeur de billets",false,true,false,false, false, false, false);
		Profil_utilisateur verificateur= new Profil_utilisateur("Vérificateur des billets",false,false,true,false, false, false, false);
		
		List<Profil_utilisateur> profils = Arrays.asList(administrateur,agent_vente,verificateur);
		
		// Create a user
		Utilisateur landry= new Utilisateur("Ayinkamiye", "Landry","79814676", "hhhgghg","ruvumu125@gmail.com","gfgffgfgfg",null,null,administrateur) ;
		Utilisateur alice= new Utilisateur("Kaneza", "Alice","61126830", "hhhgghg","kalice125@gmail.com","oooioio",null,null,agent_vente) ;
		Utilisateur andre= new Utilisateur("Sintuka", "Andre","63662730", "hhhgghg","sintandre@gmail.com","nnbnbn",null,null,verificateur) ;
		
		List<Utilisateur> utilisateurs = Arrays.asList(landry,alice,andre);
		
		//create pos machine
		Machine_pos mach1=new Machine_pos("7878788", "89066");
		Machine_pos mach2=new Machine_pos("85444", "53223");
		Machine_pos mach3=new Machine_pos("434333", "33445");
		
		List<Machine_pos> machines = Arrays.asList(mach1,mach2,mach3);
		
		// Create an event
		Evenement concert_bonyi=new Evenement("Concert bonyi", "logo",new Date(),"12h:00","Stade Ingoma");
		
		// Create two type ticket
        Type_ticket ticket_vip = new Type_ticket("Ticket VIP", 120, 130000.0);
        Type_ticket ticket_sponsor =  new Type_ticket("Ticket sponsor", 1000, 130000.0);
        Type_ticket ticket_standard =  new Type_ticket("Ticket Standard", 320, 130000.0);
        
        //create affectation
        Affectation affectation_vente=new Affectation(null, new Date(), concert_bonyi, alice, mach1, "Vente de billets");
        Affectation affectation_verification=new Affectation(null, new Date(), concert_bonyi, alice, mach2, "Vérification des billets");
        
        List<Affectation> affectations = Arrays.asList(affectation_vente,affectation_verification);
        
       //create ticket
	    Ticket ticket1=new Ticket(null, "jjjj", new Date(), false, concert_bonyi, alice,ticket_vip);
	    Ticket ticket2=new Ticket(null, "ooooo", new Date(), false, concert_bonyi, alice,ticket_vip);
	    Ticket ticket3=new Ticket(null, "bnbnnb", new Date(), false, concert_bonyi, alice,ticket_sponsor);
	    Ticket ticket4=new Ticket(null, "vfdfdf", new Date(), false, concert_bonyi, alice,ticket_standard);
        
        List<Ticket> tickets = Arrays.asList(ticket1,ticket2,ticket3,ticket4);
        
		
		
		// Add type ticket references in the event
		concert_bonyi.getType_ticket().add(ticket_vip);
		concert_bonyi.getType_ticket().add(ticket_sponsor);
		concert_bonyi.getType_ticket().add(ticket_standard);
		
		//save profil
		profil_utilisateurRepository.saveAll(profils);
		
		//save user
		utilisateurRepository.saveAll(utilisateurs);
		
		//save machine pos
		machine_posRepository.saveAll(machines);
		
		//save evenement
		evenementRepository.save(concert_bonyi);
		
		//save affectation
		affectationRepository.saveAll(affectations);
		
		//save ticket
		ticketRepository.saveAll(tickets);

	}

}
