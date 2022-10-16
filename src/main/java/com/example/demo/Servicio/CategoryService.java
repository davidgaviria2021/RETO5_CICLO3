
package com.example.demo.Servicio;

import com.example.demo.Modelo.Category;
import com.example.demo.Repositorio.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author omarg   creando atributo q herede  la class anterior ene sta capa de servicio es donde  se define donde nosotros podemo hacer reglas de negocio las reglas de negocio son basicamente seguridades en el momento q estemos haciendo operaciones de crud
 */

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    
    public Category save (Category category){
        if(category.getId() ==null){
            return categoryRepository.save(category);
        }else{
                    Optional<Category> category1 = categoryRepository.getCategory(category.getId());// para que no venga una id repetida
                   if(category1.isEmpty()){
                       return categoryRepository.save(category);
                   } else{
                       return category;
                   }
                    
            
        }
    }
    
    
      public Category update (Category category){
        if(category.getId()!=null){
            Optional<Category>g= categoryRepository.getCategory(category.getId());
            if(!g.isEmpty()){
                if(category.getDescription() !=null){
                    g.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                return categoryRepository.save(g.get());            
            }
        }
        return category;            
    }
    
    
      public boolean deleteCategory (int id){
        Boolean d = getCategory(id).map(category -> {// para recorrer todo eso
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return d;    
    }    
    
    
           
}
