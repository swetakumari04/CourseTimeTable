package Academic_ERP.bean;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NaturalId
    private int slotNo;
    @ManyToMany
    private List<Course> coursesAlloted = new ArrayList<>();

    public Slot(){

    }

    public Slot(int slotNo){
        this.slotNo = slotNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    public List<Course> getCoursesAlloted() {
        return coursesAlloted;
    }

    public void setCoursesAlloted(List<Course> coursesAlloted) {
        this.coursesAlloted = coursesAlloted;
    }

    public void addCourseToSlot(Course course){
        this.coursesAlloted.add(course);
    }


    @Override
    public String toString() {
        return "Slot{" +
                "id=" + id +
                ", slotNo=" + slotNo +
                //", coursesAlloted=" + coursesAlloted +
                '}';
    }
}
