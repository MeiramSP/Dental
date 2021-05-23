package kz.saparov.dental.patient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import kz.saparov.dental.dto.patient.PatientDto;
import kz.saparov.dental.dto.patient.PatientWithTeethDto;
import kz.saparov.dental.entity.Patient;
import kz.saparov.dental.repository.PatientRepository;
import kz.saparov.dental.service.PatientService;

@RunWith(MockitoJUnitRunner.class)
public class PatientServiceTest {
	
	@Mock
	private PatientRepository patientRepository;
	
	@InjectMocks
	private PatientService patientService;
	
	private Patient patient;
	
	@Before
	public void init() {
		
		patient = new Patient();
		patient.setId(1L);
		patient.setLastName("Сапаров");
		patient.setName("Мейрам");
		patient.setPatronymic("Берикович");
		patient.setBirthDate(LocalDate.of(1996, 12, 30));
		patient.setAddress("г.Костанай");
		
	}
	
	@Test
	public void createPatient() {
		
		when(patientRepository.save(patient)).thenReturn(patient);
		
		final Patient created = patientService.addPatient(patient);
		
		assertThat(created).isEqualTo(patient);
		
		verify(patientRepository).save(ArgumentMatchers.any(Patient.class));
	}
	
	
	@Test
	public void findPatientById() {
		
		when(patientRepository.findPatientbyId(1L)).thenReturn(Optional.of(patient));
		
		final PatientDto found = patientService.getPatient(1L);
		
		assertThat(found).isEqualTo(new PatientWithTeethDto(patient));
	}
	
	@Test
	public void updatePatient() {
		
		patient.setAddress("г. Петропавловск");
		
		when(patientRepository.save(patient)).thenReturn(patient);
		
		final Patient expected = patientService.updatePatient(patient.getId(), patient);
		
		assertThat(expected).isNotNull();
		
		verify(patientRepository).save(ArgumentMatchers.any(Patient.class));
	}
	
	
	@Test
	public void shoidBeDelete() {
		final Long patientId = 1L;
		
		patientService.deletePatient(patientId);
		patientService.deletePatient(patientId);
		
		verify(patientRepository, times(2)).deleteById(patientId);
	}
}
