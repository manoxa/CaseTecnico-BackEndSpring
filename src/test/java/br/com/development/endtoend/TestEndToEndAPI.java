package br.com.development.endtoend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class TestEndToEndAPI {
	
	@Autowired
	private AutoresService autoresService;
	
	private LivrosService livrosService;
	
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	@Test
	public void devecadastrarUmAutor() throws ParseException {
		
		Date aniversario = simpleDateFormat.parse("03/05/1981");
		List<Livro> livros = new ArrayList<>();
		Autor autor = new Autor();
		autor.setNome("Alexandre marques Rodrigues");
		autor.setNascimento(aniversario);
		autor.setNacionalidade("Brasileiro");
		
		livros.add(retornarLivro(autor));
		autor.setLivros(livros);
		
		autoresService.salvar(autor);
	}
	
	public Livro retornarLivro(Autor autor) throws ParseException {
		
		Date publicacao = simpleDateFormat.parse("25/10/2011");
		List<Comentario> comentarios = new ArrayList<>();
		Livro livro = new Livro();
		livro.setNome("Usando Docker");
		livro.setEditora("Novatec");
		livro.setResumo("Conceitos basicos e avançados");
		livro.setPublicacao(publicacao);
		livro.setAutor(autor);
		comentarios.add(retornarComentario(livro));
		livro.setComentarios(comentarios);
		
		return livro;
	}
	
	public Comentario retornarComentario(Livro livro) throws ParseException {
		
		Date data = simpleDateFormat.parse("10/05/2018");
		Comentario comentario = new Comentario();
		comentario.setData(data);
		comentario.setLivro(livro);
		comentario.setTexto("Esse livro é ótimo!");
		comentario.setUsuario("amrodrigues");
	
		return comentario;
	}
	
	@Test
	public void deveSalvarUmLivro() throws ParseException {
		
		Autor autor = autoresService.buscar(new Long(1));
		Livro livro = retornarLivro(autor);
		
		livrosService.salvar(livro);
	}

}
