package Academic_ERP.bean;

import org.hibernate.annotations.NaturalId;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NaturalId
    private String dname;
    @OneToMany
    List<Course> coursesOffered = new ArrayList<>();

    public Domain(){

    }

    public Domain(String dname){
        this.dname = dname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDno(String dname) {
        this.dname = dname;
    }

    public List<Course> getCoursesOffered() {
        return coursesOffered;
    }

    public void setCoursesOffered(List<Course> coursesOffered) {
        this.coursesOffered = coursesOffered;
    }

    public void addCourseToDomain(Course course){
        this.coursesOffered.add(course);
    }

    @Override
    public String toString() {
        return "Domain{" +
                "id=" + id +
                ", dno='" + dname + '\'' +
     //           ", coursesOffered=" + coursesOffered +
                '}';
    }
}
