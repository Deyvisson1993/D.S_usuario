package br.com.deyvisson.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.deyvisson.dao.UsuarioDAO;
import br.com.deyvisson.domain.Telefone;
import br.com.deyvisson.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

	private Usuario usuario;
	private Telefone telefone;
	List<Usuario> usuarios;
	List<Telefone> telefones;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	@PostConstruct
	public void lista() {

		try {

			UsuarioDAO dao = new UsuarioDAO();
			usuarios = dao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possivil listar os dados do Usuario");
			erro.printStackTrace();
		}
	}

	public void novo() {

		try {
			usuario = new Usuario();
			usuario.setTelefone(new Telefone());

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possivil inicializar o usuario");
			erro.printStackTrace();
		}
	}

	public void salvar() {

		try {

			UsuarioDAO dao = new UsuarioDAO();
			dao.salvar(usuario);

			novo();
			usuarios = dao.listar();

			Messages.addGlobalInfo("Usuario Cadastrado com Sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Nao foi Possivel Salvar");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {

		try {

			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioEditar");

			UsuarioDAO dao = new UsuarioDAO();
			usuarios = dao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar Editar um Usuario");
			erro.printStackTrace();
		}

	}

	public void excluir(ActionEvent evento) {

		try {
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioExcluir");

			UsuarioDAO dao = new UsuarioDAO();
			dao.excluir(usuario);

			usuarios = dao.listar();

			Messages.addGlobalInfo("Usuario excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar Excluir um Usuario");
			erro.printStackTrace();
		}

	}
}