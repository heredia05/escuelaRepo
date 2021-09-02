package com.examen.escuela.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteActuRequest {

	@ApiModelProperty(notes = "Correo", example = "example@mail.com", position = 2, required = true)
	private String correo;
	@ApiModelProperty(notes = "edad", example = "18", position = 1, required = true)
	private Integer edad;
}
