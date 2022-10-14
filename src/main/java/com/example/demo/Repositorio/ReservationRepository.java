
package com.example.demo.Repositorio;

import com.example.demo.Interface.ReservationInterface;
import com.example.demo.Modelo.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author omarg
 */
@Repository
public class ReservationRepository {
        @Autowired// me permite heredar los metodos 
      private ReservationInterface extencionesCrud;
      
      public List<Reservation> getAll(){
          return (List<Reservation>) extencionesCrud.findAll();
      }
      
      public Optional<Reservation> getReservation(int id){
          return extencionesCrud.findById(id);
      }
      
      public Reservation save(Reservation reservation){
          return extencionesCrud.save(reservation);
      }
    
    
    
}
