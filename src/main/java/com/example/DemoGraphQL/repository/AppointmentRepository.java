package com.example.DemoGraphQL.repository;
 
import com.example.DemoGraphQL.model.Appointment; 

import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}
