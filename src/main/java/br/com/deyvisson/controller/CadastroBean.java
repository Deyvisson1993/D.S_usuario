package br.com.deyvisson.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Messages;

import br.com.deyvisson.dao.UsuarioDAO;
import br.com.deyvisson.domain.Telefone;
import br.com.deyvisson.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class CadastroBean implements Serializable {

	private Usuario usuario;
	private Telefone telefone;
	private List<Usuario> usuarios;
	private List<Telefone> telefones;

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
	public void novo() {

		try {

			usuario = new Usuario();
			usuario.setTelefone(new Telefone());

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possivil inicializar o usuario");
			erro.printStackTrace();
		}
	}

	public String salvar() {

		UsuarioDAO dao = new UsuarioDAO();
		dao.salvar(usuario);

		novo();

		Messages.addGlobalInfo("Usuario Cadastrado com Sucesso");

		return "/pages/login?faces-redirect=true";
	}
}