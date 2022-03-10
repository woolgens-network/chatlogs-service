package net.woolgens.chatlogs.resource;

import net.woolgens.chatlogs.model.ChatLog;
import net.woolgens.chatlogs.repository.ChatLogsRepository;
import net.woolgens.library.microservice.exception.ServiceException;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;
import java.util.Optional;

@Path("/chatlogs/")
public class ChatLogsResource {

    @Inject
    ChatLogsRepository repository;

    @GET
    @RolesAllowed({"Admin", "Moderator"})
    public List<ChatLog> getAll() {
        return repository.listAll();
    }

    @GET
    @Path("{id}")
    @RolesAllowed({"Admin", "Moderator"})
    public ChatLog get(@PathParam("id") String id) throws ServiceException {
        Optional<ChatLog> optional = repository.findByIdOptional(id);
        if(!optional.isPresent()) {
            throw new ServiceException(404, "Chatlog not found");
        }
        return optional.get();
    }

    @PUT
    @RolesAllowed("Admin")
    public ChatLog put(ChatLog chatlog) {
        repository.persistOrUpdate(chatlog);
        return chatlog;
    }

    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") String id) {
        return repository.deleteById(id);
    }
}