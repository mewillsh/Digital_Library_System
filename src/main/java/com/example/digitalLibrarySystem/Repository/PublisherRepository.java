package com.example.digitalLibrarySystem.Repository;

import com.example.digitalLibrarySystem.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher,Integer> {

    Optional<Publisher> findByName(String prenticeHall);
}
