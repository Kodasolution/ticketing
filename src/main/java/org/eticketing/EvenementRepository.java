package org.eticketing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EvenementRepository extends JpaRepository<Evenement, Long> {

}
