package com.hospitalproject.pojo;


import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentBean {
	private int id;
	private LocalDateTime appointmentDateTime;
	private DoctorBean doctor;
	private PatientBean patient;

}
