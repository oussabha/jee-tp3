package com.example.demo.repositories;

import com.example.demo.entities.patient;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

public interface Patientrepositories extends JpaRepository<patient,Long> {
    Page<patient> findByNomContains(String kw, Pageable pageable);
}
