package com.distribuida.Config;

import com.distribuida.db.Book;
import io.helidon.dbclient.DbMapper;
import io.helidon.dbclient.spi.DbMapperProvider;
import java.util.Optional;
public class MapperProviderBooks implements DbMapperProvider {
    public static final MapperBooks MAPPER = new MapperBooks();
    @Override
    @SuppressWarnings("unchecked")
    public <T> Optional<DbMapper<T>> mapper(Class<T> type) {
        return type.equals(Book.class) ? Optional.of((DbMapper<T>) MAPPER) : Optional.empty();
    }
}
