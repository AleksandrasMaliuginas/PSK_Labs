package lt.vu.alma6475.lab1.rest;

import lombok.Getter;
import lombok.Setter;
import lt.vu.alma6475.lab1.entity.Subject;
import lt.vu.alma6475.lab1.persistence.SubjectsDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/subject")
public class SubjectController {

    @Inject
    @Setter @Getter
    private SubjectsDAO subjectsDAO;

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(subjectsDAO.loadAll()).build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Subject subject = subjectsDAO.findOne(id);
        if (subject == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setName(subject.getName());
        subjectDto.setTutorName(subject.getTutor().getName());

        return Response.ok(subjectDto).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer subjectId,
            SubjectDto subjectData) {
        try {
            Subject existingPlayer = subjectsDAO.findOne(subjectId);
            if (existingPlayer == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingPlayer.setName(subjectData.getName());
            subjectsDAO.update(existingPlayer);

            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
