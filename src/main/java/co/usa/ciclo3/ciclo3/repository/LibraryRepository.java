
package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Library;
import co.usa.ciclo3.ciclo3.repository.crud.LibraryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alexander Gonzalez P
 */
@Repository
public class LibraryRepository {
    @Autowired
    private LibraryCrudRepository libraryCrudRepository;
    
    public List<Library> getAll(){
        return (List<Library>) libraryCrudRepository.findAll();
    }
    public Optional<Library> getLibrary(int id){
        return libraryCrudRepository.findById(id);
    }
    public Library save(Library lb){
        return libraryCrudRepository.save(lb);
    }
    public void delete(Library lb){
        libraryCrudRepository.delete(lb);
    }
}
