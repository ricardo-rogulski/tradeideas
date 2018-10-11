package br.com.tradeideas.robo;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;


public class Gatilho implements ServletContextListener{
	
	long intervaloCotacoesAcoes = 15*60*1000;  //15 minutos. 
	long intervaloUmaHora = 60*60*1000;
	long intervaloUmMinuto = 1*60*1000;
	
	
	public void run(){
    	try{
                SchedulerFactory sf = new StdSchedulerFactory();
                Scheduler sched = sf.getScheduler();
                
                //if (admin.isRoboCotacaoAcaoAtivo()){
                if (true){                	
                	//Ações.
                    JobDetail job1 = new JobDetail("job1", "group1", RoboCotacoesAcoes.class);            	
                    SimpleTrigger st1 = new SimpleTrigger("myTrigger1", SimpleTrigger.REPEAT_INDEFINITELY, intervaloCotacoesAcoes);
                    sched.scheduleJob(job1, st1);
                }
                
                sched.start();

    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		run();		
	}

}
