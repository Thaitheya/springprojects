package com.chainsys.mavenlessons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import com.chainsys.mavenlessons.entity.Appointments;
import com.chainsys.mavenlessons.entity.Doctors;
import com.chainsys.mavenlessons.repository.AppointmentRepository;
/**
 * 
 * @author thai3141
 * @Date 16-06-2022
 */
@RestController
public class AppointmentControl {
	@Autowired
	private AppointmentRepository aptRepo;

	@GetMapping(value = "/fetchdoctorbyappointmentid") 
	public String getDoctorByAppointmentId(int id) {
		Appointments app = aptRepo.findById(id);
		Doctors doc = app.getDoctors();
		return doc.toString();
	}

	@GetMapping(value = "/fetchappointment")
	public Appointments getAppointmentById(int id) {
		System.out.println("received data " + id);
		Appointments app = aptRepo.findById(id);
		System.out.println(app == null);
		return app;
	}

//	@GetMapping(value = "/fetchappointmentbydoctor")
//	public List<Appointments> getAppointmentByDocId(int id) {
//		return aptRepo.findByDoctorsId(id);
//	}

	@GetMapping(value = "/fetchallappointments")
	public List<Appointments> getAllAppointments() {
		return aptRepo.findAll();
	}

	@PostMapping(value = "/newappointment", consumes = "application/json")
	public RedirectView addAppointment(@RequestBody Appointments apt) {
		aptRepo.save(apt);
		return  new RedirectView("/fetchallappointment");
	}

	@PostMapping(value = "/modifyappointment", consumes = "application/json")
	public RedirectView updateAppointment(@RequestBody Appointments apt) {
		aptRepo.save(apt);
		return new RedirectView("/fetchallappointment");
	}

	@DeleteMapping(value = "/removeappointment")
	public  RedirectView deleteAppointment(int id) {
		aptRepo.deleteById(id);
		return new RedirectView("/fetchallappointment");
	}

//	@GetMapping(value = "/fetchdoctorbyappointmentid") 
//	public String getDoctorByAppointmentId(int id) {
//		Appointments app = aptRepo.findById(id);
//		Doctors doc = app.getDoctors();
//		return doc.toString();
//	}
}
