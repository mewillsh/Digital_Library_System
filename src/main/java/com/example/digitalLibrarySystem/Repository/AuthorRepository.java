package com.example.digitalLibrarySystem.Repository;

import com.example.digitalLibrarySystem.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    @Query("SELECT a from Author a LEFT JOIN fetch a.bookId where a.Authorid=:id")
    Optional<Author> findAuthorWithBooks(@Param("id")Long id);
}
