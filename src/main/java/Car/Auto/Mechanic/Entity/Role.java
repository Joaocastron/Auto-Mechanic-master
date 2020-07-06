package Car.Auto.Mechanic.Entity;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {
    
    public Role() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}