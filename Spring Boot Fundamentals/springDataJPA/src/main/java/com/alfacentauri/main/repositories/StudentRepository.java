package com.alfacentauri.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alfacentauri.main.entities.Student;

/*
 * Crea el CRUD de forma automatica con la entidad y el tipo de la llave primaria
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
}
