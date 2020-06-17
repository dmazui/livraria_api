package com.dimaz.livrariaapi.services;

import java.util.List;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dimaz.livrariaapi.domain.dtos.LivroDTO;
import com.dimaz.livrariaapi.domain.mappers.DtoToLivro;
import com.dimaz.livrariaapi.domain.mappers.LivroToDto;
import com.dimaz.livrariaapi.domain.models.Livro;
import com.dimaz.livrariaapi.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	LivroRepository repository;
	
	@Autowired
	LivroToDto toDto;
	
	@Autowired
	DtoToLivro toLivro;
	
	public @Valid LivroDTO save(@Valid LivroDTO livroDto) {
		return toDto.convert(repository.save(toLivro.convert(livroDto)));
	}

	public LivroDTO patch(Long id) {
		
		return null;
	}

	public JSONObject delete(Long id) {
		JSONObject response = new JSONObject();
        try {
            repository.deleteById(id);
            response.put("status", "Success");
            response.put("message", "Livro excluído com sucesso!");
        } catch (Exception e) {
            response.put("status", "Error");
            response.put("message", "Houve um problema ao excluir!");
        }
        return response;
	}

	public LivroDTO findById(Long id) {
		return toDto.convert(repository.findById(id).orElse(new Livro()));
	}

	public List<LivroDTO> findAll(@Valid LivroDTO filter) {

		return null;
	}

}
