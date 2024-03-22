package Academic_ERP;

import Academic_ERP.bean.Course;
import Academic_ERP.bean.Domain;
import Academic_ERP.bean.Slot;
import Academic_ERP.bean.Student;
import Academic_ERP.services.CourseServicesImpl;
import Academic_ERP.util.SessionUtil;
import com.sun.xml.bind.v2.util.CollisionCheckStack;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args){
  /*    Course c1 =new Course("CS501","Algorithms","Muralidhara V N");
        Course c2  = new Course("CS502","Machine Learning","Neelam");

        Student s1 = new Student("MT2019134","Vipin");
        Student s2 = new Student("MT2019061","Manthan");
        Student s3 = new Student("MT2019043","Harshabh");
        Student s4 = new Student("MT2019112","Sameer");
        Student s5 = new Student("MT2019520","Vivek");
        Student s6 = new Student("MT2019525","Vinay");

        List<Student> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();

        students.add(s1);
        students.add(s2);

        c1.enrollStudent(s1);
        c1.enrollStudent(s2);

        c2.enrollStudent(s3);
        c2.enrollStudent(s4);

        s1.enrollCourse(c1);
        s2.enrollCourse(c1);
        s3.enrollCourse(c2);
        s4.enrollCourse(c2);

        Domain d1 = new Domain("MTech CSE");
        Domain d2 = new Domain("MTech ECE");

        Course c3 = new Course("EC801","VLSI","Yashwanth");
        Course c4 = new Course("EC802","Control Systems","Sudarshan Patil Kulkarni");

        Slot slot1 = new Slot(1);
        Slot slot2 = new Slot(2);
        Slot slot3 = new Slot(3);

        slot1.addCourseToSlot(c1); // Algo
        slot1.addCourseToSlot(c3); // Vlsi

        slot2.addCourseToSlot(c2); // ML

        slot3.addCourseToSlot(c4); // Control systems

        d1.addCourseToDomain(c1);
        d1.addCourseToDomain(c2);

        d2.addCourseToDomain(c3);
        d2.addCourseToDomain(c4);

        s5.enrollCourse(c3);
        s6.enrollCourse(c4);

        c3.enrollStudent(s5);
        c4.enrollStudent(s6);

        Session session = SessionUtil.getSession();
        session.beginTransaction();


        session.save(s1);
        session.save(s2);
        session.save(s3);
        session.save(s4);
        session.save(s5);
        session.save(s6);

        session.save(c1);
        session.save(c2);
        session.save(c3);
        session.save(c4);

        session.save(d1);
        session.save(d2);

        session.save(slot1);
        session.save(slot2);
        session.save(slot3);

        session.getTransaction().commit();
        session.close();
*/
/*
        String cname = "EC801";
        List<Student> enrolled = new CourseServicesImpl().findStudentsEnrolled(cname);
        System.out.println("List of students enrolled in "+cname);
        for(Student s:enrolled){
            System.out.println(s);
        }

        int slotNo = 1;
        String domain = "MTech CSE";
        List<Course> courseAlloted = new CourseServicesImpl().findCourseBySlotInDomain(slotNo,domain);
        System.out.println("Courses in slot "+slotNo+" and domain "+domain);
        for (Course c:courseAlloted){
            System.out.println(c);
        }

        slotNo = 1;
        domain  = "MTech ECE";
        courseAlloted = new CourseServicesImpl().findCourseBySlotInDomain(slotNo,domain);
        System.out.println("Courses in slot "+slotNo+" and domain "+domain);
        for (Course c:courseAlloted){
            System.out.println(c);
        }
*/

        List<Course> courses = new CourseServicesImpl().findCourseBySlotInDomain(5,"MTECH CSE");

        for (Course course:courses){
            System.out.println(course);
        }

        String cname = "CS105";
        List<Student> enrolled = new CourseServicesImpl().findStudentsEnrolled(cname);
        System.out.println("List of students enrolled in "+cname);
        for(Student s:enrolled){
            System.out.println(s);
        }
    }
}
