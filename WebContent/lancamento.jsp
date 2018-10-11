<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/lancamentos.css"/>
</head>
<body id="body">
		<f:view>
		<jsp:include page="top.jsp"></jsp:include>    
		<h:form>
		<div id="main">
				<rich:panel header="Lançamentos cobertos">
					<div class="table-wrapper">
						<h:panelGrid columns="3">
						
							<h:outputText value="Ação *"/>
							<h:outputText value="Série"/>
							<h:outputText value=""/>
							
							<h:selectOneMenu value="#{lancamentoHandler.acao.codigo}" binding="#{lancamentoHandler.acaoSelecionada}" id="acao">
								<f:selectItem itemValue="-1" itemLabel="Selecione"/>
								<f:selectItems value="#{lancamentoHandler.acoesParaComboBox}"/>
							</h:selectOneMenu>
														
							<h:selectOneMenu value="#{lancamentoHandler.serie.id}" binding="#{lancamentoHandler.serieSelecionada}" id="serie">
								<f:selectItem itemValue="-1" itemLabel="Todas"/>
								<f:selectItems value="#{lancamentoHandler.seriesParaComboBox}"/>
							</h:selectOneMenu>
							
							<h:commandButton value="Buscar" action="#{lancamentoHandler.buscar}" styleClass="botao"/>
						   
						</h:panelGrid>
					</div>
				</rich:panel>
				<br><br><br>
				
				
				<rich:panel header="Lançamentos" rendered="#{lancamentoHandler.lancamentosToShow}">
				
				<div class="filter">
				
					<h:panelGrid columns="4">
						<h:outputText value="Proteção (min)"/>
						<h:outputText value="Lucro/mês (min)"/>
						<h:outputText value="Quantidade (min)"/>
						<h:outputText value=""/>
						
						 <rich:inputNumberSlider showInput="true" value="1" minValue="0" maxValue="10" enableManualInput="false" showBoundaryValues="false"
		        		binding="#{lancamentoHandler.protecaoRefinada}" step="1" immediate="true">
		        		</rich:inputNumberSlider>
						
						 <rich:inputNumberSlider showInput="true" value="1" minValue="0" maxValue="5" enableManualInput="false" showBoundaryValues="false"
		        		binding="#{lancamentoHandler.lucroRefinado}" step="1" >
		        		</rich:inputNumberSlider>
	
						<h:commandButton value="Aplicar filtros" action="#{lancamentoHandler.refinaLista}" styleClass="botao"/>
					</h:panelGrid>
				</div>
					<br><br>
					
				<div class="table-wrapper">
				
					<rich:dataTable value="#{lancamentoHandler.lancamentosRefinados}" var="la" id="lancList">
						<rich:column>
							<f:facet name="header">
								<h:outputText value="Ação"/>
							</f:facet>
							<h:outputText value="#{la.acao}"/>
						</rich:column>

						<rich:column>
							<f:facet name="header">
								<h:outputText value="Valor ação"/>
							</f:facet>
							<h:outputText value="#{la.valorAcao}"/>
						</rich:column>
						
						<rich:column>
							<f:facet name="header">
								<h:outputText value="Opção"/>
							</f:facet>
							<h:outputText value="#{la.opcao}"/>
						</rich:column>

						<rich:column>
							<f:facet name="header">
								<h:outputText value="Strike"/>
							</f:facet>
							<h:outputText value="#{la.valorStrike}"/>
						</rich:column>


						<rich:column>
							<f:facet name="header">
								<h:outputText value="Valor últ neg."/>
							</f:facet>
							<h:outputText value="#{la.valorOpcao}"/>
						</rich:column>

						<rich:column>
							<f:facet name="header">
								<h:outputText value="Valor Extrinsico"/>
							</f:facet>
							<h:outputText value="#{la.valorExtrinsicoStr}"/>
						</rich:column>

						<rich:column sortBy="#{la.pctLucroStr}">
							<f:facet name="header">
								<h:outputText value="% Lucro"/>
							</f:facet>
							<h:outputText value="#{la.pctLucroStr}"/>
						</rich:column>

						<rich:column sortBy="#{la.pctProtecaoStr}">
							<f:facet name="header">
								<h:outputText value="% Proteção"/>
							</f:facet>
							<h:outputText value="#{la.pctProtecaoStr}"/>
						</rich:column>

						<rich:column sortBy="#{la.pctLucroMesStr}">
							<f:facet name="header">
								<h:outputText value="% Lucro/Mês"/>
							</f:facet>
							<h:outputText value="#{la.pctLucroMesStr}"/>
						</rich:column>

						<rich:column>
							<f:facet name="header">
								<h:outputText value="Dias p/ venc."/>
							</f:facet>
							<h:outputText value="#{la.diasParaVenctoSerie}"/>
						</rich:column>

					</rich:dataTable>
				</div>
			</rich:panel>
		</div>
		</h:form>
		</f:view>
</body>
</html>