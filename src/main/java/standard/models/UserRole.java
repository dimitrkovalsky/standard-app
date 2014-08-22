package standard.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "userRole")
public class UserRole {
    @Id
    private Long id = 0L;
    private String role = "";

    public Long getId(){
        return id;
    }

    public String getRole(){
        return role;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setRole(String role){
        this.role = role;
    }
}