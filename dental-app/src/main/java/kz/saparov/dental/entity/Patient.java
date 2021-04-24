package kz.saparov.dental.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="patients")
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	private Long id;
	
	@Column(name="name", length = 50)
	private String name;
	
	@Column(name="last_name", length = 50)
	private String lastName;
	
	@Column(name="patronymic", length = 50)
	private String patronymic;
	
	@Column(name="address", length = 150)
	private String address;
	
	@Column(name="birth_date", columnDefinition = "DATE")
	private LocalDate birthDate;
	
	
	@OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	//@JsonIgnore
	private List<Tooth> teeth;
	
	public Patient() {}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<Tooth> getTeeth() {
		return teeth;
	}

	public void setTeeth(List<Tooth> teeth) {
		this.teeth = teeth;
	}
}
