<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<head>
<link rel="stylesheet" type="text/css" href="css/index.css"/>
<link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
</head>
<f:view>
<h:form>

<div id="top">
	<span id="logo">Logo</span>

	<a href="#como" class="topLink">Como funciona</a>
	<a href="#quanto" class="topLink">Quanto custa</a>
	<a href="#porque" class="topLink">Operações estruturadas</a>
	
	<div id=entrar>
			<div class="divmail">
			 	<h:outputText styleClass="loginText" value="Email"/>
			 	<h:inputText id="email" styleClass="loginMail" value="#{usuarioHandler.usuario.email}" size="30"/>
			</div>			
			<div class="divpass">   
				<h:outputText styleClass="loginText" value="Senha"/>
				<h:inputSecret id="senha" styleClass="loginPass" value="#{usuarioHandler.usuario.senha}" size="10"/>
			</div>				
			<div class="divloginbtn">   
				<h:commandButton value="Entrar" styleClass="loginBtn" action="#{usuarioHandler.logar}"/>
			</div>				
	</div>
</div>

<div id="porque">
	<span>Porque usar...</span>
</div>

<div id="cadastro">
	<span class="cadastrese">Cadastre-se aqui e tenha acesso grátis por 7 dias.</span>
	
 	<h:outputText styleClass="cadText" value="Nome"/>
 	<h:inputText id="nome" styleClass="cadNome"/>

 	<h:outputText styleClass="cadText" value="Email"/>
 	<h:inputText id="cademail" styleClass="cadEmail"/>

 	<h:outputText styleClass="cadText" value="Telefone"/>
 	<h:inputText id="cadtel" styleClass="cadTel"/>
		
 	<h:outputText styleClass="cadText" value="Senha (min 6 dígitos)"/>
 	<h:inputSecret id="cadsenha" styleClass="cadSenha"/>

 	<h:outputText styleClass="cadText" value="Repita a senha"/>
 	<h:inputSecret id="cadsenhaConf" styleClass="cadSenhaConf"/>
 	
 	<h:commandButton value="Quero me cadastrar" styleClass="cadBtn"/>

	
</div>


<div id="como">
	<span>Como funciona...</span>
</div>

<div id="quanto">
	<span>Quanto custa...</span>
</div>

<div id="footer">
	<span class="footerLink">Ajuda</span>
	<span class="footerLink">Parcerias</span>
	<span class="footerLink">Contato</span>
</div>
</h:form>
</f:view>


</body>
</html>