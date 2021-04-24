package kz.saparov.dental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.saparov.dental.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
