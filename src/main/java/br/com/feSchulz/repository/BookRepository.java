package br.com.feSchulz.repository;


import br.com.feSchulz.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {}