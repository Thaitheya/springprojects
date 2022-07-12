package com.chainsys.mavenlessons.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import com.chainsys.mavenlessons.entity.Appointments;
import com.chainsys.mavenlessons.entity.Doctors;
import com.chainsys.mavenlessons.repository.DoctorRespository;
/**
 * 
 * @author thai3141
 * @Date 16-06-2022
 *
 */


@RestController
public class DoctorControl {
	@Autowired
	private DoctorRespository repo;
	
//	@Bean
//	public void setRepo(DoctorRepository repo) {
//		this.repo = repo;
//	}
	
	@GetMapping("/getdoctor")
	public Doctors getDoctor(int id) {
		return repo.findById(id);
	}
//	@GetMapping(value = "/getdoctor")
//	public String getDoctor(int id) { 
//		return repo.findById(id).toString();
//	}
	@GetMapping(value = "/getdoctorappointments")
	public List<Appointments> getAppointments(int id) {
	Doctors doc = repo.findById(id);
	List<Appointments> appointments = doc.getAppointments(); 
	return appointments;
	}
	@DeleteMapping("/deletedoctor")
	public RedirectView deleteDoctor(int id) {
		 repo.deleteById(id);
		 return new RedirectView("/getalldoctors");
	}
	@PostMapping(value = "/newdoctor", consumes = "application/json" )
	// we need give from where to read data from the HTTP request and also the content type ("application/json")  
	public RedirectView addDoctor(@RequestBody Doctors dr)
	{
	 repo.save(dr);
	 return new RedirectView("/getalldoctors");
	 
	}
	@PostMapping(value = "/modifydoctor", consumes = "application/json" )
	public RedirectView modifyDoctor(@RequestBody Doctors dr)
	{
	 repo.save(dr);
	 return new RedirectView("/getalldoctors");
	 
	}
	@GetMapping("/getalldoctors")
	public List<Doctors> getDoctors(){
		return repo.findAll();
	}  
}
