package standard.models;

import java.lang.Long;
import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "institute")
public class Institute {
    @Id
    @GeneratedValue
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