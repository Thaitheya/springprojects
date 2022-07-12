package com.chainsys.mavenlessons.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Doctors")
public class Doctors {
	/**
	 * @author thai3141
	 * @Date 16-06-2022
	 */
	
	@Id
    @Column(name = "doctor_id")
	private int id;
	@Column(name = "doctor_name")
	private String doctor_name;
	@Column(name = "dob")
	private Date dob;
	@Column(name ="phone_no")
	private long phone_no;
	@Column(name = "standard_fees")
	private float fees;
	// Bidirectional Association
	@OneToMany(mappedBy = "doctors", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Appointments> appointments;

	public void setAppointments(List<Appointments> appointments) {
		this.appointments = appointments;
	}

	public List<Appointments> getAppointments() {
		return this.appointments;
	}

	public int getDoctor_id() {
		return id;
	}

	public void setDoctor_id(int doctor_id) {
		this.id = doctor_id;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}

	public float getFees() {
		return fees;
	}

	public void setFees(float fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return String.format("%d, %s, %s, %d, %.2f", id, doctor_name, dob, phone_no, fees);
	}
}
