
package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Library;
import co.usa.ciclo3.ciclo3.service.LibraryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alexander Gonzalez P
 */
@RestController
@RequestMapping("/api/Lib")
@CrossOrigin(origins="*",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,
    RequestMethod.DELETE})
public class LibraryController {
    @Autowired
    private LibraryService libraryService;
    
    @GetMapping("/all")
    public List<Library>getLibrary(){
        return libraryService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Library>getLibrar(@PathVariable("id")int id ){
        return libraryService.getLibrary(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Library save(@RequestBody Library lb){
        return libraryService.save(lb);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Library update(@RequestBody Library lb){
        return libraryService.update(lb);
    }
    @DeleteMapping("/{id}")
    public boolean deleteCategory(@PathVariable("id")int id ){
        return libraryService.delete(id);
    }
}
