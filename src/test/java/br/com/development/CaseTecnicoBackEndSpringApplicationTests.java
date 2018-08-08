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
	public void deveSalvarUmAutorEumLivroComComentario() {
		
		List<Livro> livros = livrosService.listar();
		
		Autor autor1 = new Autor();
		autor1.setNome("Robert Rodriguez");
		autor1.setNacionalidade("Espanol");
		autor1.setNascimento(new Date());
		autor1.setLivros(livros);
		
		autoresService.salvar(autor1);
		
		List<Autor> autores = autoresService.listar();
		Autor autor = null;

		for(Autor autorSelecionado: autores) {
			autor = autorSelecionado;
		}
		
		List<Comentario> comentarios = new ArrayList<Comentario>();
		Livro livro1 = new Livro();
		
		livro1.setNome("Microservices com SpringBoot");
		livro1.setEditora("Marques Books");
		livro1.setPublicacao(new Date());
		livro1.setResumo("Livro voltado para Desenvolvedores de Software");
		livro1.setComentarios(comentarios);
		livro1.setAutor(autor);
		
		livrosService.salvar(livro1);
		
		Livro livro2 = new Livro();
		
		livro2.setNome("Gerenciando containers com Kubernetes");
		livro2.setEditora("Marques Books");
		livro2.setPublicacao(new Date());
		livro2.setResumo("Livro voltado para profissionais de TI mais especificamente DevOps");
		livro2.setComentarios(comentarios);
		livro2.setAutor(autor);
		
		livrosService.salvar(livro2);
		
		Comentario comentario1 = new Comentario();
		comentario1.setUsuario("amrodrigues");
		comentario1.setData(new Date());
		comentario1.setTexto("Particularmente esse livro é o melhor referênte ao assunto.");
		comentario1.setLivro(livro1);
		
		livrosService.salvarComentario(livro1.getId(), comentario1);
		
		Comentario comentario2 = new Comentario();
		comentario2.setUsuario("zsanches");
		comentario2.setData(new Date());
		comentario2.setTexto("Melhorei meu nível como desenvolvedor depois que li esse livro.");
		comentario2.setLivro(livro2);
		
		livrosService.salvarComentario(livro2.getId(), comentario2);
	}

}
