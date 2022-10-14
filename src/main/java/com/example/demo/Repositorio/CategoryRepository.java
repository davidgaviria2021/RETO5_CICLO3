
package com.example.demo.Repositorio;

import com.example.demo.Interface.CategoryInterface;
import com.example.demo.Modelo.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author omarg
 */
@Repository
public class CategoryRepository {
      @Autowired// me permite heredar los metodos 
      private CategoryInterface extencionesCrud;
      
      public List<Category> getAll(){
          return (List<Category>) extencionesCrud.findAll();
      }
      
      public Optional<Category> getCategory(int id){
          return extencionesCrud.findById(id);
      }
      
      public Category save(Category category){
          return extencionesCrud.save(category);
      }
}
      
