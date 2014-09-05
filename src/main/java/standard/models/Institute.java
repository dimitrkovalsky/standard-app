package standard.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "institute")
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;
    private String name = "";
    private Long head = 0L;

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Long getHead(){
        return head;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setHead(Long head){
        this.head = head;
    }
}