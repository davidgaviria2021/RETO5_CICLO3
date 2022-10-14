
package com.example.demo.Repositorio;

import com.example.demo.Interface.ClientInterface;
import com.example.demo.Modelo.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author omarg
 */
@Repository
public class ClientRepository {
      @Autowired// me permite heredar los metodos 
      private ClientInterface extencionesCrud;
      
      public List<Client> getAll(){
          return (List<Client>) extencionesCrud.findAll();
      }
      
      public Optional<Client> getClient(int id){
          return extencionesCrud.findById(id);
      }
      
      public Client save(Client client){
          return extencionesCrud.save(client);
      }
    
}
