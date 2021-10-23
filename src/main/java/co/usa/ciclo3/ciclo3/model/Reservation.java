package co.usa.ciclo3.ciclo3.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Table;

/**
 *
 * @author Alexander Gonzalez P
 */
@Entity
@Table(name="reservation")

public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private String startDate;
    private String devolutionDate;
    private String status="created";
    @ManyToOne
    @JoinColumn(name="libId")
    @JsonIgnoreProperties("reservations")
    public Library lib;
    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"reservations","messages"})
    public Client client;
    
    private Integer score;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(String devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Library getLib() {
        return lib;
    }

    public void setLib(Library lib) {
        this.lib = lib;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

  
   
}