<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html>
<html>
<body id="body">   
<f:view>
	<jsp:include page="top.jsp"/>
	
	<br><br><br>
	
	<center>
	
	<rich:panel header="Salvar / Alterar Ação" style="width: 600px">
		<h:form id="ins_acao">
			<h:panelGrid columns="2"> 
				<h:outputText value="Ação:"/>
				<h:inputText value="#{crudAcaoHandler.acao.codigo}" id="codigo" size="8"/>

				<h:outputText value="Nome:"/>
				<h:inputText value="#{crudAcaoHandler.acao.nome}" id="nome" size="20"/>

				<h:outputText value="Ativo:"/>
				<h:selectBooleanCheckbox value="#{crudOpcaoHandler.opcao.ativo}"/>
				
				<br>
				<h:panelGrid columns="2">
					<h:commandButton value="Save" action="#{crudAcaoHandler.salva}" styleClass="botao"/>
					<h:commandButton value="Cancel" action="#{crudAcaoHandler.cancel}" styleClass="botao"/>
				</h:panelGrid>
			</h:panelGrid>
		</h:form>
	</rich:panel>
	
	</center>
	<br>
	
	<center>
	<rich:panel header="Ações cadastradas" style="width: 600px">
		<h:form id="list_acao">
			<div class="table-wrapper">
				<h:dataTable value="#{crudAcaoHandler.acoes}" var="m">
					<h:column>
						<f:facet name="header">
							<h:outputText value="Id"></h:outputText>
						</f:facet>
						<h:outputText value="#{m.id}"></h:outputText>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Código"></h:outputText>
						</f:facet>
						<h:outputText value="#{m.codigo}"></h:outputText>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Nome"></h:outputText>
						</f:facet>
						<h:outputText value="#{m.nome}"></h:outputText>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Ativo"></h:outputText>
						</f:facet>
						<h:outputText value="#{m.ativo}"></h:outputText>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Update"></h:outputText>
						</f:facet>
						<h:commandLink actionListener="#{crudAcaoHandler.escolheAcao}" styleClass="link">
							<h:outputText value="Update"></h:outputText>
							<f:param id="editId" value="#{m.id}"></f:param>
						</h:commandLink>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Delete"></h:outputText>
						</f:facet>
						<h:commandLink actionListener="#{crudAcaoHandler.exclui}" styleClass="link">
							<h:outputText value="Delete"></h:outputText>
							<f:param id="excluiId" value="#{m.id}"></f:param>
						</h:commandLink>
					</h:column>
					
				</h:dataTable>
			</div>
		</h:form>
		<div class="clear"></div>
	</rich:panel>
	</center>
</f:view>
</body>
</html>