package Academic_ERP.services;

import Academic_ERP.bean.Course;
import Academic_ERP.bean.Student;

import java.util.List;

public interface CourseServices {
    List<Student> findStudentsEnrolled(String cid);
    List<Course>  findCourseBySlotInDomain(int slotNo,String dname);
    List<Course>   findCourseBySlot(int slotNo);
}
