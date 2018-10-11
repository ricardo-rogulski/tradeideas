package br.com.tradeideas.util;


import java.util.Calendar;

import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import br.com.tradeideas.dao.StatelessDAO;
import br.com.tradeideas.entity.Acao;
import br.com.tradeideas.entity.CotacaoAcao;
import br.com.tradeideas.entity.CotacaoOpcao;
import br.com.tradeideas.entity.Opcao;
import br.com.tradeideas.entity.Serie;
import br.com.tradeideas.entity.Usuario;

public class InsereDados {  
	
		public static void main(String[] args) {
			insereDados();
		}
		
		public static void insereDados(){
			
			StatelessSession session = HibernateUtil.openStatelessSession();
			Transaction transaction = (Transaction) session.beginTransaction();
		
			//Usuário do sistema.
			StatelessDAO<Usuario> daoUsuario = new StatelessDAO<Usuario>(session, Usuario.class);

			Usuario adm = new Usuario();
			adm.setEmail("adm");
			adm.setNome("Administrador");
			adm.setSenha("adm");
			adm.setAdm(true);
			daoUsuario.save(adm);

			Usuario rr = new Usuario();
			rr.setEmail("ricardo");
			rr.setNome("Ricardo Rogulski");
			rr.setSenha("ricardo");
			rr.setAdm(true);
			daoUsuario.save(rr);

			Usuario tt = new Usuario();
			tt.setEmail("tomaz");
			tt.setNome("Tomaz Lazanha");
			tt.setSenha("tomaz");
			tt.setAdm(true);
			daoUsuario.save(tt);

			//Ações
			StatelessDAO<Acao> daoAcao = new StatelessDAO<Acao>(session, Acao.class);
			Acao petr4 = new Acao();
			petr4.setCodigo("PETR4");
			petr4.setNome("PETROBRAS PN");
			petr4.setAtivo(true);
			daoAcao.save(petr4);

			Acao vale5 = new Acao();
			vale5.setCodigo("VALE5");
			vale5.setNome("VALE PN");
			vale5.setAtivo(true);
			daoAcao.save(vale5);
			
			Acao bbdc4 = new Acao();
			bbdc4.setCodigo("BBDC4");
			bbdc4.setNome("BRADESCO PN");
			bbdc4.setAtivo(true);
			daoAcao.save(bbdc4);

			Acao bbas3 = new Acao();
			bbas3.setCodigo("BBAS3");
			bbas3.setNome("BANCO DO BRASIL ON");
			bbas3.setAtivo(true);
			daoAcao.save(bbas3);

			Acao abev3 = new Acao();
			abev3.setCodigo("ABEV3");
			abev3.setNome("AMBEV ON");
			abev3.setAtivo(true);
			daoAcao.save(abev3);

			
			//Séries
			StatelessDAO<Serie> daoSerie = new StatelessDAO<Serie>(session, Serie.class);
			Serie a = new Serie();
			Calendar calA = Calendar.getInstance();
			calA.set(Calendar.DAY_OF_MONTH, 16);
			calA.set(Calendar.MONTH, Calendar.JANUARY);
			calA.set(Calendar.YEAR, 2017);
			a.setDataExercicio(calA);
			a.setNome("SERIE A");
			a.setTipo("CALL");
			a.setAtivo(false);
			daoSerie.save(a);
			
			Serie b = new Serie();
			Calendar calB = Calendar.getInstance();
			calB.set(Calendar.DAY_OF_MONTH, 20);
			calB.set(Calendar.MONTH, Calendar.FEBRUARY);
			calB.set(Calendar.YEAR, 2017);
			b.setDataExercicio(calB);
			b.setNome("SERIE B");
			b.setTipo("CALL");
			b.setAtivo(true);
			daoSerie.save(b);
			
			Serie n = new Serie();
			Calendar calN = Calendar.getInstance();
			calN.set(Calendar.DAY_OF_MONTH, 20);
			calN.set(Calendar.MONTH, Calendar.FEBRUARY);
			calN.set(Calendar.YEAR, 2017);
			n.setDataExercicio(calN);
			n.setNome("SERIE N");
			n.setTipo("PUT");
			n.setAtivo(true);
			daoSerie.save(n);
			
			Serie o = new Serie();
			Calendar calO = Calendar.getInstance();
			calO.set(Calendar.DAY_OF_MONTH, 20);
			calO.set(Calendar.MONTH, Calendar.MARCH);
			calO.set(Calendar.YEAR, 2017);
			o.setDataExercicio(calO);
			o.setNome("SERIE O");
			o.setTipo("PUT");
			o.setAtivo(true);
			daoSerie.save(o);

			
			
			//Opções
			StatelessDAO<Opcao> daoOpcao = new StatelessDAO<Opcao>(session, Opcao.class);
			Opcao petrb15 = new Opcao();
			petrb15.setAcao(petr4);
			petrb15.setSerie(b);
			petrb15.setCodigo("PETRB15");
			petrb15.setValorExerc(15.00f);
			petrb15.setAtivo(true);
			daoOpcao.save(petrb15);

			Opcao petrb16 = new Opcao();
			petrb16.setAcao(petr4);
			petrb16.setSerie(b);
			petrb16.setCodigo("PETRB16");
			petrb16.setValorExerc(16.00f);
			petrb16.setAtivo(true);
			daoOpcao.save(petrb16);
			
			Opcao valeb22 = new Opcao();
			valeb22.setAcao(vale5);
			valeb22.setSerie(b);
			valeb22.setCodigo("VALEB22");
			valeb22.setValorExerc(32.98f);
			valeb22.setAtivo(true);
			daoOpcao.save(valeb22);
			
			Opcao valeb1 = new Opcao();
			valeb1.setAcao(vale5);
			valeb1.setSerie(b);
			valeb1.setCodigo("VALEB1");
			valeb1.setValorExerc(31.98f);
			valeb1.setAtivo(true);
			daoOpcao.save(valeb1);
			
			Opcao petrn15 = new Opcao();
			petrn15.setAcao(petr4);
			petrn15.setSerie(n);
			petrn15.setCodigo("PETRN15");
			petrn15.setValorExerc(15.00f);
			petrn15.setAtivo(true);
			daoOpcao.save(petrn15);
			
			Opcao petrn16 = new Opcao();
			petrn16.setAcao(petr4);
			petrn16.setSerie(n);
			petrn16.setCodigo("PETRN16");
			petrn16.setValorExerc(16.00f);
			petrn16.setAtivo(true);
			daoOpcao.save(petrn16);
			
			Opcao valen25 = new Opcao();
			valen25.setAcao(vale5);
			valen25.setSerie(n);
			valen25.setCodigo("VALEN25");
			valen25.setValorExerc(24.98f);
			valen25.setAtivo(true);
			daoOpcao.save(valen25);
			
			Opcao valen26 = new Opcao();
			valen26.setAcao(vale5);
			valen26.setSerie(n);
			valen26.setCodigo("VALEN26");
			valen26.setValorExerc(25.98f);
			valen26.setAtivo(true);
			daoOpcao.save(valen26);
			
			
			/*
			  	private Float ultimo;
				private Float oscilacao;
				private Float qoc;
				private Float ofc;
				private Float qov;
				private Float ofv;
			 */
			
			
			//Cotação Ação
			StatelessDAO<CotacaoAcao> daoCotacaoAcao = new StatelessDAO<CotacaoAcao>(session, CotacaoAcao.class);
			CotacaoAcao cotacaoPetro = new CotacaoAcao();
			cotacaoPetro.setAcao(petr4);
			cotacaoPetro.setDataHora(Calendar.getInstance());
			cotacaoPetro.setUltimo(14.92f);
			cotacaoPetro.setOscilacao(-0.67f);
			daoCotacaoAcao.save(cotacaoPetro);

			CotacaoAcao cotacaoVale = new CotacaoAcao();
			cotacaoVale.setAcao(vale5);
			cotacaoVale.setDataHora(Calendar.getInstance());
			cotacaoVale.setUltimo(30.85f);
			cotacaoVale.setOscilacao(-1.69f);
			daoCotacaoAcao.save(cotacaoVale);
			

			//Cotação Opção
			StatelessDAO<CotacaoOpcao> daoCotacaoOpcao = new StatelessDAO<CotacaoOpcao>(session, CotacaoOpcao.class);
			CotacaoOpcao cotPetrB15 = new CotacaoOpcao();
			cotPetrB15.setOpcao(petrb15);
			cotPetrB15.setData(Calendar.getInstance());
			cotPetrB15.setUltimo(0.51f);
			cotPetrB15.setOscilacao(-15.0f);
			daoCotacaoOpcao.save(cotPetrB15);
			
			CotacaoOpcao cotPetrB16 = new CotacaoOpcao();
			cotPetrB16.setOpcao(petrb16);
			cotPetrB16.setData(Calendar.getInstance());
			cotPetrB16.setUltimo(0.19f);
			cotPetrB16.setOscilacao(-9.52f);
			daoCotacaoOpcao.save(cotPetrB16);


			CotacaoOpcao cotValeB22 = new CotacaoOpcao();
			cotValeB22.setOpcao(valeb22);
			cotValeB22.setData(Calendar.getInstance());
			cotValeB22.setUltimo(0.58f);
			cotValeB22.setOscilacao(-29.27f);
			daoCotacaoOpcao.save(cotValeB22);
			
			CotacaoOpcao cotValeB1 = new CotacaoOpcao();
			cotValeB1.setOpcao(valeb1);
			cotValeB1.setData(Calendar.getInstance());
			cotValeB1.setUltimo(0.86f);
			cotValeB1.setOscilacao(-27.73f);
			daoCotacaoOpcao.save(cotValeB1);


			CotacaoOpcao cotPetrN15 = new CotacaoOpcao();
			cotPetrN15.setOpcao(petrn15);
			cotPetrN15.setData(Calendar.getInstance());
			cotPetrN15.setUltimo(0.52f);
			cotPetrN15.setOscilacao(6.12f);
			daoCotacaoOpcao.save(cotPetrN15);
			
			CotacaoOpcao cotPetrN16 = new CotacaoOpcao();
			cotPetrN16.setOpcao(petrn16);
			cotPetrN16.setData(Calendar.getInstance());
			cotPetrN16.setUltimo(1.20f);
			cotPetrN16.setOscilacao(7.14f);
			daoCotacaoOpcao.save(cotPetrN16);


			CotacaoOpcao cotValeN25 = new CotacaoOpcao();
			cotValeN25.setOpcao(valen25);
			cotValeN25.setData(Calendar.getInstance());
			cotValeN25.setUltimo(0.09f);
			cotValeN25.setOscilacao(50.00f);
			daoCotacaoOpcao.save(cotValeN25);
			
			CotacaoOpcao cotValeN26 = new CotacaoOpcao();
			cotValeN26.setOpcao(valen26);
			cotValeN26.setData(Calendar.getInstance());
			cotValeN26.setUltimo(0.15f);
			cotValeN26.setOscilacao(36.36f);
			daoCotacaoOpcao.save(cotValeN26);

			try{
				transaction.commit();	
				System.out.println("OK!");
			}catch(Exception e){
				e.printStackTrace();
			}
		}

	

	
	

}
