package io.github.lberaldi.bookservice.repository;

import io.github.lberaldi.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
