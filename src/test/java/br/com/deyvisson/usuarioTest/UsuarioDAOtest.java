package br.com.deyvisson.usuarioTest;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.deyvisson.dao.UsuarioDAO;
import br.com.deyvisson.domain.Telefone;
import br.com.deyvisson.domain.Usuario;


public class UsuarioDAOtest {

	// @Test
	 @Ignore
	public void salvar() {

		Telefone telefone = new Telefone(new Short("81"), "99637-3211", "Celular");
		Telefone telefone1 = new Telefone(new Short("81"), "98799-5655", "Celular");
		Telefone telefone2 = new Telefone(new Short("81"), "99922-8876", "Celular");

		Usuario usuario = new Usuario("Tayline Vasconcelos", "tayline_93@gmail.com", "1234", telefone);
		Usuario usuario1 = new Usuario("Paulo Henrique", "paulo_ss3@hotmail.com", "3242", telefone1);
		Usuario usuario2 = new Usuario("Fernanda Fernandes", "fe.nanda@yahoo.com.br", "8744", telefone2);
		UsuarioDAO dao = new UsuarioDAO();
		dao.salvar(usuario);
		dao.salvar(usuario1);
		dao.salvar(usuario2);

		System.out.println("Salvo com Sucesso");

	}

	 //@Test
	@Ignore
	public void listar() {

		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> usuarios = dao.listar();

		for (Usuario usuario : usuarios) {
			System.out.println("Usaurio: " + usuario.getNome() + "- E-mail: " + usuario.getEmail() + " -Senha: "
					+ usuario.getSenha() + "- DDD: " + usuario.getTelefone().getDdd() + "- Numero: "
					+ usuario.getTelefone().getNumero());
		}

	}

	 // @Test
	@Ignore
	public void buscar() {

		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.consultarPorId(1L);

		System.out.println("Usaurio: " + usuario.getNome() + "- E-mail: " + usuario.getEmail() + " -Senha: "
				+ usuario.getSenha() + "- DDD: " + usuario.getTelefone().getDdd() + "- Numero: "
				+ usuario.getTelefone().getNumero());

	}

	// @Test
	@Ignore
	public void atualizar() {

		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.consultarPorId(1L);
		usuario.setNome("Deyvisson Mendes de Araujo");

		dao.salvar(usuario);
		System.out.println("Atualizado com sucesso");

	}

	 @Test
	//@Ignore
	public void excluir() {

		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.consultarPorId(1L);

		dao.excluir(usuario);
		System.out.println("Excluido com sucesso");

	}

//	  @Test
//	  //@Ignore
//	public void autenticar() {
//
//		AltenticarDAO dao = new AltenticarDAO();
//		Usuario usuario = dao.autenticar("Tayline Vasconcelos", "1234");
//
//		System.out.println("Usuario: " + usuario);
//	}

}
