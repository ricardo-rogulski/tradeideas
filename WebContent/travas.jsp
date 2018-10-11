<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body id="body">
	<f:view>
		<jsp:include page="top.jsp"></jsp:include>
		<div id="main">
			<h:panelGrid columns="1">
				<rich:panel header="Travas de alta disponíveis">
					<div class="table-wrapper">
						<h:dataTable value="#{travasHandler.travasDeAltaDisponiveis}" var="ta">
								<h:column>
									<f:facet name="header">
										<h:outputText value="Ação"/>
									</f:facet>
									<h:outputText value="#{ta.acao}"/>
									<h:outputText value="   "/>
									<h:outputText value="#{ta.valorAcao}"/>
								</h:column>
								<h:column>
									<f:facet name="header">
										<h:outputText value="Opção compra"/>
									</f:facet>
									<h:outputText value="#{ta.opcaoCompra}"/>
									<h:outputText value="   "/>
									<h:outputText value="#{ta.valorOpcaoCompra}"/>
								</h:column>
								<h:column>
									<f:facet name="header">
										<h:outputText value="Opção venda"/>
									</f:facet>
									<h:outputText value="#{ta.opcaoVenda}"/>
									<h:outputText value="   "/>
									<h:outputText value="#{ta.valorOpcaoVenda}"/>
								</h:column>
								<h:column>
									<f:facet name="header">
										<h:outputText value="Spreed atual"/>
									</f:facet>
									<h:outputText value="#{ta.spreed}"/>
								</h:column>
								<h:column>
									<f:facet name="header">
										<h:outputText value="Spreed máximo"/>
									</f:facet>
									<h:outputText value="#{ta.spreedMaximoStr}"/>
								</h:column>
								<h:column>
									<f:facet name="header">
										<h:outputText value="Lucro potencial"/>
									</f:facet>
									<h:outputText value="#{ta.lucroPotencialPCTStr} %"/>
								</h:column>
								<h:column>
									<f:facet name="header">
										<h:outputText value="Margem segurança"/>
									</f:facet>
									<h:outputText value="#{ta.margemSegurancaStr}"/>
								</h:column>

						</h:dataTable>
					</div>
				</rich:panel>
			</h:panelGrid>
		</div>
	</f:view>
</body>
</html>