package com.webapp.springWebapp.repositories;

import com.webapp.springWebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {


}
