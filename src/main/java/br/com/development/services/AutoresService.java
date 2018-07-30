package br.com.development.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.development.domain.Autor;
import br.com.development.repository.AutoresRepository;
import br.com.development.services.exceptions.AutorExistenteException;
import br.com.development.services.exceptions.AutorNaoEncontradoException;

@Service
public class AutoresService {

	@Autowired
	private AutoresRepository autoresRepository;
	
	public List<Autor> listar() {
		return autoresRepository.findAll();
	}	
	
	public Autor salvar(Autor autor) {
		if(autor.getId() != null) {
			Autor a = autoresRepository.getOne(autor.getId());
			
			if(a != null) {
				throw new AutorExistenteException("O autor já existe.");
			}
		}
		return autoresRepository.save(autor);
	}
	
	public Autor buscar(Long id) {
		Autor autor = autoresRepository.getOne(id);
		
		if(autor == null) {
			throw new AutorNaoEncontradoException("O autor não pôde ser encontrado.");
		}
		return autor;
	}
}