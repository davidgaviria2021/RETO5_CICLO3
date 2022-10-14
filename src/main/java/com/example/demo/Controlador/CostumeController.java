/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controlador;

import com.example.demo.Modelo.Costume;
import com.example.demo.Servicio.CostumeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author omarg
 */
@RestController
@RequestMapping("/api/Costume")
public class CostumeController {
    
     @Autowired // mepermite traer metodos desde otros paquetees 
    private CostumeService costumeService;

    @GetMapping("/all")//leee la tabla completa
    public List<Costume> getAll() {
        return costumeService.getAll();
    }

    @GetMapping("/{id}")// nos resive un id y devulve los s datos d ese id
    public Optional<Costume> getcCostume(@PathVariable("id") int id) {
        return costumeService.getCostume(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Costume save(@RequestBody Costume costume) {
        return costumeService.save(costume);
    }
    
}
