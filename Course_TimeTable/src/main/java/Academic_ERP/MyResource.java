package Academic_ERP;

import Academic_ERP.bean.Student;
import Academic_ERP.services.CourseServicesImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "I am it!";
    }

    @POST
    @Path("/getStudentsEnrolled")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public List<Student> getStudentsEnrolled(String cid){
        CourseServicesImpl cser = new CourseServicesImpl();

        List<Student> enrolledStudents = new CourseServicesImpl().findStudentsEnrolled(cid);

        return enrolledStudents;
    }


    @GET
    @Path("/sample")
    @Produces(MediaType.TEXT_PLAIN)
    public String getDisplay() {
        return "I am second!";
    }

}
