package com.distribuida.Rest;

import com.distribuida.db.Book;
import com.distribuida.servicios.BookService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
@ApplicationScoped
@Path("/book")
public class BookRest {
    @Inject
    private BookService bookService;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Book findOneById(@PathParam("id") int id) throws ExecutionException, InterruptedException {
        return this.bookService.findById(id);
    }

    @GET
    @Produces("application/json")
    public List<?> findAll() throws ExecutionException, InterruptedException {
        return this.bookService.findAll();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Map<String, Long> updateBook(Book book) {
        return Map.of("rowsChanged", this.bookService.updateBook(book));
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Map<String, Long> createBook(Book book) {
        return Map.of("rowsChanged", this.bookService.createBook(book));
    }

    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public Map<String, Long> deleteBook(@PathParam("id") int id) {
        return Map.of("rowsChanged", this.bookService.deleteBook(id));
    }
}
