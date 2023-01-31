package com.distribuida.servicios;

import com.distribuida.db.Author;
import com.distribuida.db.Book;

import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

public interface BookService {
    List<Book> findAll() throws ExecutionException, InterruptedException;
    long createBook(Book book);
    long updateBook(Book book);
    long deleteBook(int id);
    Book findById(int id) throws ExecutionException, InterruptedException;

}
