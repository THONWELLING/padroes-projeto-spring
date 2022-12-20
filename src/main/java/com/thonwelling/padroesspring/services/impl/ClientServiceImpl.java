package com.thonwelling.padroesspring.services.impl;

import com.thonwelling.padroesspring.models.Address;
import com.thonwelling.padroesspring.models.Client;
import com.thonwelling.padroesspring.repositories.AddressRepository;
import com.thonwelling.padroesspring.repositories.ClientRepository;
import com.thonwelling.padroesspring.services.ClientService;
import com.thonwelling.padroesspring.services.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * Implementação da <b>Strategy</b> {@link ClientService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 *
 * @author Thonwelling
 */

@Service
public class ClientServiceImpl implements ClientService {


  // Singleton: Injetar os componentes do Spring com @Autowired.
  @Autowired
  private ClientRepository clientRepository;
  @Autowired
  private AddressRepository addressRepository;
  @Autowired
  private ViaCepService viaCepService;

  // Strategy: Implementar os métodos definidos na interface(ClientService).
  // Facade: Abstrair integrações com subsistemas(Viacep), provendo uma interface simples.
  @Override
  public Iterable<Client> findAllClients() {
    return clientRepository.findAll();
  }

  @Override
  public Client FindClientById(Long id) {
    Optional<Client> client = clientRepository.findById(id);
    if (client.isPresent()) {
      return client.get();
    } else { throw new RuntimeException("Client Does Not Exists");
    }
  }

  @Override
  public void addClient(Client client) {
    saveClientWithZipCode(client);
  }

  @Override
  public void updateClientInformations(Long id, Client client) {
    Optional<Client> clientBd = clientRepository.findById(id);
    if (clientBd.isPresent()) {
      saveClientWithZipCode(client);
    }
  }

  @Override
  public void deleteClient(Long id) {
    clientRepository.deleteById(id);
  }

  private void saveClientWithZipCode(Client client) {
    // Verificar se o Endereco do Cliente já existe (pelo CEP).
    String cep = client.getAddress().getCep();
    Address address = addressRepository.findById(cep).orElseGet(() -> {
      // Caso não exista, integrar com o ViaCEP e persistir o retorno.
      Address newAddress = viaCepService.consultZipCode(cep);
      addressRepository.save(newAddress);
      return newAddress;
    });
    client.setAddress(address);
    // Inserir Cliente, vinculando o Endereco (novo ou existente).
    clientRepository.save(client);
  }
}
