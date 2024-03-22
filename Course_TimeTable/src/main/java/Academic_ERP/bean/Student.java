package Academic_ERP.bean;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)///(generator="system-uuid")
    private Long id;
    //@GenericGenerator(name="system-uuid", strategy = "uuid")
   // @Column(name = "rollNo", unique = true, nullable = false)
    @NaturalId
    private String rollNo;
    @Column(nullable = false, length = 100)
    private String name;

    @ManyToMany(mappedBy = "studentsEnrolled")
 //   @ManyToMany(mappedBy = "studentsEnrolled",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    List<Course> coursesEnrolled = new ArrayList<>();

    public Student(){

    }

    public  Student(String rollNo,String name){
        this.rollNo = rollNo;
        this.name = name;
    }


    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCoursesEnrolled() {
        return coursesEnrolled;
    }

    public void setCoursesEnrolled(List<Course> coursesEnrolled) {
        this.coursesEnrolled = coursesEnrolled;
    }

    public void enrollCourse(Course course){
        this.coursesEnrolled.add(course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo='" + rollNo + '\'' +
                ", name='" + name + '\'' +
               // ", coursesEnrolled=" + coursesEnrolled +
                '}';
    }
}
