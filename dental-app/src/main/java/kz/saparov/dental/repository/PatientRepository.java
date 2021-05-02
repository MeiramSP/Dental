package kz.saparov.dental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.saparov.dental.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	List<Patient> findByNameIgnoreCaseContainingOrLastNameIgnoreCaseContainingOrPatronymicIgnoreCaseContaining(String name, String lastName, String patronymic);

}
