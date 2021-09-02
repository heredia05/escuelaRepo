package com.examen.escuela.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcudientesRequest {

	@ApiModelProperty(notes = "nombre", example = "Pedro", position = 1, required = true)
	private String nombre;
	@ApiModelProperty(notes = "parentesco", example = "Padre/Madre", position = 2, required = true)
	private String parentesco;
	@ApiModelProperty(notes = "Telefono", example = "300000000", position = 3, required = true)
	private Integer telefono;
}
