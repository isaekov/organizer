package com.example.organizer.service;

import com.example.organizer.entity.Status;
import com.example.organizer.rpository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusService {

    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public void newCreate(Status status) {

        Optional<Status> statusOptional = statusRepository.findByName(status.getName());
        if (statusOptional.isEmpty()) {
            statusRepository.save(status);
        }
    }

}
