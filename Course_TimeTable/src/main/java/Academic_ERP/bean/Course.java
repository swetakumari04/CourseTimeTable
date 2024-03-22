package Academic_ERP.bean;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 //   @GenericGenerator(name="system-uuid", strategy = "uuid")
    //@Column(name = "cid", unique = true, nullable = false)
    @NaturalId
    private String cid;
    private String name;
    private String facultyName;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "Enrolled",
            joinColumns = { @JoinColumn(name = "cid") },
            inverseJoinColumns = { @JoinColumn(name = "rollNo") }
    )

    private List<Student> studentsEnrolled = new ArrayList<>();

    public Course(){

    }

    public Course(String cid,String name,String facultyName){
        this.cid = cid;
        this.name = name;
        this.facultyName = facultyName;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public void enrollStudent(Student student){
        this.studentsEnrolled.add(student);
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid='" + cid + '\'' +
                ", name='" + name + '\'' +
                ",faculty=" + facultyName +'\''+
               // ", studentsEnrolled=" + studentsEnrolled +
                '}';
    }
}
