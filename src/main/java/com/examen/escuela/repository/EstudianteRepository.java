package com.examen.escuela.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.escuela.entities.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

	public List<Estudiante> findByEdadAndIsActivo(Integer edad, Boolean isActivo);
	//public List<Estudiante> findByIsActivo(Boolean isActivo);
}
