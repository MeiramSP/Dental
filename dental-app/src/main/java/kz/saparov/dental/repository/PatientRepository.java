package kz.saparov.dental.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kz.saparov.dental.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	
public List<Patient> findByNameIgnoreCaseContainingOrLastNameIgnoreCaseContainingOrPatronymicIgnoreCaseContaining(String name, String lastName, String patronymic);
	
	public List<Patient> findTop10ByOrderByIdDesc();
	
	@Query("select p from Patient p left join fetch p.teeth where p.id = :id")
	public Optional<Patient> findPatientbyId(@Param("id") Long id);
	
}
