package br.com.development.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.development.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long> {

}
