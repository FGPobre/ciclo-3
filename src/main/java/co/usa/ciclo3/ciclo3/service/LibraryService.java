
package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Library;
import co.usa.ciclo3.ciclo3.repository.LibraryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alexander Gonzalez P
 */
@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;
    
    public List<Library>getAll(){
        return libraryRepository.getAll();
    }
    public Optional<Library> getLibrary(int id){
        return libraryRepository.getLibrary(id);
    }
    public Library save(Library lb){
        if(lb.getId()==null){
            return libraryRepository.save(lb);
        }
        else{
            Optional<Library> lbc=libraryRepository.getLibrary(lb.getId());
            if(!lbc.isPresent()){
                return libraryRepository.save(lb);
            }
            else{
                return lb;
            }
        }
    }
}
