package standard.requests;

/**
 * Created by Dmytro_Kovalskyi on 02.09.2014.
 */
public class DepartmentRequest {
    private String name;
    private Long instituteId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(Long instituteId) {
        this.instituteId = instituteId;
    }

    @Override
    public String toString() {
        return "DepartmentRequest{" +
                "name='" + name + '\'' +
                ", instituteId=" + instituteId +
                '}';
    }
}
