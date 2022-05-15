package lt.vu.alma6475.lab1.rest;

import lombok.Getter;
import lombok.Setter;
import lt.vu.alma6475.lab1.entity.Student;
import lt.vu.alma6475.lab1.persistence.StudentsDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

@ApplicationScoped
@Path("/student")
public class StudentController {

    @Inject
    @Setter @Getter
    private StudentsDAO studentsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Student student = studentsDAO.findOne(id);
        if (student == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        StudentDto studentDTO = new StudentDto();
        studentDTO.setName(student.getName());
        studentDTO.setVersion(student.getVersion());

        return Response.ok(studentDTO).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(StudentDto studentDto){
        if (studentDto == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        try{
            Student student = new Student();
            student.setName(studentDto.getName());
            studentsDAO.persist(student);

            URI location = UriBuilder.fromResource(StudentController.class)
                    .path("/{id}")
                    .resolveTemplate("id", student.getId())
                    .build();

            return Response.created(location).build();
        } catch (OptimisticLockException e){
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Integer studentId, StudentDto subjectData) {
        try {
            Student existingSubject = studentsDAO.findOne(studentId);

            if (existingSubject == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingSubject.setName(subjectData.getName());
            existingSubject.setVersion(subjectData.getVersion());

            studentsDAO.update(existingSubject);

            System.out.println("LAST  " + subjectData.getName());

        } catch (OptimisticLockException ole) {
            System.out.println("OLE Raised.");
            return Response.status(Response.Status.CONFLICT).build();
        }

        return Response.ok().build();
    }
}
