package com.examen.escuela.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.escuela.dto.EstudianteActuRequest;
import com.examen.escuela.dto.EstudianteRequest;
import com.examen.escuela.entities.Acudiente;
import com.examen.escuela.entities.Estudiante;
import com.examen.escuela.repository.EstudianteRepository;

@Service
public class EstudianteService {

	private static final int edadMinima = 18;

	@Autowired
	private EstudianteRepository estudianteRepository;

	public List<Estudiante> listarEstudiantes() {
		return estudianteRepository.findAll();
	}

	public Estudiante buscarEstudianteXId(Long id) {
		return estudianteRepository.findById(id).get();
	}

	public Boolean eliminarEstudianteXId(Long id) {
		Estudiante estudiante = buscarEstudianteXId(id);
		estudiante.setIsActivo(false);
		estudianteRepository.save(estudiante);
		return !estudiante.getIsActivo();
	}

	public Estudiante actualizarEstudiante(EstudianteActuRequest estudianteActualizar, Long id) {
		Estudiante estudiante = buscarEstudianteXId(id);
		estudiante.setEdad(estudianteActualizar.getEdad());
		estudiante.setCorreo(estudianteActualizar.getCorreo());
		return estudianteRepository.save(estudiante);
	}

	public List<Estudiante> estudianteXEdadXActivo(Integer edad, Boolean isActivo) {
		return estudianteRepository.findByEdadAndIsActivo(edad, isActivo);
	}

	public Estudiante crearEstudiante(EstudianteRequest estudianteCrear) {
		if (estudianteCrear.getEdad() < edadMinima) {
			Estudiante estudiante = new Estudiante();
			estudiante.setEdad(estudianteCrear.getEdad());
			estudiante.setNombre(estudianteCrear.getNombre());
			estudiante.setIdentificacion(estudianteCrear.getIdentificacion());
			estudiante.setCorreo(estudianteCrear.getCorreo());
			estudiante.setIsActivo(true);
			List<Acudiente> acudientes = estudianteCrear.getAcudientes().stream()
					.map(acudiente -> Acudiente.builder().nombre(acudiente.getNombre())
							.parentesco(acudiente.getParentesco()).telefono(acudiente.getTelefono())
							.estudiante(estudiante).build())
					.collect(Collectors.toList());
			estudiante.setAcudientes(acudientes);
			return estudianteRepository.save(estudiante);
		} else {
			return null;
		}
	}
}
