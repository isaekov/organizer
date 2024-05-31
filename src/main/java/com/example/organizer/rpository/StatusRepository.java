package com.example.organizer.rpository;

import com.example.organizer.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Integer> {

    public Optional<Status> findByName(String name);
}
