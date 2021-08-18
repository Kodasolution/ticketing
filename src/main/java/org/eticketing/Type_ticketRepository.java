package org.eticketing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Type_ticketRepository extends JpaRepository<Type_ticket, Long> {

}
