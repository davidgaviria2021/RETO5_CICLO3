
package com.example.demo.Repositorio;

import com.example.demo.Interface.CostumeInterface;
import com.example.demo.Modelo.Costume;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author omarg
 */
@Repository
public class CostumeRepository {
    @Autowired// me permite heredar los metodos 
      private CostumeInterface extencionesCrud;
      
      public List<Costume> getAll(){
          return (List<Costume>) extencionesCrud.findAll();
      }
      
      public Optional<Costume> getCostume(int id){
          return extencionesCrud.findById(id);
      }
      
      public Costume save(Costume costume){
          return extencionesCrud.save(costume);
      } 
      
       public void delete(Costume costume){
        extencionesCrud.delete(costume);                      
    }
}
