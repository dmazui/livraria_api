package com.dimaz.livrariaapi.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivroDTO {
	
	private Long id;
	private String titulo;
	private String isbn;
	private String autor;

}
