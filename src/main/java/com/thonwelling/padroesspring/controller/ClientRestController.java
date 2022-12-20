package com.thonwelling.padroesspring.controller;

import com.thonwelling.padroesspring.models.Client;
import com.thonwelling.padroesspring.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Banco de Dados H2 e API do ViaCEP) em uma
 * interface simples e coesa (API REST).
 *
 * @author Thonwelling
 */
@RestController
@RequestMapping("clients")
public class ClientRestController {
  @Autowired
  private ClientService clientService;

  @GetMapping
  public ResponseEntity<Iterable<Client>> findAllClients() {
    return ResponseEntity.ok(clientService.findAllClients());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Client> findClientById(@PathVariable Long id) {
    return ResponseEntity.ok(clientService.FindClientById(id));
  }

  @PostMapping
  public ResponseEntity<Client> addCllient(@RequestBody Client client) {
    clientService.addClient(client);
    return ResponseEntity.ok(client);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Client> updateClientInformations(@PathVariable Long id, @RequestBody Client client) {
    clientService.updateClientInformations(id, client);
    return ResponseEntity.ok(client);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletClient(@PathVariable Long id) {
    clientService.deleteClient(id);
    return ResponseEntity.ok().build();
  }
}
