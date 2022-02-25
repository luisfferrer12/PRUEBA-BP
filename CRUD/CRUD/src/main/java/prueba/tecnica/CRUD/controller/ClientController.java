package prueba.tecnica.CRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.tecnica.CRUD.exception.ResourceNotFoundException;
import prueba.tecnica.CRUD.model.Client;
import prueba.tecnica.CRUD.repository.ClientRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> getEmployById(@PathVariable Integer id){
        Client client = clientRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Client does not exist with id: " + id));

        return ResponseEntity.ok(client);
    }

    @PutMapping("{id}")
    public ResponseEntity<Client> updateClient(@PathVariable int id,@RequestBody Client clientDetails) {
        Client updateClient = clientRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Client does not exist with id: " + id));

        updateClient.setEstado(clientDetails.getEstado());
        updateClient.setFecha_ingreso(clientDetails.getFecha_ingreso());
        updateClient.setMonto(clientDetails.getMonto());
        updateClient.setId_cliente(clientDetails.getId_cliente());

        clientRepository.save(updateClient);

        return ResponseEntity.ok(updateClient);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable int id) {
        Client clientDeleted = clientRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Client does not exist with id: " + id));

        clientRepository.delete(clientDeleted);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
