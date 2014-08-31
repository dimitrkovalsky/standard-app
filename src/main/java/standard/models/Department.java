package standard.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * User: dimitr
 * Date: 31.08.2014
 * Time: 13:26
 */
@Entity(name = "department")
public class Department {
    @Id
    @GeneratedValue
    private Long id = 0L;
    private String name;
    private Long institute;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getInstitute() {
        return institute;
    }

    public void setInstitute(Long institute) {
        this.institute = institute;
    }
}
