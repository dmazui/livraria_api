package com.dimaz.livrariaapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dimaz.livrariaapi.domain.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
