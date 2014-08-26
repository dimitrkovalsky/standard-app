package standard.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "userRole")
public class Account {
    @Id
    private Long id = 0L;
    private String login;
    private String password;
    private String role = "";

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}