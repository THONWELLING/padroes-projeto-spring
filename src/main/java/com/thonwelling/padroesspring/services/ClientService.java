package com.thonwelling.padroesspring.services;


import com.thonwelling.padroesspring.controller.models.Client;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 *
 * @author Thonwelling
 */
public interface ClientService {
  Iterable<Client> findAllClients();

  Client FindClientById(Long id);

  void addClient(Client client);

  void updateClientInformations(Long id, Client client);

  void deleteClient(Long id);
}
