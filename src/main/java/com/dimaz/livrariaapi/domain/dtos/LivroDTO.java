package com.dimaz.livrariaapi.domain.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivroDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String titulo;
	private String isbn;
	private String autor;

}
