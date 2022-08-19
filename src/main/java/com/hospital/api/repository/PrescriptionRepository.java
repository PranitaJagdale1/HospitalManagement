package com.hospital.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.api.model.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long>{

	

	List<Prescription> findByUserId(Long uid);

}
