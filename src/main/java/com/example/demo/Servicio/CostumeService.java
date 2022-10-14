/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Costume;
import com.example.demo.Repositorio.CostumeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author omarg
 */
@Service
public class CostumeService {
    
      @Autowired
    private CostumeRepository costumeRepository;
    
    public List<Costume> getAll(){
        return costumeRepository.getAll();
    }
    
    public Optional<Costume> getCostume(int id){
        return costumeRepository.getCostume(id);
    }
    
     public Costume save (Costume costume){
        if(costume.getId() == null){
            return costumeRepository.save(costume);
        }else{
                    Optional<Costume> costume1 = costumeRepository.getCostume(costume.getId());// para que no venga una id repetida
                   if(costume1.isEmpty()){
                       return costumeRepository.save(costume);
                   } else{
                       return costume;
                   }
                    
            
        }
    }
    
    
    
}
