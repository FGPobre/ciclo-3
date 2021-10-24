package co.usa.ciclo3.ciclo3.service;



import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.repository.ReservationRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alexander Gonzalez P
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation>getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    public Reservation save(Reservation lb){
        if(lb.getIdReservation()==null){
        LocalDate fechaini =LocalDate.parse(lb.getStartDate());
        LocalDate fechad=LocalDate.parse(lb.getDevolutionDate());
        LocalTime lt = LocalTime.of(0,0) ;
        OffsetDateTime fechaini_of = OffsetDateTime.of( fechaini , lt , ZoneOffset.UTC ) ;
        OffsetDateTime fechad_of = OffsetDateTime.of( fechad , lt , ZoneOffset.UTC ) ;
        DateTimeFormatter f = DateTimeFormatter.ofPattern( "uuuu-MM-dd'T'HH:mm:ss.SSSZ" , Locale.US );
        String Fecha_fi=fechaini_of.format(f);
        String Fecha_ff=fechad_of.format(f);
        String nueva_Fecha_fi=Fecha_fi.substring(0, 26)+":"+Fecha_fi.substring(26);
        String nueva_Fecha_ff=Fecha_ff.substring(0, 26)+":"+Fecha_fi.substring(26);
        lb.setStartDate(nueva_Fecha_fi);
        lb.setDevolutionDate(nueva_Fecha_ff);
        return reservationRepository.save(lb);
         
        }
        else{
            Optional<Reservation> lbc=reservationRepository.getReservation(lb.getIdReservation());
            if(!lbc.isPresent()){
                LocalDate fechaini =LocalDate.parse(lb.getStartDate());
                LocalDate fechad=LocalDate.parse(lb.getDevolutionDate());
                LocalTime lt = LocalTime.of(0,0);
                OffsetDateTime fechaini_of = OffsetDateTime.of( fechaini , lt , ZoneOffset.UTC ) ;
                OffsetDateTime fechad_of = OffsetDateTime.of( fechad , lt , ZoneOffset.UTC ) ;
                DateTimeFormatter f = DateTimeFormatter.ofPattern( "uuuu-MM-dd'T'HH:mm:ss.SSSZ" , Locale.ROOT );
                lb.setStartDate(fechaini_of.format(f));
                lb.setDevolutionDate(fechad_of.format(f));
                return reservationRepository.save(lb);
            }
            else{
                return lb;
            }
        }
    }
}
