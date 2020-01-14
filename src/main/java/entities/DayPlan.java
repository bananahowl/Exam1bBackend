package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "day plan")
//@NamedQuery(name = "RenameMe.deleteAllRows", query = "DELETE from RenameMe")
public class DayPlan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //private List<Recipe> recipe;
    
    @Column(name = "user_pass")
    private String DayOfTheWeek;
    
    
    
    public DayPlan() {
    }
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    
    

   
}
