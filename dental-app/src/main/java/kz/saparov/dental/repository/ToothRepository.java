package kz.saparov.dental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.saparov.dental.entity.Tooth;

@Repository
public interface ToothRepository extends JpaRepository<Tooth, Long> {

}
