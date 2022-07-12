package com.chainsys.mavenlessons.repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.chainsys.mavenlessons.entity.Appointments;
/**
 * 
 * @author thai3141
 * @Date 16-06-2022
 */
public interface AppointmentRepository extends CrudRepository<Appointments,Integer> {

	Appointments findById(int id);
	@SuppressWarnings("unchecked")
	Appointments save(Appointments apt);
	void deleteById(int id);
	List<Appointments> findAll();
//	@Query("select a from Appointments a where a.doctor_id =?1")//JPQL
	//Instance of appointment entity
	List<Appointments> findByDoctorsId(int id);
	
}
