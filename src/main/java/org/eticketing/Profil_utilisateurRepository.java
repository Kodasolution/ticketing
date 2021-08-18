package org.eticketing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Profil_utilisateurRepository extends JpaRepository<Profil_utilisateur, Long>{

}
