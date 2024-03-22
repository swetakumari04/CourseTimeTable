package Academic_ERP.controllers;


import Academic_ERP.bean.Course;
import Academic_ERP.bean.Course_Min;
import Academic_ERP.bean.Student;
import Academic_ERP.bean.Student_Min;
import Academic_ERP.services.CourseServicesImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("courses")
public class    CourseController {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(){
        return "Working";
    }

    @POST
    @Path("/getStudentsEnrolled")
    // @Produces(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Consumes(MediaType.TEXT_PLAIN)
    public List<Student_Min>  getStudentsEnrolled(String cid){
        CourseServicesImpl cser = new CourseServicesImpl();
        List<Student_Min> enrolledStudentsRet = new ArrayList<>();
        System.out.println("Received = "+cid);

        List<Student> enrolledStudents = new CourseServicesImpl().findStudentsEnrolled(cid);

        System.out.println("List of students enrolled in "+cid);
        for(Student s:enrolledStudents){
            System.out.println(s);
            enrolledStudentsRet.add(new Student_Min(s.getRollNo(),s.getName()));
        }

        return enrolledStudentsRet;
    }

    @GET
    @Path("/getCoursesInSlot")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Course_Min> getCoursesInSlot(@QueryParam("dname") String dname,@QueryParam("slotNo") int slotNo){

        System.out.println("Received :"+dname+" "+slotNo);

        CourseServicesImpl cser = new CourseServicesImpl();
        List<Course_Min> coursesAlloted = new ArrayList<>();

        List<Course> courses = cser.findCourseBySlotInDomain(slotNo,dname);
        System.out.println("Courses in slot:");
        for(Course c:courses){
            System.out.println(c);
            coursesAlloted.add(new Course_Min(c.getCid(),c.getName(),c.getFacultyName(),slotNo));
        }

        return coursesAlloted;
    }

}
