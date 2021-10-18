package co.usa.ciclo3.ciclo3.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Table;

/**
 *
 * @author Alexander Gonzalez P
 */
@Entity
@Table(name="library")

public class Library implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String target;
    private Integer capacity;
    private Integer capacity_id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getCapacity_id() {
        return capacity_id;
    }

    public void setCapacity_id(Integer capacity_id) {
        this.capacity_id = capacity_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
