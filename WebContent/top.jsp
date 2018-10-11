<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/top.css"/>
<link rel="stylesheet" type="text/css" href="css/general.css"/>
<link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trade Ideas</title>
<style>
</style>
</head>

	<f:subview id="top"> 
	<h:form>
		<div class="top-menu">
		
			<div class="client-wellcome">   
				<h:outputText value="#{usuarioHandler.usuario.nome}"/>
			</div>
	
			<div class="menu-wrapper">
				<div>
					<h:outputLink value="lancamento.jsf">Lançamento coberto</h:outputLink>
				</div>
				<div>
					<h:outputLink value="cotacaoacao.jsf">Cotações - Ações</h:outputLink>
				</div>
				<div>
					<h:outputLink value="cotacaoopcao.jsf">Cotações - Opções</h:outputLink>
				</div>
				<div>
					<h:outputLink value="travas.jsf">Travas</h:outputLink>
				</div>

				<div>
					<h:outputLink value="crudAcao.jsf">ADM - Ações</h:outputLink>
				</div>
				<div>
					<h:outputLink value="crudSerie.jsf">ADM - Series</h:outputLink>
				</div>
				<div>
					<h:outputLink value="crudOpcao.jsf">ADM - Opções</h:outputLink>
				</div>
				<div>
					<h:outputLink value="contato.jsf">Logout</h:outputLink>
				</div>
			</div>
		</div>
	</h:form>
	</f:subview>

</html>