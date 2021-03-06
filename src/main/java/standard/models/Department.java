package standard.models;

import javax.persistence.*;

/**
 * User: dimitr
 * Date: 31.08.2014
 * Time: 13:26
 */
@Entity(name = "department")
public class Department {
    @Id
    // TODO: add  (strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;
    private String name;
    // TODO: Change to  Column(name = "institute_id")
    @Column(name = "institute_id")
    private Long instituteId;

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

    public Long getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(Long institute) {
        this.instituteId = institute;
    }
}
