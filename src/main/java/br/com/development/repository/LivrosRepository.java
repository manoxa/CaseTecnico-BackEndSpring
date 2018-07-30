package br.com.development.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.development.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long>{

}
