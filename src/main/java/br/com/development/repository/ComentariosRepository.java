package br.com.development.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.development.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long> {

}
