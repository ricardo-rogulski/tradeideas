package br.com.tradeideas.util;

import java.util.Calendar;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.faces.context.FacesContext;

import br.com.tradeideas.entity.Usuario;
import br.com.tradeideas.handler.UsuarioHandler;

public class Util {
	
	private static UsuarioHandler pegaUsuarioHandler(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ELContext elContext = facesContext.getELContext();
		ELResolver resolver = facesContext.getApplication().getELResolver();
		Object uh = resolver.getValue(elContext, null, "usuarioHandler");
		return (UsuarioHandler)uh;
	}
	
	public static Usuario pegaUsuarioLogado(){
		return pegaUsuarioHandler().getUsuario();
	}
	
	public static String getDataAsDiaMesAno(Calendar calendar){
		
		if (calendar==null || calendar.getTime()==null){
			return "----";
		}
		
		String dia = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
		if (dia.length()==1){
			dia = "0"+dia;
		}
		String mes = Integer.toString(calendar.get(Calendar.MONTH)+1);
		if (mes.length()==1){
			mes = "0"+mes;
		}
		String ano = Integer.toString(calendar.get(Calendar.YEAR));
		
		String data = dia+"/"+mes+"/"+ano;
		return data;
	}
	
	
	public static String getDataAsDiaMesAnoHoraMinuto(Calendar calendar){
		
		if (calendar==null || calendar.getTime()==null){
			return "----";
		}
		
		String dia = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
		if (dia.length()==1){
			dia = "0"+dia;
		}
		String mes = Integer.toString(calendar.get(Calendar.MONTH)+1);
		if (mes.length()==1){
			mes = "0"+mes;
		}
		String ano = Integer.toString(calendar.get(Calendar.YEAR));
		
		String hora = Integer.toString(calendar.get(Calendar.HOUR_OF_DAY));
		if (hora.length()==1){
			hora = "0"+hora;
		}
		String minuto = Integer.toString(calendar.get(Calendar.MINUTE));
		if (minuto.length()==1){
			minuto = "0"+minuto;
		}
		String data = dia+"/"+mes+"/"+ano+ " "+hora+":"+minuto;
		return data;
	}
	
	
	public Integer getQtdDiasAteData(Calendar dataAlvo){
		
		Calendar hoje = Calendar.getInstance();
		if (hoje.before(dataAlvo)){
			Long milis = dataAlvo.getTimeInMillis() - hoje.getTimeInMillis();
			Long dias = milis/1000/60/60/24;
			return dias.intValue();
		}
		return 0;
	}


	
	public static void main(String[] args) {
		
		int x = Integer.parseInt ("two");
		
		System.out.println(x);
		
	}
	

	
	

}
