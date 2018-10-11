package br.com.tradeideas.handler;

import java.util.Calendar;

import org.hibernate.Session;

import br.com.tradeideas.dao.DAO;
import br.com.tradeideas.dao.UsuarioDAO;
import br.com.tradeideas.entity.Usuario;
import br.com.tradeideas.util.HibernateUtil;


public class UsuarioHandler {
	
	private Usuario usuario = new Usuario();
	String msg = "";
	
	private String senhaAtual;
	private String senhaNova;
	private String senhaNova2;

	public String logar(){
		msg = "";
		
		if (this.usuario.getEmail()==null || this.usuario.getEmail().length() < 4){
			msg = "Email deve ser preenchido corretamente!";
			return "";
		}
		if (this.usuario.getSenha()==null || this.usuario.getSenha().length() < 4){
			msg = "Senha deve ser preenchida corretamente!";
			return "";
		}
		
		if (this.usuario!=null && this.usuario.getEmail()!=null){
				//Busca usuário no banco.
				Session session = HibernateUtil.currentSession();
				UsuarioDAO dao = new UsuarioDAO(session, Usuario.class);
				Usuario userRetorno = dao.getUsuarioByEmaiBySenha(this.usuario);
				if (userRetorno==null){
					msg = "Usuário ou senha inválido!";
					return "invalido";
				}
				this.usuario = userRetorno;
				return "logged";
		}
		return "invalido";
	}
	
	public String logout(){
		msg = "";
		this.usuario = new Usuario();
		
		return "login";
	}
	
	
	public String salva(){
		this.msg="";
		if(this.usuario.getNome()==null || this.usuario.getNome()==""){
			this.msg = "Nome Inválido";
			return "erro";
		}
		if(this.usuario.getEmail()==null || this.usuario.getEmail()==""){
			this.msg = "Email Inválido";
			return "erro";
		}
		
		Session session = HibernateUtil.currentSession();
		
		DAO<Usuario> dao = new DAO<Usuario>(session, Usuario.class);
		Calendar cal = Calendar.getInstance();
		

		this.usuario.setSenha("t2d8g4");
		
		dao.merge(this.usuario);
		
		this.usuario = new Usuario();
		return "sucesso";
	}
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String goToLogin(){
		setMsg("");
		return "login";
	}
	
	public String goToAutoCadastro(){
		return "cadastro";
	}


	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	public String alteraSenha(){
		msg = "";
		if (senhaNova==null || senhaNova.length()==0 || senhaNova2==null || senhaNova2.length()==0){
			this.msg = "A nova senha é inválida!"; 
			return "";
		}
		if (!senhaNova.equals(senhaNova2)){
			this.msg = "Favor repetir a nova senha corretamente!"; 
			return "";
		}
		
		if (usuario.getSenha().equals(senhaAtual)){
			this.usuario.setSenha(senhaNova);
			//salva();
			Session session = HibernateUtil.currentSession();
			DAO<Usuario> dao = new DAO<Usuario>(session, Usuario.class);
			dao.merge(this.usuario);
			
			this.msg = "Senha alterada com sucesso!";			
		}else{
			this.msg = "Senha inválida!";
		}
		return "";
	}

	public String criaSenha(){
		msg = "";
		if (senhaNova==null || senhaNova.length()==0 || senhaNova2==null || senhaNova2.length()==0){
			this.msg = "A nova senha é inválida!"; 
			return "";
		}
		if (!senhaNova.equals(senhaNova2)){
			this.msg = "Favor repetir a nova senha corretamente!"; 
			return "";
		}

		this.usuario.setSenha(senhaNova);
		
		Session session = HibernateUtil.currentSession();
		DAO<Usuario> dao = new DAO<Usuario>(session, Usuario.class);
		dao.merge(this.usuario);

		this.msg = "Senha alterada com sucesso!";			
		return "";
	}

	
	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public String getSenhaNova() {
		return senhaNova;
	}

	public void setSenhaNova(String senhaNova) {
		this.senhaNova = senhaNova;
	}

	public String getSenhaNova2() {
		return senhaNova2;
	}

	public void setSenhaNova2(String senhaNova2) {
		this.senhaNova2 = senhaNova2;
	}
	
	

}
