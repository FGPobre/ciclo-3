package co.usa.ciclo3.ciclo3.service;


import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alexander Gonzalez P
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message>getAll(){
        return messageRepository.getAll();
    }
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    public Message save(Message lb){
        if(lb.getIdMessage()==null){
            return messageRepository.save(lb);
        }
        else{
            Optional<Message> lbc=messageRepository.getMessage(lb.getIdMessage());
            if(!lbc.isPresent()){
                return messageRepository.save(lb);
            }
            else{
                return lb;
            }
        }
    }
}
