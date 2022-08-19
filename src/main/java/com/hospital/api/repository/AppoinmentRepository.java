package com.hospital.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.api.model.Appoinment;

public interface AppoinmentRepository extends JpaRepository<Appoinment, Long>{

	List<Appoinment> findByDoctorId(Long did);

}
