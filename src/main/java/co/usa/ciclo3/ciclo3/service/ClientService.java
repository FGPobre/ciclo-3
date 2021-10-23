package co.usa.ciclo3.ciclo3.service;



import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alexander Gonzalez P
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client>getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    public Client save(Client lb){
        if(lb.getIdClient()==null){
            return clientRepository.save(lb);
        }
        else{
            Optional<Client> lbc=clientRepository.getClient(lb.getIdClient());
            if(lbc.toString().isEmpty()){
                return clientRepository.save(lb);
            }
            else{
                return lb;
            }
        }
    }
}