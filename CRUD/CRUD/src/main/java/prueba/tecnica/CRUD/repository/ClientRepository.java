package prueba.tecnica.CRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prueba.tecnica.CRUD.model.Client;


public interface ClientRepository extends JpaRepository<Client, Integer> {

}
