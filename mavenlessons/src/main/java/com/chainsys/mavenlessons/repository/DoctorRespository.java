package com.chainsys.mavenlessons.repository;


	import java.util.List;

	import org.springframework.data.repository.CrudRepository;

import com.chainsys.mavenlessons.entity.Doctors;

	public interface DoctorRespository extends CrudRepository<Doctors,Integer>{
		Doctors findById(int id);
		@SuppressWarnings("unchecked")
		Doctors save(Doctors dr);
		// Used for both adding new Doctor and Modifying new Doctor
		void deleteById(int id);
		List <Doctors> findAll();
	}

