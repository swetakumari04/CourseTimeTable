package Academic_ERP.services;

import Academic_ERP.bean.Course;
import Academic_ERP.bean.Domain;
import Academic_ERP.bean.Slot;
import Academic_ERP.bean.Student;
import Academic_ERP.util.SessionUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CourseServicesImpl implements CourseServices {

    @Override
    public List<Student> findStudentsEnrolled(String cid) {
        Session session = SessionUtil.getSession();
        session.beginTransaction();

        Course course = (Course) session.bySimpleNaturalId(Course.class).load(cid);

        session.getTransaction().commit();
        session.close();
        return course.getStudentsEnrolled();
    }

    @Override
    public List<Course> findCourseBySlotInDomain(int slotNo, String dname) {

        List<Course> coursesAlloted  = new ArrayList<>();

        Session session = SessionUtil.getSession();
        session.beginTransaction();

        List<Course> domainOffered = ((Domain)session.bySimpleNaturalId(Domain.class).load(dname)).getCoursesOffered();
        List<Course> courseInSlot  = ((Slot)session.bySimpleNaturalId(Slot.class).load(slotNo)).getCoursesAlloted();

        for(Course dof:domainOffered){
            for (Course cis:courseInSlot){
                if(dof.getCid().equals(cis.getCid()))
                    coursesAlloted.add(dof);
            }
        }


        return coursesAlloted;
    }

    @Override
    public List<Course> findCourseBySlot(int slotNo) {

        Session session = SessionUtil.getSession();
        session.beginTransaction();


        List<Course> courseInSlot  = ((Slot)session.bySimpleNaturalId(Slot.class).load(slotNo)).getCoursesAlloted();



        return courseInSlot;
    }
}
