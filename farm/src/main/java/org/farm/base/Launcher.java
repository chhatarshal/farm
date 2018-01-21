package org.farm.base;

import org.farm.base.configure.BaseDao;
import org.farm.base.configure.Context;
import org.farm.base.jsf.viewbeans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.farm.base.configure")
public class Launcher  extends SpringBootServletInitializer implements CommandLineRunner{
	
		@Autowired
		private BaseDao baseDao;
	
	  @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder  application) {
	        return application.sources(Launcher.class);
	    }

	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Launcher.class, args);
	}

	
	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
	//	User user=new User("dummy","first","last");
	///	baseDao.createEntity(user);
		Context.putObject("baseDao", baseDao);
	}
	
	public  BaseDao getBaseDao() {
		return baseDao;
	}


}
