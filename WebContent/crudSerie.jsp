<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html>
<html>
<head>

</head> 
<body id="body">   
<f:view>
	<jsp:include page="top.jsp"></jsp:include>
	
	<br><br><br>
	
	<center>
	
	<rich:panel header="Salvar / Alterar Serie" style="width: 600px">
		<h:form id="ins_serie">
			<h:panelGrid columns="2"> 
				<h:outputText value="Nome:"/>
				<h:inputText value="#{crudSerieHandler.serie.nome}" id="nome" size="10"/>

				<h:outputText value="Tipo:"/>
				<h:selectOneMenu value="#{crudSerieHandler.serie.tipo}" binding="#{crudSerieHandler.tipoSerieSelecionada}" id="serie">
					<f:selectItem itemValue="-1" itemLabel="Selecione"/>
					<f:selectItems value="#{crudSerieHandler.tiposOpcaoParaComboBox}"/>
				</h:selectOneMenu>
				
				<h:outputText value="Data exercício:"/>
				<rich:calendar direction="top-right" value="#{crudSerieHandler.serie.dataExercicio.time}"/>

				<h:outputText value="Ativo:"/>
				<h:selectBooleanCheckbox value="#{crudSerieHandler.serie.ativo}"/>
				
				<br>
				<h:panelGrid columns="2">
					<h:commandButton value="Salvar" action="#{crudSerieHandler.salva}" styleClass="botao"/>
					<h:commandButton value="Cancelar" action="#{crudSerieHandler.cancel}" styleClass="botao"/>
				</h:panelGrid>
			</h:panelGrid>
		</h:form>
	</rich:panel>
	
	</center>
	<br>
	
	<center>
	<rich:panel header="Séries cadastradas" style="width: 800px">
		<h:form id="list_serie">
			<div class="table-wrapper">
				<h2>Séries</h2>
				<h:dataTable border="1" value="#{crudSerieHandler.series}" var="a">
					<h:column headerClass="col1">
						<f:facet name="header">
							<h:outputText value="Id"></h:outputText>
						</f:facet>
						<h:outputText value="#{a.id}"></h:outputText>
					</h:column>
					<h:column headerClass="col2">
						<f:facet name="header">
							<h:outputText value="Nome"></h:outputText>
						</f:facet>
						<h:outputText value="#{a.nome}"></h:outputText>
					</h:column>
					<h:column headerClass="col3">
						<f:facet name="header">
							<h:outputText value="Tipo"></h:outputText>
						</f:facet>
						<h:outputText value="#{a.tipo}"></h:outputText>
					</h:column>
					<h:column headerClass="col3">
						<f:facet name="header">
							<h:outputText value="Data Exerc."></h:outputText>
						</f:facet>
						<h:outputText value="#{a.dataExercicioStr}"></h:outputText>
					</h:column>
					<h:column headerClass="col4">
						<f:facet name="header">
							<h:outputText value="Ativo"></h:outputText>
						</f:facet>
						<h:outputText value="#{a.ativo}"></h:outputText>
					</h:column>
					<h:column headerClass="col7">
						<f:facet name="header">
							<h:outputText value="Update"></h:outputText>
						</f:facet>
						<h:commandLink actionListener="#{crudSerieHandler.escolheSerie}" styleClass="link">
							<h:outputText value="Update"></h:outputText>
							<f:param id="editId" value="#{a.id}"></f:param>
						</h:commandLink>
					</h:column>
					<h:column>
					<f:facet name="header">
						<h:outputText value="Delete"></h:outputText>
					</f:facet>
					<h:commandLink actionListener="#{crudSerieHandler.exclui}" styleClass="link">
						<h:outputText value="Delete"></h:outputText>
						<f:param id="excluiId" value="#{a.id}"></f:param>
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