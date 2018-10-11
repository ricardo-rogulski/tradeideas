<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/cotacoes.css"/>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/cotacoes.js"></script>
</head>
<body id="body">
	<f:view>
		<jsp:include page="top.jsp"></jsp:include>
		<div id="main">
			<rich:panel header="Ações">
				<div class="table-wrapper">
					<h:dataTable value="#{cotacaoAcaoHandler.cotacoesAcoes}" var="ca">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Ação"/>
							</f:facet>
							<h:outputText value="#{ca.acao.codigo}"/>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Ultimo negócio" styleClass="lblUltimo"/>
							</f:facet>
							<h:outputText value="#{ca.ultimo}" style="font-weight: bold"/>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Oscilação"/>
							</f:facet>
								<h:outputText value="+#{ca.oscilacao}" styleClass="positivo" rendered="#{ca.oscilacao>=0}"/>
								<h:outputText value="#{ca.oscilacao}" styleClass="negativo" rendered="#{ca.oscilacao<0}"/>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Data da cotação" styleClass="lblData"/>
							</f:facet>
							<h:outputText value="#{ca.dataStr}" style="font-weight: bold"/>
						</h:column>
					</h:dataTable>
				</div>
			</rich:panel>
		</div>
	</f:view>
</body>
</html>