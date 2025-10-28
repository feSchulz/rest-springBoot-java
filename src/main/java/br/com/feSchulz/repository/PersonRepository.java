package br.com.feSchulz.repository;

import br.com.feSchulz.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {}