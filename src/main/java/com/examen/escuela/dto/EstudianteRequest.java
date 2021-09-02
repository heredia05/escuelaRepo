package com.examen.escuela.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteRequest {

	@ApiModelProperty(notes = "nombre", example = "Pedro", position = 1, required = true)
	private String nombre;
	@ApiModelProperty(notes = "identificacion", example = "1000000000", position = 3, required = true)
	private Integer identificacion;
	@ApiModelProperty(notes = "correo", example = "example@mail.com", position = 4, required = true)
	private String correo;
	@ApiModelProperty(notes = "edad", example = "18", position = 2, required = true)
	private Integer edad;
	
	@ApiModelProperty(notes = "Acudientes", position = 5, required = true)
	private List<AcudientesRequest> acudientes;
}
