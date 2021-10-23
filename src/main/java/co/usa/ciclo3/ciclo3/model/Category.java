package co.usa.ciclo3.ciclo3.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.Table;

/**
 *
 * @author Alexander Gonzalez P
 */

@Entity
@Table(name="category")

public class Category implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="category")
    public List<Library> libs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Library> getLibs() {
        return libs;
    }

    public void setLibs(List<Library> libs) {
        this.libs = libs;
    }

    
}
