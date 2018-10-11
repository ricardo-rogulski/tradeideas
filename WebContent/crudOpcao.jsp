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
	
	<rich:panel header="Salvar / Alterar Opção" style="width: 600px">
		<h:form id="ins_opcao">
			<h:panelGrid columns="2"> 
				<h:outputText value="Ação:"/>
				<h:selectOneMenu value="#{crudOpcaoHandler.opcao.acao.id}" binding="#{crudOpcaoHandler.acaoSelecionada}" id="acao">
					<f:selectItem itemValue="-1" itemLabel="Selecione"/>
					<f:selectItems value="#{crudAcaoHandler.acoesParaComboBox}"/>
				</h:selectOneMenu>
			
				<h:outputText value="Série:"/>
				<h:selectOneMenu value="#{crudOpcaoHandler.opcao.serie.id}" binding="#{crudOpcaoHandler.serieSelecionada}" id="serie">
					<f:selectItem itemValue="-1" itemLabel="Selecione"/>
					<f:selectItems value="#{crudSerieHandler.seriesParaComboBox}"/>
				</h:selectOneMenu>

				<h:outputText value="Código Opcao:"/>
				<h:inputText value="#{crudOpcaoHandler.opcao.codigo}" id="opcao" size="8"/>

				<h:outputText value="Valor Exercício:"/>
				<h:inputText value="#{crudOpcaoHandler.opcao.valorExerc}" id="exrc" size="8"/>

				<h:outputText value="Ativo:"/>
				<h:selectBooleanCheckbox value="#{crudOpcaoHandler.opcao.ativo}"/>
				
				<br>
				<h:panelGrid columns="2">
					<h:commandButton value="Save" action="#{crudOpcaoHandler.salva}" styleClass="botao"/>
					<h:commandButton value="Cancel" action="#{crudOpcaoHandler.cancel}" styleClass="botao"/>
				</h:panelGrid>
			</h:panelGrid>
		</h:form>
	</rich:panel>
	
	</center>
	<br>
	
	<center>
	<rich:panel header="Opções cadastradas" style="width: 800px">
		<h:form id="list_opcao">
			<div class="table-wrapper">
				<h2>Opções</h2>
				<h:dataTable border="1" value="#{crudOpcaoHandler.opcoes}" var="m">
					<h:column headerClass="col1">
						<f:facet name="header">
							<h:outputText value="Id"></h:outputText>
						</f:facet>
						<h:outputText value="#{m.id}"></h:outputText>
					</h:column>
					<h:column headerClass="col1">
						<f:facet name="header">
							<h:outputText value="Ação"></h:outputText>
						</f:facet>
						<h:outputText value="#{m.acao.codigo}"></h:outputText>
					</h:column>
					<h:column headerClass="col1">
						<f:facet name="header">
							<h:outputText value="Série"></h:outputText>
						</f:facet>
						<h:outputText value="#{m.serie.nome}"></h:outputText>
					</h:column>
					<h:column headerClass="col2">
						<f:facet name="header">
							<h:outputText value="Opcao"></h:outputText>
						</f:facet>
						<h:outputText value="#{m.codigo}"></h:outputText>
					</h:column>
					<h:column headerClass="col2">
						<f:facet name="header">
							<h:outputText value="Exercício"></h:outputText>
						</f:facet>
						<h:outputText value="#{m.valorExerc}"></h:outputText>
					</h:column>

					<h:column headerClass="col3">
						<f:facet name="header">
							<h:outputText value="Ativo"></h:outputText>
						</f:facet>
						<h:outputText value="#{m.ativo}"></h:outputText>
					</h:column>
					<h:column headerClass="col7">
						<f:facet name="header">
							<h:outputText value="Update"></h:outputText>
						</f:facet>
						<h:commandLink actionListener="#{crudOpcaoHandler.escolheOpcao}" styleClass="link">
							<h:outputText value="Update"></h:outputText>
							<f:param id="editId" value="#{m.id}"></f:param>
						</h:commandLink>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Delete"></h:outputText>
						</f:facet>
						<h:commandLink actionListener="#{crudOpcaoHandler.exclui}" styleClass="link">
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