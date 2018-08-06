package br.com.development;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.development.domain.Autor;
import br.com.development.domain.Comentario;
import br.com.development.domain.Livro;
import br.com.development.services.AutoresService;
import br.com.development.services.LivrosService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CaseTecnicoBackEndSpringApplicationTests {


	@Autowired
	private LivrosService livrosService;
	
	@Autowired
	private AutoresService autoresService;
	
	@Test
	public void deveSalvarUmAutor() {
		List<Livro> livros = livrosService.listar();
		
		Autor autor = new Autor();
		autor.setNome("Robert Rodriguez");
		autor.setNacionalidade("Espano");
		autor.setNascimento(new Date());
		autor.setLivros(livros);
		
		autoresService.salvar(autor);
		
	}
	
	@Test
	public void deveSalvarUmLivro() {
		
		List<Autor> autores = autoresService.listar();
		Autor autor = null;

		for(Autor autorSelecionado: autores) {
			autor = autorSelecionado;
		}
		
		List<Comentario> comentarios = new ArrayList<Comentario>();
		Livro livro = new Livro();
		
		livro.setNome("Gerenciando containers com Kubernetes");
		livro.setEditora("Marques Books");
		livro.setPublicacao(new Date());
		livro.setResumo("Livro voltado para profissionais de TI mais especificamente DevOps");
		livro.setComentarios(comentarios);
		livro.setAutor(autor);
		
		livrosService.salvar(livro);
	}

}
