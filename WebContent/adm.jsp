<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>  
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body id="body">
<center>

	<f:view>
		<h:form>	
		<br>
		<br>
	<br><br><br>
	<rich:panel style="width: 300px">
	<br><br><br>
		<h:panelGrid columns="2"> 
			<h:commandButton value="Gera Banco" action="#{usuarioHandler.logar}"/>
			
			<h:commandButton value="Insere dados" action="#{usuarioHandler.logar}"/>
		</h:panelGrid>	

	</rich:panel>
	</h:form>
</f:view>
</center>
</body>
</html>