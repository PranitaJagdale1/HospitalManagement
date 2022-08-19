package com.hospital.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.hospital.api.model.Prescription;
import com.hospital.api.model.User;
import com.hospital.api.repository.PrescriptionRepository;
import com.hospital.api.repository.UserRepository;


@RestController
@CrossOrigin(origins= {"http://localhost:4200/"})
public class PrescriptionController {
	
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/prescription/{uid}")
	public Prescription postPrescription(@PathVariable ("uid") Long uid,@RequestBody Prescription prescription)
	{
		User user = userRepository.getById(uid);
		prescription.setUser(user);
		return prescriptionRepository.save(prescription);
	}
	
	@GetMapping("/prescription/user/{uid}")
	public List<Prescription> getprescription(@PathVariable ("uid") Long uid)
	{
		return prescriptionRepository.findByUserId(uid);
	}
	
}
