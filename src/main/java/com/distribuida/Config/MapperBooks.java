package com.distribuida.Config;

import com.distribuida.db.Author;
import com.distribuida.db.Book;
import io.helidon.dbclient.DbMapper;
import io.helidon.dbclient.DbRow;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class MapperBooks implements DbMapper<Book> {

    @Override
    public Book read(DbRow row) {
        var id = row.column("id");
        var isbn = row.column("isbn");
        var title = row.column("title");
        var price = row.column("price");
        var authorId = row.column("author_id");
        var firstName = row.column("first_name");
        var lastName = row.column("last_name");
        return new Book(
                id.as(Integer.class),
                new Author(
                        authorId.as(Integer.class),
                        firstName.as(String.class),
                        lastName.as(String.class)
                ),
                isbn.as(String.class),
                title.as(String.class),
                price.as(Double.class)
        );
    }

    @Override
    public Map<String, ?> toNamedParameters(Book value) {
        Map<String, Object> parameters = new HashMap<>();
        /*var map = new HashMap<String, Object>();*/
        parameters.put("id", value.getId());
        parameters.put("isbn", value.getIsbn());
        parameters.put("title", value.getTitle());
        parameters.put("price", value.getPrice());

        var author = value.getAuthor();
        parameters.put("authorId", author.getId());
        parameters.put("firstName", author.getFirstName());
        parameters.put("lastName", author.getLastName());

        return parameters;
    }

    @Override
    public List<?> toIndexedParameters(Book value) {
        List<Object> parameters = new ArrayList<>();
        parameters.add(value.getId());
        parameters.add(value.getIsbn());
        parameters.add(value.getTitle());
        parameters.add(value.getPrice());

        var author = value.getAuthor();
        parameters.add(author.getId());
        parameters.add(author.getFirstName());
        parameters.add(author.getLastName());

        return parameters;
    }


}
