package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alexander Gonzalez P
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category>getAll(){
        return categoryRepository.getAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    public Category save(Category lb){
        if(lb.getId()==null){
            return categoryRepository.save(lb);
        }
        else{
            Optional<Category> lbc=categoryRepository.getCategory(lb.getId());
            if(lbc.toString().isEmpty()){
                return categoryRepository.save(lb);
            }
            else{
                return lb;
            }
        }
    }
}