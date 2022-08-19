package com.hospital.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.hospital.api.model.Appoinment;
import com.hospital.api.model.Category;
import com.hospital.api.model.Doctor;
import com.hospital.api.repository.AppoinmentRepository;
import com.hospital.api.repository.CategoryRepository;
import com.hospital.api.repository.DoctorRepository;

@RestController
@CrossOrigin(origins= {"http://localhost:4200/"})
public class DoctorController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private AppoinmentRepository appoinmentRepository;
	
	@PostMapping("/doctor/{cid}")
	public Doctor postDoctor(@PathVariable("cid") Long cid, @RequestBody Doctor doctor)
	{
		Category category = categoryRepository.getById(cid);
		doctor.setCategory(category);
		return doctorRepository.save(doctor);
	}
	
	@GetMapping("/doctor/{cid}")
	public List<Doctor> getAllDoctors(@PathVariable("cid") Long cid)
	{
		return doctorRepository.findByCategoryId(cid);
	}
	
	@PostMapping("/appoinment/{did}")
	public Appoinment postAppoinment(@PathVariable ("did") Long did,@RequestBody Appoinment appoinment)
	{
		Doctor doctor = doctorRepository.getById(did);
		appoinment.setDoctor(doctor);
		return appoinmentRepository.save(appoinment);
	}
	
	@GetMapping("/appoinment/doctor/{did}")
	public List<Appoinment> getAllAppoinment(@PathVariable ("did") Long did)
	{
		return appoinmentRepository.findByDoctorId(did);
	}
}
